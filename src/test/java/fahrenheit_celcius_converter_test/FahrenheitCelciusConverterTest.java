package fahrenheit_celcius_converter_test;

import fahrenheit_eclcius_converter.FahrenheitCelciusConverter;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FahrenheitCelciusConverterTest {

    public Object[] getDataInCel(){
        return new Integer[]{37, 0, 100,14545,-4545};
    }

    public Object[] getDataInFar(){
        return new Integer[]{37, 0, 100,14545,4545};
    }

    @Test
    @Parameters(method = "getDataInCel")
    public void shouldConvertCelciusToFahrenheit(int DataInCel) {
        new FahrenheitCelciusConverter().toFahrenheit(DataInCel);
    }
    @Test
    @Parameters(method = "getDataInFar")
    public void shouldConvertFahrenheitToCelcius(int DataInFar) {
        new FahrenheitCelciusConverter().toFahrenheit(DataInFar);

    }
    @Test
    public void toFarMethodShouldWorkCorrect(){
        assertEquals(253,new FahrenheitCelciusConverter().toFahrenheit(123));
    }

    @Test
    public void toCelMethodShouldWorkCorrect(){
        assertEquals(-17,new FahrenheitCelciusConverter().toCelcius(0));
    }
}
