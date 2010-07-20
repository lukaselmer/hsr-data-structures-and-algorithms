/*
 * HSR - Uebungen Programmieren 2
 * $LastChangedDate: 2010-04-09 14:47:32 +0200 (Fr, 09 Apr 2010) $
 */

package u7a2;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UIDGeneratorJUnitTest {

  private static Map<String, String> uids;
  private UIDGenerator gen;

  @BeforeClass
  public static void init() throws Exception {
    File f = new File(UIDGenerator.SAVE_FILE);
    if (f.exists()) {
      FileInputStream fis = new FileInputStream(f);
      ObjectInputStream ois = new ObjectInputStream(fis);
      uids = (Map<String, String>) ois.readObject();
      ois.close();
    } else {
      String errMsg = "File can\'t be opened: " + UIDGenerator.SAVE_FILE;
      System.err.println(errMsg);
      fail(errMsg);
    }
    // make sure that our test-case "xabcdefg" is not already in the map
    if (uids.get("xabcdefg") != null) {
      String errMsg = "UserId \"xabcdefg\" should not be already in the map, is the test-case! Please remove it.";
      System.err.println(errMsg);
      fail(errMsg);
    }
  }

  @Before
  public void initTest() {
    gen = new UIDGenerator(uids);
  }

  @Test
  public void testStandardCase() {
    String firstName = "Xyz";
    String lastName = "Abcdefghijk";
    String uid = gen.generateUID(firstName, lastName);
    assertTrue(uid.equals("xabcdefg"));
    uids.put(uid, firstName + " " + lastName);
    uid = gen.generateUID(firstName, lastName);
    assertTrue(uid.equals("x1abcdef"));
  }

  @Test
  public void testShortName() {
    String firstName = "Xyz";
    String lastName = "Abc";
    String uid = gen.generateUID(firstName, lastName);
    assertTrue(uid.equals("xabc"));
  }

  @Test
  public void testManySameName() {
    String firstName = "Xyz";
    String lastName = "Abcdefghijk";
    String uid = gen.generateUID(firstName, lastName);
    assertTrue(uid.equals("x1abcdef")); // be aware: "xabcdefg" has been inserted above
    uids.put(uid, firstName + " " + lastName);
    for (int i = 2; i <= 1000; i++) {
      uid = gen.generateUID(firstName, lastName);
      uids.put(uid, firstName + " " + lastName);
    }
    assertEquals(uid, "x1000abc");
  }

}
 
