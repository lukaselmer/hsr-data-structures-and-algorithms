package u3a1;

import java.util.Scanner;

public class SumSquare {

    public static int sumSquare(int n) {
        if (n == 0) {
            return 1;
        }
        int tmp = 1;
        for (int i = 0; i < n; i++) {
            tmp *= 2;
        }
        return tmp + sumSquare(n - 1);
    }

    public static void main(String[] args) {
        System.out.print("n : ");
        int n = new Scanner(System.in).nextInt();
        System.out.println("sumSquare(" + n + ") = " + sumSquare(n));
    }
}

/* Session-Log:

n : 3
sumSquare(3) = 15

 */

