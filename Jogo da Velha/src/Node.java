public class Node<T> {

    private T data;
    private Node<T> next;

    public void setData(T d) {
        this.data = d;
    }

    public void setNext(Node<T> n) {
        this.next = n;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }


}