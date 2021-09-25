package com.devsuperior.dsclients.services;

public class EntityNotFoundException extends RuntimeException{

    public  EntityNotFoundException(String msg){
        super(msg);
    }
}
