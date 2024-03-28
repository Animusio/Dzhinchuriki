package ZADACHKA4test;

import org.example.ZADACHKA4.GenericStock;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

public class GenericStockTest {
    @Test
    public void testPrivateMethods() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // Создаем экземпляр класса GenericStock
        GenericStock<String> stock = new GenericStock<>();

        // Получаем доступ к приватному полю items с помощью рефлексии
        Field itemsField = GenericStock.class.getDeclaredField("items");
        itemsField.setAccessible(true);
        Map<String, Integer> items = (Map<String, Integer>) itemsField.get(stock);

        // Проверяем, что items пустой
        assertTrue(items.isEmpty());

        // Подготавливаем объекты для добавления в коллекцию
        String item1 = "Item1";
        String item2 = "Item2";
        int quantity1 = 10;
        int quantity2 = 20;

        // Получаем доступ к приватным методам с помощью рефлексии и устанавливаем их доступность
        Method addMethod = GenericStock.class.getDeclaredMethod("add", Object.class, int.class);
        Method removeMethod = GenericStock.class.getDeclaredMethod("remove", Object.class);
        Method getQuantityMethod = GenericStock.class.getDeclaredMethod("getQuantity", Object.class);
        Method getAllItemsMethod = GenericStock.class.getDeclaredMethod("getAllItems");
        addMethod.setAccessible(true);
        removeMethod.setAccessible(true);
        getQuantityMethod.setAccessible(true);
        getAllItemsMethod.setAccessible(true);

        // Вызываем приватные методы для добавления и удаления элементов
        addMethod.invoke(stock, item1, quantity1);
        addMethod.invoke(stock, item2, quantity2);
        removeMethod.invoke(stock, item1);

        // Проверяем результаты вызовов приватных методов
        assertEquals(quantity2, getQuantityMethod.invoke(stock, item2));
        assertNull(getQuantityMethod.invoke(stock, item1));
        assertFalse(((Set<String>) getAllItemsMethod.invoke(stock)).contains(item1));
        assertTrue(((Set<String>) getAllItemsMethod.invoke(stock)).contains(item2));
    }
}