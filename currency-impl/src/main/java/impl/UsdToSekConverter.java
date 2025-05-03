package impl;

import api.CurrencyConverter;
import api.CurrencyInfo;

@CurrencyInfo("US Dollar")
public class UsdToSekConverter implements CurrencyConverter {
    public String getSourceCurrency() {
        return "USD";
    }

    public double convertToSek(double amount) {
        return amount * 10.5;
    }
}
