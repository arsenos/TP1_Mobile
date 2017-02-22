package ca.csf.mobile1.tp1.chemical.compound;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyFormulaExceptionTest {

    @Test
    public void canGetMessageFromException() {
        EmptyFormulaException exception = new EmptyFormulaException();

        assertEquals("Chemical compound formula is empty.", exception.getMessage());
    }

}