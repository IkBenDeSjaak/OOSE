package han.oose.ooad;


public class Karakter {
    private String naam;
    private int energie = 1000;
    private Vakje vakje;
    private IVervoermiddel vervoermiddel;

    public Karakter(String naam) {
        this.naam = naam;
    }

    public Karakter(String naamKarakter, Vakje vk, IVervoermiddel vm) {
        this.naam = naamKarakter;
        setVakje(vk);
        setVervoermiddel(vm);
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

    public void setVervoermiddel(IVervoermiddel vm) {
        vervoermiddel = vm;
    }

    public void verminderEnergie(int amount) {
        energie -= amount;
        System.out.println(energie);
    }

    public void wisselVakjeMet(Karakter ander) {
        Vakje vakjeAnder = ander.getVakje();
        Vakje huidigVakje = getVakje();

        setVakje(vakjeAnder);
        verminderEnergie(20);
        ander.setVakje(huidigVakje);
    }
}