package modell;

import java.io.Serializable;
import java.util.Objects;

public class Ember implements Serializable {

    private String nev;

    public enum oltozetKategoria {
        elegans, sportos, megfelelo, szakadt
    };
    public oltozetKategoria oltozet;

    public Ember() {
        this("no-name");
    }

    public Ember(String nev) {
        this(nev, oltozetKategoria.megfelelo);
    }

    public Ember(String nev, oltozetKategoria oltozet) {
        nevEllenorzes(nev);
        this.oltozet = oltozet;
    }

    public void nevEllenorzes(String nev) throws SajatException {
        if (nev.length() <= 3) {
            throw new SajatException("nev.length() <= 3");
        }
        if (Character.isLowerCase(nev.charAt(0))) {
            this.nev = Character.toUpperCase(nev.charAt(0)) + nev.substring(1);
        } else {
            this.nev = nev;
        }

    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getNev() {
        return nev;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.nev);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ember other = (Ember) obj;
        return Objects.equals(this.nev, other.nev);
    }

    @Override
    public String toString() {
        return "Ember{" + "nev=" + nev + ", oltozet=" + oltozet + '}';
    }

}
