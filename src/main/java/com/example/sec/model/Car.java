package com.example.sec.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Car extends BaseEntity{

    @Column(name = "MODEL")
    private String model;
}
