/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-04-09 14:47:32 +0200 (Fr, 09 Apr 2010) $
 */
package u7a1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapImpl<K, V> implements Map<K, V> {

    private LinkedList<MapEntry<K, V>> list = new LinkedList<MapEntry<K, V>>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean containsKey(Object key) {
        for (MapEntry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for (MapEntry<K, V> entry : list) {
            if (entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public V get(Object key) {
        for (MapEntry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public V put(K key, V value) {
        V oldValueInList = get(key);
        if (oldValueInList == null) {
            list.add(new MapEntry<K, V>(key, value));
        } else {
            for (MapEntry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    break;
                }
            }
        }
        return oldValueInList;
    }

    private V put(MapEntry<K, V> entry) {
        put(entry.getKey(), entry.getValue());
        return null;
    }

    public V remove(Object key) {
        V oldValueInList = get(key);
        if (oldValueInList != null) {
            for (MapEntry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    list.remove(entry);
                    break;
                }
            }
        }
        return oldValueInList;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void clear() {
        list.clear();
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<K>(list.size());
        for (MapEntry<K, V> entry : list) {
            keySet.add(entry.getKey());
        }
        return keySet;
    }

    public Collection<V> values() {
        Collection<V> values = new ArrayList<V>(list.size());
        for (MapEntry<K, V> entry : list) {
            values.add(entry.getValue());
        }
        return values;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<Entry<K, V>>(list.size());
        for (MapEntry<K, V> entry : list) {
            entrySet.add(entry);
        }
        return entrySet;
    }

    public void print() {
        System.out.println("Printing map (" + list.size() + " Entries)");
        for (MapEntry<K, V> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        MapImpl<Integer, String> map1 = new MapImpl<Integer, String>();
        map1.put(1, "one");
        map1.put(5, "five");
        map1.put(10, "ten");
        map1.put(5, "five");
        map1.put(54, "fifty-four");
        map1.print();

        MapImpl<Integer, String> map2 = new MapImpl<Integer, String>();
        map2.put(2, "two");
        map2.put(6, "six");
        map2.put(5, "five");
        map2.put(11, "eleven");
        map2.put(55, "fifty-five");
        map2.put(6, "six");
        map2.print();

        map1.putAll(map2);
        map1.print();

    }
}

/* Session-Log:

Printing map (4 Entries): 
1: one
5: five
10: ten
54: fifty-four
Printing map (5 Entries): 
2: two
6: six
5: five
11: eleven
55: fifty-five
Printing map (8 Entries): 
1: one
5: five
10: ten
54: fifty-four
2: two
11: eleven
55: fifty-five
6: six

 */
