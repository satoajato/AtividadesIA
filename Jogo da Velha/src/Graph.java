import java.util.ArrayList;

public class Graph<T> {
    private ArrayList<Vertex<T>> vertices;
    private ArrayList<Edge<T>> arestas;
    private Vertex<T> raiz;
    private boolean direcional;

    public Graph(){
        this.vertices = new ArrayList<Vertex<T>>();
        this.arestas = new ArrayList<Edge<T>>();
        this.direcional = false;
    }
    
    public Graph(boolean direct){
        this.vertices = new ArrayList<Vertex<T>>();
        this.arestas = new ArrayList<Edge<T>>();
        this.direcional = direct;
    }

    public void setRaiz(Vertex<T> root) {
        this.raiz = root;
    }

    public Vertex<T> getRaiz(){
        return this.raiz;
    }

    public void addVertice (T dado){
        Vertex<T> novoVert = new Vertex<T>(dado);
        if(vertices.isEmpty()) {
            setRaiz(novoVert);
        }
        this.vertices.add(novoVert);
    }

    public void addAresta (T dadoInicio, T dadoFim){
        Vertex<T> inicio = this.getVertice(dadoInicio);
        Vertex<T> fim = this.getVertice(dadoFim);
        Edge<T> aresta = new Edge<T>(inicio, fim);
        inicio.addAjascente(fim);
        fim.addAjascente(inicio);
        this.arestas.add(aresta);
    }

    public ArrayList<Vertex<T>> getARVertice() { //retorna arraylist dos vertices
        return this.vertices;
    }

    public void setVertex(ArrayList<Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Edge<T>> getArestas() {
        return this.arestas;
    }

    public void setArestas(ArrayList<Edge<T>> arestas) {
        this.arestas = arestas;
    }

    public boolean isDirecional() {
        return this.direcional;
    }

    public boolean getDirecional() {
        return this.direcional;
    }

    public void setDirecional(boolean direcional) {
        this.direcional = direcional;
    }

    public Vertex<T> getVertice(T dado){
        Vertex<T> vertice = null;
        for(int i = 0; i<this.vertices.size(); i++){
            if(this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public ArrayList<Vertex<T>> getVertices() {
        return this.vertices;
    }

    public void setVertices(ArrayList<Vertex<T>> vertices) {
        this.vertices = vertices;
    }

    public void setDesmarcado() {
        for(Vertex<T> x : this.vertices) {
            if(x.isMarcado()) x.setMarcado(false);
        }
    }
}