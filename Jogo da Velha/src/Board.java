import java.util.ArrayList;

public class Board {

    private int[][] tabuleiro;
    private int pontuacao; //pontuação da possivel jogada da ia

    public Board() {
        this.tabuleiro = new int[3][3];
    }

    public int[][] getMatriz() {
        return this.tabuleiro;
    }

    public void setMatriz(int[][] mat) {
        this.tabuleiro = mat;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int score) {
        this.pontuacao = score;
    }

    public void zerarTabuleiro() {
        for(int linha=0 ; linha<3 ; linha++) {
            for(int coluna=0 ; coluna<3 ; coluna++) {
                tabuleiro[linha][coluna]=0;
            }
        }
    }

    public void exibirTabuleiro() {
        System.out.println();
        for(int linha=0 ; linha<3 ; linha++){
            for(int coluna=0 ; coluna<3 ; coluna++){
                if(tabuleiro[linha][coluna]==-1){
                    System.out.print(" x ");
                }
                if(tabuleiro[linha][coluna]==1){
                    System.out.print(" o ");
                }
                if(tabuleiro[linha][coluna]==0){
                    System.out.print("   ");
                }
                
                if(coluna==0 || coluna==1)
                    System.out.print("|");
            }
            System.out.println();
        }
    }

    public int getPosicao(int[] tentativa) {
        return this.tabuleiro[tentativa[0]][tentativa[1]];
    }
    
    public void setPosicao(int[] tentativa, int jogador) {
        if(jogador == 1)
            tabuleiro[tentativa[0]][tentativa[1]] = -1;
        else
            tabuleiro[tentativa[0]][tentativa[1]] = 1;
        
        exibirTabuleiro();
    }

    public int checarLinhas(){
        for(int linha=0 ; linha<3 ; linha++) {
            if((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
                return -1;
            if((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checarColunas() {
        for(int coluna=0 ; coluna<3 ; coluna++) {
            if((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
                return -1;
            if((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checarDiagonais() {
        if((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
            return -1;
        if((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
            return 1;
        if((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
            return -1;
        if((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
            return 1;
        
        return 0;
    }

    public boolean tabuleiroCompleto() {
        for(int linha=0 ; linha<3 ; linha++) {
            for(int coluna=0 ; coluna<3 ; coluna++) {
                if(tabuleiro[linha][coluna]==0 ) { 
                    return false; 
                }
            }
        }
        return true;
    }

    public int ChecarVitoria() {
        if(this.checarLinhas() == 1) return 1;
        if(this.checarColunas() == 1) return 1;
        if(this.checarDiagonais() == 1) return 1;
        
        if(this.checarLinhas() == -1) return -1;
        if(this.checarColunas() == -1) return -1;
        if(this.checarDiagonais() == -1) return -1;
        
        return 0;
    }

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