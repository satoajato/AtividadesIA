import java.util.ArrayList;

public class Grafo<T> {
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;
    private Vertice<T> raiz;
    private boolean direcional;

    public Grafo(){
        this.vertices = new ArrayList<Vertice<T>>();
        this.arestas = new ArrayList<Aresta<T>>();
        this.direcional = false;
    }
    
    public Grafo(boolean direct){
        this.vertices = new ArrayList<Vertice<T>>();
        this.arestas = new ArrayList<Aresta<T>>();
        this.direcional = direct;
    }

    public void setRaiz(Vertice<T> root) {
        this.raiz = root;
    }

    public Vertice<T> getRaiz(){
        return this.raiz;
    }

    public void addVertice (T dado){
        Vertice<T> novoVert = new Vertice<T>(dado);
        if(vertices.isEmpty()) {
            setRaiz(novoVert);
        }
        this.vertices.add(novoVert);
    }

    public void addAresta (T dadoInicio, T dadoFim){
        Vertice<T> inicio = this.getVertice(dadoInicio);
        Vertice<T> fim = this.getVertice(dadoFim);
        
        Aresta<T> arestaIn = new Aresta<T>(inicio, fim);
        Aresta<T> arestaFi = new Aresta<T>(fim, inicio);
        
        inicio.addAjascente(arestaIn);
        fim.addAjascente(arestaFi);

        this.arestas.add(arestaIn);
        this.arestas.add(arestaFi);
    }

    public void addAresta (T dadoInicio, T dadoFim, int weight){
        Vertice<T> inicio = this.getVertice(dadoInicio);
        Vertice<T> fim = this.getVertice(dadoFim);
        
        Aresta<T> arestaIn = new Aresta<T>(inicio, fim);
        Aresta<T> arestaFi = new Aresta<T>(fim, inicio);
        
        inicio.addAjascente(arestaIn);
        fim.addAjascente(arestaFi);

        this.arestas.add(arestaIn);
        this.arestas.add(arestaFi);
    }

    public ArrayList<Vertice<T>> getVertices() {
        return this.vertices;
    }

    public void setVertices(ArrayList<Vertice<T>> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<Aresta<T>> getArestas() {
        return this.arestas;
    }

    public void setArestas(ArrayList<Aresta<T>> arestas) {
        this.arestas = arestas;
    }

    public boolean isDirecional() {
        return this.direcional;
    }

    public void setDirecional(boolean direcional) {
        this.direcional = direcional;
    }

    public Vertice<T> getVertice(T dado){
        Vertice<T> vertice = null;
        for(int i = 0; i<this.vertices.size(); i++){
            if(this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

}