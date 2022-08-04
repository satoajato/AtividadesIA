public class ProfundidadePlayer extends Player{

    public ProfundidadePlayer(int jogador) {
        super(jogador);
        this.jogador = jogador;
        System.out.println("Jogador 'Busca em Profundidade' criado!");
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
            DFS<Board> buscaVit = new DFS<Board>(1,this.grafo.getRaiz(),this.grafo); //buscar vitória
            tentativa = buscaVit.buscar();
            if(!checarTentativa(tentativa, tabuleiro)) {
                carregarTabuleiro(tabuleiro);
                DFS<Board> buscaEmp = new DFS<Board>(2,this.grafo.getRaiz(),this.grafo); //buscar empate
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