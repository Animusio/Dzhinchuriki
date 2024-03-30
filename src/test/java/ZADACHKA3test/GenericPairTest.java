package ZADACHKA3test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GenericPairTest {

    @Test
    public void testGetters(){
        Class<?> classobj = null;
        try {
            classobj = Class.forName("org.example.ZADACHKA3.GenericPair");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Класс не найден");
        }
        try {
            Object classStorageInstance1 = classobj.getConstructor(Object.class, Object.class).newInstance("dwdw", 123123);
            Object classStorageInstance2 = classobj.getConstructor(Object.class, Object.class).newInstance(1234, "1231");

            Method Method1 = classStorageInstance1.getClass().getDeclaredMethod("getFirst");
            Method Method2 = classStorageInstance1.getClass().getDeclaredMethod("getSecond");

            Method Method21 = classStorageInstance2.getClass().getDeclaredMethod("getFirst");
            Method Method22 = classStorageInstance2.getClass().getDeclaredMethod("getSecond");

            Method1.setAccessible(true);
            Method2.setAccessible(true);

            Method21.setAccessible(true);
            Method22.setAccessible(true);

            Assertions.assertEquals(Method1.invoke(classStorageInstance1),"dwdw");
            Assertions.assertEquals(Method2.invoke(classStorageInstance1), 123123);

            Assertions.assertEquals(Method21.invoke(classStorageInstance2),1234);
            Assertions.assertEquals(Method22.invoke(classStorageInstance2), "1231");

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
