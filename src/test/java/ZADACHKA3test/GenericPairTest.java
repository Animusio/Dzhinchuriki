package ZADACHKA3test;

import org.example.ZADACHKA3.GenericPair;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class GenericPairTest {

    @Test
    public void testGetters() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String firstValue = "Hello";
        Integer secondValue = 123;

        GenericPair<String, Integer> pair = new GenericPair<>(firstValue, secondValue);

        Field firstField = GenericPair.class.getDeclaredField("first");
        firstField.setAccessible(true);

        Method getFirstMethod = GenericPair.class.getDeclaredMethod("getFirst");
        getFirstMethod.setAccessible(true);

        assertEquals(firstValue, firstField.get(pair));
        assertEquals(firstValue, getFirstMethod.invoke(pair));

        Field secondField = GenericPair.class.getDeclaredField("second");
        secondField.setAccessible(true);

        Method getSecondMethod = GenericPair.class.getDeclaredMethod("getSecond");
        getSecondMethod.setAccessible(true);

        assertEquals(secondValue, secondField.get(pair));
        assertEquals(secondValue, getSecondMethod.invoke(pair));
    }
}
