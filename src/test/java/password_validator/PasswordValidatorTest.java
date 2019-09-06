package password_validator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;

/**
 * When creating an account, it is often required that the password should fulfil some strength requirements.
 * It should be X characters long, have at least Y digits, contain underscore, hash, and a mixture of lower
 * and capital letters, etc. Your task is to write a method that will validate a given password. The set of
 * rules (requirements) with which you will be verifying the passwords: one Big Character(latin only), one small,
 * at less six digits, without ()/*-+/?><@!%$#&* characters. Example - 123456Wd.
 **/
@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {
    private static final String TEST_PASSWORD = "78Aspassword";
    private static final char[] TEST_PASSWORD_WITHOUT_DIGITS = {'s', 'r', 'r', 'Q', 'e'};
    private static final char[] TEST_PASSWORD_WITH_6_DIGITS = {'9', 's', 'r', 'r', 'Q', 'e', '1', '0', '7', '5', '2'};
    private static final char[] TEST_PASSWORD_WITH_BIG_LITERAL = {'9', 's', 'r', 'r', 'W', 'e', '1', '0', '7', '5', '2'};
    private static final char[] TEST_PASSWORD_WITHOUT_BIG_LITERAL = {'h', 's', 'r', 'r', 'q', 'e', '1', '0', '7', '5', '2'};
    private static final char[] TEST_PASSWORD_WITH_SMALL_LITERAL = {'H', 'S', 'R', 'R', 'R', 'e', '1', '0', '7', '5', '2'};
    private static final char[] TEST_PASSWORD_WITHOUT_SMALL_LITERAL = {'H', 'S', 'R', '1', '0', '7', '5', '2'};
    private static final char[] TEST_PASSWORD_WITH_INVALID_CHARACTERS = {'!', '@', '#', '%', '>', '<', '|', ']','[','+','-','*','/','?'};
    private static final char[] TEST_PASSWORD_WITH_VALID_CHARACTERS = {'1', '_', 'd', 'R', ')'};

    @Before
    public void setUp(){
        PasswordValidator validator = new PasswordValidator();
    }

    @Test
    public void passwordValidatorConstructorShouldTakePassword() {
        PasswordValidator validator = new PasswordValidator(TEST_PASSWORD);
        assertEquals("PasswordValidator took to constructor password String,  but were returned " +
                validator.getPassword(), "78Aspassword", validator.getPassword());
    }

    public Object[] getValidValuesForValidateMethod() {
        return $("123", "fkjkfjk787878", "67678___/*/*6787845 ", "12315ASadsd");
    }

    public Object[] getInvalidValuesForValidateMethod() {
        return $(null, " ", "");

    }

    public Object[] getInvalidCharactersForValidateMethod() {
        return $('!', '@', '#', '%', '>', '<', '|', ']','[','+','-','*','/','?');

    }
    public Object[] getInvalidCharacterArraysForValidateMethod() {
        return new Character[][]{{'!'}, {'@'}, {'#'}, {'%'}, {'>'}, {'<'}, {'|'}, {']'},{'['},{'+'},{'-'},{'*'},{'/'},{'?'}};

    }

    @Test
    @Parameters(method = "getValidValuesForValidateMethod")
    public void validateMethodShouldTakeString(String testString) {
        if (testString == null || testString.equals("") || testString.equals(" ")) throw new IllegalArgumentException();
        PasswordValidator validator = new PasswordValidator(testString);
        validator.validate(TEST_PASSWORD);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getInvalidValuesForValidateMethod")
    public void validateMethodShouldThrowIAE(String testString) {
        if (testString == null || testString.equals("") || testString.equals(" ")) throw new IllegalArgumentException();
        PasswordValidator validator = new PasswordValidator(testString);

    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = " getInvalidCharacterArraysForValidateMethod")
    public void inputStringShouldNotHaveUnsupportedCharacters(char[] unsupportedChar ) {
        PasswordValidator validator = new PasswordValidator();
        validator.checkPresenceOfInvalidCharacters(unsupportedChar);
    }

    @Test
    public void validateMethodShouldParseStringToCharArray() {
        PasswordValidator validator = new PasswordValidator();
        char[] array = validator.parse(TEST_PASSWORD);
    }

    @Test
    public void validateMethodShouldCountDigits() {
        PasswordValidator validator = new PasswordValidator();

        assertEquals(0, validator.countDigits(TEST_PASSWORD_WITHOUT_DIGITS));
        assertEquals(6, validator.countDigits(TEST_PASSWORD_WITH_6_DIGITS));
    }

    @Test
    public void validateMethodShouldCheckPresenceOfBigChar() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.checkPresenceOfBigLiteral(TEST_PASSWORD_WITHOUT_BIG_LITERAL));
        assertTrue(validator.checkPresenceOfBigLiteral(TEST_PASSWORD_WITH_BIG_LITERAL));
    }

    @Test
    public void validateMethodShouldCheckPresenceOfSmallChar() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.checkPresenceOfSmallLiteral(TEST_PASSWORD_WITHOUT_SMALL_LITERAL));
        assertTrue(validator.checkPresenceOfSmallLiteral(TEST_PASSWORD_WITH_SMALL_LITERAL));
    }

    @Test
    public void validateMethodShouldDonNotTakeInvalidChars(){
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.checkPresenceOfInvalidCharacters(TEST_PASSWORD_WITH_INVALID_CHARACTERS));
        assertTrue(validator.checkPresenceOfInvalidCharacters(TEST_PASSWORD_WITH_VALID_CHARACTERS));
    }

    public Object[] getPasswordsForTesting(){
        return $("aeerrrA1545214545","klshjhjhDj454547","Qw445459","Sr909090jkjknnxer9","232424345454wewewewA");
    }

    @Test
    @Parameters(method = "getPasswordsForTesting")
    public void validateMethodGeneralTest(String testPassword){
        PasswordValidator validator = new PasswordValidator();
        assertTrue(validator.validate(testPassword));
    }
}