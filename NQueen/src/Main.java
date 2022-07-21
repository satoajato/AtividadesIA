public class Main {
    public static void main(String[] args) throws Exception {
        int number = 7; //args
        NQueen jogo = new NQueen(number);
        jogo.getTabuleiro().printarTabuleiro();

        jogo.solucao();
    }
}