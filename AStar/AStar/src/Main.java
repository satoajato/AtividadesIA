public class Main {
    public static void main(String[] args) throws Exception {
        Graph grafo = new Graph<>();

        grafo.addVertice("A"); // ARAD
        grafo.addVertice("B"); // ZERIND
        grafo.addVertice("C"); // ORADEA
        grafo.addVertice("D"); // SIBIU
        grafo.addVertice("E"); // TIMISOARA
        grafo.addVertice("F"); // LUGOJ
        grafo.addVertice("G"); // MAHEADIA
        grafo.addVertice("H"); // DOBRETA
        grafo.addVertice("I"); // CRAIOVA
        grafo.addVertice("J"); // RIMNICU VILCEA
        grafo.addVertice("K"); // FAGARAS
        grafo.addVertice("L"); // PITESTI
        grafo.addVertice("M"); // BUCHAREST (RESULTADO)
        grafo.addVertice("N"); // GIURGIU
        grafo.addVertice("O"); // URZICENI
        grafo.addVertice("P"); // HIRSOVA
        grafo.addVertice("Q"); // EFORIE
        grafo.addVertice("R"); // VASLUL
        grafo.addVertice("S"); // IASI
        grafo.addVertice("T"); // NEAMT

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
        grafo.addAresta("K", "M", 211);
        grafo.addAresta("L", "M", 101);
        grafo.addAresta("M", "N", 90);
        grafo.addAresta("M", "O", 85);
        grafo.addAresta("O", "P", 98);
        grafo.addAresta("P", "Q", 86);
        grafo.addAresta("O", "R", 142);
        grafo.addAresta("R", "S", 92);
        grafo.addAresta("S", "T", 87);


        AStar<String> busca = new AStar<>("M");
        busca.buscar(grafo.getRaiz());
        busca.ExibirTextoResult();

    }
}
