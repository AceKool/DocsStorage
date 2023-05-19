package com.docsstorage.docsstorage.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="objects")
@Data
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "capacity")
    private Float capacity;
    @Column(name = "filepath")
    private String filepath;


    public void updateObject(Object object) {
        if (object.name != null)        { this.name = object.name; }

        if (object.description != null) { this.description = object.description; }

        if (object.capacity != null)    { this.capacity = object.capacity; }

        if (object.filepath != null)    { this.filepath = object.filepath; }

        if(object.order != null)        { this.order = object.order; }

    }

    // Connection with DEALS table
    @ManyToOne
    @JoinColumn(name= "deal_id")
    private Order order;

}
