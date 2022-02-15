import java.util.Currency;

public class CurrencyTest {
    /* test behavior when setting system currency through system property java.util.currency.data */

    static void currencyTest() {
        Currency c = Currency.getInstance("CP");
        System.out.println(c.toString());
    }
}
