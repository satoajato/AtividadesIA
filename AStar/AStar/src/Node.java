public class Node<T> {

    private T data;
    private Node<T> next;
    private int custo;

    public Node(int cost) {
        this.custo = cost;
    }

    public int getCusto() {
        return this.custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
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