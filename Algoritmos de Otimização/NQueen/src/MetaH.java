import java.util.ArrayList;
import java.util.Random;

public class MetaH {

    private ArrayList<Board> listaExp;

    public MetaH(Board board, int qtdRainhas) {
        this.listaExp = exp(board, qtdRainhas);
    }

    public ArrayList<Board> getListaExp() {
        return listaExp;
    }

    public void setListaExp(ArrayList<Board> listaExp) {
        this.listaExp = listaExp;
    }

    public int metaHeuristica(Board board, int N) { //N = qtd rainhas
        int mHeuristica=0;
        int[][] mat = board.getMatriz();

        for(int j=0; j<N; j++) {
            for(int i=0; i<N; i++) {
                if(mat[i][j] != 0) {
                    for(int k=0; k<N; k++) { //linha e coluna
                        if(mat[k][j] !=0 && mat[k][j] != mat[i][j]) {
                            mHeuristica++;
                            //System.out.println("Colisão coluna " + mat[k][j] + " com " + mat[i][j]);
                        }
                        if(mat[i][k] !=0 && mat[i][k] != mat[i][j]) {
                            mHeuristica++;
                            //System.out.println("Colisão linha " + mat[i][k] + " com " + mat[i][j]);
                        }
                    }
                    //diagonal aumenta o i e o j
                    int k=1;
                    while(j+k<N && i+k<N) {
                        if(mat[i+k][j+k] != mat[i][j] &&  mat[i+k][j+k]!=0) {
                            mHeuristica++;
                            //System.out.println("Colisão diagonal " + mat[i+k][j+k] + " com " + mat[i][j]);
                        }
                    k++;
                    }

                    k=1;
                    while(j-k>=0 && i-k>=0) {
                        if (mat[i-k][j-k] != mat[i][j] && mat[i-k][j-k]!=0) {
                            mHeuristica++;
                            //System.out.println("Colisão diagonal " + mat[i-k][j-k] + " com " + mat[i][j]);
                        }
                        k++;
                    }

                    //AntiDiagonais
                    k=1;
                    while(j+k<N && i-k>=0) {
                        if(mat[i-k][j+k] != mat[i][j] &&  mat[i-k][j+k]!=0) { //anterior mat[i-k][j+k] != mat[i][j] &&  mat[i-k][j+k]!=0
                            mHeuristica++;
                            //System.out.println("Colisão anti-diagonal " + mat[i-k][j+k] + " com " + mat[i][j]);
                        }
                    k++;
                    }

                    k=1;
                    while(i+k<N && j-k>=0) {
                        if (mat[i+k][j-k] != mat[i][j] && mat[i+k][j-k]!=0) {
                            mHeuristica++;
                            //System.out.println("Colisão anti-diagonal " + mat[i+k][j-k] + " com " + mat[i][j]);
                        }
                        k++;
                    }
                }
            }
        }
        return mHeuristica/2;
    }
    
    public ArrayList<Board> exp(Board board, int N) {
        int[][] mat = board.getMatriz();
        ArrayList<Board> espaco = new ArrayList<Board>();

        for(int j=0; j<N; j++) {
            for(int i=0; i<N; i++) {
                if(mat[i][j] == 0) {
                    for(int k=0; k<N; k++) { //linha e coluna
                        if(mat[k][j] !=0 && mat[k][j] != mat[i][j]) {
                            int mAux[][] = this.copy(mat);
                            mAux[i][j] = mat[k][j]; // colocando a rainha na casa vazia
                            mAux[k][j] = 0; // casa de onde a rainha veio
                            Board bAux = new Board(mAux);
                            bAux.setPontuacao(metaHeuristica(bAux, N));
                            espaco.add(bAux);
                        }
                        if(mat[i][k] !=0 && mat[i][k] != mat[i][j]) {
                            int mAux[][] = this.copy(mat);
                            mAux[i][j] = mat[i][k]; // colocando a rainha na casa vazia
                            mAux[i][k] = 0; // casa de onde a rainha veio
                            Board bAux = new Board(mAux);
                            bAux.setPontuacao(metaHeuristica(bAux, N));
                            espaco.add(bAux);
                        }
                    }
                    //diagonal aumenta o i e o j
                    int k=1;
                    while(j+k<N && i+k<N) {
                        if(mat[i+k][j+k] != mat[i][j] &&  mat[i+k][j+k]!=0) {
                            int mAux[][] = this.copy(mat);
                            mAux[i][j] = mat[i+k][j+k]; // colocando a rainha na casa vazia
                            mAux[i+k][j+k] = 0; // casa de onde a rainha veio
                            Board bAux = new Board(mAux);
                            bAux.setPontuacao(metaHeuristica(bAux, N));
                            espaco.add(bAux);
                        }
                    k++;
                    }

                    k=1;
                    while(j-k>=0 && i-k>=0) {
                        if (mat[i-k][j-k] != mat[i][j] && mat[i-k][j-k]!=0) {
                            int mAux[][] = this.copy(mat);
                            mAux[i][j] = mat[i-k][j-k]; // colocando a rainha na casa vazia
                            mAux[i-k][j-k] = 0; // casa de onde a rainha veio
                            Board bAux = new Board(mAux);
                            bAux.setPontuacao(metaHeuristica(bAux, N));
                            espaco.add(bAux);
                        }
                        k++;
                    }

                    //AntiDiagonais
                    k=1;
                    while(j+k<N && i-k>=0) {
                        if(mat[i-k][j+k] != mat[i][j] &&  mat[i-k][j+k]!=0) {
                            int mAux[][] = this.copy(mat);
                            mAux[i][j] = mat[i-k][j+k]; // colocando a rainha na casa vazia
                            mAux[i-k][j+k] = 0; // casa de onde a rainha veio
                            Board bAux = new Board(mAux);
                            bAux.setPontuacao(metaHeuristica(bAux, N));
                            espaco.add(bAux);
                        }
                    k++;
                    }

                    k=1;
                    while(i+k<N && j-k>=0) {
                        if (mat[i+k][j-k] != mat[i][j] && mat[i+k][j-k]!=0) {
                            int mAux[][] = this.copy(mat);
                            mAux[i][j] = mat[i+k][j-k]; // colocando a rainha na casa vazia
                            mAux[i+k][j-k] = 0; // casa de onde a rainha veio
                            Board bAux = new Board(mAux);
                            bAux.setPontuacao(metaHeuristica(bAux, N));
                            espaco.add(bAux);
                        }
                        k++;
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