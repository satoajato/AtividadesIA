public class Board {

    private int[][] matriz;
    private int pontuacao;

    public Board(int N) {
        this.matriz = new int[N][N];
    }

    public void printarTabuleiro() {
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getTabuleiro() {
        return this.matriz;
    }

    public void setTabuleiro(int[][] tabuleiro) {
        this.matriz = tabuleiro;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

}
