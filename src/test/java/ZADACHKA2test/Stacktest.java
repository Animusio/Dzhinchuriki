package ZADACHKA2test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class Stacktest {
    @Test
    public void testWithReflection(){

        Class<?> classobj = null;
        try {
            classobj = Class.forName("org.example.ZADACHKA2.GenericStack");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Класс не найден");
        }
        try {
            Object classStorageInstance1 = classobj.getConstructor().newInstance();
            Object classStorageInstance2 = classobj.getConstructor().newInstance();

            Method Method1 = classStorageInstance1.getClass().getDeclaredMethod("push", Object.class);
            Method Method2 = classStorageInstance1.getClass().getDeclaredMethod("pop");
            Method Method3 = classStorageInstance1.getClass().getDeclaredMethod("peek");
            Method Method4 = classStorageInstance1.getClass().getDeclaredMethod("isEmpty");

            Method Method21 = classStorageInstance2.getClass().getDeclaredMethod("push", Object.class);
            Method Method22 = classStorageInstance2.getClass().getDeclaredMethod("pop");
            Method Method23 = classStorageInstance2.getClass().getDeclaredMethod("peek");
            Method Method24 = classStorageInstance2.getClass().getDeclaredMethod("isEmpty");

            Method1.setAccessible(true);
            Method2.setAccessible(true);
            Method3.setAccessible(true);
            Method4.setAccessible(true);

            Method21.setAccessible(true);
            Method22.setAccessible(true);
            Method23.setAccessible(true);
            Method24.setAccessible(true);

            Method1.invoke(classStorageInstance1, "Test Item 1");
            Method1.invoke(classStorageInstance1, "Test Item 2");
            Method2.invoke(classStorageInstance1);

            Method21.invoke(classStorageInstance2, 1);
            Method21.invoke(classStorageInstance2, 2);
            Method22.invoke(classStorageInstance2);

            String result1 = (String) Method3.invoke(classStorageInstance1);
            int result2 = (Integer) Method23.invoke(classStorageInstance2);

            Assertions.assertEquals("Test Item 1", result1);
            Assertions.assertEquals(1, result2);

            Method2.invoke(classStorageInstance1);
            Method22.invoke(classStorageInstance2);

            boolean boolres1 = (boolean)Method4.invoke(classStorageInstance1);
            boolean boolres2 = (boolean)Method24.invoke(classStorageInstance1);

            Assertions.assertTrue(boolres1);
            Assertions.assertTrue(boolres2);

        } catch (NoSuchMethodException e){
            Assertions.fail("АЛАРМ АЛАРМ  АЛАРМ ошибка в методе");
        }
        catch (InvocationTargetException e){
            Assertions.fail("АЛАРМ АЛАРМ  АЛАРМ вызываемый метод вызывает исключение");
        }
        catch (InstantiationException e){
            Assertions.fail("АЛАРМ АЛАРМ  АЛАРМ не удалось создать объект класса");
        }
        catch (IllegalAccessException e){
            Assertions.fail("АЛАРМ АЛАРМ  АЛАРМ нелегальная доступа к члену класса (полям, методам или конструкторам)");
        }
    }
}
