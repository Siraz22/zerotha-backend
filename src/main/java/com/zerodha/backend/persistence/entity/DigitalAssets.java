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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "digital_assets")
public abstract class DigitalAssets extends InvestmentEntity {
    @Enumerated(value = EnumType.STRING)
    MarketCap marketCap;

    @Enumerated(value = EnumType.STRING)
    Sector sector;
}
