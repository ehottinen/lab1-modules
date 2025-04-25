package impl;

import api.CurrencyConverter;

public class EuroToSekConverter implements CurrencyConverter {
    public String getSourceCurrency() {
        return "EUR";
    }

    public double convertToSek(double amount) {
        return amount * 11.3;
    }
}
