package Mankala.sogyo;

public abstract class Vak {
    private int stenen;
    private Speler hoortBij;
    private Vak volgende;
    private Vak overkant;
    private Vak kalaha;
    boolean eindeZet = false;

    Vak(Speler hoortBij) {
        this.hoortBij = hoortBij;
    }

    Speler hoortBij() {
        return hoortBij;
    }

    void setAantalStenen(int aantal) {
        this.stenen = aantal;
    }

    int aantalStenen() {
        return stenen;
    }

    void zoekVolgende(Vak volgende) {
        this.volgende = volgende;
    }

    Vak getVolgende() {
        return volgende;
    }

    void zoekOverkant(Vak overkant) {
        this.overkant = overkant;
    }

    Vak getOverkant() {
        return overkant;
    }

    void zoekKalaha(Vak kalaha) {
        this.kalaha = kalaha;
    }

    Vak getKalaha() {
        return kalaha;
    }

    private void ontvang(int stenenGeefDoor, Speler aanDeBeurt) {
        if (stenenGeefDoor > 1) {
            steenInVakDoen(stenenGeefDoor,aanDeBeurt);
        } else {
            if (eindigInLeegKleinVak(aanDeBeurt)) {
                sla();
            } else if (eindigInKalaha(aanDeBeurt)) {
                geenBeurtWissel();
            } else if (overslaanKalahaTegenstander()) {
                getVolgende().scoren(stenenGeefDoor);
            } else {
                this.stenen= this.stenen + 1;
            }
        }
    }

    boolean eindeZet() {
        eindeZet = true;
        return eindeZet;
    }

    private void scoren(int stenenScore) {
        this.stenen = this.stenen + stenenScore;
    }

    private int maakLeeg() {
        int nieuw = stenen;
        setAantalStenen(0);
        return nieuw;
    }

    void zet(Speler aanDeBeurt) {
        int stenenGeefDoor = this.stenen;
        maakLeeg();
        getVolgende().ontvang(stenenGeefDoor,aanDeBeurt);
    }

    private void sla() {
        this.stenen = this.stenen + 1;
        getKalaha().scoren(this.stenen);
        this.maakLeeg();
        if (getOverkant().aantalStenen() > 0) {
            int stenenScore = getOverkant().aantalStenen();
            getKalaha().scoren(stenenScore);
            getOverkant().maakLeeg();
        }
    }

    private void steenInVakDoen(int stenenGeefDoor, Speler aanDeBeurt) {
        this.stenen = this.stenen + 1;
        stenenGeefDoor = stenenGeefDoor - 1;
        getVolgende().ontvang(stenenGeefDoor, aanDeBeurt);
    }

    private void geenBeurtWissel() {
        this.stenen = this.stenen + 1;
        System.out.println("De speler mag nog een keer!");
        eindeZet();
    }

    private boolean eindigInLeegKleinVak(Speler aanDeBeurt) {
        return this.stenen == 0 && this.hoortBij == aanDeBeurt && this.getClass() == KleinVak.class;
    }

    private boolean eindigInKalaha(Speler aanDeBeurt) {
        return this.hoortBij == aanDeBeurt && this.getClass() == Kalaha.class;
    }

    private boolean overslaanKalahaTegenstander() {
        return this.getClass() == Kalaha.class;
    }

}


