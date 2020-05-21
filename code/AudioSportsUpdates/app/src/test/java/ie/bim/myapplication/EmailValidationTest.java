package ie.bim.myapplication;

import org.junit.Test;

import ie.bim.myapplication.utils.EmailUtils;

import static org.junit.Assert.*;

public class EmailValidationTest {

    @Test
    public void email_isValid() {
        String email = "test@valid.email.com";

        boolean isValid = EmailUtils.validateEmail(email);

        assertTrue(isValid);
    }

    @Test
    public void email_notValid() {
        String email = "test.valid.email.com";

        boolean isValid = EmailUtils.validateEmail(email);

        assertFalse(isValid);
    }

}
