import java.util.ArrayList;
public class Vertice<T> {
    private T dado;
    private int custo;
    private ArrayList<Aresta<T>> Adjs;
    private boolean marcado;

    public Vertice(T valor) {
        this.custo = 0;
        this.dado = valor;
        this.Adjs = new ArrayList<Aresta<T>>();
    }

    public Vertice(T valor, int num) {
        this.custo = num;
        this.dado = valor;
        this.Adjs = new ArrayList<Aresta<T>>();
    }

    public int getCusto() {
        return this.custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public ArrayList<Aresta<T>> getVertAdj() {
        return this.Adjs;
    }

    public void setVertAdj(ArrayList<Aresta<T>> vertAdj) {
        this.Adjs = vertAdj;
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

    public void addAjascente(Aresta<T> adj) {
        this.Adjs.add(adj);
        this.custo = this.custo + 0;
    }
}