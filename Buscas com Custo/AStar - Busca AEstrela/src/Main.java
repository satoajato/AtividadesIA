public class Main {
    public static void main(String[] args) throws Exception {
        Graph<String> grafo = new Graph<>();

        grafo.newVertice("A"); // ARAD
        grafo.newVertice("B"); // ZERIND
        grafo.newVertice("C"); // ORADEA
        grafo.newVertice("D"); // SIBIU
        grafo.newVertice("E"); // TIMISOARA
        grafo.newVertice("F"); // LUGOJ
        grafo.newVertice("G"); // MAHEADIA
        grafo.newVertice("H"); // DOBRETA
        grafo.newVertice("I"); // CRAIOVA
        grafo.newVertice("J"); // RIMNICU VILCEA
        grafo.newVertice("K"); // FAGARAS
        grafo.newVertice("L"); // PITESTI
        Vertex<String> objetivo = new Vertex<String>("M");
        grafo.addVertice(objetivo); // BUCHAREST (objetivo)
        grafo.newVertice("N"); // GIURGIU
        grafo.newVertice("O"); // URZICENI
        grafo.newVertice("P"); // HIRSOVA
        grafo.newVertice("Q"); // EFORIE
        grafo.newVertice("R"); // VASLUL
        grafo.newVertice("S"); // IASI
        grafo.newVertice("T"); // NEAMT

        grafo.addAresta("A", "B", 75);
        grafo.addAresta("B", "C", 71);
        grafo.addAresta("C", "D", 151);
        grafo.addAresta("A", "D", 140);
        grafo.addAresta("A", "E", 118);
        grafo.addAresta("E", "F", 111);
        grafo.addAresta("F", "G", 70);
        grafo.addAresta("G", "H", 75);
        grafo.addAresta("H", "I", 120);
        grafo.addAresta("I", "J", 146);
        grafo.addAresta("I", "L", 138);
        grafo.addAresta("D", "K", 99);
        grafo.addAresta("D", "J", 80);
        grafo.addAresta("J", "L", 97);
        grafo.addAresta("K", "M", 211);
        grafo.addAresta("L", "M", 101);
        grafo.addAresta("M", "N", 90);
        grafo.addAresta("M", "O", 85);
        grafo.addAresta("O", "P", 98);
        grafo.addAresta("P", "Q", 86);
        grafo.addAresta("O", "R", 142);
        grafo.addAresta("R", "S", 92);
        grafo.addAresta("S", "T", 87);


        AStar<String> busca = new AStar<>(objetivo, grafo);
        busca.buscar(grafo.getRaiz());

    }
}
