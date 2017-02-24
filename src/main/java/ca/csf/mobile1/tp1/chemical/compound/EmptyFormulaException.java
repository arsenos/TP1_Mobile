package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */

/**
 * Exception: La formule est vide.
 */
public class EmptyFormulaException extends Throwable {

    /**
     * Constructeur passant un message à la classe mère.
     */
    public EmptyFormulaException()
    {
        super("Chemical compound formula is empty.");
    }
}
