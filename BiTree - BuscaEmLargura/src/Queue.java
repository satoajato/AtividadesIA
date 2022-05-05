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

    @Override
    public String toString() {
        String out = "[";
        Node<T> aux = this.head;
        while(aux != null) {
            out += aux.getData().toString();
            out += (aux.getNext() != null ? ", " : "]");
            aux = aux.getNext();
        }
        return out;
    }

    public static void main(String[] args) {
        
        Queue<Integer> q = new Queue<Integer>();

        System.out.println("Inicio");
        
        q.enqueue(1);
        System.out.println(q.toString());
        q.enqueue(2);
        System.out.println(q.toString());
        q.enqueue(3);
        System.out.println(q.toString());
        q.enqueue(4);
        System.out.println(q.toString());

        System.out.println(q.dequeue());
        System.out.println(q.toString());
        System.out.println(q.dequeue());
        System.out.println(q.toString());

    }

}