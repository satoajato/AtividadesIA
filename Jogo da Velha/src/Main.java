import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        do {
            Game jogo = new Game();
            System.out.println("Continuar no jogo? 0 - nao, 1 - sim");
            x = scan.nextInt();
        }
        while(x!=0);
    }
}