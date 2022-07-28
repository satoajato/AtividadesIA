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
        System.out.println("--- Algoritmo Subida de Encosta para resolver problema das N-Puzzle ---:");
        this.tabuleiro.setPontuacao(mh.metaHeuristica(this.tabuleiro,this.tamanho));
        this.tabuleiro.printarTabuleiro();
        HillClimbing(this.tabuleiro);
        // switch (alg) {
        //     case 1:
        //         System.out.println("--- Algoritmo Subida de Encosta para resolver problema das 8 rainhas ---:");
        //         this.tabuleiro.setPontuacao(mh.metaHeuristica(this.tabuleiro));
        //         this.tabuleiro.printarTabuleiro();
        //         HillClimbing(this.tabuleiro);
        //         break;
        //     case 2:
                
        //         break;
        //     case 3:
                
        //         break;
        // }
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

    public Board LocalBeam() {
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
