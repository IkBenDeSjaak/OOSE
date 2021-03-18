package han.oose.ooad;

import han.oose.ooad.vervoermiddelen.Auto;
import han.oose.ooad.vervoermiddelen.Fiets;
import han.oose.ooad.vervoermiddelen.Scooter;
import han.oose.ooad.vervoermiddelen.Step;

public class VervoermiddelFactory {

    public IVervoermiddel maakVervoermiddel(String voertuigType) {
        switch (voertuigType) {
            case "Auto":
                return new Auto();

            case "Fiets":
                return new Fiets();

            case "Scooter":
                return new Scooter();

            case "Step":
                return new Step();

            default:
                return null;
        }
    }
}
