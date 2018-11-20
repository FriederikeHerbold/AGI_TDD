public class Spielfeld implements FourWinsLogic {

    public static final int MAX_COLUMS = 7;
    public static final int WIN_LENGTH = 4;
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
        return prüfeAufSieg(player, column).toString();
    }

    private void setzeSpielstein(Spielstein farbe, int spalte) {
        findeZeile(spalte);
        feld[spalte][zeile] = farbe;
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

    private Ergebniss prüfeAufSieg(Spielstein farbe, int column) {

        if (prüfeHorizontal(farbe) && farbe == Spielstein.ROT) {
            return Ergebniss.SIEGER_ROT;
        }
        return Ergebniss.SPIEL_LÄUFT;
    }

    private boolean prüfeHorizontal(Spielstein farbe) {
        boolean win = false;
        for (int i = 0; i < MAX_COLUMS - WIN_LENGTH + 1; i++) {
            boolean winIntern = true;
            for (int y = i; y < WIN_LENGTH + i; y++) {
                winIntern &= feld[y][5] == farbe;
            }
            win |= winIntern;
        }
        return win;
    }

}
