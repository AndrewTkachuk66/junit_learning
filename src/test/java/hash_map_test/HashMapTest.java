package hash_map_test;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**Write unit tests which will verify the following properties of the java.util.HashMap class:
        • an object stored with the put() method can be retrieved with the get() method,
        • adding a second object with the same key results in the old value being replaced ,
        • the clear() method removes all its content,
        • the null value can be used as a key,
 Additional requirements and hints:
 • use the appropariate JUnit annotations to create a fresh, empty map before each test method is called
 (see Section 3.8),
 • Javadocs of the java.util.HashMap class can be accessed at http://download.oracle.com/javase/6/
 docs/api/java/util/HashMap.html**/
public class HashMapTest {

    Map<Integer, String> testedHashMap;

    @Before
    public void setUp(){
      testedHashMap  = new HashMap();
    }

    @Test
    public void testMethodPut(){
        testedHashMap.put(1, "One");
        assertEquals("One",testedHashMap.get(1));

    }

    @Test
    public void putMethodInHashMapShouldReplaceOldObject(){
        testedHashMap.put(1, "One");
        testedHashMap.put(1, "ONE");
        assertNotEquals("One", testedHashMap.get(1));
    }
    @Test
    public void clearMethodRemoveAllObjFromHashMap(){
        testedHashMap.put(1, "One");
        testedHashMap.put(2, "two");
        testedHashMap.clear();
        assertNull(null,testedHashMap.get(1));
        assertNull(null,testedHashMap.get(2));
    }

    @Test
    public void nullObjCanBeKey(){
        testedHashMap.put(null, "One");
        testedHashMap.get(null);
    }
}
