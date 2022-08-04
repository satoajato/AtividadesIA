import java.util.ArrayList;
import java.util.Random;

public class Puzzle {

    private Board tabuleiro;
    private MetaH mh;
    private int tamanho;


    public Puzzle(int Number) {
        this.tamanho = Number;
        this.tabuleiro = new Board(Number);
        this.mh = new MetaH(this.tabuleiro);
    }

    public void solucao(int alg) {
        switch (alg) {
            case 1:
                System.out.println("--- Algoritmo Subida de Encosta para resolver problema das N-Puzzle ---:");
                this.tabuleiro.setPontuacao(mh.metaHeuristica(this.tabuleiro,this.tamanho));
                this.tabuleiro.printarTabuleiro();
                HillClimbing(this.tabuleiro);
                break;
            case 2:
                System.out.println("--- Algoritmo Tempera Simulada para resolver problema das N-Puzzle ---:");
                this.tabuleiro.setPontuacao(mh.metaHeuristica(this.tabuleiro,this.tamanho));
                this.tabuleiro.printarTabuleiro();
                SimulatedAnnealing(this.tabuleiro);
                break;
            case 3:
                System.out.println("--- Algoritmo Feixe Local para resolver problema das N-Puzzle ---:");
                LocalBeam(2,this.tamanho);
                break;
        }
    }

    public Board HillClimbing(Board board) {
        //atual = inio
        //while true
        //  V = atual.adja.get(vmin ou vmax)
        //  se valor de v = valor de atual
        //      retorna atual
        //  atual = v
        Board atual = board; 
        while(true) {
            MetaH mh = new MetaH(atual);
            Board menor = mh.getMinAdj(atual);
            if(atual.getPontuacao() == menor.getPontuacao()) {
                System.out.println("Achou o que menos se distancia: ");
                menor.printarTabuleiro();
                return menor;
            }
            atual = menor;
            atual.printarTabuleiro();
        }
    }

    public Board SimulatedAnnealing(Board board) {
        //Atual = P.inicial
        //For t = 1 até infinito
        //  T = S(t)
        //  if(T==0):
        //      return Atual
        //  Prox = Atual.sucessorRandom()
        //  DeltaE = Prox.getValor - Atual.getValor
        //  if(DeltaE < 0):
        //      Atual = Prox
        //  else if(rand(0,1) < e^(-DeltaE/T)):
        //      Atual = Prox
        Board atual = board;
        for(int t = 1; true; t++) {
            Double T = 1/(1+Math.pow(2.718, t*0.00005)); 
            System.out.println("Temperatura: " + T);
            if(T==0) {
                System.out.println("Achou o que menos se distancia: ");
                atual.printarTabuleiro();
                return atual;
            }
            MetaH mh = new MetaH(atual);
            Board prox = mh.getRandAdj(atual);
            int deltaE = prox.getPontuacao() - atual.getPontuacao();
            Random r = new Random();
            if(deltaE < 0) {
                System.out.println("A");
                atual = prox;
            }
            else {
                double tmp_a = r.nextDouble(0,1);
                double tmp_b = Math.exp(-deltaE/T);
                System.out.println(tmp_a + " - " + tmp_b);
                if(tmp_a < tmp_b) {
                    System.out.println("B");
                    atual = prox;
                }
            }
            atual.printarTabuleiro();
        }
    }

    public Board LocalBeam(int K, int tam) {
        //Atuais = P.getRandom(K)
        //while(true):
        //  S = Atuais.getSucessores(K)
        //  if(Atuais.hasSolucao()):
        //      return atuais.getSolucao()
        //  Atuais = S.getMelhores()
        ArrayList<Board> atuais = new ArrayList<>();
        for(int i=0; i<K; i++) {
            atuais.add(new Board(tam));
        }
        while(true) {
            
        }
    }

    public Board getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Board tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

}