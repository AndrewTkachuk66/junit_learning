package string_reverse;

import java.util.ArrayList;
import java.util.List;

/**Additional requirements and hints:
        • think about the possible input parameters (see Section 6.1),
        • use parameterized tests (see Section 3.6) to make the test code concise,
        • write tests for expected exceptions (see Section 3.7),
        • if the method on Listing 3.16 does not work properly, then fix it,
        • refactor (after all the tests pass)
 **/
public class StringReverse {

    public  String reverse(String s) {
        if(s == null || s.equals("")){
            throw new IllegalArgumentException("Illegal string- " + s);
        }
        List<String> tempArray = new ArrayList<>(s.length());
        StringBuilder reversedString = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            tempArray.add(s.substring(i, i+1));
        }

        for (int i = tempArray.size() -1; i >= 0; i--) {
            reversedString.append(tempArray.get(i));
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringReverse().reverse("Hello, Andrew"));
    }

}
