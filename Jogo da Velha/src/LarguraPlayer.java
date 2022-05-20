public class LarguraPlayer extends Player{
    
    public LarguraPlayer(int jogador){
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
    public void Tentativa(Board tabuleiro){
        
    }
}