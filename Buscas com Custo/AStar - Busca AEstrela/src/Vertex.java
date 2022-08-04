import java.util.ArrayList;
public class Vertex<T> {
    private T dado;
    private int G,H,F;
    private ArrayList<Edge<T>> vertAdj;
    private int valorDji;
    private boolean tempDji;
    private Vertex<T> paiDji;

    public Vertex(T valor) {
        this.G = 0; // distancia do filho até o atual
        this.H = 0; // distancia do filho até o objetivo
        this.F = 0; // soma das distancias
        this.dado = valor;
        this.vertAdj = new ArrayList<Edge<T>>();
        this.valorDji = 0;
        this.paiDji = null;
    }

    public Vertex<T> getPaiDji() {
        return this.paiDji;
    }

    public void setPaiDji(Vertex<T> paiDji) {
        this.paiDji = paiDji;
    }

    public int getDji() {
        return this.valorDji;
    }

    public void setDji(int valorDji) {
        this.valorDji = valorDji;
    }

    public boolean isTemp() {
        return this.tempDji;
    }

    public void setTemp(boolean tempDji) {
        this.tempDji = tempDji;
    }

    public int getG() {
        return this.G;
    }

    public void setG(int Gg) {
        this.G = Gg;
    }

    public int getH() {
        return this.H;
    }

    public void setH(int Hh) {
        this.H = Hh;
    }

    public int getF() {
        return this.F;
    }

    public void setF(int Ff) {
        this.F = Ff;
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