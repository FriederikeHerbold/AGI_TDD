public class Spielfeld implements FourWinsLogic {

    public static final int MAX_COLUMS = 6;
    public static final int WIN_LENGTH = 4;
    public static final int MAX_ROWS = 5;
    Spielstein[][] feld;
    int zeile = -1;

    public Spielfeld() {
        feld = new Spielstein[7][6];
    }

    @Override
    public String throwChip(Spielstein player, int column) {
        column--;
        if (!prüfeObSpalteVoll(feld[column])) {
            setzeSpielstein(player, column);
        }
        return prüfeAufSieg(player).toString();
    }

    private void setzeSpielstein(Spielstein farbe, int spalte) {
        findeZeile(spalte);
        feld[spalte][zeile] = farbe;
        /*        System.out.println("Setze: zeile=" + zeile + ", spalte=" + spalte);*/
        zeile = -1;
    }

    private boolean prüfeObSpalteVoll(Spielstein[] spalte) {
        boolean voll = true;
        for (int i = 0; i < 6; i++) {
            if (spalte[i] == null) {
                voll = false;
            }
        }
        return voll;
    }

    private void findeZeile(int spalte) {
        for (int i = 5; i >= 0; i--) {
            if (feld[spalte][i] == null && zeile == -1) {
                zeile = i;
            }
        }
    }

    private Ergebniss prüfeAufSieg(Spielstein farbe) {

        if (prüfeHorizontal(farbe) || prüfeVertikal(farbe)) {
            if (farbe == Spielstein.ROT) {
                return Ergebniss.SIEGER_ROT;
            } else if (farbe == Spielstein.GELB) {
                return Ergebniss.SIEGER_GELB;
            }
        }
        return Ergebniss.SPIEL_LÄUFT;
    }

    private boolean prüfeHorizontal(Spielstein farbe) {
        boolean win = false;
        for (int zeile = MAX_ROWS; zeile >= 0; zeile--) {
            for (int pos = 0; pos <= MAX_COLUMS - WIN_LENGTH + 1; pos++) {
                boolean winIntern = true;
                for (int column = pos; column < WIN_LENGTH + pos; column++) {
                    winIntern &= feld[column][zeile] == farbe;
                }
                win |= winIntern;
            }
        }
        return win;
    }

    private boolean prüfeVertikal(Spielstein farbe) {
        boolean win = false;
        for (int spalte = 0; spalte <= MAX_COLUMS; spalte++) {
            for (int pos = 0; pos <= MAX_ROWS - WIN_LENGTH + 1; pos++) {
                boolean winIntern = true;
                for (int zeile = (MAX_ROWS - pos); zeile >= MAX_ROWS - WIN_LENGTH + 1 - pos; zeile--) {
                    winIntern &= feld[spalte][zeile] == farbe;
                }
                win |= winIntern;
            }
        }
        return win;
    }
}
