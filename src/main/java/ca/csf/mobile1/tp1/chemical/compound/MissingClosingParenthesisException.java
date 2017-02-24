package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */

/**
 * Exception: Il manque une parenthèse fermante.
 */
public class MissingClosingParenthesisException extends Throwable {

    /**
     * Retourne le message de l'exception.
     * @return le message de l'exception.
     */
    public String getMessage()
    {
        return "Chemical compound is missing a closing parenthesis.";
    }
}
