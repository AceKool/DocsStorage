package com.docsstorage.docsstorage.Exceptions;

public class DealNotFoundException extends RuntimeException{
    public DealNotFoundException(Integer id){
        super("Couldn't find deal with id: " + id);
    }
}