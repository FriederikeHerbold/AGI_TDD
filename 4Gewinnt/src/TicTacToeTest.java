import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicTacToeTest {
    TicTacToeLogic spielfeld;

    @Before
    public void init() {
        spielfeld = new Spielfeld(Spielvariante.TIC_TAC_TOE);
    }

    @Test
    public void gewinnHorizontalROTUnten() {
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 1, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 1, 2));
        assertEquals("SIEGER_ROT", spielfeld.setChip(Spielstein.ROT, 1, 3));
    }

    @Test
    public void gewinnHorizontalROTMitte() {
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 2, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 2, 2));
        assertEquals("SIEGER_ROT", spielfeld.setChip(Spielstein.ROT, 2, 3));
    }

    @Test
    public void gewinnHorizontalROTOben() {
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 3, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 3, 2));
        assertEquals("SIEGER_ROT", spielfeld.setChip(Spielstein.ROT, 3, 3));
    }

    @Test
    public void gewinnVertikalROTLinks() {
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 1, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 2, 1));
        assertEquals("SIEGER_ROT", spielfeld.setChip(Spielstein.ROT, 3, 1));
    }

    @Test
    public void gewinnVertikalROTMitte() {
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 1, 2));
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 2, 2));
        assertEquals("SIEGER_ROT", spielfeld.setChip(Spielstein.ROT, 3, 2));
    }

    @Test
    public void gewinnVertikalROTRechts() {
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 1, 3));
        assertEquals("SPIEL_LÄUFT", spielfeld.setChip(Spielstein.ROT, 2, 3));
        assertEquals("SIEGER_ROT", spielfeld.setChip(Spielstein.ROT, 3, 3));
    }
}
