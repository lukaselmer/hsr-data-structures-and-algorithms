/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-12 18:02:38 +0100 (Fr, 12 Mrz 2010) $
 */
package u4a2;

enum PositionState {

    OPEN(' '), WALL('#'), WALKED('o'), BACKTRACKED('.'), CURRENT_POSITION('X');
    private char markingChar;

    PositionState(char c) {
        markingChar = c;
    }

    char getMarkingCharacter() {
        return markingChar;
    }
}

/**
 * Labyrinth in Matrix-formation [y][x]. 0=walkable, 1=obstacle.
 * In addition start and end point are saved in col/row format.
 */
public class Labyrinth {

    // Start coordinate:
    private final int sx = 1;
    private final int sy = 1;
    // End coordinate:
    private final int ex = 9;
    private final int ey = 10;
    private int[][] initMatrix = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
        {1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1},
        {1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1},
        {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    private PositionState[][] matrix;

    public Labyrinth() {
        matrix = new PositionState[initMatrix.length][initMatrix[0].length];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                switch (initMatrix[y][x]) {
                    case 0:
                        matrix[y][x] = PositionState.OPEN;
                        break;
                    case 1:
                        matrix[y][x] = PositionState.WALL;
                        break;
                    default:
                        throw new Error("Unexpected value in initMatrix: " + initMatrix[y][x]);
                }
            }
        }
    }

    private void checkBounds(int x, int y) {
        if (y < 0 || y >= matrix.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (x < 0 || x > matrix[y].length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public PositionState getField(int x, int y) {
        checkBounds(x, y);
        return matrix[y][x];
    }

    public void setField(int x, int y, PositionState val) {
        checkBounds(x, y);
        matrix[y][x] = val;
    }

    public int getStartCol() {
        return sx;
    }

    public int getStartRow() {
        return sy;
    }

    public int getEndCol() {
        return ex;
    }

    public int getEndRow() {
        return ey;
    }

    public void print() {
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                System.out.print(" " + matrix[y][x].getMarkingCharacter());
            }
            System.out.println();
        }
    }

    // test function
    public static void main(String[] args) {
        Labyrinth l = new Labyrinth();
        System.out.println("Starting point: " + l.sx + "/" + l.sy);
        System.out.println("End point: " + l.ex + "/" + l.ey);
        System.out.println("Labyrinth:");
        l.print();
    }
}
