public class BuscaEmProfundidadeLimitada<T> {
    
    private Stack<Elemento<T>> pilha;
    private String textoResposta;
    private T valorBusca;
    private int limite;
    private int profundidade;

    public BuscaEmProfundidadeLimitada(T valueSearch, int limitDepth){
        this.pilha = new Stack<Elemento<T>>();
        this.valorBusca = valueSearch;
        this.limite = limitDepth;
        this.profundidade = 0;
    }

    public boolean isResult(Elemento<T> valor){
        return valor.getValor().equals(valorBusca);
    }

    public boolean buscar(Elemento<T> valor) {
        while(this.profundidade <= this.limite) {
            this.pilha.push(valor);
            this.profundidade++;
            if(isResult(valor)) {
                obterResultadoPaternal(valor);
                this.profundidade--;
                System.out.println("Encontrado na profundidade: " + this.profundidade);
                System.out.println("Limite de profundidade: " + this.limite);
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
            this.profundidade--;
            return false;
        }
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
