package com.example.midas_task.controller;

import java.io.Serializable;

public class GenericResponseREST implements Serializable {
    public String message;

    public GenericResponseREST() {
    }

    public GenericResponseREST(String message) {
        this.message = message;
    }
}