package han.oose.ooad;

public class TranslateToDutch {

    DictionaryAdapterFactory dictionaryAdapterFactory = DictionaryAdapterFactory.getInstance();

    IDictionaryAdapter koenen = dictionaryAdapterFactory.getDictionaryAdapter("Koenen");
    IDictionaryAdapter kramers = dictionaryAdapterFactory.getDictionaryAdapter("Kramers");

    public String translate(String word) {

        if(koenen.translate(word) != null) {
            return koenen.translate(word);
        }

        if(kramers.translate(word) != null) {
            return kramers.translate(word);
        }

        return null;
    }
}
