import java.util.ArrayList;
public class Vertice<T> {
    private T dado;
    private ArrayList<Vertice<T>> vertAdj;
    private boolean marcado;

    public Vertice(T valor) {
        this.dado = valor;
        this.vertAdj = new ArrayList<Vertice<T>>();
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
    }
    
}