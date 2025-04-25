import api.CurrencyConverter;
import impl.*;

module currency.impl {
    requires currency.api;
    provides CurrencyConverter with
            UsdToSekConverter,
            EuroToSekConverter,
            BitcoinToSekConverter;
}