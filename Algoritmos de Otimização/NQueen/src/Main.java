public class Main {
    public static void main(String[] args) throws Exception {
        int number = 4;
        int alg = 3;
        for(int i = 0; i<args.length; i++) {
            if(args[i].equals("-H")) {
                System.out.println("=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Comandos: ");
                System.out.println("'-N x' (x sendo o número de rainhas)");
                System.out.println("'-A alg' (alg sendo um algoritmo de otimização)");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Lista de algoritmos:");
                System.out.println("'1' - Subida de Encosta (Hill Climbing)");
                System.out.println("'2' - Tempera Simulada (Simulated Annealing)");
                System.out.println("'3' - Feixe Local (Local Beam)");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=");
            }
            else if(args[i].equals("-N")) {
                number = Integer.parseInt(args[i+1]);
            }
            else if(args[i].equals("-A")) {
                alg = Integer.parseInt(args[i+1]);
            }
        }
        NQueen jogo = new NQueen(number);
        jogo.solucao(alg);
    }
}