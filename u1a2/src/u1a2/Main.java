/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package u1a2;

import java.util.TreeMap;

/**
 *
 * @author Lukas Elmer
 */
public class Main {

    public static void main(String[] args) {
        String s = "Das Studium an der HSR kann manchmal nerven, speziell beim Programmieren!";
        Character[] characs = {'a', 'o', 'i', 'e', 'u'};
        TreeMap<Character, Integer> m = new TreeMap<Character, Integer>();

        for (int i = 0; i < characs.length; i++) {
            m.put(characs[i], 0);
        }

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer x = m.get(c);
            if (x != null) {
                m.put(c, x + 1);
            }
        }

        for (int i = 0; i < characs.length; i++) {
            System.out.println(characs[i] + "=" + m.get(characs[i]));
        }
    }
}
