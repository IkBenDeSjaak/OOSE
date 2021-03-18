package han.oose.ooad;

import java.util.ArrayList;

public class EenRij implements ISpelbordVorm{
    private ArrayList<Vakje> vakjes = new ArrayList<Vakje>();

    public EenRij() {
        for (int i = 0; i < AANTALVAKJES; i++) {
            vakjes.add(new Vakje(i));
        }
    }

    @Override
    public Vakje getVakje(int i) {
        return vakjes.get(i);
    }
}
