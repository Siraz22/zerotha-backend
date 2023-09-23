package com.zerodha.backend.persistence.entity;

import com.zerodha.backend.enums.InvestmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "investment_entity")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorColumn(name = "investment_type", discriminatorType = DiscriminatorType.STRING)
public abstract class InvestmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "average_price")
    BigDecimal averagePrice;

    @ManyToOne
    @JoinColumn(name = "ref_user")
    UserEntity investmentHolder;

    @OneToOne
    @JoinColumn(name = "ref_platform")
    PlatformEntity platform;

    @OneToOne
    @JoinColumn(name = "ref_country")
    CountryEntity associatedCountry;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "investment_type", insertable = false, updatable = false)
    InvestmentType investmentType;
}
