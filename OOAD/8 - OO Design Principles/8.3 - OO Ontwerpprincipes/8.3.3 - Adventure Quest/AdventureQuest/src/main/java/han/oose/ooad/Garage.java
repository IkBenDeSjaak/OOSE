package han.oose.ooad;

import java.util.ArrayList;

public class Garage {
    private ArrayList<Vervoermiddel> vervoersmiddelen = new ArrayList<Vervoermiddel>();

    public Garage() {
        for(int i = 0; i < 3; i++) {
            vervoersmiddelen.add(new Vervoermiddel());
        }
    }

    public Vervoermiddel kiesVervoermiddel() {
        return vervoersmiddelen.get(1);
    }
}
