package Mankala.sogyo;

import junit.framework.Assert;
import junit.framework.TestCase;

public class VakTest extends TestCase {
    private Speler spelerEen = new Speler();
    private Speler spelerTwee = new Speler();

    public void testKleinVak() {
        KleinVak nieuw = new KleinVak(spelerEen, 1);
        KleinVak nieuw2 = new KleinVak(spelerTwee, 1);
        nieuw.setAantalStenen(4);
        nieuw2.setAantalStenen(4);
        Assert.assertEquals(4, nieuw.aantalStenen());
        Assert.assertEquals(4, nieuw2.aantalStenen());
    }

    public void testKalaha() {
        Kalaha vanEen = new Kalaha(spelerEen);
        Kalaha vanTwee = new Kalaha(spelerTwee);
        vanEen.setAantalStenen(3);
        vanTwee.setAantalStenen(0);
        Assert.assertEquals(3, vanEen.aantalStenen());
        Assert.assertEquals(0, vanTwee.aantalStenen());
    }

    public void testVakVolgendeLeegTwee() {
        KleinVak kv1 = new KleinVak(spelerEen, 1);
        KleinVak kv2 = new KleinVak(spelerEen, 2);
        KleinVak kv3 = new KleinVak(spelerEen, 3);
        kv1.zoekVolgende(kv2);
        kv2.zoekVolgende(kv3);
        Assert.assertEquals(kv1.getVolgende(),kv2);
        Assert.assertEquals(kv2.getVolgende(),kv3);
    }

    public void testVakVolgendeZet() {
        KleinVak kv1 = new KleinVak(spelerEen, 1);
        KleinVak kv2 = new KleinVak(spelerEen, 2);
        kv1.setAantalStenen(1);
        kv2.setAantalStenen(2);
        kv1.zoekVolgende(kv2);
        kv1.zet(spelerEen);
        Assert.assertEquals(0,kv1.aantalStenen());
        Assert.assertEquals(3,kv2.aantalStenen());
    }

    public void testKleinVakZetMeer() {
        KleinVak kv13 = new KleinVak(spelerEen, 2);
        KleinVak kv14 = new KleinVak(spelerEen, 3);
        KleinVak kv15 = new KleinVak(spelerEen, 4);
        kv13.zoekVolgende(kv14);
        kv14.zoekVolgende(kv15);
        kv13.setAantalStenen(2);
        kv14.setAantalStenen(3);
        kv15.setAantalStenen(3);
        kv13.zet(spelerEen);
        Assert.assertEquals(0,kv13.aantalStenen());
        Assert.assertEquals(4,kv14.aantalStenen());
        Assert.assertEquals(4,kv15.aantalStenen());
    }

    public void testKleinVakZetMeer2() {
        KleinVak kv3 = new KleinVak(spelerEen, 2);
        KleinVak kv4 = new KleinVak(spelerEen, 3);
        KleinVak kv5 = new KleinVak(spelerEen, 4);
        KleinVak kv6 = new KleinVak(spelerEen, 5);
        kv3.zoekVolgende(kv4);
        kv4.zoekVolgende(kv5);
        kv5.zoekVolgende(kv6);
        kv3.setAantalStenen(3);
        kv4.setAantalStenen(3);
        kv5.setAantalStenen(3);
        kv6.setAantalStenen(3);
        kv3.zet(spelerEen);
        Assert.assertEquals(0,kv3.aantalStenen());
        Assert.assertEquals(4,kv4.aantalStenen());
        Assert.assertEquals(4,kv5.aantalStenen());
        Assert.assertEquals(4,kv6.aantalStenen());
    }

    public void testVakVolgendeVullen() {
        KleinVak kv1 = new KleinVak(spelerEen, 1);
        KleinVak kv2 = new KleinVak(spelerEen, 2);
        kv1.setAantalStenen(1);
        kv1.zoekVolgende(kv2);
        kv1.zet(spelerEen);
        Assert.assertEquals(0,kv1.aantalStenen());
        Assert.assertEquals(5,kv2.aantalStenen());
    }

    public void testVakVolgendeSla() {
        KleinVak kv1 = new KleinVak(spelerEen,1);
        KleinVak kv2 = new KleinVak(spelerEen,2);
        KleinVak kv3 = new KleinVak(spelerTwee,1);
        Kalaha vanEen = new Kalaha(spelerEen);
        kv1.setAantalStenen(1);
        kv2.setAantalStenen(0);
        kv3.setAantalStenen(0);
        kv1.zoekVolgende(kv2);
        kv2.zoekVolgende(kv3);
        kv2.zoekKalaha(vanEen);
        kv2.zoekOverkant(kv3);
        kv1.zet(spelerEen);
        Assert.assertEquals(0,kv1.aantalStenen());
        Assert.assertEquals(0,kv2.aantalStenen());
        Assert.assertEquals(1,vanEen.aantalStenen());
    }

    public void testVakVolgendeSlanietLeeg() {
        KleinVak kv1 = new KleinVak(spelerEen,1);
        KleinVak kv2 = new KleinVak(spelerEen,2);
        KleinVak kv3 = new KleinVak(spelerTwee,1);
        Kalaha vanEen = new Kalaha(spelerEen);
        kv1.setAantalStenen(1);
        kv2.setAantalStenen(0);
        kv1.zoekVolgende(kv2);
        kv2.zoekKalaha(vanEen);
        kv2.zoekOverkant(kv3);
        kv3.zoekKalaha(vanEen);
        kv1.zet(spelerEen);
        Assert.assertEquals(0,kv1.aantalStenen());
        Assert.assertEquals(0,kv2.aantalStenen());
        Assert.assertEquals(5,vanEen.aantalStenen());
    }

    public void testVakEindigOverkantLeeg() {
        KleinVak kv1 = new KleinVak(spelerEen,1);
        KleinVak kv2 = new KleinVak(spelerEen,2);
        KleinVak kv3 = new KleinVak(spelerTwee,1);
        Kalaha vanEen = new Kalaha(spelerEen);
        kv1.setAantalStenen(3);
        kv2.setAantalStenen(0);
        kv3.setAantalStenen(0);
        kv1.zoekVolgende(kv2);
        kv2.zoekVolgende(vanEen);
        vanEen.zoekVolgende(kv3);
        kv2.zoekKalaha(vanEen);
        kv2.zoekOverkant(kv3);
        kv3.zoekKalaha(vanEen);
        kv1.zet(spelerEen);
        Assert.assertEquals(0,kv1.aantalStenen());
        Assert.assertEquals(1,kv2.aantalStenen());
        Assert.assertEquals(1,vanEen.aantalStenen());
        Assert.assertEquals(1,kv3.aantalStenen());
    }

}