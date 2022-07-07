import java.util.ArrayList;
public class Vertex<T> {
    private T dado;
    private int custo;
    private ArrayList<Edge<T>> vertAdj;
    private boolean marcado;

    public Vertex(T valor) {
        this.custo = 0;
        this.dado = valor;
        this.vertAdj = new ArrayList<Edge<T>>();
    }

    public int getCusto() {
        return this.custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public ArrayList<Edge<T>> getVertAdj() {
        return this.vertAdj;
    }

    public void setVertAdj(ArrayList<Edge<T>> vertAdj) {
        this.vertAdj = vertAdj;
    }

    public boolean isMarcado() {
        return this.marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public T getDado(){
        return this.dado;
    }

    public void setDado(T valor) {
        this.dado = valor;
    }

    public void addAjascente(Edge<T> adj) {
        this.vertAdj.add(adj);
        this.custo = this.custo + 0;
    }

    public void addAjascente(Edge<T> adj, int weight) {
        this.vertAdj.add(adj);
        this.custo = weight;
    }
    
}