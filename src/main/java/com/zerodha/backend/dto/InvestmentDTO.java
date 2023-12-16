package com.zerodha.backend.dto;

import java.math.BigDecimal;

import com.zerodha.backend.enums.InvestmentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentDTO
{
    private Integer id;
    private Integer quantity;
    private BigDecimal averagePrice;
    InvestmentType investmentType;
    private Integer associatedCountryId;
}
