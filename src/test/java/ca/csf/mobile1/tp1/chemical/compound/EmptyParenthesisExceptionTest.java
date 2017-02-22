package ca.csf.mobile1.tp1.chemical.compound;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyParenthesisExceptionTest {

    @Test
    public void canGetMessageFromException() {
        EmptyParenthesisException exception = new EmptyParenthesisException();

        assertEquals("Chemical compound contains an illegal empty parenthesis.", exception.getMessage());
    }

}