import java.util.Currency;

public class CurrencyTestBT {
    // clinit will run at build time
    static Currency btCurrency;
    static {
        System.out.println("set btCurrency");
        btCurrency = Currency.getInstance("CAD");
    }

    static Currency getCurrency() {
        return btCurrency;
    }
}
