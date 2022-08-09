import java.util.ArrayList;

public class UCS<T> {
    
    private Queue<Vertice<T>> fila;
    private ArrayList<Vertice<T>> caminho = new ArrayList<>();
    private T valorBusca;

    public UCS(T valueSearch){
        this.fila = new Queue<Vertice<T>>();
        this.valorBusca = valueSearch;
    }

    public boolean isResult(Vertice<T> valor){
        return valor.getDado().equals(valorBusca);
    }

    public void buscar(Vertice<T> raiz) {
        System.out.println("Buscando vértice!");
        
        raiz.setMarcado(true);
        this.fila.enqueue(raiz , raiz.getCusto());

        while(!this.fila.isEmpty()) {
            Vertice<T> valor = this.fila.dequeue();
            this.caminho.add(valor);
            if(isResult(valor)) {
                System.out.println("Valor encontrado!");
                break;
            }
            for(int i = 0; i < valor.getVertAdj().size(); i++) {
                if(!valor.getVertAdj().get(i).getFim().isMarcado()) {
                    valor.getVertAdj().get(i).getFim().setMarcado(true);
                    int peso = valor.getVertAdj().get(i).getFim().getCusto() + valor.getCusto();
                    // System.out.println("Enfileirando vertice: " + valor.getVertAdj().get(i).getDado() + " com custo: " + peso);
                    this.fila.enqueue(valor.getVertAdj().get(i).getFim(), peso);
                }
            }
        }
    }

    public void ExibirTextoResult(){
        System.out.print("Caminho:");
        for(Vertice<T> x : caminho) {
            System.out.print(" -> ");
            System.out.print(x.getDado());
        }
    }
}