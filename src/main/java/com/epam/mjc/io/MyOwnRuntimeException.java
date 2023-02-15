package com.epam.mjc.io;

import java.io.FileNotFoundException;

public class MyOwnRuntimeException extends RuntimeException{
    public MyOwnRuntimeException(String message) {
        super(message);
    }
}
