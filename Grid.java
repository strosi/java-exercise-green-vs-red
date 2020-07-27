package com.company;

public class Grid {
    private Cell[][] cells;
    private boolean isGenerationDifferent = false;

    public Grid(int height, int width) {
        this.cells = new Cell[height][width];
    }

    public void setCell(int row, int col, char state) {
        this.cells[row][col] = new Cell(state);
    }

    public char getCellState(int row, int col) {
        return cells[row][col].getState();
    }

    public int getCellGreenStatesCount(int row, int col) {
        return cells[row][col].getGreenStatesCount();
    }

    public boolean checkIfGenerationDiffer() {
        return isGenerationDifferent;
    }

    public void createNextGeneration() {
        this.isGenerationDifferent = false;
        boolean noChange = true;

        // Finds how many '1' (green) cells there is around every cell
        for (int row = 0; row < this.cells.length; row++) {
            for (int col = 0; col < this.cells[0].length; col++) {
                int greenNeighboursCount = 0;

                for (int subRow = row - 1; subRow <= row + 1; subRow++) {
                    for (int subCol = col - 1; subCol <= col + 1; subCol++) {
                        if ((subRow >= 0 && subRow < this.cells.length) && (subCol >= 0 && subCol < this.cells.length)) {
                            if (!(subRow == row && subCol == col)) {
                                greenNeighboursCount += (this.cells[subRow][subCol].getState() == '1' ? 1 : 0);
                            }
                        }
                    }
                }

                char newState = calcCellState(greenNeighboursCount, this.cells[row][col].getState());
                this.cells[row][col].setGeneratedState(newState);

                // If there is one cell with changed state in the new generation,
                // it is considered different from the ancestor grid
                if (noChange) {
                    if (this.cells[row][col].getGeneratedState() != this.cells[row][col].getState()) {
                        this.isGenerationDifferent = true;
                        noChange = false;
                    }
                }
            }
        }

        changeGridStates();
    }

    private void changeGridStates() {
        for (int row = 0; row < this.cells.length; row++) {
            for (int col = 0; col < this.cells[0].length; col++) {
                this.cells[row][col].changeState(this.cells[row][col].getGeneratedState());
            }
        }
    }

    private char calcCellState(int greenNeighboursCount, char state) {
        if (state == '1') {
            return ((greenNeighboursCount == 2 || greenNeighboursCount == 3 || greenNeighboursCount == 6) ? '1' : '0');
        } else {
            return ((greenNeighboursCount == 3 || greenNeighboursCount == 6) ? '1' : '0');
        }
    }
}
