package han.oose.ooad;


public class Karakter {
    private String naam;
    private int energie = 1000;
    private Vakje vakje;
    private Vervoermiddel vervoermiddel;

    public Karakter(String naam) {
        this.naam = naam;
        vervoermiddel = new Vervoermiddel();
    }

    public int getEnergie() {
        return energie;
    }

    public Vakje getVakje () {
        return vakje;
    }

    public String getNaam () {
        return naam;
    }

    public void setVakje(Vakje v) {
        vakje = v;
        v.setKarakter(this);
    }

    public void verminderEnergie(int amount) {
        energie -= amount;
        System.out.println(energie);
    }
}