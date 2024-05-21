package modell;

import java.text.Collator;
import java.util.Comparator;

public class NevComparator implements Comparator<Dolgozo> {

    @Override
    public int compare(Dolgozo o1, Dolgozo o2) {
        Collator collator = Collator.getInstance();
        return collator.compare(o1.getNev(), o2.getNev());
    }

}
