import java.util.ArrayList;

public class Grafo<T> {
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;
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

    public void addVertice (T dado){
        Vertice<T> novoVert = new Vertice<T>(dado);
        this.vertices.add(novoVert);
    }

    public void addAresta (T dadoInicio, T dadoFim){
        
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