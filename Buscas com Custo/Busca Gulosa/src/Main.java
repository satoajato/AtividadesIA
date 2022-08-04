public class Main {
    public static void main(String[] args) throws Exception {
        Graph<String> grafo = new Graph<>();

        grafo.newVertice("A",366); // ARAD
        grafo.newVertice("B",374); // ZERIND
        grafo.newVertice("C",380); // ORADEA
        grafo.newVertice("D",253); // SIBIU
        grafo.newVertice("E",329); // TIMISOARA
        grafo.newVertice("F",244); // LUGOJ
        grafo.newVertice("G",241); // MAHEADIA
        grafo.newVertice("H",242); // DOBRETA
        grafo.newVertice("I",160); // CRAIOVA
        grafo.newVertice("J",193); // RIMNICU VILCEA
        grafo.newVertice("K",178); // FAGARAS
        grafo.newVertice("L",98); // PITESTI
        Vertex<String> objetivo = new Vertex<String>("M",0);
        grafo.addVertice(objetivo); // BUCHAREST (objetivo)
        grafo.newVertice("N",77); // GIURGIU
        grafo.newVertice("O",80); // URZICENI
        grafo.newVertice("P",151); // HIRSOVA
        grafo.newVertice("Q",161); // EFORIE
        grafo.newVertice("R",199); // VASLUI
        grafo.newVertice("S",226); // IASI
        grafo.newVertice("T",234); // NEAMT

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


        Greedy<String> busca = new Greedy<>(objetivo);
        busca.buscar(grafo.getRaiz());

    }
}
