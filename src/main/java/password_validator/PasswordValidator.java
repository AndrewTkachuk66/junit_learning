package password_validator;

public class PasswordValidator {

    public String password;

    public PasswordValidator(String password) {
        this.password = password;
    }

    public PasswordValidator() { }

    public String getPassword() {
        return password;
    }

    public boolean validate(String password) {
        char[] arrayFromPassword = parse(password);
        if (countDigits(arrayFromPassword) >= 6) {
            if (checkPresenceOfBigLiteral(arrayFromPassword)) {
                if (checkPresenceOfSmallLiteral(arrayFromPassword)) {
                    if (checkPresenceOfInvalidCharacters(arrayFromPassword))
                        return true;
                }
            }
        }
        return false;
    }

    public char[] parse(String password) {
        char[] charPassword = new char[password.length()];
        for (int i = 0; i < password.length(); i++) {
            charPassword[i] = password.charAt(i);
        }
        return charPassword;
    }

    public int countDigits(char[] password) {
        int countOfDigits = 0;
        for (Character currentChar : password) {
            if (currentChar >= '0' && currentChar <= '9')
                countOfDigits++;
        }
        return countOfDigits;
    }

    public boolean checkPresenceOfBigLiteral(char[] password) {
        boolean result = false;
        for (Character currentChar : password) {
            if (Character.isUpperCase(currentChar)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean checkPresenceOfSmallLiteral(char[] password) {
        boolean result = false;
        for (Character currentChar : password) {
            if (Character.isLowerCase(currentChar)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean checkPresenceOfInvalidCharacters(char[] password) {
        for (int i = 0; i < password.length; i++) {
            if (password[i] == '!' || password[i] == '@' || password[i] == '#' || password[i] == '%' || password[i] == '>'
                    || password[i] == '<' || password[i] == '|' || password[i] == ']' || password[i] == '['
                    || password[i] == '+' || password[i] == '-' || password[i] == '*' || password[i] == '/' || password[i] == '?'
                    || password[i] == '=') {
                return false;
            }
        }
        return true;
    }
}
