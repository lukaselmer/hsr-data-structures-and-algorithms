/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-04-24 08:49:59 +0200 (Sa, 24 Apr 2010) $
 */
package u9a4;

import java.util.Vector;

public class VectorTest {

    private Vector<Integer> vec;

    public void clear() {
        // TODO Implement here...
    }

    public void generateTree(int nodes) {
        // TODO Implement here...
    }

    public void print() {
        System.out.print("{ ");
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.get(i));
            if (i != vec.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        System.out.println("VECTOR based TEST");
        System.out.println("Please be patient, the following operations may take some time...");
        final int TESTRUNS = 100;
        final int BEGINSIZE = 10000;
        final int VARYSIZE = 10;

        VectorTest vt = new VectorTest();
        double avgTime = 0;
        long startTime;
        for (int i = 0; i < TESTRUNS; i++) {
            vt.clear();
            startTime = System.currentTimeMillis();
            vt.generateTree(BEGINSIZE + i * VARYSIZE);
            avgTime = ((avgTime * i) + (System.currentTimeMillis() - startTime)) / (i + 1);
        }

        System.out.println("Test successful, result is as follows:");
        System.out.println("Average time for generation is: " + avgTime + "ms");
    }
}

/* Session-Log:

VECTOR based TEST
Please be patient, the following operations may take some time...
Test successful, result is as follows:
Average time for generation is: 55.16ms

 */
