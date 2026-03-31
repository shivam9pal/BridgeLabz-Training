package JUnit_demo.JUnit;

import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Password1"));
        assertTrue(PasswordValidator.isValid("Secure9X"));
    }

    @Test
    void testInvalidPasswordTooShort() {
        assertFalse(PasswordValidator.isValid("Abc1"));
    }

    @Test
    void testInvalidPasswordNoUppercase() {
        assertFalse(PasswordValidator.isValid("password1"));
    }

    @Test
    void testInvalidPasswordNoDigit() {
        assertFalse(PasswordValidator.isValid("Password"));
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValid(null));
    }

}
