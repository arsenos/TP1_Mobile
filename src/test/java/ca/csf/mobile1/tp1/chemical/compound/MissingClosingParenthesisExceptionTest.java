package ca.csf.mobile1.tp1.chemical.compound;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissingClosingParenthesisExceptionTest {

    @Test
    public void canGetMessageFromException() {
        MissingClosingParenthesisException exception = new MissingClosingParenthesisException();

        assertEquals("Chemical compound contains is missing a closing parenthesis.", exception.getMessage());
    }

}