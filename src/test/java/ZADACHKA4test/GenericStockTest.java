package ZADACHKA4test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;

import java.lang.reflect.InvocationTargetException;

public class GenericStockTest {
    @Test
    public void testPrivateMethods(){
        Class<?> genericStockClass = null;
        try {
            genericStockClass = Class.forName("org.example.ZADACHKA4.GenericStock");
        } catch (ClassNotFoundException e) {
            Assertions.fail("Класс не найден");
        }
        try {

            Constructor<?> genericStockConstructor = genericStockClass.getDeclaredConstructor();
            genericStockConstructor.setAccessible(true);
            Object genericStock = genericStockConstructor.newInstance();

            Method addMethod = genericStockClass.getDeclaredMethod("add", Object.class, int.class);
            Method removeMethod = genericStockClass.getDeclaredMethod("remove", Object.class);
            Method getQuantityMethod = genericStockClass.getDeclaredMethod("getQuantity", Object.class);
            Method getAllItemsMethod = genericStockClass.getDeclaredMethod("getAllItems");

            addMethod.setAccessible(true);
            removeMethod.setAccessible(true);
            getQuantityMethod.setAccessible(true);
            getAllItemsMethod.setAccessible(true);

            addMethod.invoke(genericStock, "Item1", 10);
            addMethod.invoke(genericStock, "Item2", 20);
            removeMethod.invoke(genericStock, "Item1");

            Assertions.assertEquals(20, getQuantityMethod.invoke(genericStock, "Item2"));
            Assertions.assertNull(getQuantityMethod.invoke(genericStock, "Item1"));
            Set<?> allItems = (Set<?>) getAllItemsMethod.invoke(genericStock);
            Assertions.assertEquals(Set.of("Item2"), allItems);






            Constructor<?> genericStockConstructor2 = genericStockClass.getDeclaredConstructor();
            genericStockConstructor2.setAccessible(true);
            Object genericStock2 = genericStockConstructor2.newInstance();

            Method addMethod2 = genericStockClass.getDeclaredMethod("add", Object.class, int.class);
            Method removeMethod2 = genericStockClass.getDeclaredMethod("remove", Object.class);
            Method getQuantityMethod2 = genericStockClass.getDeclaredMethod("getQuantity", Object.class);
            Method getAllItemsMethod2 = genericStockClass.getDeclaredMethod("getAllItems");

            addMethod2.setAccessible(true);
            removeMethod2.setAccessible(true);
            getQuantityMethod2.setAccessible(true);
            getAllItemsMethod2.setAccessible(true);

            addMethod.invoke(genericStock2, "Item1", 10);
            addMethod.invoke(genericStock2, "Item2", 20);
            removeMethod.invoke(genericStock2, "Item1");

            Assertions.assertEquals(20, getQuantityMethod.invoke(genericStock, "Item2"));
            Assertions.assertNull(getQuantityMethod.invoke(genericStock, "Item1"));
            Set<String> allItems2 = (Set<String>) getAllItemsMethod.invoke(genericStock);
            Assertions.assertEquals(Set.of("Item2"), allItems2);

        }
        catch (NoSuchMethodException e){
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
