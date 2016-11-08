package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void peek() throws Exception {
        Stack myStack = new Stack();
        String expected = "MS7";
        myStack.push(1);
        myStack.push(5);
        myStack.push("MS7");
        assertEquals(myStack.peek(), expected);
    }

    @Test
    public void pop() throws Exception {
        Stack myStack = new Stack();
        String expected = "1 ";
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        myStack.pop();
        assertEquals(myStack.toString(), expected);
    }

    @Test
    public void add() throws Exception {
        Stack myStack = new Stack();
        String expected = "1 2 3 4 ";
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        assertEquals(myStack.toString(), expected);
    }
}
