package modell;

public class Latogato extends Ember {

    private String szin;

    public Latogato() {
        this("fehér");
    }

    public Latogato(String szin) {
        this(szin, "sanya");
    }

    public Latogato(String szin, String nev) {
        this(szin, nev, oltozetKategoria.megfelelo);
    }

    public Latogato(String szin, String nev, oltozetKategoria oltozet) {
        super(nev, oltozet);
        this.szin = szin;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + "Latogato{" + "szin=" + szin + '}';
    }

}
