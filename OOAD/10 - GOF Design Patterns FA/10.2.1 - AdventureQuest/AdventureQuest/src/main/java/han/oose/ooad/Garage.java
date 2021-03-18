package han.oose.ooad;

import java.util.ArrayList;

public class Garage {
    private ArrayList<IVervoermiddel> vervoersmiddelen = new ArrayList<IVervoermiddel>();
    private VervoermiddelFactory vervoermiddelFactory = new VervoermiddelFactory();

    public Garage() {
        vervoersmiddelen.add(maakVervoermiddel("Auto"));
        vervoersmiddelen.add(maakVervoermiddel("Fiets"));
        vervoersmiddelen.add(maakVervoermiddel("Scooter"));
        vervoersmiddelen.add(maakVervoermiddel("Step"));
    }

    public IVervoermiddel maakVervoermiddel(String type) {
        return vervoermiddelFactory.maakVervoermiddel(type);
    }

    public IVervoermiddel kiesVervoermiddel() {
        return vervoersmiddelen.get(1);
    }
}
