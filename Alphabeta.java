public class Alphabeta extends Jogo_Do_Galo {
    public static int alphabeta(char[][] estado, int prof, int a, int b, boolean max) {

        String temp = Gerais.isTerminal(estado);
        int v = 0;
        if (!temp.equals("NO")) {
            return Gerais.getScore( temp, prof);
        }
        if (max) {
            v = Integer.MIN_VALUE;
            for (No act : Gerais.successors(estado, "max")) {
                nrestados++;
                int tmp = v;
                v = Gerais.max(v, alphabeta(act.estado, prof + 1, a, b, false));
                if (v > tmp && prof == 1)
                    compMove = act.mov;
                a = Gerais.max(a, v);
                if (b <= a)
                    break;
            }
        } else {
            v = 7000000;
            for (No act : Gerais.successors(estado, "min")) {
                nrestados++;
                v = Gerais.min(v, alphabeta(act.estado, prof + 1, a, b, true));
                b = Gerais.min(b, v);
                if (b <= a)
                    break;
            }
        }
        return v;
    }
}