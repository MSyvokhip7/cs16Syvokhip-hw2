package ua.edu.ucu.collections.immutable;


/**
 * Created by TheOriginMS7 on 03.11.2016.
 */

public class Node implements Cloneable {
    Node next = null;
    Object data;

    public Node(Object data){
        this.data = data;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node clone(){
        return new Node(this.data);
    }

    public Object getData(){
        return data;
    }
}
