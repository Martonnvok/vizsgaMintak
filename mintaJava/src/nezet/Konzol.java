package nezet;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Dolgozo;
import modell.Ember;
import modell.Epulet;
import modell.Latogato;
import modell.NevComparator;
import modell.SajatException;
import modell.SzinComparator;

public class Konzol {

    private Epulet e = new Epulet();

    public Konzol() throws SajatException {
        feladatok();
    }

    private void feladatok() {
        epuletbenLevoEmberekKonzolon(e.getLatogato());
        epuletbenLevoEmberekKonzolon(e.getDolgozo());
        epuletbenLevoEmberekFajlban();
        dolgozokNevsorban();
        dolgozokNyugdijig();
        latogatokTeruletekSzerint();
    }

    private static <T> void epuletbenLevoEmberekKonzolon(List tomb) {
        for (Object elem : tomb) {
            System.out.println(elem);
        }
    }

    private void epuletbenLevoEmberekFajlban() {
        try {
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(new FileOutputStream("emberek.dat"));
            oos.writeObject(e.getDolgozo());
            oos.writeObject(e.getLatogato());
            oos.close();

        } catch (SajatException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Konzol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Konzol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dolgozokNevsorban() {
        System.out.println("\nDolgozok sorban");
        e.getDolgozo().sort(new NevComparator());
        epuletbenLevoEmberekKonzolon(e.getDolgozo());
    }

    private void dolgozokNyugdijig() {
        System.out.println("\nDolgozok Nyugdij szerint");
        Collections.sort(e.getDolgozo());
        epuletbenLevoEmberekKonzolon(e.getDolgozo());
    }

    private void latogatokTeruletekSzerint() {
        System.out.println("\nLatogatok terulet szerint");
        e.getLatogato().sort(new SzinComparator());
        for (Object l : e.getLatogato()) {
            System.out.println(l);
        }
        epuletbenLevoEmberekKonzolon(e.getLatogato());
    }

}
