package consumer;

import api.CurrencyConverter;

import java.util.Scanner;
import java.util.ServiceLoader;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceLoader<CurrencyConverter> loader = ServiceLoader.load(CurrencyConverter.class);

        CurrencyConverter[] converters = loader.stream()
                .map(ServiceLoader.Provider::get)
                .toArray(CurrencyConverter[]::new);

        if (converters.length == 0) {
            System.out.println("Inga valutakonverterare hittades.");
            return;
        }

        boolean runAgain = true;
        while (runAgain) {
            System.out.println("\nTillgängliga valutakonverterare:");
            for (int i = 0; i < converters.length; i++) {
                CurrencyConverter converter = converters[i];
                Class<?> clazz = converter.getClass();
                String displayName = converter.getSourceCurrency();

                if (clazz.isAnnotationPresent(api.CurrencyInfo.class)) {
                    api.CurrencyInfo info = clazz.getAnnotation(api.CurrencyInfo.class);
                    displayName = info.value() + " (" + converter.getSourceCurrency() + ")";
                }

                System.out.printf("  %d) %s%n", i + 1, displayName);
            }

            System.out.print("\nAnge numret på önskad konverterare: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine()) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Fel: Du måste skriva ett giltigt nummer.");
                continue;
            }

            if (choice < 0 || choice >= converters.length) {
                System.out.println("Ogiltigt val. Välj ett nummer från listan.");
                continue;
            }

            CurrencyConverter selected = converters[choice];
            System.out.printf("\nVald konverterare: %s → SEK%n", selected.getSourceCurrency());

            System.out.printf("Ange belopp i %s: ", selected.getSourceCurrency());
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Fel: Ogiltigt belopp.");
                continue;
            }

            double result = selected.convertToSek(amount);
            System.out.printf("\n%.2f %s motsvarar %.2f SEK%n",
                    amount, selected.getSourceCurrency(), result);

            System.out.print("\nVill du göra en ny konvertering? (j/n): ");
            String svar = scanner.nextLine().trim().toLowerCase();
            runAgain = svar.equals("j");
        }

        System.out.println("Tack för att du använde valutakonverteraren!");
    }
}