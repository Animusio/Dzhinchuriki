package ZADACHKA1test;

import org.example.ZADACHKA1.GenericStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StorageTest {
    @Test
    void storageTest(){
        GenericStorage<String> storage = new GenericStorage<>();
        storage.addItem("bolt");

        Assertions.assertEquals("bolt",storage.getItem());

        GenericStorage<Integer> storage2 = new GenericStorage<>();
        storage2.addItem(213);

        Assertions.assertEquals(213,storage2.getItem());
    }

}
