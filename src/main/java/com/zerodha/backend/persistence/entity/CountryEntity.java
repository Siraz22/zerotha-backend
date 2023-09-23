package com.zerodha.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "currency")
    String currency;

    @OneToOne(mappedBy = "associatedCountry", cascade = CascadeType.ALL, orphanRemoval = false)
    InvestmentEntity investment;
}
