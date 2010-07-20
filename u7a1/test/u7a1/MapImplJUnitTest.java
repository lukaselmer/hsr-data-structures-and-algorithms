package u7a1;

/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-04-09 14:47:32 +0200 (Fr, 09 Apr 2010) $
 */
import static org.junit.Assert.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.junit.Before;
import org.junit.Test;

public class MapImplJUnitTest {

    private MapImpl<Integer, String> map;

    @Before
    public void initTest() {
        map = new MapImpl<Integer, String>();
    }

    @Test
    public void testFillingAndRemoving() {
        final int LEN = 3;
        assertTrue(map.isEmpty());
        assertTrue(map.size() == 0);
        for (int i = 0; i < LEN; i++) {
            map.put(i, "String_" + i);
            assertTrue(map.size() == (i + 1));
        }
        for (int i = 0; i < LEN; i++) {
            map.remove(i);
            assertTrue(map.size() == (LEN - i - 1));
        }
        assertTrue(map.isEmpty());
        assertTrue(map.size() == 0);
    }

    @Test
    public void testSearching() {
        assertFalse(map.containsKey(0));
        assertFalse(map.containsValue("String_0"));
        assertNull(map.get(0));
        assertNull(map.remove(0));
        final int LEN = 10000;
        fillMapWithEntries(map, LEN);
        assertTrue(map.size() == LEN);
        assertTrue(map.get(0).equals("String_0"));
        assertTrue(map.containsKey(LEN - 1));
        assertTrue(map.containsValue("String_" + (LEN - 1)));
        assertFalse(map.containsKey(LEN));
        assertFalse(map.containsValue("String_" + (LEN)));
    }

    @Test
    public void testPutAll() {
        MapImpl<Integer, String> map1 = new MapImpl<Integer, String>();
        fillMapWithEntries(map1, 1, 10);
        MapImpl<Integer, String> map2 = new MapImpl<Integer, String>();
        fillMapWithEntries(map2, 5, 10);
        map1.putAll(map2);
        assertTrue(map1.size() == 14);
    }

    @Test
    public void testSets() {
        final int LEN = 3;
        fillMapWithEntries(map, LEN);
        Set<Entry<Integer, String>> entrySet = map.entrySet();
        assertTrue(entrySet.size() == LEN);
        Set<Integer> keySet = map.keySet();
        Collection<String> valueCollection = map.values();
        for (int i = 0; i < LEN; i++) {
            assertTrue(keySet.contains(i));
            assertTrue(valueCollection.contains("String_" + i));
        }
        map.clear();
        assertTrue(map.size() == 0);
    }

    /**
     * Filling the map with sequence of entries: [1, "String_1"], [2, "String_2"],
     * ...
     *
     * @param map
     *          The map to fill.
     * @param nr
     *          Number of entries to fill.
     */
    private void fillMapWithEntries(Map<Integer, String> map, int nr) {
        fillMapWithEntries(map, 0, nr);
    }

    /**
     * Filling the map with sequence of entries: [`start`, "String_`start`"],
     * [`start+1`, "String_`start+1`"], ...
     *
     * @param map
     *          The map to fill.
     * @param start
     *          Number for first entry.
     * @param nr
     *          Number of entries to fill.
     */
    private void fillMapWithEntries(Map<Integer, String> map, int start, int nr) {
        for (int i = start; i < start + nr; i++) {
            map.put(i, "String_" + i);
        }
    }
}
