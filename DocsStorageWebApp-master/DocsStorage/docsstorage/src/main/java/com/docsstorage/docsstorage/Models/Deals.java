package com.docsstorage.docsstorage.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name= "deals")
@Data
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date_of_deal")
    private Date date_of_deal;
    @Column(name = "status")
    private Boolean status;


    public void updateDeal(Deal deal){
        if(deal.date_of_deal != null) { this.date_of_deal = deal.date_of_deal; }

        if(deal.status != null)        { this.status = deal.status; }

        if(deal.student != null)        {this.student = deal.student; }

        if(deal.objects != null)       {this.objects = deal.objects; }
    }

    // Connection with OBJECT table
    @JsonIgnore
    @OneToMany(mappedBy = "deal")
    private List<Object> objects;

    // Connection with STUDENT table
    @ManyToOne
    @JoinColumn(name = "students_id_fk", referencedColumnName = "id")
    private Client student;



}