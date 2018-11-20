import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Tests {
    @Test
    public void gewinnROT(){
        FourWinsLogic spielfeld = new Spielfeld();
        assertEquals("SPIEL_LÄUFT",   spielfeld.throwChip(Spielstein.ROT,1));
        assertEquals("SPIEL_LÄUFT",   spielfeld.throwChip(Spielstein.ROT,2));
        assertEquals( "SPIEL_LÄUFT",  spielfeld.throwChip(Spielstein.ROT,3));
          assertEquals("SIEGER_ROT",spielfeld.throwChip(Spielstein.ROT,4));
    }
}
