package Mankala.sogyo;

class KleinVak extends Vak {
    private int plaats;

    public KleinVak(Speler hoortBij,int plaats) {
        super(hoortBij);
        this.plaats = plaats;
        setAantalStenen(4);
    }

    public int getPlaats() {
        return plaats;
    }







}
