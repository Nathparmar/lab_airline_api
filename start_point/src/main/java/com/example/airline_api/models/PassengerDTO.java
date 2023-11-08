package com.example.airline_api.models;

import java.util.List;

public class PassengerDTO {


    private long id;

    public PassengerDTO(long id) {
        this.id = id;
    }

    public PassengerDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
