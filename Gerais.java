import java.util.LinkedList;

public class Gerais extends Jogo_Do_Galo {


    public static LinkedList<No> successors(char[][] estado, String type){

        LinkedList<No> succ = new LinkedList<No>();

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(estado[i][j] == ' '){
                    if(type.equals("max")){
                        char[][] temp = clone(estado);
                        temp[i][j] = comp.charAt(0);
                        succ.add(new No(temp, getmovimento(i, j)));
                    }else{
                        char[][] temp = clone(estado);
                        temp[i][j] = player.charAt(0);
                        succ.add(new No(temp, getmovimento(i, j)));
                    }
                }
            }
        }

        return succ;
    }

    public static String getmovimento(int y, int x){
        return table[y][x];
    }

    public static int max(int v, int val){
        if(v > val)
            return v;
        return val;
    }
    public static int min(int v, int val){
        if(v < val)
            return v;
        return val;
    }

    public static int getScore( String winner, int d){
        if(!winner.equals("DRAW")){
            if(winner.equals(player))
                return -10+d;
            else
                return 10-d;
        }
        return 0;
    }

    public static void endGame(String winner){
        if(player.equals(winner))
            System.out.println("You won.");
        else if(comp.equals(winner))
            System.out.println("You lost.");
        else
            System.out.println("It's a draw.\n" );
    }

    public static String isTerminal(char[][] estado){

        int j=0;

        //Horizontal
        for(int i=0; i<3; i++)
            if(estado[i][j] == estado[i][j+1] && estado[i][j] == estado[i][j+2] && estado[i][j] != ' ')
                return String.valueOf(estado[i][j]);

        //Vertical
        for(int i=0; i<3; i++)
            if(estado[j][i] == estado[j+1][i] && estado[j][i] == estado[j+2][i] && estado[j][i] != ' ')
                return String.valueOf(estado[j][i]);

        //Diagonal
        if(estado[0][0] == estado[1][1] && estado[0][0] == estado[2][2] && estado[0][0] != ' '){
            return String.valueOf(estado[0][0]);
        }
        if(estado[0][2] == estado[1][1] && estado[0][2] == estado[2][0] && estado[0][2] != ' '){
            return String.valueOf(estado[0][2]);
        }

        for(int i=0; i<3; i++)
            for(int k=0; k<3; k++)
                if(estado[i][k] == ' ')
                    return "NO";

        return "DRAW";


    }

    public static boolean evalmovimento(String movimento){
        switch(movimento){
            case "1" : return (atual[0][0]==' ')?true:false;
            case "2" : return (atual[0][1]==' ')?true:false;
            case "3" : return (atual[0][2]==' ')?true:false;
            case "4" : return (atual[1][0]==' ')?true:false;
            case "5" : return (atual[1][1]==' ')?true:false;
            case "6" : return (atual[1][2]==' ')?true:false;
            case "7" : return (atual[2][0]==' ')?true:false;
            case "8" : return (atual[2][1]==' ')?true:false;
            case "9" : return (atual[2][2]==' ')?true:false;
            default: return false;
        }
    }
    public static void jogada(String movimento){
        String tmp="";
        if(turn == true)
            tmp = player;
        else
            tmp = comp;

        switch(movimento){
            case "1" : atual[0][0]=tmp.charAt(0); break;
            case "2" : atual[0][1]=tmp.charAt(0); break;
            case "3" : atual[0][2]=tmp.charAt(0); break;
            case "4" : atual[1][0]=tmp.charAt(0); break;
            case "5" : atual[1][1]=tmp.charAt(0); break;
            case "6" : atual[1][2]=tmp.charAt(0); break;
            case "7" : atual[2][0]=tmp.charAt(0); break;
            case "8" : atual[2][1]=tmp.charAt(0); break;
            case "9" : atual[2][2]=tmp.charAt(0); break;
            default: System.exit(1);
        }
    }

    public static char[][] clone(char[][] state){
        char[][] clone = new char[3][3];
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                clone[i][j] = state[i][j];

        return clone;
    }

    public static void printestado(char[][] state){

        //state[y][x]
        System.out.println();
        if(turn == true)
            System.out.println("Your turn");
        else
            System.out.println("Computer");
        System.out.println();
        System.out.println(state[0][0]+" | "+state[0][1]+" | "+state[0][2]+"  ");
        System.out.println(state[1][0]+" | "+state[1][1]+" | "+state[1][2]+"  ");
        System.out.println(state[2][0]+" | "+state[2][1]+" | "+state[2][2]+"  ");
        System.out.println();
    }

}



