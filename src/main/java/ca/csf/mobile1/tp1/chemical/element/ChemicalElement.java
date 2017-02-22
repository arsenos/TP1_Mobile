package ca.csf.mobile1.tp1.chemical.element;

/**
 * Représente une élément du tableau périodique.
 *
 * @author Benjamin Lemelin
 * @author Daniel Huot
 * @see ChemicalElementRepository
 */
public class ChemicalElement {

    private final String name;
    private final String symbol;
    private final int number;
    private final double weight;

    /**
     * Construit un nouvel élément du tableau périodique.
     * @param name Nom complet de l'élément, tel que "Hydrogène" ou "Lithium".
     * @param symbol Symbole de l'élément, tel que "H" ou "Li". Commence toujours par une majuscule.
     * @param number Numéro de l'élément dans le tableau périodique.
     * @param weight Poids, en <code>g/mol</code>, de l'élément.
     */
    public ChemicalElement(String name, String symbol, int number, double weight) {
        this.name = name;
        this.symbol = symbol;
        this.number = number;
        this.weight = weight;
    }

    /**
     * Retourne le nom de cet élément du tableau périodique.
     * @return <code>string</code> contenant le nom de l'élément.
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne le symbol représentant cet élément du tableau périodique.
     * @return <code>string</code> contenant le symbole de l'élément.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Retourne le numéro de cet élément dans le tableau périodique.
     * @return Numéro de l'élément.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Retourne le poids, en <code>g/mol</code>, de cet élément du tableau périodique.
     * @return Poids, en <code>g/mol</code>, de l'élément.
     */
    public double getWeight() {
        return weight;
    }

}
