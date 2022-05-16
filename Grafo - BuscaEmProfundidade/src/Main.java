public class Main {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new Grafo<Integer>();
        
        grafo.addVertice(10);
        grafo.addVertice(5);
        grafo.addVertice(7);
        grafo.addVertice(8);
        grafo.addVertice(2);
        grafo.addVertice(1);
        grafo.addVertice(3);
        grafo.addVertice(4);
        grafo.addVertice(6);
        grafo.addVertice(9);

        grafo.addAresta(10,5);
        grafo.addAresta(9,10);
        grafo.addAresta(9,5);
        grafo.addAresta(8,5);
        grafo.addAresta(5,7);
        grafo.addAresta(8,9);
        grafo.addAresta(6,4);
        grafo.addAresta(1,3);
        grafo.addAresta(3,7);
        grafo.addAresta(3,2);
        
        DFS busca = new DFS(grafo, 2);
        
        
    }
}