public class Node<T> {
    private int H;
    private T data;
    private Node<T> next;

    public Node(int heuristic) {
        this.H = heuristic;
    }

    public int getH() {
        return H;
    }

    public void setH(int h) {
        H = h;
    }

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