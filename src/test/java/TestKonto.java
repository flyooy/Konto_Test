import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.example.Konto;
import org.junit.Test;

public class TestKonto {
    @Test
    public void testAbHebenMitGueltigemBetrag() {
    Konto konto = new Konto("GB2384931H", 22.0);
        double betrag = 5.0;
    assertEquals(17,konto.abHeben(betrag),0.001);
        Konto konto2 = new Konto("GB2384931H", 25.0);
        double betrag2 = 10.0;
        assertEquals(15,konto2.abHeben(betrag2),0.001);
    }

    @Test
    public void testObSaldoWenigerAlsBetragIstAbheben() {
        Konto konto = new Konto("GB2384931H", 22.0);
        double betrag = 25.0;
        assertThrows(IllegalArgumentException.class, () -> {
            konto.abHeben(betrag);
        });

    }

    @Test
    public void testObBetragNegativIstAbhebenAndEinzahlen() {
        Konto konto = new Konto("GB2384931H", 22.0);
        double betrag = -5.0;
        assertThrows(IllegalArgumentException.class, () -> {
            konto.abHeben(betrag);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            konto.einZahlen(betrag);
        });
    }

    @Test
    public void testEinZahlen() {
        Konto konto = new Konto("GB2384931H", 22.0);
        double betrag = 5.0;
        assertEquals(27,konto.einZahlen(betrag),0.001);
    }

    @Test
    public void testUberweisen() {
        Konto konto = new Konto("GB2384931H", 22.0);
        Konto konto2 = new Konto("GB2284531H", 50.0);
        double betrag = 15.0;
        assertEquals(7,konto.uberweisen(konto2,betrag),0.001);
        assertEquals(65,konto2.getSaldo(),0.001);
    }

    @Test
    public void testObSaldoWenigerAlsBetragIstUberweisen() {
        Konto konto = new Konto("GB2384931H", 22.0);
        Konto konto2 = new Konto("GB2284531H", 50.0);
        double betrag = 25.0;
        assertThrows(IllegalArgumentException.class, () -> {
            konto.uberweisen(konto2,betrag);
        });

    }
    @Test
    public void testObBetragNegativIstUberweisen() {
        Konto konto = new Konto("GB2384931H", 22.0);
        Konto konto2 = new Konto("GB2284531H", 50.0);
        double betrag = -5.0;
        assertThrows(IllegalArgumentException.class, () -> {
            konto.uberweisen(konto2,betrag);
        });
    }

    @Test
    public void testObUberweisengkontoNullIst() {
        Konto konto = new Konto("GB2384931H", 22.0);
        double betrag = 5.0;
        assertThrows(IllegalArgumentException.class, () -> {
            konto.uberweisen(null,betrag);
        });
    }
    @Test
    public void testGetKontoNummer() {
        Konto konto = new Konto("GB2384931H", 52.0);
        assertEquals("GB2384931H", konto.getKontoNummer());
    }

    @Test
    public void testGetSaldo() {
        Konto konto = new Konto("GB2384931H", 29.0);
        assertEquals(29.0, konto.getSaldo(), 0.001);
    }
}



