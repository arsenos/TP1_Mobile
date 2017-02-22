package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChemicalCompoundExponentTest {

    @Test
    public void weightOfChemicalCompoundIsWeightOfInnerChemicalCompoundMultipliedByExponent() {
        ChemicalCompound chemicalCompound = new ChemicalCompoundBasic(new ChemicalElement("Hydroène", "H", 1, 1.5D));

        ChemicalCompoundExponent chemicalCompoundExponent = new ChemicalCompoundExponent(chemicalCompound, 3);

        assertEquals(4.5D, chemicalCompoundExponent.getWeight(), 0.000001D);
    }

}