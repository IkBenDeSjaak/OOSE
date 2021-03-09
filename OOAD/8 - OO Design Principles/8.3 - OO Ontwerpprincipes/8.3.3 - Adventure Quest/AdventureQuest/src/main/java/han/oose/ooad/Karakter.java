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

    public Karakter(String naamKarakter, Vakje vk, Vervoermiddel vm) {
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

    public void setVervoermiddel(Vervoermiddel vm) {
        vervoermiddel = vm;
        vm.setKarakter(this);
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