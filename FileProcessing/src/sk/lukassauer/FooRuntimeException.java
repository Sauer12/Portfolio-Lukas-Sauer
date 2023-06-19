package sk.lukassauer;

// Vlastna exception
public class FooRuntimeException extends Exception{
    public FooRuntimeException(String message){
        super(message);
    }
}
