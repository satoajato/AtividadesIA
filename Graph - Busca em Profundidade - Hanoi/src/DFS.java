public class DFS<T> {
    
    private Stack<Vertice<T>> pilha;
    private String textoResposta;
    private T valorBusca;
    // private Grafo<T> grafo;

    public DFS(T valueSearch, Grafo<T> graph){
        this.textoResposta = "";
        this.pilha = new Stack<Vertice<T>>();
        this.valorBusca = valueSearch;
        // this.grafo = graph;
    }

    public boolean isResult(Vertice<T> valor){
        return valor.getDado().equals(valorBusca);
    }

    public void buscar(Vertice<T> valor) {
        this.pilha.push(valor);
        while(!pilha.isEmpty()) {
            valor = this.pilha.pop();
            if(!valor.isMarcado()) {
               valor.setMarcado(true);
               for(int i = 0; i < valor.getVertAdj().size(); i++)
                   this.pilha.push(valor.getVertAdj().get(i));
            }
            if(isResult(valor)) {
                this.textoResposta = this.textoResposta + " " + valor.getDado().toString();
                // obterResultadoMarcados();
                break;
            }
            this.textoResposta = this.textoResposta + " " + valor.getDado().toString();
        }
    }

    // private void obterResultadoMarcados() {
    //     String Retorno = "";
    //     for(int i = 0; i<this.grafo.getVertices().size(); i++) {
    //         if(this.grafo.getVertices().get(i).isMarcado()){
    //             Retorno = Retorno + " " + this.grafo.getVertices().get(i).getDado().toString();
    //         }
    //     }
    //     this.textoResposta = Retorno;
    // }

    // private String obterResultadoPilha(){
    //     String Retorno = "";
    //     while(this.pilha.size()>0) {
    //         Retorno = this.pilha.pop().getDado() + " " + Retorno;
    //     }
    //     this.textoResposta = Retorno;
    //     return this.textoResposta;
    // }

    public void ExibirTextoResult(){
        if(this.textoResposta != null) {
            System.out.println("O caminho percorrido: " + this.textoResposta);
        }
        else{
            System.out.println("O valor não foi encontrado");
        }
    }
}