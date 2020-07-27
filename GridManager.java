import java.util.Arrays;
import java.util.Scanner;

/**
 * Utility class. The method getCellGreenStates() takes input from the console,
 * creates Grid object with the given dimension and cell states,
 * manages the calculation of generations and at the end returns how many times
 * the target cell has been in green state (with value '1').
 *
 * Input format:
 *
 * COLUMNS, ROWS           - positive integers on the first line as dimension of the grid,
 * ROWS lines of strings   - each COLUMNS characters long, containing 0s and 1s ('0' as red and '1' as green cell state)
 * X, Y, GENERATIONS       - integers on a separate line, (X, Y) cell coordinates in the grid
 *                           and GENERATIONS is the count of generations to be calculated.
 */

public class GridManager {

    public static int getCellGreenStates() {
        Scanner scanner = new Scanner(System.in);
        int[] gridDimension = Arrays.stream(scanner.nextLine().split(",\\s*"))
                .mapToInt(Integer::parseInt).toArray();
        int gridWidth = gridDimension[0];
        int gridHeight = gridDimension[1];
        Grid grid = new Grid(gridHeight, gridWidth);

        // Grid cells initialization
        for (int row = 0; row < gridHeight; row++) {
            char[] currentRowValues = scanner.nextLine().toCharArray();
            for (int col = 0; col < gridWidth; col++) {
                grid.setCell(row, col, currentRowValues[col]);
            }
        }

        int[] line = Arrays.stream(scanner.nextLine().split(",\\s*"))
                .mapToInt(Integer::parseInt).toArray();
        int targetCellX = line[0];
        int targetCellY = line[1];
        int generationsCount = line[2];

        scanner.close();

        return getCellGreenStatesCount(grid, targetCellY, targetCellX, generationsCount);
    }

    private static int getCellGreenStatesCount(Grid grid, int targetCellY, int targetCellX, int generationsCount) {

        int generation = 1;

        while (generation <= generationsCount){

            grid.createNextGeneration();

            // If cells state didn't change in two sequential generations they wouldn't change in all next generations.
            // In such case green states count of a cell could be calculated as sum of the green states counted to the first repeating
            // and the count of the remaining generations if the last cell state was '1' (green).
            if (!grid.checkIfGenerationDiffer()) {
                int remainderGreenStates =
                        (grid.getCellState(targetCellY, targetCellX) == '1' ? (generationsCount - generation) : 0);
                return grid.getCellGreenStatesCount(targetCellY, targetCellX) + remainderGreenStates;
            }

            generation++;
        }

        return grid.getCellGreenStatesCount(targetCellY, targetCellX);
    }
}
