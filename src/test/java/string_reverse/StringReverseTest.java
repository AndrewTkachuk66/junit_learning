package string_reverse;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class StringReverseTest {
    private static final String testString = "Hello";
    private static final String expectedString = "olleH";

    public static final Object[] getTestedStrings(){
        return new String[][]{{"Hello"},{" "},{"Java forever"}};
    }

    public static final Object[] getInvalidStrings(){
        return new String[][]{{null},{""}};
    }

    @Test
    public void reverseMethodShouldWorkCorrectly(){
        assertEquals(expectedString, new StringReverse().reverse(testString));
    }

    @Test
    public void reverseMethodShouldReturnString() {
        Object object = new StringReverse().reverse(testString);
        Class<?> reversedObject = object.getClass();
    }
    @Test
    @Parameters(method = "getTestedStrings")
    public void reverseMethodShouldTakeValidStrings(String testedString){
       new StringReverse().reverse(testedString);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidStrings")
    public void reverseMethodShouldThrowIAEx(String invalidString){
        new StringReverse().reverse(invalidString);
    }
}