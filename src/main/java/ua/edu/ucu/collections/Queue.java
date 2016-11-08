package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    public ImmutableLinkedList myList = new ImmutableLinkedList();

    public Object peek(){
        return myList.getFirst();
    }

    public Object dequeue(){
        Object first = peek();
        myList = myList.remove(0);
        return first;
    }

    public void enqueue(Object e){
        myList = myList.addLast(e);
    }

    public String toString(){
        return myList.toString();
    }
}
