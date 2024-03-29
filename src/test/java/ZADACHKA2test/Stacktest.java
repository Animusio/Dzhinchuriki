package ZADACHKA2test;

import org.example.ZADACHKA2.GenericStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class Stacktest {
    @Test
    public void testWithReflection() throws Exception {
        try {
        GenericStack<Integer> stack = new GenericStack<>();

        Integer newItem = 123;

        Method pushMethod = GenericStack.class.getDeclaredMethod("push", Object.class);
        pushMethod.setAccessible(true);

        pushMethod.invoke(stack, newItem);

        Method popMethod = GenericStack.class.getDeclaredMethod("pop");
        popMethod.setAccessible(true);

        popMethod.invoke(stack);

        Method isEmptyMethod = GenericStack.class.getDeclaredMethod("isEmpty");
        isEmptyMethod.setAccessible(true);

        boolean isEmpty = (boolean) isEmptyMethod.invoke(stack);
        Assertions.assertTrue(isEmpty);
        } catch (Exception e) {
            // Если возникло исключение, помечаем тест как проваленный
            org.junit.jupiter.api.Assertions.fail("Ошибка при тестировании метода: " + e.getMessage());
        }
    }
}
