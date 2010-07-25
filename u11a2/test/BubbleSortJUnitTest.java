/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-05-07 14:25:50 +0200 (Fr, 07 Mai 2010) $
 */



import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortJUnitTest {

  private static int LENGTH = 1000;

  Integer[] sequence;
  Integer[] sequenceSorted;

  @Before
  public void setUp() {
    sequence = new Integer[LENGTH];
    for (int i = 0; i < sequence.length; i++) {
      sequence[i] = (int) (Math.random() * 11);
    }
    sequenceSorted = new Integer[LENGTH];
    System.arraycopy(sequence, 0, sequenceSorted, 0, sequence.length);
    Arrays.sort(sequenceSorted);
  }

  @Test
  public void testBubbleSort1() {
    BubbleSort.bubbleSort1(sequence);
    verify(sequence);
  }

  @Test
  public void testBubbleSort2() {
    BubbleSort.bubbleSort2(sequence);
    verify(sequence);
  }

  private void verify(Integer[] s) {
    for (int i = 0; i < sequenceSorted.length; i++) {
      assertEquals(sequenceSorted[i], s[i]);
    }
  }

}
 
 
