package impl;

import api.CurrencyConverter;
import api.CurrencyInfo;

@CurrencyInfo("Euro")
public class EuroToSekConverter implements CurrencyConverter {
    public String getSourceCurrency() {
        return "EUR";
    }

    public double convertToSek(double amount) {
        return amount * 11.3;
    }
}
