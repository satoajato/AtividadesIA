public class BFS<T> extends Search {

    private Queue<Vertex<Board>> fila;

    public BFS(int valueSearch, Vertex<Board> raiz, Graph<Board> graph){
        this.jogada = new int[2];
        this.fila = new Queue<Vertex<Board>>();
        this.valorBusca = valueSearch;
        this.root = raiz;
        this.grafo = graph;
    }

    @Override
    public int [] buscar() {
        this.root.setMarcado(true);
        this.fila.enqueue(root);
        while(!this.fila.isEmpty()) {
            Vertex<Board> valor = this.fila.dequeue();
            if(isResult(valor)) {
                this.vertBusca = valor;
                this.jogada = getJogada();
                this.grafo.setDesmarcado();
                break;
            }
            for(int i = 0; i < valor.getVertAdj().size(); i++) {
                if(!valor.getVertAdj().get(i).isMarcado()) {
                    valor.getVertAdj().get(i).setMarcado(true);
                    this.fila.enqueue(valor.getVertAdj().get(i));
                }
            }
        }
        return this.jogada;
    }
}