module currency.consumer {
    requires currency.api;
    requires currency.impl;

    uses api.CurrencyConverter;
}