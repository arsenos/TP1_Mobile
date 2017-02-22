package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElementFactory;
import ca.csf.mobile1.tp1.chemical.element.ChemicalElementRepository;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ChemicalCompoundFactoryTest {

    private ChemicalElementRepository chemicalElementRepository;
    private ChemicalCompoundFactory chemicalCompoundFactory;

    @Before
    public void before() throws IOException {
        //TODO : Lire le fichier "chemicalElementsForTests.txt", obtenir tous les composés chimiques, et les placer dans chemicalElementRepository
        chemicalCompoundFactory = new ChemicalCompoundFactory(chemicalElementRepository);
    }

    @Test
    public void canCreateChemicalCompoundFromSimpleString() throws Exception {

        //Here, if the weight is good, we assume that the compound is created correctly
        assertEquals(1.007940D, chemicalCompoundFactory.createFromString("H").getWeight(), 0.001D);
        assertEquals(58.4428D, chemicalCompoundFactory.createFromString("NaCl").getWeight(), 0.001D);

    }

    @Test
    public void canCreateChemicalCompoundWithExponents() throws Exception {

        //Here, if the weight is good, we assume that the compound is created correctly
        assertEquals(18.01528D, chemicalCompoundFactory.createFromString("H2O").getWeight(), 0.001D);
        assertEquals(31.99880D, chemicalCompoundFactory.createFromString("O2").getWeight(), 0.001D);

    }

    @Test
    public void canCreateChemicalCompoundFromStringWithParenthesis() throws Exception {

        //Here, if the weight is good, we assume that the compound is created correctly
        assertEquals(233.7711D, chemicalCompoundFactory.createFromString("(NaCl)4").getWeight(), 0.01D);
        assertEquals(95.9964D, chemicalCompoundFactory.createFromString("(O2)3").getWeight(), 0.01D);
        assertEquals(90.0779D, chemicalCompoundFactory.createFromString("CO(CH2OH)2").getWeight(), 0.01D);
        assertEquals(58.0791D, chemicalCompoundFactory.createFromString("(CH3)2CO").getWeight(), 0.01D);
        assertEquals(168.5503D, chemicalCompoundFactory.createFromString("NaCl(O3H5)2H4").getWeight(), 0.01D);

    }

    @Test
    public void canCreateChemicalCompoundFromStringWithInnerParenthesis() throws Exception {

        //Here, if the weight is good, we assume that the compound is created correctly
        assertEquals(525.3877D, chemicalCompoundFactory.createFromString("(H(CN)4)5").getWeight(), 0.01D);
        assertEquals(200.0660D, chemicalCompoundFactory.createFromString("(CN)4(O2)3").getWeight(), 0.01D);
        assertEquals(722.6503D, chemicalCompoundFactory.createFromString("B(Ar(CF3)2)4").getWeight(), 0.01D);
        assertEquals(258.1604D, chemicalCompoundFactory.createFromString("(Al2Si2O5(OH)4)").getWeight(), 0.01D);
        assertEquals(816.9881D, chemicalCompoundFactory.createFromString("(Ca4Si2O6(CO3)(OHF))2").getWeight(), 0.01D);
        assertEquals(286.2606D, chemicalCompoundFactory.createFromString("(H2SO4(Be)3(H2O))2").getWeight(), 0.01D);
        assertEquals(722.6503D, chemicalCompoundFactory.createFromString("B(Ar(CF3)2)4").getWeight(), 0.01D);

    }

    @Test(expected = EmptyFormulaException.class)
    public void cannotCreateChemicalCompoundFromEmptyFormula() throws Exception {
        chemicalCompoundFactory.createFromString("");
    }

    @Test(expected = EmptyFormulaException.class)
    public void cannotCreateChemicalCompoundFromFormulaWithWhitespaces() throws Exception {
        chemicalCompoundFactory.createFromString("        ");
    }

    @Test(expected = EmptyFormulaException.class)
    public void cannotCreateChemicalCompoundFromFormulaWithTabs() throws Exception {
        chemicalCompoundFactory.createFromString("\t\t");
    }

    @Test(expected = EmptyFormulaException.class)
    public void cannotCreateChemicalCompoundFromFormulaWithCarriageReturns() throws Exception {
        chemicalCompoundFactory.createFromString("\n\n");
    }

    @Test(expected = UnknownChemicalElementException.class)
    public void cannotCreateChemicalCompoundFromUnknownElement() throws Exception {
        chemicalCompoundFactory.createFromString("HuHuHu");
    }

    @Test(expected = EmptyParenthesisException.class)
    public void cannotCreateChemicalCompoundWithEmptyParenthesis() throws Exception {
        chemicalCompoundFactory.createFromString("Na()Cl");
    }

    @Test(expected = MisplacedExponentException.class)
    public void cannotCreateChemicalCompoundWithMisplacedExponent() throws Exception {
        chemicalCompoundFactory.createFromString("2HO");
    }

    @Test(expected = IllegalCharacterException.class)
    public void cannotCreateChemicalCompoundWithIllegalCharacter() throws Exception {
        chemicalCompoundFactory.createFromString("H2$");
    }

    @Test(expected = IllegalClosingParenthesisException.class)
    public void cannotCreateChemicalCompoundWithIllegalClosingParenthesis() throws Exception {
        chemicalCompoundFactory.createFromString("H2O)");
    }

    @Test(expected = MissingClosingParenthesisException.class)
    public void cannotCreateChemicalCompoundWithMissingClosingParenthesis() throws Exception {
        chemicalCompoundFactory.createFromString("(H2O");
    }

}