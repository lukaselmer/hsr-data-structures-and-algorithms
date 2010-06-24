package u3a2;

import java.util.Random;
import java.util.Scanner;

public class BinarySearch {

    public static int search(String[] array, String token, int start, int end) {
        int diff = end - start;
        int middle = start + (diff / 2);
        if (start == end) {
            if (array[start].equals(token)) {
                return start + 1;
            } else {
                System.out.println("b Token not found!");
                return -1;
            }
        }
        int cmp = token.compareTo(array[middle]);
        if (cmp == 0) {
            return middle + 1;
        } else if (cmp < 0) {
            return search(array, token, start, middle - 1);
        } else /*if(cmp > 0)*/ {
            return search(array, token, middle + 1, end);
        }
    }

    public static void main(String[] args) {
        String[] array = new String[]{"Alge", "Ding", "Lang", "Politik", "Spiel",
            "Text", "Welt", "Zimmer"};

        System.out.println("Lang: " + search(array, "Lang", 0, array.length));
        System.out.println("Welt: " + search(array, "Welt", 0, array.length));
        System.out.println("Politik: " + search(array, "Politik", 0, array.length));

        String string = "Alaska"; //new Scanner(System.in).nextLine();
        System.out.println("Suchstring : " + string);
        System.out.println(search(array, string, 0, array.length - 1));
        try {
            for (int i = 0; i < array.length; ++i) {
                if (search(array, array[i], 0, array.length) != i + 1) {
                    throw new AssertionError("not working: " + search(array, array[i], 0, array.length) + "<>" + (i + 1));
                }
            }
        } catch (Exception ex) {
            throw new AssertionError();
        }
    }
}

/* Session-Log:

Lang: 3
Welt: 7
Politik: 4
Suchstring : Ding
2

 */

