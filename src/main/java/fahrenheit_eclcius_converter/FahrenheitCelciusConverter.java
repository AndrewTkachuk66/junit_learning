package fahrenheit_eclcius_converter;

public class FahrenheitCelciusConverter {
    public static final float FOR_FAR_COEFICIENT = 1.8f;
    public static final float FOR_CEL_COEFICIENT = 0.5555555555555556f;

    public  int toFahrenheit(int poCel){
        int result = (int) (poCel * FOR_FAR_COEFICIENT + 32);
        return result;
    }

    public static int toCelcius(int poFar){
        int result = (int) ((poFar - 32) * FOR_CEL_COEFICIENT);
        return result;
    }
}
