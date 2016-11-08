package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList test;
    public ImmutableLinkedListTest() {
        test = new ImmutableLinkedList();
        test = test.addAll(new Object[] {1, 77, 27, "aa"});
    }

    @Test
    public void add() throws Exception {
        ImmutableLinkedList myLinkedList = new ImmutableLinkedList();
        String expected = "1 3 2 ";
        myLinkedList = myLinkedList.add(1);
        myLinkedList = myLinkedList.add(2);
        myLinkedList = myLinkedList.add(1, 3);
        assertEquals(myLinkedList.toString(), expected);
    }
    @Test
    public void addFirst() throws Exception {
        ImmutableLinkedList myLinkedList = new ImmutableLinkedList();
        String expected = "7 0 1 ";
        myLinkedList = myLinkedList.addFirst(1);
        myLinkedList = myLinkedList.addFirst(0);
        myLinkedList = myLinkedList.addFirst(7);
        assertEquals(myLinkedList.toString(), expected);

    }

    @Test
    public void addAll() throws Exception {
        ImmutableLinkedList myLinkedList = new ImmutableLinkedList();
        String expected = "1 2 3 ";
        Integer[] arr = new Integer[]{1, 2, 3};
        myLinkedList = myLinkedList.addAll(arr);
        assertEquals(myLinkedList.toString(), expected);
    }

    @Test
    public void get() throws Exception {
        ImmutableLinkedList myLinkedList = new ImmutableLinkedList();
        Integer[] arr = new Integer[]{1, 2, 3};
        myLinkedList = myLinkedList.addAll(arr);
        assertEquals((myLinkedList.get(0)), 1);
    }

    @Test
    public void set() throws Exception {
        ImmutableLinkedList myLinkedList = new ImmutableLinkedList();
        String expected = "1 2 3 777 ";
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        myLinkedList = myLinkedList.addAll(arr);
        myLinkedList = myLinkedList.set(3, 777);
        assertEquals(myLinkedList.toString(), expected);
    }

    @Test
    public void indexOf() throws Exception {
        assertEquals(test.indexOf(77), 1);
    }

    @Test
    public void size() throws Exception {
        assertEquals(test.size(), 4);
    }

    @Test
    public void clear() throws Exception {
        test = test.clear();
        assertEquals(test.toString(), "");
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(test.isEmpty(), false);
    }

    @Test
    public void toArray() throws Exception {
        Object[] arr = test.toArray();
        String expected = "[1, 77, 27, aa]";
        assertEquals(Arrays.toString(arr), expected);
    }
}
