public class Minimax  extends Jogo_Do_Galo{
    public static int minimax(char[][] estado, int d, boolean max){

        String temp = Gerais.isTerminal(estado);
        int v = 0;

        if(!temp.equals("NO")){
            return Gerais.getScore( temp, d);
        }

        if(max){
            v = Integer.MIN_VALUE;
            for(No act:Gerais.successors(estado, "max")){
                nrestados++;
                int tmp = v;
                v = Gerais.max(v, minimax(act.estado, d+1, false));
                if(v > tmp && d == 1)
                    compMove = act.mov;
            }
        }else{
            v = 700000;
            for(No act:Gerais.successors(estado, "min")){
                nrestados++;
                v = Gerais.min(v, minimax(act.estado, d+1, true));
            }
        }
        return v;
    }
}
