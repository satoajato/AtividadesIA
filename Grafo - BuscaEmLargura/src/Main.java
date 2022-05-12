public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<String>();
        grafo.addVertice("Joao");
        grafo.addVertice("Lorenzo");
        grafo.addVertice("Creuza");
        grafo.addVertice("Cleber");
        grafo.addVertice("Claudio");

        grafo.addAresta(2.0, "Joao", "Lorenzo");
        grafo.addAresta(3.0, "Lorenzo", "Cleber");
        grafo.addAresta(1.0, "Cleber", "Creuza");
        grafo.addAresta(1.0, "Joao", "Creuza");
        grafo.addAresta(3.0, "Claudio", "Joao");
        grafo.addAresta(2.0, "Claudio", "Lorenzo");

        grafo.buscaEmLarg(4); //id do grafo (ordem de adição do vértice)
    }
}
