package ZADACHKA2test;

import org.example.ZADACHKA2.GenericStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Stacktest {
    @Test
    void stackTest(){
        GenericStack<String> stack = new GenericStack<>();
        stack.push("Aboba");
        stack.push("Abiba");
        stack.push("Ab");
        stack.pop();
        Assertions.assertEquals(stack.peek(),"Abiba");
        GenericStack<Integer> stack2 = new GenericStack<>();
        stack2.push(8982);
        Assertions.assertEquals(stack2.peek(),8982);
    }
}
