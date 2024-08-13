package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CUSTOMER")
public class Customer {

    public static final String ID_GENERATOR = "SEQ_CUSTOMER";
    public static final String SEQUENCE_NAME = "CUSTOMER_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Customer.ID_GENERATOR)
    public Long id;


    @Column(name = "EMAIL")
    @Getter
    @Setter
    private String email;

    @Column(name = "PASSWORD")
    @Getter
    @Setter
    private String password;

    @Column(name = "ROLE")
    @Getter
    @Setter
    private String role;

    @SequenceGenerator(name = Customer.ID_GENERATOR, sequenceName = Customer.SEQUENCE_NAME, allocationSize = 1)
    private Long getId(){
        return id;
    }
}
