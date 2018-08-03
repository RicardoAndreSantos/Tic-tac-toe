import java.util.*;

public class Jogo_Do_Galo{

    public static boolean turn;
    public static String player;
    public static String comp;
    public static int algo;
    public static char[][] atual;
    public static String[][] table = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    public static int nrestados;
    public static String compMove;

    public static void main(String args[]){

        Scanner ler = new Scanner(System.in);
        atual = new char[3][3];
        nrestados=0;
        System.out.println("Algorithm ?");
        System.out.println("1 - Min-Max");
        System.out.println("2 - Alpha Beta");
        algo = ler.nextInt();
        System.out.println("How to play");
        int x = 1;
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(x + " | ");
                x++;
            }
            System.out.println();
        }

        System.out.println("Be the first to play?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        if ( ler.nextInt() == 1 ) {
            turn = true;
        }
        else {
            turn = false;
        }
        player = "X";
        comp = "O";
        for(char[] row: atual){
            Arrays.fill(row, ' ');
        }

        String win;

        while((win = Gerais.isTerminal(atual)) == "NO"){

            String move="";
            Gerais.printestado(atual);

            if(turn){
                move = ler.next();
                while(!Gerais.evalmovimento(move)){
                    System.out.println("Try Again");
                    System.out.println();
                    move = ler.next();
                }
                Gerais.jogada(move);
                turn = !turn;
                continue;
            }
            if(algo == 1)
                Minimax.minimax(atual, 1, true);
            else if(algo == 2)
                Alphabeta.alphabeta(atual, 1, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
            move = compMove;
            if(Gerais.evalmovimento(move)){
                Gerais.jogada(move);
            }

            turn = !turn;
        }
        Gerais.printestado(atual);
        Gerais.endGame(win);
    }

}

class No{

    public char[][] estado;
    public String mov;

    No(char[][] estado, String mov){
        this.estado = estado;
        this.mov=mov;
    }

}

