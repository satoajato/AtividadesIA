import java.util.ArrayList;
public class Vertex<T> {
    private T dado;
    private ArrayList<Vertex<T>> vertAdj;
    private boolean marcado;

    public Vertex(T valor) {
        this.dado = valor;
        this.vertAdj = new ArrayList<Vertex<T>>();
    }

    public ArrayList<Vertex<T>> getVertAdj() {
        return this.vertAdj;
    }

    public void setVertAdj(ArrayList<Vertex<T>> vertAdj) {
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

    public void addAjascente(Vertex<T> adj) {
        this.vertAdj.add(adj);
    }
    
}