package com.example.sec.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ITEMS")
@Data
public class Item extends BaseEntity{

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "POINT")
    private int point;

    @Column(name = "MARK")
    private String mark;
}
