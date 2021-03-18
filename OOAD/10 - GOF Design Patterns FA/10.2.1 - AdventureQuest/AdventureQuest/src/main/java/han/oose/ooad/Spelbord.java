package han.oose.ooad;

import java.util.ArrayList;
import java.util.Random;

public class Spelbord {
//    public static final int MAAT = 8;
//    private ArrayList<Vakje> vakjes = new ArrayList<Vakje>();


    private ISpelbordVorm vorm;

    public Spelbord() {
//        for (int i = 0; i < MAAT * MAAT; i++) {
//            vakjes.add(new Vakje(i));
//        }
        vorm = new EenRij();
    }

    public void plaatsOpVrijVakje(Karakter k) {
        Vakje v = kiesVrijVakje();
        k.setVakje(v);
    }

    public Karakter getKarakter(int vaknr) {
        Vakje vak = getVakje(vaknr);
        return vak.getKarakter();
    }

    public Vakje kiesVrijVakje() {
//        Random rand = new Random();
//        Vakje v;
//        do {
//            int vaknr = rand.nextInt(Spelbord.MAAT * Spelbord.MAAT);
//            v = vakjes.get(vaknr);
//        } while (!v.isLeeg());
//        return v;

        Random rand = new Random();
        Vakje v;
        do {
            int vaknr = rand.nextInt(ISpelbordVorm.AANTALVAKJES);
            v = vorm.getVakje(vaknr);
        } while (!v.isLeeg());
        return v;
    }

//    public Vakje getVakje(int i) {
//        return vakjes.get(i);
//    }

    public Vakje getVakje(int i) {
        return vorm.getVakje(i);
    }

    public void teleporteer(Karakter k, int vaknr) {
        Vakje v = k.getVakje();
        v.maakVakjeLeeg();

        k.setVakje(getVakje(vaknr));
        k.verminderEnergie(20);

//        vakjes.forEach(vakje -> System.out.println(vakje.getVaknr() + "" + vakje.isLeeg()));
    }

    public void wisselVakje(Karakter karakter1, int doelVak) {
        if (karakter1.getEnergie() > 20) {
            Vakje oudVakje = karakter1.getVakje();
            Vakje vervangendVakje = getVakje(doelVak);

            Karakter karakter2 = vervangendVakje.getKarakter();
            karakter1.setVakje(vervangendVakje);
            karakter1.verminderEnergie(20);
            karakter2.setVakje(oudVakje);

        }

//        vakjes.forEach(vakje -> {
//            System.out.println(vakje.getVaknr());
//            if (vakje.getKarakter() != null) {
//                System.out.println(vakje.getKarakter().getNaam());
//            }
//        });
    }
}
