import java.util.ArrayList;

public class MetaH {

    private int mHeuristica;

    public void MetaH() {
        this.mHeuristica = 0;
    }

    public ArrayList<Board> espaco_busca(ArrayList<Board> lista, Board board, int qtdRainhas) {
        lista.add(board);
        board.setPontuacao(metaHeuristica(board, qtdRainhas));

        ArrayList<Board> espaco = this.exp(board, qtdRainhas);
        for(Board x : espaco) {
            this.espaco_busca(grafo, x, qtdRainhas);
            grafo.addAresta(board, x);
        }

        return grafo;
    }

    public int metaHeuristica(Board board, int qtdRainhas) {
        int[][] mat = board.getMatriz();

        for(int i = 0; i<qtdRainhas; i++) {
            for(int j=0; j<qtdRainhas; j++) {
                for(int k=1; k<qtdRainhas; k++) {
                    if(mat[i][j] != 0) {
                        if(mat[i+k][j] != 0) {
                            this.mHeuristica++;
                        }
                        if(mat[i][j+k] != 0) {
                            this.mHeuristica++;
                        }
                        if(mat[i+k][j]+k != 0) {
                            this.mHeuristica++;
                        }
                    }
                } 
            }
        }
        return this.mHeuristica/2;
    }
    
    public ArrayList<Board> exp(Board board, int qtdRainhas) {
        int[][] m = board.getMatriz();
        ArrayList<Board> espaco = new ArrayList<Board>();
        for(int i = 0; i<qtdRainhas; i++) {
            for(int j=0; j<qtdRainhas; j++) {
                if(m[i][j] == 0) {
                    Board auxBoard = new Board(board.getMatriz().length);
                    int aux[][] = this.copy(m);
                    if(aux[i][j] != 0) {
                        
                    }
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