public class Spielfeld implements FourWinsLogic, TicTacToeLogic {

    public int MAX_COLUMNS;
    public int MAX_ROWS;
    public int WIN_LENGTH;

    Spielstein[][] feld;
    int zeile = -1;

    public Spielfeld() {
        CreateFourWins();
    }

    public Spielfeld(Spielvariante variante) {
        switch (variante) {
            case FOUR_WINS:
                CreateFourWins();
                break;
            case TIC_TAC_TOE:
                crateTicTacToe();
                break;
            default:
                CreateFourWins();
        }
    }

    protected Spielfeld(String row6, String row5, String row4, String row3, String row2, String row1) {
        CreateFourWins();
        for (int i = 0; i <= MAX_COLUMNS; i++) {
            char test = row1.charAt(i);
            if (test == 'x') {
                setzeSpielstein(Spielstein.ROT, i, 0);
            } else if (test == 'o') {
                setzeSpielstein(Spielstein.GELB, i, 0);
            }
        }
        for (int i = 0; i <= MAX_COLUMNS; i++) {
            char test = row2.charAt(i);
            if (test == 'x') {
                setzeSpielstein(Spielstein.ROT, i, 1);
            } else if (test == 'o') {
                setzeSpielstein(Spielstein.GELB, i, 1);
            }
        }
        for (int i = 0; i <= MAX_COLUMNS; i++) {
            char test = row3.charAt(i);
            if (test == 'x') {
                setzeSpielstein(Spielstein.ROT, i, 2);
            } else if (test == 'o') {
                setzeSpielstein(Spielstein.GELB, i, 3);
            }
        }
        for (int i = 0; i <= MAX_COLUMNS; i++) {
            char test = row4.charAt(i);
            if (test == 'x') {
                setzeSpielstein(Spielstein.ROT, i, 3);
            } else if (test == 'o') {
                setzeSpielstein(Spielstein.GELB, i, 3);
            }
        }
        for (int i = 0; i <= MAX_COLUMNS; i++) {
            char test = row5.charAt(i);
            if (test == 'x') {
                setzeSpielstein(Spielstein.ROT, i, 4);
            } else if (test == 'o') {
                setzeSpielstein(Spielstein.GELB, i, 4);
            }
        }
        for (int i = 0; i <= MAX_COLUMNS; i++) {
            char test = row6.charAt(i);
            if (test == 'x') {
                setzeSpielstein(Spielstein.ROT, i, 5);
            } else if (test == 'o') {
                setzeSpielstein(Spielstein.GELB, i, 5);
            }
        }
    }

    protected Spielfeld(String row3, String row2, String row1) {

    }

    private void CreateFourWins() {
        MAX_COLUMNS = 6;
        MAX_ROWS = 5;
        WIN_LENGTH = 4;
        feld = new Spielstein[MAX_COLUMNS + 1][MAX_ROWS + 1];
    }

    private void crateTicTacToe() {
        MAX_COLUMNS = 2;
        MAX_ROWS = 2;
        WIN_LENGTH = 3;
        feld = new Spielstein[MAX_COLUMNS + 1][MAX_ROWS + 1];
    }

    @Override
    public String throwChip(Spielstein chip, int column) {
        column--;
        if (!prüfeObSpalteVoll(column)) {
            werfeSpielstein(chip, column);
        }
        return prüfeAufSieg(chip).toString();
    }

    @Override
    public String setChip(Spielstein chip, int row, int column) {
        column--;
        row--;
        if (!prüfeObSpalteVoll(row, column)) {
            setzeSpielstein(chip, column, row);
        }
        return prüfeAufSieg(chip).toString();
    }

    private void werfeSpielstein(Spielstein farbe, int spalte) {
        findeZeile(spalte);
        setzeSpielstein(farbe, spalte, zeile);
        zeile = -1;
    }

    private void setzeSpielstein(Spielstein farbe, int col, int row) {
        feld[col][row] = farbe;
    }

    private boolean prüfeObSpalteVoll(int column) {
        Spielstein[] spalte = feld[column];
        boolean voll = true;
        for (int i = 0; i < 6; i++) {
            if (spalte[i] == null) {
                voll = false;
            }
        }
        return voll;
    }

    private boolean prüfeObSpalteVoll(int row, int column) {
        return feld[row][column] != null;
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
            for (int pos = 0; pos <= MAX_COLUMNS - WIN_LENGTH + 1; pos++) {
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
        for (int spalte = 0; spalte <= MAX_COLUMNS; spalte++) {
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
