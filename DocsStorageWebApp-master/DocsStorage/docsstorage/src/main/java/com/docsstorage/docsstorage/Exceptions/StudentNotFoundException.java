package com.docsstorage.docsstorage.Exceptions;

public class ClientNotFoundException extends RuntimeException{
    public StudentNotFoundException(Integer id){
        super("Couldn't find client with id: " + id);
    }
}
