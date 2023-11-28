package com.zerodha.backend.persistence.entity;

import java.util.List;

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

    @Column(name = "currency_name")
    String currencyName;

    @Column(name = "currency_symbol")
    String currencySymbol;

    /**
     * Don't remove the investments if country is removed,
     * instead keep the investments, so user can update a country for them.
     * For time being, we keep the country to null, and set it to Unknown in frontend
     */
    @OneToMany(mappedBy = "associatedCountry", cascade = CascadeType.ALL, orphanRemoval = false)
    List<InvestmentEntity> investmentEntities;
}
