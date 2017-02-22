package ca.csf.mobile1.tp1.chemical.compound;

import org.junit.Test;

import static org.junit.Assert.*;

public class IllegalCharacterExceptionTest {

    @Test
    public void canGetCharacter() {
        IllegalCharacterException exception = new IllegalCharacterException('$');

        assertEquals('$', exception.getCharacter());
    }

    @Test
    public void canGetMessageFromException() {
        IllegalCharacterException exception = new IllegalCharacterException('$');


        assertEquals("Illegal character \"$\"found in chemical compound formula.", exception.getMessage());
    }

}