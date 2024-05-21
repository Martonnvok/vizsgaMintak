package modell;

import java.util.UUID;

public class Dolgozo extends Ember implements Comparable<Dolgozo> {

    private UUID id;
    private int hatralevoEv;

    public Dolgozo() {
        this(10);
    }

    public Dolgozo(int hatralevoEv) {
        this(hatralevoEv, "sanya");
    }

    public Dolgozo(int hatralevoEv, String nev) {
        this(hatralevoEv, nev, oltozetKategoria.megfelelo);
    }

    public Dolgozo(int hatralevoEv, String nev, oltozetKategoria oltozet) {
        super(nev, oltozet);
        setId();
        this.hatralevoEv = hatralevoEv;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public void setHatralevoEv(int hatralevoEv) {
        this.hatralevoEv = hatralevoEv;
    }

    public UUID getId() {
        return id;
    }

    public int getHatralevoEv() {
        return hatralevoEv;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s + "Dolgozo{" + "id=" + id + ", hatralevoEv=" + hatralevoEv + '}';
    }

    @Override
    public int compareTo(Dolgozo o) {
        return this.hatralevoEv - o.hatralevoEv;
    }

}
