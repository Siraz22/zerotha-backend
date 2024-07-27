package com.zerodha.backend.converter;

import com.zerodha.backend.enums.InvestmentType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class InvestmentTypeConverter implements AttributeConverter<InvestmentType, String> {

    @Override
    public String convertToDatabaseColumn(InvestmentType investmentType) {
        return investmentType != null ? investmentType.name() : null;
    }

    @Override
    public InvestmentType convertToEntityAttribute(String databaseValue) {
        return databaseValue != null ? InvestmentType.valueOf(databaseValue) : null;
    }
}
