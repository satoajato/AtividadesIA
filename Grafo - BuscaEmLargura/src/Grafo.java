import java.util.ArrayList;

public class Grafo<T> {
    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;

    public Grafo(){
        this.vertices = new ArrayList<Vertice<T>>();
        this.arestas = new ArrayList<Aresta<T>>();
    }

    public void addVertice (T dado){
        Vertice<T> novoVert = new Vertice<T>(dado);
        this.vertices.add(novoVert);
    }

    public void addAresta (Double peso, T dadoInicio, T dadoFim){
        Vertice<T> inicio = this.getVertice(dadoInicio);
        Vertice<T> fim = this.getVertice(dadoFim);
        Aresta<T> aresta = new Aresta<T>(peso, inicio, fim);
        inicio.addArestaSaida(aresta);
        fim.addArestaEntrada(aresta);
        this.arestas.add(aresta);
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

    public void buscaEmLarg(int id){
        ArrayList<Vertice<T>> marcados = new ArrayList<Vertice<T>>();
        Queue<Vertice<T>> fila = new Queue<Vertice<T>>(); //ArrayList<Vertice<T>> fila = new ArrayList<Vertice<T>>();
        Vertice<T> atual = this.vertices.get(id);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.enqueue(atual); // fila.add(atual);
        while(fila.size() > 0) {
            Vertice<T> visitado = fila.getFirst().getData(); // Vertice<T> visitado = fila.get(0);
            for(int i = 0; i<visitado.getArestasSaida().size();i++) {
                Vertice<T> proximo = visitado.getArestasSaida().get(i).getFim();
                if(!marcados.contains(proximo)) {
                    marcados.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.enqueue(proximo); // fila.add(proximo);
                }
            }
            fila.dequeue(); // fila.remove(0);
        }
    }
}
