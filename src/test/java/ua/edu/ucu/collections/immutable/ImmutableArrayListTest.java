package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;


public class ImmutableArrayListTest {

    @Test
    public void add() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        String expected = "[1]";
        myArrayList = myArrayList.add(1);
        assertEquals(myArrayList.toString(), expected);
    }

    @Test
    public void add1() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        String expected = "[1, 3, 2]";
        myArrayList = myArrayList.add(1);
        myArrayList = myArrayList.add(2);
        myArrayList = myArrayList.add(1, 3);
        assertEquals(myArrayList.toString(), expected);

    }

    @Test
    public void addAll() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        String expected = "[1, 2, 3, 4]";
        myArrayList = myArrayList.add(1);
        myArrayList = myArrayList.add(2);
        Integer[] arr = new Integer[]{3, 4};
        myArrayList = myArrayList.addAll(arr);
        assertEquals(myArrayList.toString(), expected);
    }

    @Test
    public void addAll1() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        String expected = "[1, 2, 3, 4]";
        myArrayList = myArrayList.add(1);
        myArrayList = myArrayList.add(4);
        Integer[] arr = new Integer[]{2, 3};
        myArrayList = myArrayList.addAll(1, arr);
        assertEquals(myArrayList.toString(), expected);

    }

    @Test
    public void get() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        myArrayList = myArrayList.add(1);
        myArrayList = myArrayList.add(2);
        myArrayList = myArrayList.add(3);
        assertEquals(myArrayList.get(2), 3);

    }

    @Test
    public void remove() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        String expected = "[null, 2]";
        myArrayList = myArrayList.add(1);
        myArrayList = myArrayList.add(2);
        myArrayList = (ImmutableArrayList) myArrayList.remove(0);
        assertEquals(myArrayList.toString(), expected);

    }

    @Test
    public void set() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        String expected = "[0, 2]";
        myArrayList = myArrayList.add(1);
        myArrayList = myArrayList.add(2);
        myArrayList = myArrayList.set(0, 0);
        assertEquals(myArrayList.toString(), expected);

    }

    @Test
    public void indexOf() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        myArrayList = myArrayList.add(1);
        myArrayList = myArrayList.add(2);
        assertEquals(myArrayList.indexOf(1), 0);

    }

    @Test
    public void size() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        myArrayList = myArrayList.add(1);
        myArrayList = myArrayList.add(2);
        assertEquals(myArrayList.size(), 2);

    }

    @Test
    public void clear() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        myArrayList = myArrayList.add(1);
        myArrayList = myArrayList.add(2);
        myArrayList = (ImmutableArrayList) myArrayList.clear();
        assertEquals(myArrayList.toString(), "[]");

    }

    @Test
    public void isEmpty() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        myArrayList = myArrayList.add(1);
        myArrayList = myArrayList.add(2);
        assertEquals(myArrayList.isEmpty(), false);
    }

    @Test
    public void toArray() throws Exception {
        ImmutableArrayList myArrayList = new ImmutableArrayList();
        myArrayList = myArrayList.add(1);
        myArrayList = myArrayList.add(2);
        myArrayList = (ImmutableArrayList) myArrayList.clear();
        assertEquals(Arrays.toString(myArrayList.toArray()), "[]");
    }
}
