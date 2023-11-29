package com.zerodha.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {
    Integer id;
    String name;
    String currency;
    String currencyName;
    String currencySymbol;
    //Investment entities
}
