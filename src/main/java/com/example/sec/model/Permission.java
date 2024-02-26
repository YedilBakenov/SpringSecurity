package com.example.sec.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "PERMISSION")
@Getter
@Setter
public class Permission implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name ="NAME")
    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
