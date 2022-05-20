public class BFS<T> {
    
    private Queue<Vertice<T>> fila;
    private String textoResposta;
    private T valorBusca;

    public BFS(T valueSearch){
        this.textoResposta = "";
        this.fila = new Queue<Vertice<T>>();
        this.valorBusca = valueSearch;
    }

    public boolean isResult(Vertice<T> valor){
        return valor.getDado().equals(valorBusca);
    }

    public void buscar(Vertice<T> raiz) {
        raiz.setMarcado(true);
        this.fila.enqueue(raiz);
        while(!this.fila.isEmpty()) {
            Vertice<T> valor = this.fila.dequeue();
            if(isResult(valor)) {
                this.textoResposta = this.textoResposta + " " + valor.getDado().toString();
                break;
            }
            for(int i = 0; i < valor.getVertAdj().size(); i++) {
                if(!valor.getVertAdj().get(i).isMarcado()) {
                    valor.getVertAdj().get(i).setMarcado(true);
                    this.fila.enqueue(valor.getVertAdj().get(i));
                }
            }
            this.textoResposta = this.textoResposta + " " + valor.getDado().toString();
        }
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