package Mankala.sogyo;

public class Mankala {
    private Boolean spelGaatDoor = true;
    private Speler spelerEen = new Speler();
    private Speler spelerTwee = new Speler();
    SpeelBord nieuw = new SpeelBord(spelerEen, spelerTwee);
    private Speler beurtSpeler = spelerEen;

    public void startSpel() {
        while (spelGaatDoor) {
            if (beurtSpeler.equals(spelerEen)) {
                spelerEenDoetZet();
            }
            if (beurtSpeler.equals(spelerTwee)) {
                spelerTweeDoetZet();
            }
        }
    }

    private void spelerEenDoetZet() {
        printBord();
        System.out.println("Speler Een is aan de beurt");
        spelerEen.doetZet();
        if (isLegaleZetSpelerEen()) {
            nieuw.haalKleinVak(spelerEen, spelerEen.vakje).zet(spelerEen);
            if (!nieuw.haalKalaha(spelerEen).eindeZet) {
                if (kleineVakkenSpelerTweeLeeg()) {
                    spelGaatDoor = false;
                    System.out.println("het spel is voorbij. De stenen worden geteld!");
                    berekenWinnaar();
                } else {
                    wisselBeurt();
                }
            }
            nieuw.haalKalaha(spelerEen).eindeZet = false;
        } else {
            System.out.println("kies een ander vakje, dit vakje bestaat niet of is leeg");
            startSpel();
        }
    }

    private void spelerTweeDoetZet() {
        printBord();
        System.out.println("Speler Twee is aan de beurt");
        spelerTwee.doetZet();
        if (isLegaleZetSpelerTwee()) {
            nieuw.haalKleinVak(spelerTwee, spelerTwee.vakje).zet(spelerTwee);
            if (!nieuw.haalKalaha(spelerTwee).eindeZet) {
                if (kleineVakkenSpelerEenLeeg()) {
                    spelGaatDoor = false;
                    System.out.println("het spel is voorbij. De stenen worden geteld!");
                    berekenWinnaar();
                } else {
                    wisselBeurt();
                }
            }
            nieuw.haalKalaha(spelerTwee).eindeZet = false;
        } else {
            System.out.println("kies een ander vakje");
            startSpel();
        }
    }

    private String printBordRijEen() {
        return "\t"  + nieuw.haalKleinVak(spelerTwee,6).aantalStenen() + "\t" +
            nieuw.haalKleinVak(spelerTwee,5).aantalStenen() + "\t" +
            nieuw.haalKleinVak(spelerTwee,4).aantalStenen() + "\t" +
            nieuw.haalKleinVak(spelerTwee,3).aantalStenen() + "\t" +
            nieuw.haalKleinVak(spelerTwee,2).aantalStenen() + "\t" +
            nieuw.haalKleinVak(spelerTwee,1).aantalStenen();
    }

    private String printBordRijTwee() {
        return nieuw.haalKalaha(spelerTwee).aantalStenen() + "\t\t\t\t\t\t\t" +
            nieuw.haalKalaha(spelerEen).aantalStenen();
    }

    private String printBordRijDrie() {
        return "\t" + nieuw.haalKleinVak(spelerEen,1).aantalStenen() + "\t" +
            nieuw.haalKleinVak(spelerEen,2).aantalStenen() + "\t" +
            nieuw.haalKleinVak(spelerEen,3).aantalStenen() + "\t" +
            nieuw.haalKleinVak(spelerEen,4).aantalStenen() + "\t" +
            nieuw.haalKleinVak(spelerEen,5).aantalStenen() + "\t" +
            nieuw.haalKleinVak(spelerEen,6).aantalStenen();
    }

    private void printBord() {
        System.out.println(printBordRijEen());
        System.out.println(printBordRijTwee());
        System.out.println(printBordRijDrie());
    }

    private boolean isLegaleZetSpelerEen() {
        return (0 < spelerEen.vakje && spelerEen.vakje < 7 &&
                nieuw.haalKleinVak(spelerEen, spelerEen.vakje).aantalStenen() > 0);
    }

    private boolean isLegaleZetSpelerTwee() {
        return (0 < spelerTwee.vakje && spelerTwee.vakje < 7 &&
                nieuw.haalKleinVak(spelerTwee, spelerTwee.vakje).aantalStenen() > 0);
    }

    private boolean kleineVakkenSpelerEenLeeg() {
        int scoreKleinVakkenSpelerEen = nieuw.haalKleinVak(spelerEen,1).aantalStenen() +
                nieuw.haalKleinVak(spelerEen,2).aantalStenen() +
                nieuw.haalKleinVak(spelerEen,3).aantalStenen() +
                nieuw.haalKleinVak(spelerEen,4).aantalStenen() +
                nieuw.haalKleinVak(spelerEen,5).aantalStenen() +
                nieuw.haalKleinVak(spelerEen,6).aantalStenen();
        return (scoreKleinVakkenSpelerEen == 0);
    }

    private boolean kleineVakkenSpelerTweeLeeg() {
        int scoreKleinVakkenSpelerTwee = nieuw.haalKleinVak(spelerTwee,1).aantalStenen() +
            nieuw.haalKleinVak(spelerTwee,2).aantalStenen() +
            nieuw.haalKleinVak(spelerTwee,3).aantalStenen() +
            nieuw.haalKleinVak(spelerTwee,4).aantalStenen() +
            nieuw.haalKleinVak(spelerTwee,5).aantalStenen() +
            nieuw.haalKleinVak(spelerTwee,6).aantalStenen();
       return (scoreKleinVakkenSpelerTwee == 0);
    }

    private void wisselBeurt() {
        if(beurtSpeler.equals(spelerEen))
            beurtSpeler = spelerTwee;
        else
            beurtSpeler = spelerEen;
    }

    private int scoreSpelerEen() {
        return nieuw.haalKleinVak(spelerEen,1).aantalStenen() +
            nieuw.haalKleinVak(spelerEen,2).aantalStenen() +
            nieuw.haalKleinVak(spelerEen,3).aantalStenen() +
            nieuw.haalKleinVak(spelerEen,4).aantalStenen() +
            nieuw.haalKleinVak(spelerEen,5).aantalStenen() +
            nieuw.haalKleinVak(spelerEen,6).aantalStenen() +
            nieuw.haalKalaha(spelerEen).aantalStenen();
    }

    private int scoreSpelerTwee() {
        return nieuw.haalKleinVak(spelerTwee,1).aantalStenen() +
            nieuw.haalKleinVak(spelerTwee,2).aantalStenen() +
            nieuw.haalKleinVak(spelerTwee,3).aantalStenen() +
            nieuw.haalKleinVak(spelerTwee,4).aantalStenen() +
            nieuw.haalKleinVak(spelerTwee,5).aantalStenen() +
            nieuw.haalKleinVak(spelerTwee,6).aantalStenen() +
            nieuw.haalKalaha(spelerTwee).aantalStenen();
    }

    private void berekenWinnaar() {
        System.out.println("Score van speler B " + scoreSpelerEen() + " Score van speler B " + scoreSpelerTwee());

        if (scoreSpelerEen() > scoreSpelerTwee()) {
            System.out.println("Speler A heeft gewonnen!");
        } else if (scoreSpelerTwee() > scoreSpelerEen()) {
            System.out.println("Speler B heeft gewonnen!");
        } else {
            System.out.println("Het is een gelijkspel!");
        }
    }

}
