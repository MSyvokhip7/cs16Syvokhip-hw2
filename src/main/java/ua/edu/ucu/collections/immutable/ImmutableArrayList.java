package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    public Object[] myList = new Object[0];
    public int size;

    @Override
    public ImmutableArrayList add(Object e) {
        size++;
        Object[] newList = new Object[size];
        if (myList.length > 0) {
            System.arraycopy(myList, 0, newList, 0, myList.length);
        }
        newList[size - 1] = e;
        ImmutableArrayList myNewList = new ImmutableArrayList();
        myNewList.myList = newList;
        myNewList.size = size;
        return myNewList;
    }

    @Override
    public ImmutableArrayList add(int index, Object e)  {
        if (index > myList.length) {
            throw new IndexOutOfBoundsException();
        }
        size++;
        Object[] newList = new Object[size];
        System.arraycopy(myList, 0, newList, 0, index);
        newList[index] = e;
        System.arraycopy(myList, index, newList, index + 1, myList.length - index);

        ImmutableArrayList myNewList = new ImmutableArrayList();
        myNewList.myList = newList;
        myNewList.size = size;
        return myNewList;
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        size += c.length;
        Object[] newList = new Object[size];
        if (myList.length > 0) {
            System.arraycopy(myList, 0, newList, 0, myList.length);
            System.arraycopy(c, 0, newList, myList.length, c.length);
        }
        else {
            System.arraycopy(c, 0, newList, 0, c.length);
        }

        ImmutableArrayList myNewList = new ImmutableArrayList();
        myNewList.myList = newList;
        myNewList.size = size;
        return myNewList;
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c)  {
        if (index > myList.length) {
            throw new IndexOutOfBoundsException();
        }
        size += c.length;
        Object[] newList = new Object[size];
        System.arraycopy(myList, 0, newList, 0, index);
        System.arraycopy(c, 0, newList, index, c.length);
        System.arraycopy(myList, index, newList, index + c.length, myList.length - index);

        ImmutableArrayList myNewList = new ImmutableArrayList();
        myNewList.myList = newList;
        myNewList.size = size;
        return myNewList;
    }

    @Override
    public Object get(int index) {
        if (index > myList.length) {
            throw new IndexOutOfBoundsException();
        }
        return myList[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index > myList.length) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableArrayList myNewList = new ImmutableArrayList();
        myNewList.myList = new Object[myList.length];
        System.arraycopy(myList, 0, myNewList.myList, 0, myList.length);
        myNewList.size = size;
        myNewList.myList[index] = null;
        myNewList.size--;
        return myNewList;
    }

    @Override
    public ImmutableArrayList set(int index, Object e)  {
        if (index > myList.length) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = new Object[size];
        System.arraycopy(myList, 0, newList, 0, myList.length);
        newList[index] = e;
        ImmutableArrayList myNewList = new ImmutableArrayList();
        myNewList.myList = newList;
        myNewList.size = size;
        return myNewList;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < myList.length; i++) {
            if (myList[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < myList.length; ++ i) {
            if (myList[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public Object[] toArray() {
        return myList;
    }

    public String toString() {
        return Arrays.toString(myList);
    }
}