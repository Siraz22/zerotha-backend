package com.zerodha.backend.dto;

import com.zerodha.backend.enums.MarketCap;
import com.zerodha.backend.enums.Sector;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockUpdateDTO extends InvestmentDTO
{
    MarketCap marketCap;
    Sector sector;
}
