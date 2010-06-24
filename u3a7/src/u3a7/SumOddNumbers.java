package u3a7;

public class SumOddNumbers {

    public static void main(String[] args) {
        SumOddNumbers s = new SumOddNumbers();
        System.out.println("Sum numbers up to " + Integer.parseInt(args[0]));
        System.out.println(s.perLoop(Integer.parseInt(args[0])));
        System.out.println(s.perRecursion(Integer.parseInt(args[0])));
    }

    public int perLoop(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }

    public int perRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n + perRecursion(n - 2);
    }
}
