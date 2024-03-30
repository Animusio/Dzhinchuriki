package ZADACHKA1test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StorageTest {
    @Test
    void storageTest(){

        Class<?> classobj = null;
        try {
            classobj = Class.forName("org.example.ZADACHKA1.GenericStorage");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Класс не найден");
        }
        try {
            Object classStorageInstance1 = classobj.getConstructor().newInstance();
            Object classStorageInstance2 = classobj.getConstructor().newInstance();

            Method Method1 = classStorageInstance1.getClass().getDeclaredMethod("addItem", Object.class);
            Method Method2 = classStorageInstance2.getClass().getDeclaredMethod("addItem", Object.class);

            Method1.setAccessible(true);
            Method2.setAccessible(true);

            Method1.invoke(classStorageInstance1, "Test Item");
            Method2.invoke(classStorageInstance2, 323232);

            Method Method3 = classStorageInstance1.getClass().getDeclaredMethod("getItem");
            Method Method4 = classStorageInstance2.getClass().getDeclaredMethod("getItem");

            Method3.setAccessible(true);
            Method4.setAccessible(true);

            String result = (String) Method3.invoke(classStorageInstance1);
            int result2 = (Integer) Method4.invoke(classStorageInstance2);


            Assertions.assertEquals("Test Item", result);
            Assertions.assertEquals(323232, result2);
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
