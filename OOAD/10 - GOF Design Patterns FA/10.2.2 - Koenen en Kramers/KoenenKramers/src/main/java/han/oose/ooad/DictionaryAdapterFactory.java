package han.oose.ooad;

public class DictionaryAdapterFactory {

    private static DictionaryAdapterFactory instance;

    private DictionaryAdapterFactory() {

    }

    public static DictionaryAdapterFactory getInstance() {
        if (instance == null) {
            instance = new DictionaryAdapterFactory();
        }

        return instance;
    }

    public IDictionaryAdapter getDictionaryAdapter(String adapterName) {
        switch (adapterName) {
            case "Koenen":
                return new KoenenAdapter();
            case "Kramers":
                return new KramersAdapter();
            default:
                return null;
        }
    }
}
