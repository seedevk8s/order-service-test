package co.kr.ideacube.orderservicetest.exceptions;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String s) {
        super(s);
    }

    public OrderNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}

