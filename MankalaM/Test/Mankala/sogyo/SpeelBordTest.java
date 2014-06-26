package Mankala.sogyo;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

public class SpeelBordTest extends TestCase {
    private Speler spelerEen;
    private Speler spelerTwee;
    private Kalaha spelerEenKalaha;
    private Kalaha spelerTweeKalaha;


    @Test
    public void testVakSteen() {
        spelerEenKalaha = new Kalaha(spelerEen);
        spelerTweeKalaha = new Kalaha(spelerTwee);
        Assert.assertEquals(spelerEenKalaha.aantalStenen(), spelerTweeKalaha.aantalStenen());
    }

    public void testVakSteenEen() {
        spelerEenKalaha = new Kalaha(spelerEen);
        spelerTweeKalaha = new Kalaha(spelerTwee);
        Assert.assertEquals(spelerEenKalaha.hoortBij(), spelerEen);
    }

    public void testBord() {
        Speler spelerEen = new Speler();
        Speler spelerTwee = new Speler();
        SpeelBord nieuw = new SpeelBord(spelerEen, spelerTwee);
        int result = nieuw.haalKleinVak(spelerEen,1).aantalStenen();
        int result2 = nieuw.haalKleinVak(spelerEen,2).aantalStenen();
        Assert.assertEquals(result, result2);
    }

    public void testBordTweeHelemaalRond() {
        Speler spelerEen = new Speler();
        Speler spelerTwee = new Speler();
        SpeelBord nieuw = new SpeelBord(spelerEen, spelerTwee);
        nieuw.haalKleinVak(spelerEen,5).setAantalStenen(15);
        nieuw.haalKleinVak(spelerEen,5).zet(spelerEen);
        Assert.assertEquals(1,nieuw.haalKleinVak(spelerEen,5).aantalStenen());
    }
}