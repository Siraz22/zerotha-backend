package com.zerodha.backend.persistence.entity;

import com.zerodha.backend.enums.InvestmentType;
import com.zerodha.backend.enums.MarketCap;
import com.zerodha.backend.enums.Sector;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stock")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("STOCK")
public class StockEntity extends InvestmentEntity {
    @Column(name = "symbol")
    String symbol;

    @Enumerated(value = EnumType.STRING)
    MarketCap marketCap;

    @Enumerated(value = EnumType.STRING)
    Sector sector;

    @Column(name = "name")
    String name;
}
