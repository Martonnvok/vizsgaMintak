package modell;

import java.text.Collator;
import java.util.Comparator;

public class SzinComparator implements Comparator<Latogato> {

    @Override
    public int compare(Latogato o1, Latogato o2) {
        Collator collator = Collator.getInstance();
        return collator.compare(o1.getSzin(), o2.getSzin());
    }

}
