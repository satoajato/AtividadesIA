public class Stack<T> {
    
    private Node<T> top;
    private int size;

    public void push(T data) {
        Node<T> tmp = new Node<T>();
        tmp.setData(data);
        if(this.top != null) {
            tmp.setNext(this.top);
        }
        this.top = tmp;
        this.size ++;
    }

    public T pop() {
        if(this.top != null) {
            Node<T> aux = this.top;
            this.top = this.top.getNext();
            this.size --;
            return aux.getData();
        }
        return null;
    }

    public T top() {
        return (this.top != null ? this.top.getData() : null);
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String out = "top -> [";
        Node<T> aux = this.top;
        while(aux != null) {
            out += aux.getData().toString();
            out += (aux.getNext() != null ? ", " : "]");
            aux = aux.getNext();
        }
        return out;
    }
}