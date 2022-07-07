import java.util.ArrayList;

public class AStar<T> {
    
    private Queue<Vertex<T>> entrada;
    private ArrayList<Vertex<T>> saida = new ArrayList<>();
    private T valorBusca;

    public AStar(T valueSearch){
        this.entrada = new Queue<Vertex<T>>();
        this.valorBusca = valueSearch;
    }

    public boolean isResult(Vertex<T> valor){
        return valor.getDado().equals(valorBusca);
    }

    public void buscar(Vertex<T> raiz) {

    }
}