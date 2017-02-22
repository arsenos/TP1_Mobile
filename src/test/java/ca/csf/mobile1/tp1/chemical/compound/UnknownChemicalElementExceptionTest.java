package ca.csf.mobile1.tp1.chemical.compound;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnknownChemicalElementExceptionTest {

    @Test
    public void canGetElement() {
        UnknownChemicalElementException exception = new UnknownChemicalElementException("Hu");

        assertEquals("Hu", exception.getElement());
    }

    @Test
    public void canGetMessageFromException() {
        UnknownChemicalElementException exception = new UnknownChemicalElementException("Hu");

        assertEquals("Chemical element \"Hu\" is unknown.", exception.getMessage());
    }

}