package ca.csf.mobile1.tp1.chemical.compound;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MisplacedExponentExceptionTest {

    @Test
    public void canGetMessageFromException() {
        MisplacedExponentException exception = new MisplacedExponentException();

        assertEquals("Exponent found before any other chemical element or parenthesis.", exception.getMessage());
    }

}