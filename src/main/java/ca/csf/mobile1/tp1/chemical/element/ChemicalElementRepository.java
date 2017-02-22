package ca.csf.mobile1.tp1.chemical.element;

import java.util.HashMap;
import java.util.Map;

/**
 * Représente un tableau périodique. Cette classe est en fait un dépôt de {@link ChemicalElement}. Il est possible de les
 * obtenir via leur {@link ChemicalElement#getSymbol() symbole} par la méthode {@link ChemicalElementRepository#get(String)}.
 * <br />
 * <br />
 * Avant d'être utilisée, ce dépôt doit être peuplé d'éléments en utilisant la méthode {@link ChemicalElementRepository#add(ChemicalElement)}.
 *
 * @author Benjamin Lemelin
 * @author Daniel Huot
 * @see ChemicalElement
 */
public class ChemicalElementRepository {

    private Map<String, ChemicalElement> chemicalElements;

    /**
     * Construit un nouveau tableau périodique vide.
     */
    public ChemicalElementRepository() {
        this.chemicalElements = new HashMap<>();
    }

    /**
     * Ajoute un {@link ChemicalElement} a ce tableau périodique. Il devient alors possible de l'obtenir via la méthode {@link ChemicalElementRepository#get(String)}.
     * Si un élément avec le même symbole existe déjà, il sera remplacé.
     * @param chemicalElement Élément à ajouter au tableau périodique.
     *                        Si un élément avec le même symbole existe déjà, il sera remplacé.
     * @see ChemicalElement
     */
    public void add(ChemicalElement chemicalElement) {
        chemicalElements.put(chemicalElement.getSymbol(), chemicalElement);
    }

    /**
     * Retourne le {@link ChemicalElement} correspondant au {@link ChemicalElement#getSymbol() symbole} reçu en paramêtre.
     * @param symbol Le {@link ChemicalElement#getSymbol() symbole} de l'élément voulu.
     * @return {@link ChemicalElement} correspondant au {@link ChemicalElement#getSymbol() symbole} reçu. Si l'élément demandé est
     * introuvable, retourne <code>null</code>.
     */
    public ChemicalElement get(String symbol) {
        return chemicalElements.get(symbol);
    }

}
