package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElement;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChemicalCompoundGroupTest {

    @Test
    public void canComputeWeightFromElementsComposingTheChemicalCompound() {
        ChemicalCompound chemicalCompound1 = new ChemicalCompoundBasic(new ChemicalElement("Hydroène", "H", 1, 1.5D));
        ChemicalCompound chemicalCompound2 = new ChemicalCompoundBasic(new ChemicalElement("Hélium", "He", 2, 0.5D));
        ChemicalCompound chemicalCompound3 = new ChemicalCompoundBasic(new ChemicalElement("Lithium", "Li", 3, 2.0D));

        ChemicalCompoundGroup chemicalCompound = new ChemicalCompoundGroup(chemicalCompound1, chemicalCompound2, chemicalCompound3);

        assertEquals(4.0D, chemicalCompound.getWeight(), 0.0D);
    }

}