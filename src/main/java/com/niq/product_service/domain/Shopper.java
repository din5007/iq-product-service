package com.niq.product_service.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shopper")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shopper {

    @Id
    @SequenceGenerator(name = "shopper_id_seq", sequenceName = "shopper_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shopper_id_seq")
    private Long id;

    private String shopperId;

    private String shopperName;
}
