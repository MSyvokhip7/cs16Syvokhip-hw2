package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    protected Node head;
    protected int size;

    public ImmutableLinkedList(){
        head = new Node(null);
        size = 0;
    }

    public ImmutableLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    @Override
    public ImmutableLinkedList add(Object e){
        if (isEmpty()){
            return new ImmutableLinkedList(new Node(e), (size + 1));
        }
        else{
            Node newHead = copyLinkedList(head);
            Node this_node = newHead;
            while (this_node.getNext() != null){
                this_node = this_node.getNext();
            }
            this_node.setNext(new Node(e));
            return new ImmutableLinkedList(newHead, (size + 1));
        }
    }

    @Override
    public ImmutableLinkedList add(int index, Object e){
        if (index == 0) {
            return addFirst(e);
        } else {
            size++;
            int i = 0;
            Node newHead = copyLinkedList(head);
            Node current = newHead;
            while (i + 1 != index) {
                current = current.getNext();
                i++;
            }
            Node newNode = new Node(e);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            return new ImmutableLinkedList(newHead, size);
        }
    }

    public ImmutableLinkedList addFirst(Object e) {
        if (isEmpty()) {
            size++;
            head = new Node(e);
            return new ImmutableLinkedList(head, size);
        }
        size++;
        Node newHead = copyLinkedList(head);
        Node firstNode = new Node(e);
        firstNode.setNext(newHead);
        return new ImmutableLinkedList(firstNode, size);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        ImmutableLinkedList newList = new ImmutableLinkedList();
        for (int i = 0; i < c.length; i++) {
            newList = newList.add(c[i]);
        }
        return newList;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c){
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return addFirst(c);
        }
        size += c.length;
        int i = 0;
        Node newHead = copyLinkedList(head);
        Node start = newHead;
        while ((i + 1) != index) {
            start = start.getNext();
            i++;
        }
        Node startNodeNewPart = new Node(c[0]);
        Node startNode = startNodeNewPart;
        for (int j = 1; j < c.length; j++) {
            startNode.setNext(new Node(c[j]));
            startNode = startNode.getNext();
        }
        startNode.setNext(start.getNext());
        start.setNext(startNodeNewPart);
        return new ImmutableLinkedList(newHead, size);
    }

    @Override
    public Object get(int index)  {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = copyLinkedList(head);
        int i = 0;
        while (i != index) {
            current = current.getNext();
            i++;
        }
        return current.getData();
    }

    public Object getLast() {
        if (!isEmpty())
        {
            Node start = head;
            while (start.getNext() != null) {
                start = start.getNext();
            }
            return start.getData();
        }
        return null;
    }

    public Object getFirst() {
        return get(0);
    }

    @Override
    public ImmutableLinkedList remove(int index)  {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList newList = new ImmutableLinkedList();
        newList.size = size - 1;
        Node newHead = copyLinkedList(head);
        Node current = newHead;
        int i = 0;
        while ((i + 1) != index) {
            current = current.getNext();
            i++;
        }
        current.setNext(current.getNext().getNext());
        return new ImmutableLinkedList(newHead, size);
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }


    public ImmutableLinkedList removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        Node newHead = copyLinkedList(head);
        Node start = newHead;
        while (start.getNext().getNext() != null) {
            start = start.getNext();
        }
        start.setNext(null);
        return new ImmutableLinkedList(newHead, size);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e){
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node newHead = copyLinkedList(head);
            Node tmp = new Node(e);
            Node next = newHead.getNext();
            tmp.setNext(next);
            newHead = tmp;
            return new ImmutableLinkedList(newHead, size);
        }
        Node newHead = copyLinkedList(head);
        Node current = newHead;
        int i = 0;
        while ((i + 1)!= index) {
            current = current.getNext();
            i++;
        }
        Node tmp = new Node(e);
        tmp.setNext(current.getNext().getNext());
        current.setNext(tmp);
        return new ImmutableLinkedList(newHead, size);
    }

    @Override
    public int indexOf(Object e) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.getData() == e) {
                return position;
            }
            position++;
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableLinkedList clear() {
        ImmutableLinkedList newList = new ImmutableLinkedList();
        newList.head = null;
        newList.size = 0;
        return newList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] n = new Object[size];
        int i = 0;
        Node current = head;
        while (current != null) {
            n[i] = current.getData();
            current = current.getNext();
            i++;
        }
        return n;
    }


    @Override
    public String toString() {
        Node currentNode = head;
        String s = "";
        while (currentNode != null) {
            s += currentNode.getData().toString();
            s += ' ';
            currentNode = currentNode.getNext();
        }
        return s;
    }

    public Node copyLinkedList(Node head){
        Node currentNode = head;
        Node newHead = new Node(currentNode.getData());
        Node currentNew = newHead;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            currentNew.setNext(new Node(currentNode.getData()));
            currentNew = currentNew.getNext();
        }
        return newHead;
    }
}
