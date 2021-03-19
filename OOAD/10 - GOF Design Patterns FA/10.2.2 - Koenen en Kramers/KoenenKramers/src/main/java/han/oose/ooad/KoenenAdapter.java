package han.oose.ooad;

public class KoenenAdapter implements IDictionaryAdapter {
    KoenenDictionary koenenDictionary = new KoenenDictionary();

    public String translate(String word) {
        return koenenDictionary.lookUp(word);
    }

    @Override
    public String getName() {
        return "Koenen";
    }
}
