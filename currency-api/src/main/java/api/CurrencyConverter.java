package api;

public interface CurrencyConverter {
    String getSourceCurrency();
    double convertToSek(double amount);
}
