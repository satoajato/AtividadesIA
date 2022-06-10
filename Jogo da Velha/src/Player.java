public abstract class Player {
    protected Graph<Board> grafo = new Graph<Board>();
    protected int[] tentativa = new int[2];
    protected int jogador;
    
    public Player(int jogador) {
        this.jogador = jogador;
    }
    
    public abstract void jogar(Board tabuleiro);
    
    public abstract void Tentativa(Board tabuleiro);

    public boolean checarTentativa(int[] tentativa, Board tabuleiro) {
        if(tabuleiro.getPosicao(tentativa) == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void carregarTabuleiro(Board tabuleiro) {
        this.grafo = tabuleiro.espaco_busca(this.grafo,tabuleiro,true);
    }
}