package com.epam.mjc.io;

public class MyOwnRuntimeException extends RuntimeException{
    public MyOwnRuntimeException(String message) {
        super(message);
    }
    public void foo(String bar) throws Throwable {  // Noncompliant
        throw new RuntimeException("My Message");     // Noncompliant
    }
}
