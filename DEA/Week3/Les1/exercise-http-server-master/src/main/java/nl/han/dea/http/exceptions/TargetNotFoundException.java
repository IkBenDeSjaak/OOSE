package nl.han.dea.http.exceptions;

public class TargetNotFoundException extends Exception {
    public TargetNotFoundException(String fileName) {
        super("Can not find " + fileName);
    }
}
