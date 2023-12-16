package com.zerodha.backend.dto;

import com.zerodha.backend.enums.MarketCap;
import com.zerodha.backend.enums.Sector;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StockDTO extends InvestmentDTO
{
    private String symbol;
    private MarketCap  marketCap;
    private Sector sector;
    private String name;
}
