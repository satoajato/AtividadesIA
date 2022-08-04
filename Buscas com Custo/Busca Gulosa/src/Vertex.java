import java.util.ArrayList;
public class Vertex<T> {
    private T dado;
    private int H;
    private ArrayList<Edge<T>> vertAdj;

    public Vertex(T valor) {
        this.H = 0; // distancia do filho até o objetivo
        this.dado = valor;
        this.vertAdj = new ArrayList<Edge<T>>();
    }

    public Vertex(T valor, int heuristic) {
        this.H = heuristic; // distancia do filho até o objetivo
        this.dado = valor;
        this.vertAdj = new ArrayList<Edge<T>>();
    }

    public int getH() {
        return this.H;
    }

    public void setH(int Hh) {
        this.H = Hh;
    }

    public ArrayList<Edge<T>> getVertAdj() {
        return this.vertAdj;
    }

    public void setVertAdj(ArrayList<Edge<T>> vertAdj) {
        this.vertAdj = vertAdj;
    }

    public T getDado(){
        return this.dado;
    }

    public void setDado(T valor) {
        this.dado = valor;
    }

    public void addAjascente(Edge<T> adj) {
        this.vertAdj.add(adj);
    }
}