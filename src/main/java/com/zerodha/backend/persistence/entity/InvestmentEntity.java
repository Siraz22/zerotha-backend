package com.zerodha.backend.persistence.entity;

import com.zerodha.backend.converter.InvestmentTypeConverter;
import com.zerodha.backend.enums.InvestmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "investment")
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
    BigDecimal quantity;

    @Column(name = "average_price")
    BigDecimal averagePrice;

    @ManyToOne
    @JoinColumn(name = "ref_user")
    UserEntity investmentHolder;

    @ManyToOne
    @JoinColumn(name = "ref_platform")
    PlatformEntity platform;

    @ManyToOne
    @JoinColumn(name = "ref_country")
    CountryEntity associatedCountry;

    //TODO - Read more about converters and discriminators!
    @Convert(converter = InvestmentTypeConverter.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "investment_type", insertable = false, updatable = false)
    InvestmentType investmentType;
}
