public class DFS<T> {
    
    private Stack<Vertice<T>> pilha;
    private String textoResposta;
    private Grafo grafoBusca;
    private T valorBusca;

    public DFS(Grafo grafo, T valueSearch){
        this.grafoBusca = grafo;
        this.pilha = new Stack<Vertice<T>>();
        this.valorBusca = valueSearch;
    }

    public boolean isResult(Vertice<T> valor){
        return valor.getDado().equals(valorBusca);
    }

    public void buscar(Vertice<T> valor) {
        this.pilha.push(valor);
        while(!pilha.isEmpty()) {
            valor = this.pilha.pop();
            if(valor.isMarcado()) {
               valor.setMarcado(true);
               for(int i = 0; i < valor.getArestasSaida().size(); i++)
                   this.pilha.push(valor.getArestasSaida().)
            }
        }
    }

    private void obterResultadoPilha(){
        String Retorno = "";
        while(this.pilha.size()>0) {
            Retorno = this.pilha.pop().getDado() + " " + Retorno;
        }
        this.textoResposta = Retorno;
    }

    public void ExibirTextoResult(){
        if(this.textoResposta != null) {
            System.out.println("O caminho percorrido: " + this.textoResposta);
        }
        else{
            System.out.println("O valor não foi encontrado");
        }
    }
}