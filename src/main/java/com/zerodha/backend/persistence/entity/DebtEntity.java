package com.zerodha.backend.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "debt")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DebtEntity extends InvestmentEntity {
    @Column(name = "name")
    String name;

    @Column(name = "assured_interest")
    BigDecimal assuredInterest;
}
