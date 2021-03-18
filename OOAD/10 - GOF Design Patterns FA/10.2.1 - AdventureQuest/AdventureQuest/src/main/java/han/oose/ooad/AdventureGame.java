package han.oose.ooad;

public class AdventureGame {
    public static void main (String[] args) {
        Spel spel = new Spel();
        spel.meldAan("Bob");
        spel.meldAan("Kim");

        spel.meldAan("naamKarakter");

        System.out.println(spel.getKarakter("Bob").getVakje().getVaknr());
        System.out.println(spel.getKarakter("naamKarakter").getVakje().getVaknr());


//        spel.teleporteer("naamkarakter", 30);
        spel.wisselVakje("naamKarakter", spel.getKarakter("Bob").getVakje().getVaknr());

        System.out.println(spel.getKarakter("Bob").getVakje().getVaknr());
        System.out.println(spel.getKarakter("naamKarakter").getVakje().getVaknr());

    }
}
