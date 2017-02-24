package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */

/**
 * Exception: Il y a une parenthèse fermante de trop.
 */
public class IllegalClosingParenthesisException extends Throwable {

    /**
     * Retourne le message de l'exception.
     * @return le message de l'exception.
     */
    public String getMessage()
    {
        return "Chemical compound contains an illegal closing parenthesis before any opening parenthesis.";
    }
}
