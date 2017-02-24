package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */

/**
 * Un ChemicalCompound ainsi qu'un multiplicateur.
 */
public class ChemicalCompoundExponent implements ChemicalCompound
{

    private ChemicalCompound compound;

    /**
     * Multiplicateur du compound.
     */
    private int exponent;

    /**
     * Constructeur prenant en paramètre un ChemicalCompound et un exposant.
     * @param compound le ChemicalCompound.
     * @param exponent l'exposant.
     */
    public ChemicalCompoundExponent(ChemicalCompound compound, int exponent)
    {
        this.exponent = exponent;
        this.compound = compound;
    }

    /**
     * Retourne le poid du ChemicalCompound multiplié par son exposant.
     * @return le poid du ChemicalCompound multiplié par son exposant.
     */
    public double getWeight(){
        return compound.getWeight() * exponent;
    }

}
