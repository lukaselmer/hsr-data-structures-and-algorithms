/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-12 18:02:38 +0100 (Fr, 12 Mrz 2010) $
 */
package u4a2;

public class Walker {

    enum Direction {

        NORTH(0, -1), WEST(-1, 0), EAST(1, 0), SOUTH(0, 1);
        private int offsetX;
        private int offsetY;

        Direction(int offsetX, int offsetY) {
            this.offsetX = offsetX;
            this.offsetY = offsetY;
        }

        int getOffsetX() {
            return offsetX;
        }

        int getOffsetY() {
            return offsetY;
        }
    }
    /**
     * The Labyrinth where the Walker is.
     */
    private Labyrinth lab;

    public Walker() {
        lab = new Labyrinth();
    }

    /**
     * Recursive method, which is called for every position to check.
     *
     * @param x
     *          X-Position to check.
     * @param y
     *          Y-Position to check.
     * @return True if the destination is found, else false.
     */
    public boolean walk(int x, int y) {
        printLabyrinth();
        sleep(400);
        lab.setField(x, y, PositionState.CURRENT_POSITION);

        int[][] fieldsToCheck = {{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};

        for (int i = 0; i < fieldsToCheck.length; i++) {
            int[] f = fieldsToCheck[i];
            try {
                PositionState p = lab.getField(f[0], f[1]);
                if (f[0] == lab.getEndRow() && f[1] == lab.getEndCol()) {
                    lab.setField(x, y, PositionState.WALKED);
                    lab.setField(f[0], f[1], PositionState.CURRENT_POSITION);
                    printLabyrinth();
                    return true;
                }
                if (p.getMarkingCharacter() == PositionState.OPEN.getMarkingCharacter()) {
                    lab.setField(x, y, PositionState.WALKED);
                    if (walk(f[0], f[1])) {
                        return true;
                    } else {
                        lab.setField(f[0], f[1], PositionState.BACKTRACKED);
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                // Try / catch is not good here because it steers the program flow.
                // Problem: interface has no other options
                // Pass
            }
        }
        return false;
    }

    private void printLabyrinth() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        lab.print();
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
        }
    }

    public static void main(String[] args) {
        Walker walker = new Walker();
        // start walking at the start position
        if (walker.walk(walker.lab.getStartCol(), walker.lab.getStartRow())) {
            System.out.println("Finally found a way out!");
        } else {
            System.out.println("Desperate search ended unsuccessful...");
        }
    }
}

/* Session-Log:

# # # # # # # # # # # # #
# o # . . # . . . . . . #
# o # . # # . # . # . # #
# o o . # . . # . # . . #
# # o # # # # # . # # # #
# . o o o o o o o o o . #
# . # # # o o # # # o # #
# . . . # o o o o o o   #
# # # # # o # # # # #   #
# . . . . o # . #   #   #
# . # # # o # . # X # # #
# . # . # o o o # o #   #
# . . . # # # o o o     #
# # # # # # # # # # # # #
Evaluating new possible solution (9/10)
Finally found a way out!

 */
