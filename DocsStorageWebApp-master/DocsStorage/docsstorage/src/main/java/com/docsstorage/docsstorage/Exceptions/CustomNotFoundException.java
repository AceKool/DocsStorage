package com.docsstorage.docsstorage.Exceptions;

import org.springframework.http.HttpStatus;

// Избегаем ошибки вывода статуса и сообщения в контроллерах путем создания своего исключения
public class CustomNotFoundException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public CustomNotFoundException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus(){
        return status;
    }

    public String getMessage() {
        return message;
    }

}
