package impl;

import api.CurrencyConverter;
import api.CurrencyInfo;

@CurrencyInfo("Bitcoin")
public class BitcoinToSekConverter implements CurrencyConverter {
    @Override
    public String getSourceCurrency() {
        return "BTC";
    }

    @Override
    public double convertToSek(double amount) {
        return amount * 600000; // 1 BTC = 600000 SEK
    }
}
