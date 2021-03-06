package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElement;

/**
 * Created by Samuel A on 2017-02-22.
 */

/**
 * Un ChemicalCompound élémentaire comprenant seulement un élément de la table de donnée.
 */
public class ChemicalCompoundBasic implements ChemicalCompound{
    private ChemicalElement element;

    public ChemicalCompoundBasic(ChemicalElement element)
    {
        this.element = element;
    }

    public double getWeight(){
        return element.getWeight();
    }
}
