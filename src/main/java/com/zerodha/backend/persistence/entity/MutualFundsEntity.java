package com.zerodha.backend.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mutual_funds")
public class MutualFundsEntity extends InvestmentEntity {
    @Column(name = "name")
    String name;

    @Column(name = "issuer")
    String issuer;
}
