import java.util.ArrayList;

public class Vertex<T> {
    private T dado;
    private ArrayList<Edge<T>> arestasEntrada;
    private ArrayList<Edge<T>> arestasSaida;

    public Vertex(T valor) {
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Edge<T>>();
        this.arestasSaida = new ArrayList<Edge<T>>();
    }

    public T getDado(){
        return this.dado;
    }

    public void setDado(T valor) {
        this.dado = valor;
    }

    public void addArestaEntrada(Edge<T> aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void addArestaSaida(Edge<T> aresta) {
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Edge<T>> getArestasEntrada() {
        return this.arestasEntrada;
    }

    public void setArestasEntrada(ArrayList<Edge<T>> arestasEntrada) {
        this.arestasEntrada = arestasEntrada;
    }

    public ArrayList<Edge<T>> getArestasSaida() {
        return this.arestasSaida;
    }

    public void setArestasSaida(ArrayList<Edge<T>> arestasSaida) {
        this.arestasSaida = arestasSaida;
    }
}
