import java.util.ArrayList;
import java.util.Random;

public class MetaH {

    private ArrayList<Board> listaExp;

    public MetaH(Board board) {
        this.listaExp = exp(board, board.getMatriz().length);
    }

    public ArrayList<Board> getListaExp() {
        return listaExp;
    }

    public void setListaExp(ArrayList<Board> listaExp) {
        this.listaExp = listaExp;
    }

    public int metaHeuristica(Board board, int N) { //N = tamanho
        int mHeuristica=0;
        int[][] mat = board.getMatriz();

        for(int j=0; j<N; j++) {
            for(int i=0; i<N; i++) {
                if(mat[i][j] != 0) {
                    int contJ = mat[i][j];
                    int contI = 0;
                    while(contJ > N) {
                        contI++;
                        contJ = contJ - N;
                    }
                    contJ--;
                    boolean dif = true;
                    while(dif) {
                        if(contI < i) {
                            contI++;
                            mHeuristica++;
                        }
                        else if(contI > i) {
                            contI--;
                            mHeuristica++;
                        }
                        else if(contJ < j) {
                            contJ++;
                            mHeuristica++;
                        }
                        else if(contJ > j) {
                            contJ--;
                            mHeuristica++;
                        }
                        else {
                            dif = false;
                        }
                    }
                }
            }
        }
        
        return mHeuristica;
    }
    
    public ArrayList<Board> exp(Board board, int N) {
        int[][] mat = board.getMatriz();
        ArrayList<Board> espaco = new ArrayList<Board>();

        for(int j=0; j<N; j++) {
            for(int i=0; i<N; i++) {
                if(mat[i][j] == 0) {
                    if(j-1>=0) { //empurra o vazio pra cima
                        int mAux[][] = this.copy(mat);
                        mAux[i][j] = mat[i][j-1]; // 0 vai receber a pedra de cima
                        mAux[i][j-1] = 0; // casa de cima vai receber 0
                        Board bAux = new Board(mAux);
                        bAux.setPontuacao(metaHeuristica(bAux, N));
                        espaco.add(bAux);
                    }
                    if(j+1<N) { //empurra o vazio pra baixo
                        int mAux[][] = this.copy(mat);
                        mAux[i][j] = mat[i][j+1]; // 0 vai receber a pedra de baixo
                        mAux[i][j+1] = 0; // casa de baixo vai receber 0
                        Board bAux = new Board(mAux);
                        bAux.setPontuacao(metaHeuristica(bAux, N));
                        espaco.add(bAux);
                    }
                    if(i-1>=0) { //empurra pra esquerda
                        int mAux[][] = this.copy(mat);
                        mAux[i][j] = mat[i-1][j]; // 0 vai receber a pedra da esquerda
                        mAux[i-1][j] = 0; // casa da esquerda vai receber 0
                        Board bAux = new Board(mAux);
                        bAux.setPontuacao(metaHeuristica(bAux, N));
                        espaco.add(bAux);
                    }
                    if(i+1<N) {
                        int mAux[][] = this.copy(mat);
                        mAux[i][j] = mat[i+1][j]; // 0 vai receber a pedra da direita
                        mAux[i+1][j] = 0; // casa da direita vai receber 0
                        Board bAux = new Board(mAux);
                        bAux.setPontuacao(metaHeuristica(bAux, N));
                        espaco.add(bAux);
                    }
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

    public Board getMinAdj(Board b) {
        Board minimo = b;

        for (Board board : this.listaExp) {
            // board.printarTabuleiro();
            if(minimo.getPontuacao()>board.getPontuacao()) {
                minimo = board;
            }
        }

        return minimo;
    }

    public Board getRandAdj(Board b) {
        Board random = b;
        Random rand = new Random();
        random = this.listaExp.get(rand.nextInt(0, this.listaExp.size()));
        
        return random;
    }
}