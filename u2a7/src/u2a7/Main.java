package u2a7;

public class Main {

    public static void main(String[] args) {
        int[] ii = {47, 73, 21, 17};
        for (int i = 0; i < ii.length - 1; i++) {
            System.out.print("i = " + (i + 1) + " -> ");
            for (int j = i + 1; j < ii.length; j++) {
                System.out.print(ii[i] + "+" + ii[j] + ", ");
            }
            System.out.println();
        }
    }
}
