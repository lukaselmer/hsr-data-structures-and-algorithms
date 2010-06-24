/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package u1a3;

import java.util.Random;

/**
 *
 * @author Lukas Elmer
 */
public class Main {

    static int[] change = {1, 2, 5, 10, 20, 50, 100, 200};

    public static void main(String[] args) {
        Random r = new Random(10);
        for (int i = 0; i < 20; i++) {
            int num = r.nextInt(999) + 1;
            System.out.println(num + " = " + splitMoney(num));
        }
    }

    private static String splitMoney(int rest) {
        StringBuffer s = new StringBuffer();
        int changeIndex = change.length - 1;
        while (rest > 0) {
            while (rest >= change[changeIndex]) {
                s.append(change[changeIndex] + " + ");
                rest -= change[changeIndex];
            }
            changeIndex -= 1;
        }

        return s.substring(0, s.length() - 2); // remove last  ", "
    }
}

