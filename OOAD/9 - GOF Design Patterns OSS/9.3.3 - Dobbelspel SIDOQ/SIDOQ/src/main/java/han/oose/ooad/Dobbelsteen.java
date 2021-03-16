package han.oose.ooad;

import java.util.Random;

public class Dobbelsteen {
    private int aantalOgen;
    private Random rand = new Random();
    private IDobbelsteenState dobbelsteenState = new Enkel();

    public int werp() {
        System.out.println("State: " + dobbelsteenState);
        aantalOgen = rand.nextInt(6) + 1;
        System.out.println("Geworpen ogen " + aantalOgen);
        return dobbelsteenState.handle(this);
    }

    public int getAantalOgen() {
        return aantalOgen;
    }

    public void setDobbelsteenState(IDobbelsteenState dobbelsteenState) {
        this.dobbelsteenState = dobbelsteenState;
    }
}
