package com.zerodha.backend.persistence.entity;

import com.zerodha.backend.enums.MarketCap;
import com.zerodha.backend.enums.Sector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "precious_metal")
public abstract class PreciousMetals extends InvestmentEntity {
    @Column(name = "quantity_weight_unit")
    Integer quantityWeightUnit;
}
