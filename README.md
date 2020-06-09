# Simple Minesweeper Game

## About This Program
This is a mini C++ console game, simulating the Minsweeper game. It supports 3 classic difficulties (easy/medium/hard) and customizing the size of game board.

## How to Play
1. Run the file and select the difficulty (the program will raise error when encountering invalid inputs);
2. In the game interface:
  - "#" represents your current place
  - "." represents a free cell that has not been clicked on yet
  - "*" represents a bomb
  - the number on a cell represent the number of bombs around this cell;
3. In the "Do: " command line, type in:
  - <kbd>W</kbd> to move upward
  - <kbd>S</kbd> to move downward
  - <kbd>A</kbd> to move leftward
  - <kbd>D</kbd> to move rightward
  - <kbd>X</kbd> to click on the current cell;
4. If the game is finished, you can choose whether to play again. This will lead you back to the difficulty-selecting interface.

## Knowledge Applied to this Program
- Switch Statements
- Recursions
- Random Seed and Shuffle
- Nested Functions
