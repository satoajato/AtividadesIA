public class DFS<T> extends Search {

    private Stack<Vertex<Board>> pilha;

    public DFS(int valueSearch, Vertex<Board> raiz, Graph<Board> graph){
        this.jogada = new int[3];
        this.pilha = new Stack<Vertex<Board>>();
        this.valorBusca = valueSearch;
        this.root = raiz;
        this.grafo = graph;
    }
    
    @Override
    public int [] buscar() {
        this.pilha.push(this.root);
        while(!pilha.isEmpty()) {
            Vertex<Board> valor = this.pilha.pop();
            // valor.getDado().exibirTabuleiro();
            if(!valor.isMarcado()) {
                valor.setMarcado(true);
                for(int i = 0; i < valor.getVertAdj().size(); i++)
                    this.pilha.push(valor.getVertAdj().get(i));
             }
            if(isResult(valor)) {
                this.vertBusca = valor;
                this.jogada = getJogada();
                this.grafo.setDesmarcado();
                return this.jogada;
            }
        }
        return jogada;
    }
}