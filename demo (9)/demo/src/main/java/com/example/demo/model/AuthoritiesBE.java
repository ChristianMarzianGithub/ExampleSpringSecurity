package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="AUTHORITIES")
@SequenceGenerator(name = CustomerBE.ID_GENERATOR, sequenceName = CustomerBE.SEQUENCE_NAME, allocationSize = 1)
public class AuthoritiesBE {
    public static final String ID_GENERATOR = "SEQ_AUTHORITIES";
    public static final String SEQUENCE_NAME = "AUTHORITIES_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CustomerBE.ID_GENERATOR)
    @Getter
    private Long ID;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerBE CUSTOMER_ID;

    @Getter
    @Setter
    private String NAME;
}