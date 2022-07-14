public class Edge<T> {
    private Vertex<T> inicio;
    private Vertex<T> fim;
    private int peso;

    public Edge(Vertex<T> start, Vertex<T> end, int weight) {
        this.inicio = start;
        this.fim = end;
        this.peso = weight;
    }

    public Edge(Vertex<T> start, Vertex<T> end) {
        this.inicio = start;
        this.fim = end;
        this.peso = 0;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
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