/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-04-24 08:49:59 +0200 (Sa, 24 Apr 2010) $
 */
package u9a4;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import u9a4.BinarySearchTree.Entry;

public class BinarySearchTreeJUnitTest {

    BinarySearchTree<Integer, String> bts;

    @Before
    public void setUp() {
        bts = new BinarySearchTree<Integer, String>();
    }

    @Test
    public void testEmptySizeInsertClear() {
        assertTrue(bts.isEmpty() == true);
        assertTrue(bts.size() == 0);
        bts.insert(1, "String_1");
        assertTrue(bts.size() == 1);
        assertTrue(bts.isEmpty() == false);
        bts.insert(2, "String_2");
        assertTrue(bts.size() == 2);
        bts.insert(2, "String_2");
        assertTrue(bts.size() == 3);
        bts.clear();
        assertTrue(bts.isEmpty() == true);
        assertTrue(bts.size() == 0);
    }

    @Test
    public void testGetHeight() {
        assertTrue(bts.getHeight() == -1);
        bts.insert(1, "String_1");
        assertTrue(bts.getHeight() == 0);
        bts.insert(2, "String_2");
        assertTrue(bts.getHeight() == 1);
    }

    @Test
    public void testFind() {
        Entry<Integer, String> entry;
        entry = bts.find(1);
        assertTrue(entry == null);
        Entry<Integer, String> insertedEntry = bts.insert(1, "String_1");
        entry = bts.find(1);
        assertTrue(entry != null);
        assertTrue(entry.getKey() == 1);
        assertTrue(entry.getValue().equals("String_1"));
        assertTrue(entry == insertedEntry);
    }

    @Test
    public void testFindAll() {
        Collection<Entry<Integer, String>> col;
        col = bts.findAll(1);
        assertTrue(col.size() == 0);
        bts.insert(1, "String_1");
        col = bts.findAll(2);
        assertTrue(col.size() == 0);
        bts.insert(2, "String_2");
        col = bts.findAll(2);
        assertTrue(col.size() == 1);
        bts.insert(2, "String_2");
        col = bts.findAll(2);
        assertTrue(col.size() == 2);
    }

    @Test
    public void testRemove() {
        Entry<Integer, String> entry = new Entry<Integer, String>(1, "String_1");
        entry = bts.remove(entry);
        assertTrue(entry == null);
        final Entry<Integer, String> entry1 = bts.insert(1, "String_1");
        entry = bts.remove(entry1);
        assertTrue(entry == entry1);
        assertTrue(bts.size() == 0);
        final Entry<Integer, String> entry1a = bts.insert(1, "String_1a");
        final Entry<Integer, String> entry1b = bts.insert(1, "String_1b");
        assertTrue(bts.size() == 2);
        entry = bts.remove(entry1a);
        assertTrue(entry == entry1a);
        assertTrue(bts.size() == 1);
        entry = bts.remove(entry1b);
        assertTrue(entry == entry1b);
        assertTrue(bts.size() == 0);
    }

    @Test
    public void stressTest() {
        final int SIZE = 10000;
        Random randomGenerator = new Random();
        List<Entry<Integer, String>> entriesList = new LinkedList<Entry<Integer, String>>();
        // key-Counters: count for every key how many time it was generated
        Map<Integer, Integer> keyCounters = new Hashtable<Integer, Integer>();
        // fill the Tree
        for (int i = 0; i < SIZE; i++) {
            int key = (int) (randomGenerator.nextFloat() * SIZE / 3);
            Integer numberOfKeys = keyCounters.get(key);
            if (numberOfKeys == null) {
                numberOfKeys = 1;
            } else {
                numberOfKeys++;
            }
            keyCounters.put(key, numberOfKeys);
            Entry<Integer, String> entry = bts.insert(key, "String_" + i);
            entriesList.add(entry);
            assertTrue(bts.size() == i + 1);
        }
        // verify the number of entries per key
        for (Map.Entry<Integer, Integer> keyEntry : keyCounters.entrySet()) {
            int key = keyEntry.getKey();
            int numberOfKeys = keyEntry.getValue();
            assertTrue(bts.findAll(key).size() == numberOfKeys);
        }
        // remove all entries
        int size = bts.size();
        for (Entry<Integer, String> entry : entriesList) {
            Entry<Integer, String> deletedEntry = bts.remove(entry);
            assertTrue(deletedEntry == entry);
            assertTrue(bts.size() == --size);
        }
    }
}
