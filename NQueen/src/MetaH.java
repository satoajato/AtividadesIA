public class MetaH {
    

    public Graph<Board> espaco_busca(Graph<Board> grafo, Board board, boolean jogador) {
        grafo.addVertice(board);
        board.setPontuacao(board.ChecarVitoria());
        if(board.tabuleiroCompleto() && board.getPontuacao()==0) {
            board.setPontuacao(2);
        }
        // board.exibirTabuleiro();
        if(!board.tabuleiroCompleto()) {
            ArrayList<Board> espaco = board.exp(board, jogador);
            for(Board x : espaco) {
                espaco_busca(grafo, x, !jogador);
                grafo.addAresta(board, x);
            }
        }
        return grafo;
    }
    
    public ArrayList<Board> exp(Board board, boolean jogador) {
        int[][] m = board.getMatriz();
        ArrayList<Board> espaco = new ArrayList<Board>();
        for(int i = 0; i<m.length; i++) {
            for(int j=0; j<m[0].length; j++) {
                if(m[i][j] == 0) {
                    Board auxBoard = new Board();
                    int aux[][] = board.copy(m);
                    aux[i][j] = (jogador ? 1 : -1);
                    auxBoard.setMatriz(aux);
                    espaco.add(auxBoard);
                }
            }
        }
        return espaco;
    }

    public int[][] copy(int m[][]) {
        int aux[][] = new int[m.length][m[0].length];
        for(int i=0; i<aux.length; i++) {
            for(int j=0; j<aux[0].length; j++) {
                aux[i][j] = m[i][j];
            }
        }
        return aux;
    }
}
