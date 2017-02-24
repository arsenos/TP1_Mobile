package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElement;

/**
 * Created by Samuel A on 2017-02-22.
 */

/**
 * Un groupe de ChemicalCompound.
 */
public class ChemicalCompoundGroup implements ChemicalCompound{

    private ChemicalCompound[] compounds;


    /**
     * Constructeur prenant un tableau de ChemicalCompounds en paramètre.
     * @param compounds le tableau de compounds.
     */
    public ChemicalCompoundGroup(ChemicalCompound[] compounds)
    {
        this.compounds = compounds;
    }

    /**
     * Retourne le poid total du groupe de ChemicalCompounds.
     * @return le poid total du groupe de ChemicalCompounds.
     */
    public double getWeight()
    {
        double weight = 0;
        if (compounds.length != 0)
        {
            for (int i = 0; i < compounds.length; i++) {
                weight += compounds[i].getWeight();
            }
        }

        return weight;
    }
}
