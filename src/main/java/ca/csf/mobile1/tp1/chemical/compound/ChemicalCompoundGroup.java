package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElement;

/**
 * Created by Samuel A on 2017-02-22.
 */
public class ChemicalCompoundGroup implements ChemicalCompound{

    private ChemicalCompound[] compounds;

    public ChemicalCompoundGroup(ChemicalCompound[] compounds)
    {
        this.compounds = compounds;
    }

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
