package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElement;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChemicalCompoundBasicTest {

    @Test
    public void weightOfChemicalCompoundIsWeightOfChemicalElement() {
        ChemicalElement chemicalElement = new ChemicalElement("Hydroène", "H", 1, 1.5D);

        ChemicalCompoundBasic chemicalCompound = new ChemicalCompoundBasic(chemicalElement);

        assertEquals(1.5D, chemicalCompound.getWeight(), 0.000001D);
    }

}