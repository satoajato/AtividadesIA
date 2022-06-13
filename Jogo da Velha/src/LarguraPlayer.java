public class LarguraPlayer extends Player{
    
    public LarguraPlayer(int jogador) {
        super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador 'Busca em Largura' criado!");
    }
    
    @Override
    public void jogar(Board tabuleiro) {
        Tentativa(tabuleiro);
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
    @Override
    public void Tentativa(Board tabuleiro) {
        //carregar o tabuleiro
        System.out.println("Buscando jogada...");
        do{
            carregarTabuleiro(tabuleiro);
            BFS<Board> buscaVit2 = new BFS<Board>(1,this.grafo.getRaiz(),this.grafo); //buscar vitória
            tentativa = buscaVit2.buscar();
            if(!checarTentativa(tentativa, tabuleiro)) {
                carregarTabuleiro(tabuleiro);
                BFS<Board> buscaEmp = new BFS<Board>(2,this.grafo.getRaiz(),this.grafo); //buscar empate
                tentativa = buscaEmp.buscar();
                if(!checarTentativa(tentativa,tabuleiro)) {
                	System.out.println("Jogada Aleatória!");
                	tentativa = JogadaAleatoria();
                }
            }
        }
        while(!checarTentativa(tentativa, tabuleiro));
        int linha = this.tentativa[0] + 1;
        int coluna = this.tentativa[1] + 1;
        System.out.println("Linha: " + linha + "\nColuna:  " + coluna);
    }
}