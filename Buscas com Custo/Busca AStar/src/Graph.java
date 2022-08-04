import java.util.ArrayList;

public class Graph<T> {
    private ArrayList<Vertex<T>> vertices;
    private ArrayList<Edge<T>> arestas;
    private Vertex<T> raiz;
    private boolean direcional;

    public Graph() {
        this.vertices = new ArrayList<Vertex<T>>();
        this.arestas = new ArrayList<Edge<T>>();
        this.direcional = false;
    }
    
    public Graph(boolean direct) {
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

    public void newVertice (T dado){
        Vertex<T> novoVert = new Vertex<T>(dado);
        if(vertices.isEmpty()) {
            setRaiz(novoVert);
        }
        this.vertices.add(novoVert);
    }

    public void newVertice (T dado, int heuristic){
        Vertex<T> novoVert = new Vertex<T>(dado, heuristic);
        if(vertices.isEmpty()) {
            setRaiz(novoVert);
        }
        this.vertices.add(novoVert);
    }

    public void addVertice (Vertex<T> vertex){
        this.vertices.add(vertex);
    }

    public void addAresta (T dadoInicio, T dadoFim){
        Vertex<T> inicio = this.getVertice(dadoInicio);
        Vertex<T> fim = this.getVertice(dadoFim);
        
        Edge<T> arestaIn = new Edge<T>(inicio, fim);
        Edge<T> arestaFi = new Edge<T>(fim, inicio);
        
        inicio.addAjascente(arestaIn);
        fim.addAjascente(arestaFi);

        this.arestas.add(arestaIn);
        this.arestas.add(arestaFi);
    }

    public void addAresta (T dadoInicio, T dadoFim, int weight){
        Vertex<T> inicio = this.getVertice(dadoInicio);
        Vertex<T> fim = this.getVertice(dadoFim);
        
        Edge<T> arestaIn = new Edge<T>(inicio, fim, weight);
        Edge<T> arestaFi = new Edge<T>(fim, inicio, weight);
        
        inicio.addAjascente(arestaIn);
        fim.addAjascente(arestaFi);

        this.arestas.add(arestaIn);
        this.arestas.add(arestaFi);
    }

    public ArrayList<Vertex<T>> getVertices() {
        return this.vertices;
    }

    public void setVertices(ArrayList<Vertex<T>> vertices) {
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

}