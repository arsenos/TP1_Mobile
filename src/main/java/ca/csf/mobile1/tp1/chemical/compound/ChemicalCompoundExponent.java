package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */
public class ChemicalCompoundExponent implements ChemicalCompound
{

    private int exponent;
    private ChemicalCompound compound;

    public ChemicalCompoundExponent(ChemicalCompound compound, int exponent)
    {
        this.exponent = exponent;
        this.compound = compound;
    }

    public double getWeight(){
        return compound.getWeight() * exponent;
    }

}
