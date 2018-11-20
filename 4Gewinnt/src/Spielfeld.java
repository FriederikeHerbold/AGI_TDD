public class Spielfeld implements FourWinsLogic {

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
        for (int i = 5; i > 0; i--) {
            if (feld[spalte][i] == null) {
                zeile = i;
            }
        }
    }

    private Ergebniss prüfeAufSieg(Spielstein farbe, int column) {

        if(pruefeHorizontal(column, farbe) && farbe == Spielstein.ROT){
            return Ergebniss.SIEGER_ROT;
        }
        return Ergebniss.SPIEL_LÄUFT;
    }

    private boolean pruefeHorizontal(int column, Spielstein farbe){
        int anzahl = 0;
        if(feld[0][5]==farbe && feld[1][5]==farbe && feld[2][5]==farbe && feld[3][5]==farbe){
            return true;
        } else {
            return false;
        }
    }
}
