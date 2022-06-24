public class Aresta<T> {
    private Vertice<T> inicio;
    private Vertice<T> fim;
    private int peso;

    public Aresta(Vertice<T> start, Vertice<T> end, int weight) {
        this.inicio = start;
        this.fim = end;
        this.peso = weight;
    }

    public Aresta(Vertice<T> start, Vertice<T> end) {
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