package han.oose.ooad;

public class Vakje {
    private Karakter karakter;
    private int vaknr;

    public Vakje(int vaknr) {
        this.vaknr = vaknr;
    }

    public void setKarakter(Karakter karakter) {
        this.karakter = karakter;
    }

    public Karakter getKarakter() {
        return karakter;
    }
}
