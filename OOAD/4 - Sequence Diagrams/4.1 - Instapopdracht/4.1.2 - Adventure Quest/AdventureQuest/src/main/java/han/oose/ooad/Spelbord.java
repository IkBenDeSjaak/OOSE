package han.oose.ooad;

import java.util.ArrayList;

public class Spelbord {
    private ArrayList<Vakje> vakjes = new ArrayList<Vakje>();

    public Spelbord() {
        for(int i = 0; i < 10; i++) {
            vakjes.add(new Vakje(i));
        }
    }
    public void plaatsOpVrijVakje(Karakter k) {
        Vakje v = kiesVrijVakje();
        k.setVakje(v);
    }
    private Vakje kiesVrijVakje() {
        ArrayList<Vakje> beschikbareVakjes = new ArrayList<Vakje>();
        for (Vakje vakje : vakjes) {
            if (vakje.getKarakter() != null) {
                beschikbareVakjes.add(vakje);
            }
        }
        return beschikbareVakjes.get(0);
    }

}
