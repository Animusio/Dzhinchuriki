package ZADACHKA1test;

import org.example.ZADACHKA1.GenericStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StorageTest {
    @Test
    void storageTest(){
        try {
            GenericStorage<String> storage = new GenericStorage<>();

            Method addItemMethod = GenericStorage.class.getDeclaredMethod("addItem", Object.class);
            addItemMethod.setAccessible(true);
            addItemMethod.invoke(storage, "Test Item");

            Method getItemMethod = GenericStorage.class.getDeclaredMethod("getItem");
            getItemMethod.setAccessible(true);
            String result = (String) getItemMethod.invoke(storage);

            assertEquals("Test Item", result);
        } catch (Exception e) {
            // Если возникло исключение, помечаем тест как проваленный
            org.junit.jupiter.api.Assertions.fail("Ошибка при тестировании метода: " + e.getMessage());
        }
    }


}
