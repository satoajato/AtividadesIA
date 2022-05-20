public class ProfundidadePlayer extends Player{
    
    public ProfundidadePlayer(int jogador){
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
    public void Tentativa(Board tabuleiro){
        
    }
}