import java.util.Currency;

public class CurrencyTest {
    /* test behavior when setting system currency through system property java.util.currency.data */

	// -Djava.util.currency.data=currency.data
    static void currencyTest() {
        Currency c = Currency.getInstance("CMD");
        System.out.println(c.toString() + " " + c.getNumericCode());
    }
}
