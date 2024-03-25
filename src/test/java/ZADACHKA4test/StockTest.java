package ZADACHKA4test;

import org.example.ZADACHKA4.GenericStock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StockTest {
    GenericStock<String> stock = new GenericStock<>();
    @Test
    public void testAdd() {
        stock.add("123", 10);
        Assertions.assertEquals(10, stock.getQuantity("123"));
    }
    @Test
    public void testRemove() {
        stock.add("456", 20);
        stock.remove("456");
        Assertions.assertEquals(0, stock.getQuantity("456"));
    }
    @Test
    public void testGetQuantity() {
        Assertions.assertEquals(0, stock.getQuantity("789"));
    }

}
