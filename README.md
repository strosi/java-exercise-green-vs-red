# Green vs. Red

A small Java program that takes input from the console and creates grid with given dimention and elements with values either '1' (green) or '0' (red). According to the value of each element and its neighbors a new grid is created (called generation) considering the next rules:
- If red element is surrounded by exactly 3 or 6 green elements it chages to green.
- If green element is surrounded by exactly 2, 3 or 6 green elements it stays green.

The program calculates a given number of generations and returns how many times a certain element had green value (including the initial grid - the zero generation).

Input format:
- COLUMNS, ROWS - two positive integers as grid demention
- ROWS lines of strings with lenght COLUMNS and containing only '0' and '1'
- X, Y, GENERATIONS - last line gives the target element's coordinates in the grid and how many generations to be calculated.
