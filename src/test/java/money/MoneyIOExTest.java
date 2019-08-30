package money;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import money.Money;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MoneyIOExTest {
    private final static int VALID_AMOUNT = 5;
    private final static String VALID_CURRENCY = "USD";

    private static final Object [] getInvalidAmount(){
        return new Integer [][]{{-1245},{-1},{-454565456}};
    }

    private static final Object [] getInvalidCurrency(){
        return new String [][]{{null},{""}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidAmount")
    public void constrShouldThrowIAExForInvalidAmount(int invalidAmount){
        new Money(invalidAmount, VALID_CURRENCY);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidCurrency")
    public void currencyShouldThrowIAExForInvalidCurrency(String invalidCurrency){
        new Money(VALID_AMOUNT, invalidCurrency);
    }
}
