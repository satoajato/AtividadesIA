public class NQueen {
    
    private Board tabuleiro;
    private Graph<Board> grafo;


    public NQueen(int Number) {
        this.tabuleiro = new Board(Number);
        this.grafo = new Graph<Board>();
    }

    public void solucao() {
        //expandir o vertice de menor pontuação
        MetaH mH = new MetaH();
        tabuleiro.setPontuacao(mH.metaHeuristica(tabuleiro, tabuleiro.getMatriz().length));

        tabuleiro.printarTabuleiro();
        
    }

    public Board getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Board tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    
}