import java.util.ArrayList;

public class Vertice<T> {
    private T dado;
    private ArrayList<Vertice<T>> vertAdj;
    private boolean marcado;

    public Vertice(T valor) {
        this.dado = valor;
        this.vertAdj = new ArrayList<Vertice<T>>();
    }

    public boolean isMarcado() {
        return marcado;
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