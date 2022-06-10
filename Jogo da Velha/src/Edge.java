public class Edge<T> {
    private Vertex<T> inicio;
    private Vertex<T> fim;

    public Edge(Vertex<T> start, Vertex<T> end) {
        this.inicio = start;
        this.fim = end;
    }

    public Vertex<T> getInicio() {
        return this.inicio;
    }

    public void setInicio(Vertex<T> inicio) {
        this.inicio = inicio;
    }

    public Vertex<T> getFim() {
        return this.fim;
    }

    public void setFim(Vertex<T> fim) {
        this.fim = fim;
    }

}