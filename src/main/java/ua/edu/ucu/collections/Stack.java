package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList myList = new ImmutableLinkedList();

    public Object peek(){
        return myList.getLast();
    }

    public Object pop(){
        Object popped = peek();
        myList = myList.removeLast();
        return popped;
    }

    void push(Object e) {
        myList = myList.addLast(e);
    }

    public String toString(){
        return myList.toString();
    }

}
