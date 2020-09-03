# Simple Minesweeper Game

## About This Program
This is a mini C++ console game, simulating the Minsweeper game. 

This game supports 3 classic difficulties (easy/medium/hard) and customizing the size of game board. The player can also "mark flag" on the potential bomb positions.

This game has been tested on XCode v11.5.

## How to Play
1. Run the main file and start by selecting the difficulty (the program will raise error when encountering invalid inputs);
2. In the game interface:
  - the number of existed bombs will be shown on the first line (BOMBS LEFT), every time the player marks flag on a cell, the BOMBS LEFT will be reduced by 1
  - "#" represents your current place
  - "." represents a free cell that has not been clicked on yet
  - "*" represents a bomb
  - "F" represents a flag
  - the number on one cell represents the number of bombs around this cell;
3. In the "Do: " command line, type in:
  - <kbd>W</kbd> to move upward
  - <kbd>S</kbd> to move downward
  - <kbd>A</kbd> to move leftward
  - <kbd>D</kbd> to move rightward
  - <kbd>X</kbd> to click on the current cell
  - <kbd>F</kbd> to flag/unflag the current cell
  - <kbd>R</kbd> to restart the game under current difficulty
  - <kbd>Q</kbd> to quit the game immediately;
4. If the game is finished (either win or lose), you can always choose whether to play again. If yes, it will lead you back to the difficulty-selecting interface.

## Demonstration Screenshot
- Game execution in the console window:

![Starting_interface](/C_Cpp/Simple_Minesweeper/Demo/starting.png)

- During the game (easy mode):

![Game](/C_Cpp/Simple_Minesweeper/Demo/game.png)

- Winning the game:

![Win](/C_Cpp/Simple_Minesweeper/Demo/win.png)

- Losing the game:

![Lose](/C_Cpp/Simple_Minesweeper/Demo/lose.png)

## Knowledge Applied to this Program
- Switch Statements
- Recursions
- Random Seed and Shuffle
- Nested Functions
