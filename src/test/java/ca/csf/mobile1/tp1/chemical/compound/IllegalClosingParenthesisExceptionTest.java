package ca.csf.mobile1.tp1.chemical.compound;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IllegalClosingParenthesisExceptionTest {

    @Test
    public void canGetMessageFromException() {
        IllegalClosingParenthesisException exception = new IllegalClosingParenthesisException();

        assertEquals("Chemical compound contains an illegal closing parenthesis before any opening parenthesis.", exception.getMessage());
    }

}