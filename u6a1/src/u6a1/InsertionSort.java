/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-03-26 18:48:07 +0100 (Fr, 26 Mrz 2010) $
 */
package u6a1;

public class InsertionSort {

    private int[] a;
    private int n;

    public int[] sort(int[] a0) {
        a = a0;
        n = a.length;
        return insertionsort();
    }

    private int[] insertionsort() {
        int i, j, t;
        for (i = 1; i < n; i++) {
            for (j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        return a;
    }

    //    private int[] insertionsort() {
    //        int i, j, t;
    //        for (i = 1; i < n; i++) {
    //            for (j = i; j > 0; j--) {
    //                if (a[j] < a[j - 1]) {
    //                    t = a[j - 1];
    //                    a[j - 1] = a[j];
    //                    a[j] = t;
    //                } else {
    //                    break;
    //                }
    //            }
    //        }
    //        return a;
    //    }
    public static void main(String[] leer) {
        InsertionSort is;
        int[] a = {1, 3, 2, 9, 8, 7};

        System.out.println("Unsorted array");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }

        is = new InsertionSort();
        a = is.sort(a);
        System.out.println("\nSorted array");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i]);
        }
        System.out.println();

    }
}

/* Session-Log (SOLL):
Unsorted array
1 3 2 9 8 7
Sorted array
1 2 3 7 8 9
 */
