import java.util.ArrayList;

public abstract class Search {
    
    protected int valorBusca;
    protected int[] jogada;
    protected Vertex<Board> root;
    protected Vertex<Board> vertBusca;
    protected ArrayList<Vertex<Board>> resultadj = new ArrayList<>();
    protected Graph<Board> grafo;

    public Vertex<Board> getVertBusca() {
        return vertBusca;
    }

    public void setVertBusca(Vertex<Board> vertBusca) {
        this.vertBusca = vertBusca;
    }

    public boolean isResult(Vertex<Board> valor){
        return valor.getDado().getPontuacao()==valorBusca;
    }

    public abstract int[] buscar();

    public Vertex<Board> encontrarCaminho() { 
        Vertex<Board> vertAux = vertBusca;
        resultadj = AdjascentesResultado(vertBusca);
        for(Vertex<Board> x : root.getVertAdj()) {
            for(Vertex<Board> y : resultadj) {
                if(x.equals(y)) {
                    vertAux = x;
                }
            }
        }

        return vertAux;
    }

    public ArrayList<Vertex<Board>> AdjascentesResultado(Vertex<Board> vertRes) {
        if(vertRes.equals(root)) return resultadj;
        resultadj.addAll(vertRes.getVertAdj());
        
        // resultadj.get(resultadj.size()-1).getDado().exibirTabuleiro(); //adjascentes

        return AdjascentesResultado(resultadj.get(resultadj.size()-1));
    }

    public int[] getJogada() {
        Vertex<Board> vertJogada = encontrarCaminho();
        int[][] mat1 = vertJogada.getDado().getMatriz();
        int[][] mat2 = this.root.getDado().getMatriz();
        //pegar a raiz
        //comparar com proxima jogada do grafo da resposta
        //encontrar a jogada a partir disso
        for(int i=0; i<mat1.length; i++) {
            for(int j=0; j<mat1[0].length; j++) {
                if(mat1[i][j] != mat2[i][j]) {
                    this.jogada[0] = i;
                    this.jogada[1] = j;
                    return this.jogada;
                }
            }
        }
        return this.jogada;
    }
}