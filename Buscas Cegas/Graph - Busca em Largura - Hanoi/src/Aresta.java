public class Aresta<T> {
    private Vertice<T> inicio;
    private Vertice<T> fim;

    public Aresta(Vertice<T> start, Vertice<T> end) {
        this.inicio = start;
        this.fim = end;
    }

    public Vertice<T> getInicio() {
        return this.inicio;
    }

    public void setInicio(Vertice<T> inicio) {
        this.inicio = inicio;
    }

    public Vertice<T> getFim() {
        return this.fim;
    }

    public void setFim(Vertice<T> fim) {
        this.fim = fim;
    }

}