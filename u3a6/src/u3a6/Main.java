package u3a6;

import java.util.Stack;

abstract class Spans {

    /**
     * The span-algorithm.
     *
     * @param x
     *          Array with input-values.
     * @param n
     *          Number of values.
     * @return An array with the corresponding spans.
     */
    abstract int[] algorithm(int[] x, int n);
    // utilities:
    /**
     * If true, additional information will be written to stdout.
     */
    static boolean tracing = false;

    static void printArr(String prefix, int[] arr) {
        System.out.print(prefix + ": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    static void printArr(String prefix, Stack<Integer> stack) {
        System.out.print(prefix + ": ");
        while (!stack.empty()) {
            System.out.print((stack.pop()) + " ");
        }
        System.out.println("");
    }
} // end of class Spans

/**
 * Class Spans1 implements algorithm "spans1" (see slides from lecture).
 */
class Spans1 extends Spans {

    public int[] algorithm(int[] x, int n) {
        int[] S = new int[n]; // new array of n integers
        for (int i = 0; i < x.length; i++) {
            int s = 1;
            while (s <= i && x[i - s] <= x[i]) {
                s++;
            }
            S[i] = s;
        }
        return S;
    }
} // end of class Spans1

/**
 * Class Spans2 implements algorithm "spans2" (see slides from lecture).
 */
@SuppressWarnings("unchecked")
class Spans2 extends Spans {

    public int[] algorithm(int[] x, int n) {
        int[] S = new int[n]; // new array of n integers
        Stack<Integer> A = new Stack<Integer>(); // new empty stack

        return S;
    }
} // end of class Spans2

class SpansTest {

    public static void main(String[] args) {
        int algoNr = 12;//readArguments(args);
        Spans spans = null;
        if (algoNr == 12) {
            runtimeMeasurement();
            return;
        }
        if (algoNr == 1) {
            spans = new Spans1();
        } else {
            spans = new Spans2();
        }
        int[] x1 = {6, 3, 4, 5, 2};
        Spans.printArr("Input  x1", x1);
        int[] s1 = spans.algorithm(x1, x1.length);
        Spans.printArr("Result s1", s1);

        System.out.println("");

        int[] x2 = {6, 3, 4, 1, 2, 3, 5, 4};
        Spans.printArr("Input  x2", x2);
        int[] s2 = spans.algorithm(x2, x2.length);
        Spans.printArr("Result s2", s2);
    }

    private static int readArguments(String[] args) {
        int algoNr = 0;
        for (int i = 0; i < args.length; i++) {
            if (i == args.length - 1) {
                try {
                    algoNr = Integer.parseInt(args[i]);
                } catch (Exception e) {
                    algoNr = -1;
                }
            } else if (args[i].equals("-t")) {
                Spans.tracing = true;
            }
        }
        if ((algoNr != 1) && (algoNr != 2) && (algoNr != 12)) {
            usage();
            System.exit(1);
        }
        return algoNr;
    }

    enum Algorithm {

        QUADRATIC, LINEAR
    };

    private static void runtimeMeasurement() {
        int size = 1000;
        long[] lastTimes = new long[Algorithm.values().length];
        for (Algorithm a : Algorithm.values()) {
            lastTimes[a.ordinal()] = Long.MAX_VALUE;
        }
        for (int sizes = 0; sizes < 5; sizes++, size = size * 2) {
            Spans spans = null;
            for (Algorithm algo : Algorithm.values()) {
                if (algo == Algorithm.QUADRATIC) {
                    spans = new Spans1();
                } else {
                    spans = new Spans2();
                }
                int[] x = new int[size];
                for (int i = 0; i < x.length; i++) {
                    x[i] = i;
                }
                final int MEASUREMENTS = 30;
                long minTime = Long.MAX_VALUE;
                for (int i = 0; i < MEASUREMENTS; i++) {
                    long start = System.nanoTime();
                    spans.algorithm(x, x.length);
                    long end = System.nanoTime();
                    long time = end - start;
                    if (time < minTime) {
                        minTime = time;
                    }
                }
                System.out.format("Algorithm: %-9s   Size: %,6d    Time: %,7.1f ms    Ratio to last: %2.1f\n",
                        algo.name(), size, (double) minTime / (long) 1e6, (double) minTime / lastTimes[algo.ordinal()]);
                lastTimes[algo.ordinal()] = minTime;
            }
        }
    }

    private static void usage() {
        System.err.println("usage: uebung03.ml.aufgabe6.SpansTest [-t] algorithm-number");
        System.err.println("       -t               :  additional tracing.");
        System.err.println("       alogarithm-number:  1|2|12");
        System.err.println("         1:  quadratic");
        System.err.println("         2:  linear");
        System.err.println("         12: runtime-measurement with both");
    }
} // end of class SpansTest
/* Session-Log:

$ java uebung03.ml.aufgabe6.SpansTest 1
Input  x1: 6 3 4 5 2
Result s1: 1 1 2 3 1

Input  x2: 6 3 4 1 2 3 5 4
Result s2: 1 1 2 1 2 3 6 1



$ java uebung03.ml.aufgabe6.SpansTest 2
Input  x1: 6 3 4 5 2
Result s1: 1 1 2 3 1

Input  x2: 6 3 4 1 2 3 5 4
Result s2: 1 1 2 1 2 3 6 1



$ java -Xint -Xms100m -Xmx100m muebung03.ml.aufgabe6.SpansTest 12
Algorithm: QUADRATIC   Size:  1'000    Time:    11.8 ms    Ratio to last: 0.0
Algorithm: LINEAR      Size:  1'000    Time:     1.8 ms    Ratio to last: 0.0
Algorithm: QUADRATIC   Size:  2'000    Time:    47.8 ms    Ratio to last: 4.0
Algorithm: LINEAR      Size:  2'000    Time:     3.5 ms    Ratio to last: 1.9
Algorithm: QUADRATIC   Size:  4'000    Time:   190.1 ms    Ratio to last: 4.0
Algorithm: LINEAR      Size:  4'000    Time:     6.6 ms    Ratio to last: 1.9
Algorithm: QUADRATIC   Size:  8'000    Time:   771.9 ms    Ratio to last: 4.1
Algorithm: LINEAR      Size:  8'000    Time:    12.6 ms    Ratio to last: 1.9
Algorithm: QUADRATIC   Size: 16'000    Time: 3'159.2 ms    Ratio to last: 4.1
Algorithm: LINEAR      Size: 16'000    Time:    25.4 ms    Ratio to last: 2.0


$ java uebung03.ml.aufgabe6.SpansTest -t 2
Input  x1: 6 3 4 5 2
i : 0
S: 1 0 0 0 0
A: 0
------------------
i : 1
S: 1 1 0 0 0
A: 1 0
------------------
i : 2
S: 1 1 2 0 0
A: 2 0
------------------
i : 3
S: 1 1 2 3 0
A: 3 0
------------------
i : 4
S: 1 1 2 3 1
A: 4 3 0
------------------
Result s1: 1 1 2 3 1

Input  x2: 6 3 4 1 2 3 5 4
i : 0
S: 1 0 0 0 0 0 0 0
A: 0
------------------
i : 1
S: 1 1 0 0 0 0 0 0
A: 1 0
------------------
i : 2
S: 1 1 2 0 0 0 0 0
A: 2 0
------------------
i : 3
S: 1 1 2 1 0 0 0 0
A: 3 2 0
------------------
i : 4
S: 1 1 2 1 2 0 0 0
A: 4 2 0
------------------
i : 5
S: 1 1 2 1 2 3 0 0
A: 5 2 0
------------------
i : 6
S: 1 1 2 1 2 3 6 0
A: 6 0
------------------
i : 7
S: 1 1 2 1 2 3 6 1
A: 7 6 0
------------------
Result s2: 1 1 2 1 2 3 6 1

 */

