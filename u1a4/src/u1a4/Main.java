package u1a4;

/**
 * @author Lukas Elmer
 */
public class Main {

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            System.out.println(i + "(rek, impl, expl): (" + rek(i) + ", " + impl(i) + ", " + expl(i) + ")");

        }
    }

    private static int rek(int i) {
        if (i == 1) {
            return 5;
        }
        return 8 + rek(i - 1);
    }

    private static int impl(int to) {
        int sum = 5;
        for (int i = 2; i <= to; i++) {
            sum += 8;
        }
        return sum;
    }

    private static int expl(int i) {
        return 8 * i - 3;
    }
}
