import java.util.ArrayList;

public class AStar<T> {
    
    private Queue<Vertex<T>> aberta;
    private ArrayList<Vertex<T>> fechada = new ArrayList<>();
    private Vertex<T> objetivo;
    private Graph<T> grafo;
    
    public AStar(Vertex<T> valueSearch, Graph<T> graph){
        this.aberta = new Queue<Vertex<T>>();
        this.objetivo = valueSearch;
        this.grafo = graph;
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
                filho.setG(atual.getG() + Dijkstra(filho, atual));
                filho.setH(Dijkstra(filho,objetivo));
                filho.setF(filho.getG()+filho.getH());
                
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

    private int Dijkstra(Vertex<T> inicio, Vertex<T> objetivo) { //algoritmo pra calcular menor distancia (noinicial = u e objt = v)
        Queue<Vertex<T>> qDij = new Queue<>();
        int distancia = 0;
        // para todos os vertices (r) dele, setar valor infinito e temporario, fazer w (atual) receber u (no inicial)
        for (Edge<T> edge : grafo.getArestas()) {
            edge.getFim().setTemp(true);
            edge.getFim().setDji(Integer.MAX_VALUE);
            edge.getFim().setPaiDji(null);
        }

        // setar valor 0 pro primeiro nó e deixar o valor nao temporario (perm)
        inicio.setDji(0);
        inicio.setTemp(false);

        Vertex<T> atual = inicio; // atual (w) recebe (u) no inicial
        qDij.enqueue(atual,atual.getG(),atual.getDji());
        System.out.println("\nCria pilha de Dijkstra");
        
        while(!qDij.isEmpty()) { //enquanto a pilha não estiver vazia
            atual = qDij.dequeue();
            System.out.println("Atual recebe " + atual.getDado());
            atual.setTemp(false);

            // -> cada aresta do atual:
            for (Edge<T> edge : atual.getVertAdj()) {
                System.out.println(edge.getFim().getDado() + " : " + atual.getDado());
                if(edge.getFim().isTemp() && edge.getFim().getDji() > atual.getDji() + edge.getPeso()) {
                    System.out.println(edge.getFim().getDado() + " é temporario e tem o peso " + edge.getFim().getDji());
                    //se r=temporario e valor r > valor w + aresta peso(w,r):
                    edge.getFim().setDji(atual.getDji() + edge.getPeso()); //valor de r = valor w + aresta peso(w,r)
                    System.out.println(edge.getFim().getDado() + " recebe " + atual.getDji() + " somado a " + edge.getPeso());
                    edge.getFim().setPaiDji(atual); //pai de r = w
                    System.out.println(atual.getDado() + " é pai de " + edge.getFim().getDado());
                    qDij.enqueue(edge.getFim(), 0, edge.getFim().getDji());
                    System.out.println(edge.getFim().getDado() + " adicionado na pilha de Djikstra");
                }
            }
        }
        System.out.println("Distancia de " + inicio.getDado() + " até " + objetivo.getDado() + " é " + objetivo.getDji());
        //achar o caminho (pegar cada pai do objetivo)
        distancia = objetivo.getDji();
        return distancia;
    }

}