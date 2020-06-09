//
//  main.cpp
//  Minesweeper
//
//  Created by Ricky Lahm Wang on 2020/6/7.
//  Copyright © 2020 Ricky Lahm Wang. All rights reserved.
//

#include <iostream>
#include <vector>
#include <ctime>
#include <algorithm>
#include <random>
#include <chrono>

#define BOMB '*'
#define FREE '.'
#define FLAG_COMMAND 'f'
#define FLAG_DISPLAY 'F'
#define UP 'w'
#define DOWN 's'
#define LEFT 'a'
#define RIGHT 'd'
#define POSITION '#'
#define CLICK 'x'
#define RESTART 'r'
#define QUIT 'q'

using namespace std;

int rows, columns, bomb_num, is_game_finished, player_row, player_col, bomb_left;
char player_board[100][100], game_board[100][100], is_clicked[100][100];
bool restart = false, quit = false;

// the starting interface asking the user to select the difficulty of the game
void choose_difficulty(){
    char choice;
    cout << "Welcome to Minsweeper Game!\nSelect game difficulty: \n1 - Easy\n2 - Medium\n3 - Hard\n4 - Customize\nYour Choice: ";
    cin >> choice;
    switch (choice){
        // easy mode
        case '1':
            rows = 9;
            columns = 9;
            bomb_num = bomb_left = 10;
            break;
        // medium mode
        case '2':
            rows = 16;
            columns = 16;
            bomb_num = bomb_left = 40;
            break;
        // hard mode
        case '3':
            rows = 16;
            columns = 30;
            bomb_num = bomb_left = 99;
            break;
        // customize mode
        case '4':
            printf("Enter the number of rows: ");
            scanf("%d", &rows);
            printf("Enter the number of columns: ");
            scanf("%d", &columns);
            do {printf("Enter the number of bombs: ");
                scanf("%d", &bomb_num);
                if (bomb_num <= 0 || bomb_num >= rows*columns){
                    printf("Invalid number of bombs, please enter again\n");
                }
            } while (bomb_num <= 0 || bomb_num >= rows*columns);
            bomb_left = bomb_num;
            break;
        // invalid inputs
        default:
            cout << "Invalid Input, please enter again\n";
            choose_difficulty();
            break;
        }
}

// detect whether the coordinate point is within the board
bool is_in_board(int row, int col){
    return (0 <= row && row < rows && 0 <= col && col < columns);
}

void place_bomb(){
    // use random seed based on the current time to make the shuffle more random distributed
    srand((unsigned)time(NULL));
    unsigned seed = rand();
    // use vector pair to generate the shuffle
    vector <pair<int, int>> position;
    for (int r = 0; r < rows; r++){
        for (int c = 0; c < columns; c++){
            position.push_back(make_pair(r, c));
        }
    }
    // use shuffle to randomly change the position of the vector pairs
    shuffle(position.begin(), position.end(), default_random_engine(seed));
    for (int idx = 0; idx < bomb_num; idx++)
        game_board[position[idx].first][position[idx].second] = BOMB;
    
}

// compute the number of bombs around the current cell to generate the number on the cell
int compute_neighbors(int current_row, int current_col){
    int num_bomb_neighbor = 0;
    for (int delta_row = -1; delta_row <= 1; delta_row++){
        for (int delta_col = -1; delta_col <= 1; delta_col++){
            // when delta_row = delta_col = 0, we are looking at the "current cell" instead of its neighbors, but in init_board function, we are assuming the "current cell" is not a bomb, so this condition still holds
            num_bomb_neighbor += (is_in_board(current_row + delta_row, current_col + delta_col) && game_board[current_row + delta_row][current_col + delta_col] == BOMB);
        }
    }
    return num_bomb_neighbor;
}

// initialize the game board (the board with bombs and numbers set), the player board (the board that player will be clicking on) and the is_clicked board
void init_board(){
    // initialize the game board and player board with all empty cells
    for (int r = 0; r < rows; r++){
        for (int c = 0; c < columns; c++){
            game_board[r][c] = player_board[r][c] = FREE;
        }
    }
    // place bombs on game board
    place_bomb();
    for (int r = 0; r < rows; r++){
        for (int c = 0; c < columns; c++){
            if (game_board[r][c] != BOMB)
                // add numbers indicating the number of bombs on game board
                game_board[r][c] = compute_neighbors(r, c) + '0';
        }
    }
    // initialize the is_clicked board
    for (int i = 0; i < 100; i++){
        for (int j = 0; j < 100; j++){
            is_clicked[i][j] = '0';
        }
    }
}

// print out the player board as game interface
void print_board(){
    cout << "BOMBS LEFT: " << bomb_left << endl;
    for (int r = 0; r < rows; r++){
        for (int c = 0; c < columns; c++){
            cout << player_board[r][c];
        }
        cout << "\n";
    }
}

// starting the game
void start_game(){
    player_row = player_col = 0;
    is_game_finished = 0;
    init_board();
    player_board[player_row][player_col] = POSITION;
}

// deal with the situation after the user clicks on the cell
void on_click(int row, int col){
    // if the cell is already clicked or flagged, no need to process
    if (is_clicked[row][col] == '1' || is_clicked[row][col] == 'f')
        return;
    
    if (game_board[row][col] == BOMB){
        // if stepping on a bomb, end the game
        is_game_finished = 1;
        cout << "Game Over! You Lose!\n";
        // and output the bombs' positions
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++){
                if (game_board[r][c] == BOMB)
                    cout << BOMB;
                else
                    cout << player_board[r][c];
            }
            cout << "\n";
        }
    }
    
    // if it is a normal cell, open it and reveal the game board's corresponding cell
    else{
        player_board[row][col] = game_board[row][col];
        is_clicked[row][col] = '1';
        // if clicking on a zero, automatically open the adjacent cells
        if (player_board[row][col] == '0'){
            for (int delta_row = -1; delta_row <= 1; delta_row++){
                for (int delta_col = -1; delta_col <= 1; delta_col++){
                    int next_row = row + delta_row, next_col = col + delta_col;
                    if (is_in_board(next_row, next_col))
                        on_click(next_row, next_col);
                }
            }
        }
    }
}

// receiving and processing the incoming command of moving or clicking
void handle_commands(char command){
    int next_row = player_row, next_col = player_col;
    
    if (command == UP || command == DOWN || command == LEFT || command == RIGHT){
        // if the player moves
        if (command == UP){
            next_row --;}
        else if (command == LEFT){
            next_col --;}
        else if (command == DOWN){
            next_row ++;}
        else if (command == RIGHT){
            next_col ++;}
        // make sure the destination is within the board
        if (!is_in_board(next_row, next_col))
            return;
        
        // if current cell has not been clicked, remain its setting of '.' when the POSITION goes past this cell
        if (is_clicked[player_row][player_col] == '0')
            player_board[player_row][player_col] = FREE;
        // if current cell has been flagged, change the cell's value to 'f'
        else if (is_clicked[player_row][player_col] == 'f')
            player_board[player_row][player_col] = FLAG_DISPLAY;
        // if current cell has been clicked, access the cell's value through the game board
        else
            player_board[player_row][player_col] = game_board[player_row][player_col];
        
        player_row = next_row;
        player_col = next_col;
        player_board[player_row][player_col] = POSITION;
    }
    // if the player clicks on the board to open the cell
    else if (command == CLICK){
        on_click(player_row, player_col);
    }
    // if the player flags this cell
    else if (command == FLAG_COMMAND){
        // if this cell has been flagged before, cancel the flag
        if (is_clicked[player_row][player_col] == 'f'){
            is_clicked[player_row][player_col] = '0';
            player_board[player_row][player_col] = POSITION;
            bomb_left ++;
        }
        // if this cell is not flagged, give it a flag
        else if (is_clicked[player_row][player_col] == '0'){
            is_clicked[player_row][player_col] = 'f';
            player_board[player_row][player_col] = FLAG_DISPLAY;
            bomb_left --;
        }
    }
    // restart the game
    else if (command == RESTART)
        restart = true;
    // quit the game
    else if (command == QUIT)
        quit = true;
    // other inputs are invalid
    else{
        cout << "Invalid operation, please enter again: ";
        char new_command;
        cin >> new_command;
        handle_commands(new_command);
    }

}

// see if the current player board matches the game board by checking the number of bombs
bool check_game_finished(){
    int marked = 0;
    for (int r = 0; r < rows; r++){
        for (int c = 0; c < columns; c++){
            if ((is_clicked[r][c] == 'f' || is_clicked[r][c] == '0'))
                marked += 1;
        }
    }
    if (marked == bomb_num){
        cout << "Congratulations! You Win!\n";
        return true;
    }
    return false;
}

// the loop controlling game and re-playing the game
void game_loop(){
    choose_difficulty();
    start_game();
    while (!is_game_finished){
        print_board();
        char command;
        cout << "Do: \n";
        cin >> command;
        handle_commands(command);
        if (!is_game_finished)
            is_game_finished = check_game_finished();
        if (restart){
            cout << "Restarting the game...\n";
            start_game();
            restart = false;
            continue;
        }
        if (quit){
            char ans;
            cout << "Do you really want to quit? (y/n) ";
            cin >> ans;
            if (ans == 'y')
                break;
        }
    }
    // ask the user if they want to play again
    if (is_game_finished){
        char answer;
        cout << "Do you want to play again? (y/n) ";
        cin >> answer;
        if (answer == 'y')
            game_loop();
    }
}

int main(){
    game_loop();
    return 0;
}
