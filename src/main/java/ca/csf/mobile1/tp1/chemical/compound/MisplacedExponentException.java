package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */

/**
 * Exception: Il y a un exposant mal placé.
 */
public class MisplacedExponentException extends Throwable {

    /**
     * Retourne le message de l'exception.
     * @return le message de l'exception.
     */
    public String getMessage()
    {
        return "Exponent found before any other chemical element or parenthesis.";
    }
}
