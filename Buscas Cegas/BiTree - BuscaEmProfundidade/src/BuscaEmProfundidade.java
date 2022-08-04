public class BuscaEmProfundidade<T> {
    
    private Stack<Elemento<T>> pilha;
    private String textoResposta;
    private T valorBusca;

    public BuscaEmProfundidade(T valueSearch){
        this.pilha = new Stack<Elemento<T>>();
        this.valorBusca = valueSearch;
    }

    public boolean isResult(Elemento<T> valor){
        return valor.getValor().equals(valorBusca);
    }

    public boolean buscar(Elemento<T> valor) {
        this.pilha.push(valor);
        if(isResult(valor)) {
            obterResultadoPaternal(valor);
            return true;
        }
        else {
            if(valor.getEsquerda() != null && this.buscar(valor.getEsquerda())){
                return true;
            }
            if (valor.getDireita() != null && this.buscar(valor.getDireita())) {
                return true;
            }
        }
        this.pilha.pop();
        return false;
    }

    private void obterResultadoPilha(){
        String Retorno = "";
        while(this.pilha.size()>0) {
            Retorno = this.pilha.pop().getValor() + " " + Retorno;
        }
        this.textoResposta = Retorno;
    }

    private void obterResultadoPaternal(Elemento<T> no) {
        String Retorno = "";
        Elemento<T> noValor = no;
        Retorno += noValor.getValor();
        while(noValor.getPai()!=null) {
            noValor = noValor.getPai();
            Retorno = noValor.getValor() + " " + Retorno;
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
