package modell;

import java.util.ArrayList;
import java.util.List;

public final class Epulet {

    private List dolgozo = new ArrayList<Dolgozo>();
    private List latogato = new ArrayList<Latogato>();

    public Epulet() throws SajatException {
        Ember d0 = new Dolgozo();
        Ember l0 = new Latogato();
        Ember d1 = new Dolgozo(12, "józsef", Ember.oltozetKategoria.megfelelo);
        Ember d2 = new Dolgozo(2, "sándor");
        Ember d3 = new Dolgozo(5, "Anna");
        Ember l1 = new Latogato("Zöld", "Béla");
        Ember l2 = new Latogato("Fehér", "Gaspar", Ember.oltozetKategoria.szakadt);
        Ember l3 = new Latogato("Piros", "Irénke");
        addDolgozo(d0);
        addDolgozo(d1);
        addDolgozo(d2);
        addDolgozo(d3);
        addLatogato(l0);
        addLatogato(l1);
        addLatogato(l2);
        addLatogato(l3);
    }

    public List getDolgozo() {
        return dolgozo;
    }

    public List getLatogato() {
        return latogato;
    }

    public void addDolgozo(Ember dolgozo) {
        this.dolgozo.add(dolgozo);
    }

    public void addLatogato(Ember latogato) {
        this.latogato.add(latogato);
    }

}
