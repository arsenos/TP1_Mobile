package ca.csf.mobile1.tp1.chemical.element;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChemicalElementTest {

    @Test
    public void canCreateNewChemicalElement() {
        ChemicalElement chemicalElement = new ChemicalElement("Hydrogène", "H", 1, 1.00794D);

        assertEquals("Hydrogène", chemicalElement.getName());
        assertEquals("H", chemicalElement.getSymbol());
        assertEquals(1, chemicalElement.getNumber());
        assertEquals(1.00794D, chemicalElement.getWeight(), 0.000001D);
    }

}