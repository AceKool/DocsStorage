package com.docsstorage.docsstorage.Exceptions;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(Integer id){
        super("Couldn't find object with id: " + id);
    }
}
