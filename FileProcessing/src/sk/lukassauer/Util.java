package sk.lukassauer;

public class Util {

    public int number(int a) throws FooRuntimeException {
        if(a < 10){
            throw new FooRuntimeException("Number is smaller than 10");
        }
        return a;
    }
}
