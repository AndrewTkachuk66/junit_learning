package money;

import money.Money;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MoneyTest {

    @Test
    public void constructorShouldSetAmountAndCurrency() {
        Money money = new Money(100, "USD");

        assertEquals(100, money.getAmount());
        assertEquals("USD", money.getCurrency());
    }

    @Test
    public void testEquals() {
    }
}