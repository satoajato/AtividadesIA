public class BuscaEmLargura<T> {
    
    private Queue<Elemento<T>> fila;
    private String textoResposta;
    private T valorBusca;

    public BuscaEmLargura(T valueSearch){
        this.fila = new Queue<Elemento<T>>();
        this.valorBusca = valueSearch;
    }

    public boolean isResult(Elemento<T> valor){
        return valor.getValor().equals(valorBusca);
    }

    public boolean buscar(Elemento<T> valor) {
        this.fila.enqueue(valor);
        if(isResult(valor)) {
            exibirResultadoPaternal(valor);
            return true;
        }
        else {
            if(valor.getEsquerda() != null){
                this.fila.enqueue(valor.getEsquerda());
            }
            if (valor.getDireita() != null) {
                this.fila.enqueue(valor.getDireita());
            }
            Elemento<T> noPonta = this.fila.dequeue();
            if(noPonta!=null && buscar(noPonta)) {
                return true;
            }
        }
        this.fila.dequeue();
        return false;
    }

    public void exibirResultadoPaternal(Elemento<T> no) {
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
