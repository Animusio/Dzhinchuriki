package ZADACHKA3test;

import org.example.ZADACHKA2.GenericStack;
import org.example.ZADACHKA3.GenericPair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Pairtest {
    @Test
    void pairTest(){
        GenericPair<String, Integer> pair = new GenericPair<>("Alex",1973);
        Assertions.assertEquals("Alex",pair.getFirst());
        Assertions.assertEquals(1973,pair.getSecond());

        GenericPair<Integer, String> pair2 = new GenericPair<>(1973,"Alex");
        Assertions.assertEquals("Alex",pair2.getSecond());
        Assertions.assertEquals(1973,pair2.getFirst());
    }
}
