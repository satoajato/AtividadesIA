public class Queue<T> {
    
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void enqueue(T data, int h) {
        Node<T> aux = new Node<T>(h);
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
        headpriority();
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

    private void headpriority() {
        Node<T> aux = this.head;
        Node<T> menor = new Node<>(Integer.MAX_VALUE);
        enqueue(this.head.getData(), this.head.getH());
        
        while(aux != null) {
            if(menor.getH() >= aux.getH()) {
                menor = aux;
            }
            aux = aux.getNext();
        }
        this.head = menor;
        menor = menor.getNext();
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

    public boolean contains(T filho) {
        Node<T> aux = this.head;

        while(aux != null) {
            if(aux.getData().equals(filho)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public int maxH() {
        int Hmaximo = 0;
        Node<T> aux = this.head;

        while(aux != null) {
            if(Hmaximo < aux.getH()) {
                Hmaximo = aux.getH();
            }
            aux = aux.getNext();
        }
        return Hmaximo;
    }

}