package com.phonebook.controller;

/**
 * Created by PunKHS on 06.08.2016.
 */
public class Message {
    private String type;
    private String message;

    public Message(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}