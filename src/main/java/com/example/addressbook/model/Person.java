package com.example.addressbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {
    @Id
    private final UUID id;
    //consider adding the @NotBlank annotation later
    @Column(name="name")
    private final String name;
    @Column(name="phone")
    private final String phone;
    @Column(name="address")
    private final String address;
    private int seq_id;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("phone") String phone,
                  @JsonProperty("address") String address,
                  @JsonProperty("seq_id") int seq_id) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.seq_id = seq_id;
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

    public int getSeq_id() {
        return seq_id;
    }
}