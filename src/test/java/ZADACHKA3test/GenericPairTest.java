package ZADACHKA3test;

import org.example.ZADACHKA3.GenericPair;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class GenericPairTest {

    @Test
    public void testGetters() throws Exception {

        GenericPair<String, Integer> pair = new GenericPair<>("Hello", 123);

        Field firstField = GenericPair.class.getDeclaredField("first");
        firstField.setAccessible(true);

        Method getFirstMethod = GenericPair.class.getDeclaredMethod("getFirst");
        getFirstMethod.setAccessible(true);

        assertEquals("Hello", firstField.get(pair));
        assertEquals("Hello", getFirstMethod.invoke(pair));


        Field secondField = GenericPair.class.getDeclaredField("second");
        secondField.setAccessible(true);

        Method getSecondMethod = GenericPair.class.getDeclaredMethod("getSecond");
        getSecondMethod.setAccessible(true);

        assertEquals(123, secondField.get(pair));
        assertEquals(123, getSecondMethod.invoke(pair));
    }
}
