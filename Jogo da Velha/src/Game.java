import java.util.Scanner;

public class Game {
    private Board tabuleiro;
    private int rodada=1, vez=1;
    private Player jogador1;
    private Player jogador2;
    public Scanner entrada = new Scanner(System.in);
    
    public Game() {
        tabuleiro = new Board();
        iniciarJogadores();
        while(Jogar());
    }
    
    public void iniciarJogadores() {
        System.out.println("Você é o Jogador 1!");
        this.jogador1 = new Humano(1);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Quem vai ser o Jogador 2?");
        
        int numPlayer = escolherJogador();
        if(numPlayer == 1) {
            this.jogador2 = new LarguraPlayer(2);
        }
        else if(numPlayer == 2) {
            this.jogador2 = new ProfundidadePlayer(2);
        }
        else if(numPlayer == 3) {
            this.jogador2 = new Humano(2);
        }
        
    }
    
    public int escolherJogador() {
        int opcao=0;
        do {
            System.out.println("1. Busca em Largura");
            System.out.println("2. Busca em Profundidade");
            System.out.println("3. Humano\n");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            if(opcao != 1 && opcao != 2 && opcao != 3) {
                System.out.println("Opção inválida! Tente novamente");
            }
        }
        while(opcao != 1 && opcao != 2 && opcao != 3);
        return opcao;
    }
    
    public boolean Jogar() {
        if(ganhou() == 0 ) {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("\nRodada "+rodada);
            System.out.println("É a vez do jogador " + vez() );
            
            if(vez()==1) {
                jogador1.jogar(tabuleiro);
            }
            else {
                jogador2.jogar(tabuleiro);
            }
            
            if(tabuleiro.tabuleiroCompleto() && tabuleiro.getPontuacao()==2) {
                System.out.println("\nTabuleiro Completo. Jogo empatado");
                return false;
            }
            vez++;
            rodada++;

            return true;
        } 
        else {
            if(ganhou() == -1 ) {
                System.out.println("Jogador 1 ganhou!");
            }
            else {
                System.out.println("Jogador 2 ganhou!");
            }
            return false;
        }
            
    }
    
    public int vez() {
        if(vez%2 == 1) { 
            return 1;
        }
        else {
            return 2;
        }
    }
    
    public int ganhou() {
        if(tabuleiro.checarLinhas() == 1) return 1;
        if(tabuleiro.checarColunas() == 1) return 1;
        if(tabuleiro.checarDiagonais() == 1) return 1;
        
        if(tabuleiro.checarLinhas() == -1) return -1;
        if(tabuleiro.checarColunas() == -1) return -1;
        if(tabuleiro.checarDiagonais() == -1) return -1;
        
        return 0;
    }
}