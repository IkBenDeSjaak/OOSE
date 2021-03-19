package han.oose.ooad;

public class KramersAdapter implements IDictionaryAdapter{

    KramersDictionary kramersDictionary = new KramersDictionary();

    public String translate(String word) {
        return kramersDictionary.find(word);
    }

    @Override
    public String getName() {
        return "Kramers";
    }
}
