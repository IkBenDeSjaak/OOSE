```Java
public class Directory {
    Files[] files;
    IZipAdapter zipAdapter = new Zip4UAdapter();

    public void createArchive(){
        zipAdapter.createArchive(files);
    }
}

public class Zip4UAdapter implements IZipAdapter {
    Zip4U zip4u = new Zip4U();

    public void createArchive(List<File> files) {
        zip4u.zipFiles(files);
    }
}
```
