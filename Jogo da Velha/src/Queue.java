import java.util.ArrayList;

public class Queue<T> {
    
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void enqueue(T data) {
        Node<T> aux = new Node<T>();
        aux.setData(data);
        if(this.head == null) {
            this.head = aux;
        } else {
            this.tail.setNext(aux);
        }
        this.tail = aux;
        this.size ++;
    }

    public T dequeue() {
        if(this.head != null) {
            Node<T> aux = this.head;
            this.head = this.head.getNext();
            if(this.head == null) {
                this.tail = null;
            }
            this.size --;
            return aux.getData();
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Node<T> getFirst(){
        return this.head;
    }

    @Override
    public String toString() {
        String out = "[";
        Node<T> aux = this.head;
        while(aux != null) {
            out += aux.getData().getClass();
            out += (aux.getNext() != null ? ", " : "]");
            aux = aux.getNext();
        }
        return out;
    }

    public void enqueueAll(ArrayList<T> vizinhos) {
        for(int i = 0; i<vizinhos.size(); i++) {
            Node<T> aux = new Node<T>();
            aux.setData(vizinhos.get(i));
            if(this.head == null) {
                this.head = aux;
            } 
            else {
                this.tail.setNext(aux);
            }
            this.tail = aux;
            this.size ++;
        }
    }

}