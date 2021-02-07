package com.example.addressbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Person {

    private final UUID id;
    //consider adding the @NotBlank annotation later
    private final String name;
    private final String phone;
    private final String address;


    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("phone") String phone,
                  @JsonProperty("address") String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}