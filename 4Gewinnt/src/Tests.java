import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {
    @Test
    public void gewinnHorizontalROT() {
        FourWinsLogic spielfeld = new Spielfeld();
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 1));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 2));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 3));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 4));
    }


    @Test
    public void gewinnHorizontalROT2() {
        FourWinsLogic spielfeld = new Spielfeld();
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 2));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 3));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 4));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 5));
    }

    @Test
    public void gewinnHorizontalROT3() {
        FourWinsLogic spielfeld = new Spielfeld();
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 4));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 5));
        assertEquals("SPIEL_LÄUFT", spielfeld.throwChip(Spielstein.ROT, 6));
        assertEquals("SIEGER_ROT", spielfeld.throwChip(Spielstein.ROT, 7));
    }
}
