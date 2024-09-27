package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CUSTOMER")
@SequenceGenerator(name = CustomerBE.ID_GENERATOR, sequenceName = CustomerBE.SEQUENCE_NAME, allocationSize = 1)
public class CustomerBE {

    public static final String ID_GENERATOR = "SEQ_CUSTOMER";
    public static final String SEQUENCE_NAME = "CUSTOMER_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CustomerBE.ID_GENERATOR)
    @Getter
    private Long id;


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

}
