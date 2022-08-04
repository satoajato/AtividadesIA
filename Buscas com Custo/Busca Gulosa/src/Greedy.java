import java.util.ArrayList;

public class Greedy<T> {
    
    private Queue<Vertex<T>> aberta;
    private ArrayList<Vertex<T>> fechada = new ArrayList<>();
    private Vertex<T> objetivo;
    
    public Greedy(Vertex<T> valueSearch){
        this.aberta = new Queue<Vertex<T>>();
        this.objetivo = valueSearch;
    }

    public void buscar(Vertex<T> raiz) {
        this.aberta.enqueue(raiz,0);
        while(!aberta.isEmpty()) {
            Vertex<T> atual = aberta.dequeue();
            System.out.println(atual.getDado() + " adicionado na lista fechada!");
            fechada.add(atual);
            if(atual.equals(objetivo)) {
                //sucesso
                System.out.println("ENCONTROU O OBJETIVO!");
                break;
            }
            ArrayList<Edge<T>> arestas = atual.getVertAdj();
            ArrayList<Vertex<T>> filhos = new ArrayList<>();

            System.out.println("Adicionando os adjascentes!");
            for (Edge<T> edge : arestas) {
                Vertex<T> aux = edge.getFim();
                filhos.add(aux);
                System.out.println(aux.getDado() + " é adjascente de " + atual.getDado());
            }
            
            System.out.println("\nCriando a Heuristica para os nós");
            for (Vertex<T> filho : filhos) {
                System.out.println("\nFilho: " + filho.getDado());
                if(contem(filho,fechada)) {
                    System.out.println(filho.getDado() + " está na lista fechada");
                    continue;
                }
                System.out.println(filho.getDado() + " com H: " + filho.getH() + " adicionado na lista aberta");
                aberta.enqueue(filho, filho.getH());
            }
        }
    }

    private boolean contem(Vertex<T> filho, ArrayList<Vertex<T>> lista) {
        for (Vertex<T> objeto : fechada) {
            if(filho.getDado().equals(objeto.getDado())) {
                return true;
            }
        }
        return false;
    }

}