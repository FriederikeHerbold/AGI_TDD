import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FourWinTest {
    FourWinsLogic spielfeld;

    @Before
    public void init() {
        spielfeld = new Spielfeld();
    }

    @Test
    public void gewinnHorizontalROTUntenLinks() {
       /* spielfeld = new Spielfeld(
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "xxx    ");*/
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 2));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 3));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 4));
    }

    @Test
    public void gewinnHorizontalROTUntenMitte() {
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 2));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 3));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 4));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 5));
    }

    @Test
    public void gewinnHorizontalROTUntenRechts() {
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 4));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 5));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 6));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 7));
    }

    @Test
    public void gewinnHorizontalROTMitteLinks() {
        spielfeld.throwChip(Spielstein.GELB, 4);
        spielfeld.throwChip(Spielstein.GELB, 5);
        spielfeld.throwChip(Spielstein.GELB, 6);
        assertEquals("SIEGER_GELB", spielfeld.throwChip(Spielstein.GELB, 7));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 4));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 5));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 6));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 7));
    }

    @Test
    public void gewinnHorizontalROTObenLinks() {
        spielfeld.throwChip(Spielstein.GELB, 1);
        spielfeld.throwChip(Spielstein.GELB, 2);
        spielfeld.throwChip(Spielstein.GELB, 3);
        spielfeld.throwChip(Spielstein.GELB, 4);
        spielfeld.throwChip(Spielstein.GELB, 1);
        spielfeld.throwChip(Spielstein.GELB, 2);
        spielfeld.throwChip(Spielstein.GELB, 3);
        spielfeld.throwChip(Spielstein.GELB, 4);
        spielfeld.throwChip(Spielstein.GELB, 1);
        spielfeld.throwChip(Spielstein.GELB, 2);
        spielfeld.throwChip(Spielstein.GELB, 3);
        spielfeld.throwChip(Spielstein.GELB, 4);
        spielfeld.throwChip(Spielstein.GELB, 1);
        spielfeld.throwChip(Spielstein.GELB, 2);
        spielfeld.throwChip(Spielstein.GELB, 3);
        spielfeld.throwChip(Spielstein.GELB, 4);
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 2));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 3));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 4));
    }

    @Test
    public void gewinnHorizontalROTObenRechts() {
        spielfeld.throwChip(Spielstein.GELB, 4);
        spielfeld.throwChip(Spielstein.GELB, 5);
        spielfeld.throwChip(Spielstein.GELB, 6);
        spielfeld.throwChip(Spielstein.GELB, 7);
        spielfeld.throwChip(Spielstein.GELB, 4);
        spielfeld.throwChip(Spielstein.GELB, 5);
        spielfeld.throwChip(Spielstein.GELB, 6);
        spielfeld.throwChip(Spielstein.GELB, 7);
        spielfeld.throwChip(Spielstein.GELB, 4);
        spielfeld.throwChip(Spielstein.GELB, 5);
        spielfeld.throwChip(Spielstein.GELB, 6);
        spielfeld.throwChip(Spielstein.GELB, 7);
        spielfeld.throwChip(Spielstein.GELB, 4);
        spielfeld.throwChip(Spielstein.GELB, 5);
        spielfeld.throwChip(Spielstein.GELB, 6);
        spielfeld.throwChip(Spielstein.GELB, 7);
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 4));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 5));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 6));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 7));
    }

    @Test
    public void gewinnVertikalROTUntenLinks() {
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 1));
    }

    @Test
    public void gewinnVertikalROTMitteLinks() {
        spielfeld.throwChip(Spielstein.GELB, 1);
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 1));
    }

    @Test
    public void gewinnVertikalROTObenLinks() {
        spielfeld.throwChip(Spielstein.GELB, 1);
        spielfeld.throwChip(Spielstein.GELB, 1);
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 1));
    }

    @Test
    public void gewinnVertikalROTUntenMitte() {
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 3));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 3));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 3));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 3));
    }

    @Test
    public void gewinnVertikalROTUntenRechts() {
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 7));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 7));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 7));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 7));
    }

    @Test
    public void gewinnVertikalROTObenRechts() {
        spielfeld.throwChip(Spielstein.GELB, 7);
        spielfeld.throwChip(Spielstein.GELB, 7);
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 7));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 7));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 7));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 7));
    }
}
