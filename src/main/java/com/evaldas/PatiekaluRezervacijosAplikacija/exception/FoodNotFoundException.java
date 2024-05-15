package com.evaldas.PatiekaluRezervacijosAplikacija.exception;

public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(Long id){
        super("Could not food the user with id "+ id);
    }
}
