package Mankala.sogyo;

public class SpeelBord {
    private Speler spelerEen;
    private Speler spelerTwee;
    private Speler beurtSpeler;
    private Kalaha spelerEenKalaha;
    private Kalaha spelerTweeKalaha;
    private KleinVak[] spelerEenKleinVakken;
    private KleinVak[] spelerTweeKleinVakken;
    public static final int aantalVakken = 6;

    // het bord bestaat uit de objecten Kalaha en KleinVak en heeft ook twee spelers.

    public SpeelBord(Speler spelerEen, Speler spelerTwee) {
        this.spelerEen = spelerEen;
        this.spelerTwee = spelerTwee;
        maakSpeelBord();
        startVolgende();
    }

    //aanmaken alle vakken, aantal vakken wordt bijgehouden in een array.

    private void maakSpeelBord(){
        spelerEenKalaha = new Kalaha(spelerEen);
        spelerEenKleinVakken = new KleinVak[aantalVakken];
        spelerTweeKalaha = new Kalaha(spelerTwee);
        spelerTweeKleinVakken = new KleinVak[aantalVakken];

        for(int i = 0; i < aantalVakken; i++){
            spelerEenKleinVakken[i] = new KleinVak(spelerEen,i);
            spelerTweeKleinVakken[i] = new KleinVak(spelerTwee, i);
        }
    }

    // alle opvolgende vakjes, kalaha apart opgegeven. ook gelijk de overkant.

    private void startVolgende(){
        for(int i = 0; i < (aantalVakken - 1); i++){
            spelerEenKleinVakken[i].zoekVolgende(spelerEenKleinVakken[i + 1]);
            spelerTweeKleinVakken[i].zoekVolgende(spelerTweeKleinVakken[i + 1]);
        }

        spelerEenKleinVakken[aantalVakken - 1].zoekVolgende(spelerEenKalaha);
        spelerTweeKleinVakken[aantalVakken - 1].zoekVolgende(spelerTweeKalaha);

        spelerEenKalaha.zoekVolgende(spelerTweeKleinVakken[0]);
        spelerTweeKalaha.zoekVolgende(spelerEenKleinVakken[0]);

        for (int i = 0; i <= (aantalVakken - 1); i++) {
            spelerEenKleinVakken[i].zoekOverkant(spelerTweeKleinVakken[5 - i]);
            spelerTweeKleinVakken[i].zoekOverkant(spelerEenKleinVakken[5 - i]);
        }

        for (int i = 0; i <= (aantalVakken - 1); i++) {
            spelerEenKleinVakken[i].zoekKalaha(spelerEenKalaha);
            spelerTweeKleinVakken[i].zoekKalaha(spelerTweeKalaha);
        }

    }

    // om de vakjes per speler te kunnen aanwijzen en berekenen.

    public KleinVak haalKleinVak(Speler speler, int KleinVak) {
        if (speler.equals(spelerEen)) {
            return spelerEenKleinVakken[KleinVak -1];
        } else if (speler.equals(spelerTwee)) {
            return spelerTweeKleinVakken[KleinVak -1];
        } else {
            return null;
        }
    }

    // om de kalaha van de speler te kunnen aanwijzen en berekenen.

    public Kalaha haalKalaha(Speler speler) {
        if (speler.equals(spelerEen)) {
            return spelerEenKalaha;
        } else if (speler.equals(spelerTwee)) {
            return spelerTweeKalaha;
        } else {
            return null;
        }
    }


}
