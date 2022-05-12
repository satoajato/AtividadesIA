import java.util.ArrayList;

public class Vertice<T> {
    private T dado;
    private ArrayList<Aresta<T>> arestasEntrada;
    private ArrayList<Aresta<T>> arestasSaida;

    public Vertice(T valor) {
        this.dado = valor;
        this.arestasEntrada = new ArrayList<Aresta<T>>();
        this.arestasSaida = new ArrayList<Aresta<T>>();
    }

    public T getDado(){
        return this.dado;
    }

    public void setDado(T valor) {
        this.dado = valor;
    }

    public void addArestaEntrada(Aresta<T> aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void addArestaSaida(Aresta<T> aresta) {
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Aresta<T>> getArestasEntrada() {
        return this.arestasEntrada;
    }

    public void setArestasEntrada(ArrayList<Aresta<T>> arestasEntrada) {
        this.arestasEntrada = arestasEntrada;
    }

    public ArrayList<Aresta<T>> getArestasSaida() {
        return this.arestasSaida;
    }

    public void setArestasSaida(ArrayList<Aresta<T>> arestasSaida) {
        this.arestasSaida = arestasSaida;
    }
}
