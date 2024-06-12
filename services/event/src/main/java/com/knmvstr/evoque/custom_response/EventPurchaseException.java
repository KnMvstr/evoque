package com.knmvstr.evoque.custom_response;

public class EventPurchaseException extends RuntimeException{
    public EventPurchaseException(String message){
        super(message);
    }
}