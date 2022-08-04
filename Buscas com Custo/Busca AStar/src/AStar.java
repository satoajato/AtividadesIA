import java.util.ArrayList;

public class AStar<T> {
    
    private Queue<Vertex<T>> aberta;
    private ArrayList<Vertex<T>> fechada = new ArrayList<>();
    private Vertex<T> objetivo;
    
    public AStar(Vertex<T> valueSearch){
        this.aberta = new Queue<Vertex<T>>();
        this.objetivo = valueSearch;
    }

    public void buscar(Vertex<T> raiz) {
        this.aberta.enqueue(raiz,0,0);
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
                filho.setG(atual.getG() + distancia(filho, atual));
                filho.setH(filho.getH());
                filho.setF(filho.getG() + filho.getH());
                
                if(aberta.contains(filho) && filho.getG() > aberta.maxG()) {
                    System.out.println("A lista aberta contém filho e filho é maior que o Gmaximo da lista aberta");
                    continue;
                }
                System.out.println(filho.getDado() + " com G: " + filho.getG() + ", H: " + filho.getH() + " e F:" + filho.getF() + " adicionado na lista aberta");
                aberta.enqueue(filho, filho.getG(), filho.getF());
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

    private int distancia(Vertex<T> origem, Vertex<T> destino) {
        int distancia = 0;

        for(Edge<T> aresta : origem.getVertAdj()) {
            if(aresta.getFim().equals(destino)) {
                distancia = aresta.getPeso();
            }
        }

        System.out.println("Distancia de " + origem.getDado() + " até " + objetivo.getDado() + " é " + distancia);
        return distancia;
    }

}