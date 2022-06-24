import java.util.ArrayList;
public class Vertice<T> {
    private T dado;
    private int custo;
    private ArrayList<Vertice<T>> vertAdj;
    private boolean marcado;

    public Vertice(T valor) {
        this.custo = 0;
        this.dado = valor;
        this.vertAdj = new ArrayList<Vertice<T>>();
    }

    public Vertice(T valor, int num) {
        this.custo = num;
        this.dado = valor;
        this.vertAdj = new ArrayList<Vertice<T>>();
    }

    public int getCusto() {
        return this.custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public ArrayList<Vertice<T>> getVertAdj() {
        return this.vertAdj;
    }

    public void setVertAdj(ArrayList<Vertice<T>> vertAdj) {
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

    public void addAjascente(Vertice<T> adj) {
        this.vertAdj.add(adj);
        this.custo = this.custo + 0;
    }

    public void addAjascente(Vertice<T> adj, int weight) {
        this.vertAdj.add(adj);
        this.custo = weight;
    }
    
}