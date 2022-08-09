import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Board {

    private int[][] matriz;
    private int pontuacao;

    public Board(int N) {
        this.matriz = GerarRandom(N);
    }

    public Board(int[][] mat) {
        this.matriz = mat;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    private int[][] GerarRandom(int n) {
        int[][] matAux = new int[n][n];
        for(int i = 0; i<matAux.length; i++) {
            for(int j = 0; j<matAux[i].length; j++) {
                matAux[i][j] = 0;
            }
        }

        ArrayList<Integer> pedras = new ArrayList<>() ;
        for(int i=1 ; i<=Math.pow(n, 2)-1 ; i++) {
            pedras.add(i);
        }

        while(!pedras.isEmpty()) {
            Random rand = new Random();
            int x = rand.nextInt(0,n);
            int y = rand.nextInt(0,n);

            if(matAux[x][y] == 0) {
                matAux[x][y] = pedras.remove(pedras.size()-1);
            }
        }

        return matAux;
    }

    public void printarTabuleiro() {
        System.out.println("Tabuleiro: ");
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "] ");
            }
            System.out.println();
        }
        System.out.println("Distancia: " + this.pontuacao + "\n");
        new Scanner(System.in).nextLine();
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

}