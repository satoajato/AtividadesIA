public class Main {
    public static void main(String[] args) throws Exception {
        int number = 4; //args
        NQueen jogo = new NQueen(number);
        jogo.printarTabuleiro();

        jogo.solucao();
    }
}
