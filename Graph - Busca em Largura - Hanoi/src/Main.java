public class Main {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new Grafo<Integer>(false);
        grafo.addVertice(111);
        grafo.addVertice(112);
        grafo.addVertice(113);
        grafo.addVertice(121);
        grafo.addVertice(122);
        grafo.addVertice(123);
        grafo.addVertice(131);
        grafo.addVertice(132);
        grafo.addVertice(133);
        grafo.addVertice(211);
        grafo.addVertice(212);
        grafo.addVertice(213);
        grafo.addVertice(221);
        grafo.addVertice(222);
        grafo.addVertice(223);
        grafo.addVertice(231);
        grafo.addVertice(232);
        grafo.addVertice(233);
        grafo.addVertice(311);
        grafo.addVertice(312);
        grafo.addVertice(313);
        grafo.addVertice(321);
        grafo.addVertice(322);
        grafo.addVertice(323);
        grafo.addVertice(331);
        grafo.addVertice(332);
        grafo.addVertice(333);

        grafo.addAresta(111,112);
        grafo.addAresta(111,113);
        grafo.addAresta(112,113);
        grafo.addAresta(112,132);
        grafo.addAresta(132,133);
        grafo.addAresta(132,131);
        grafo.addAresta(133,131);
        grafo.addAresta(131,121);
        grafo.addAresta(113,123);
        grafo.addAresta(123,121);
        grafo.addAresta(123,122);
        grafo.addAresta(121,122);
        grafo.addAresta(133,233);
        grafo.addAresta(233,231);
        grafo.addAresta(233,232);
        grafo.addAresta(231,232);
        grafo.addAresta(122,322);
        grafo.addAresta(322,323);
        grafo.addAresta(322,321);
        grafo.addAresta(323,321);
        grafo.addAresta(231,221);
        grafo.addAresta(221,222);
        grafo.addAresta(221,223);
        grafo.addAresta(222,223);
        grafo.addAresta(232,212);
        grafo.addAresta(212,213);
        grafo.addAresta(212,211);
        grafo.addAresta(213,211);
        grafo.addAresta(223,211);
        grafo.addAresta(323,313);
        grafo.addAresta(313,311);
        grafo.addAresta(313,312);
        grafo.addAresta(311,312);
        grafo.addAresta(211,311);
        grafo.addAresta(321,331);
        grafo.addAresta(331,332);
        grafo.addAresta(331,333);
        grafo.addAresta(312,332);
        grafo.addAresta(332,333);

        BFS busca = new BFS(333);
        busca.buscar(grafo.getRaiz());
        busca.ExibirTextoResult();

    }
}
