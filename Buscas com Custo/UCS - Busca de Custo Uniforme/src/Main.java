public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<String>(false);

        grafo.addVertice("A");
        grafo.addVertice("B");
        grafo.addVertice("C");
        grafo.addVertice("D");
        grafo.addVertice("E");
        grafo.addVertice("F");
        grafo.addVertice("G");

        grafo.addAresta("A", "B", 2);
        grafo.addAresta("A", "C", 1);
        grafo.addAresta("B", "D", 4);
        grafo.addAresta("B", "E", 6);
        grafo.addAresta("C", "D", 5);
        grafo.addAresta("C", "F", 5);
        grafo.addAresta("D", "E", 3);
        grafo.addAresta("D", "F", 2);
        grafo.addAresta("E", "G", 6);
        grafo.addAresta("F", "G", 1);
        

        UCS<String> busca = new UCS<>("G");
        busca.buscar(grafo.getRaiz());
        busca.ExibirTextoResult();

    }
}
