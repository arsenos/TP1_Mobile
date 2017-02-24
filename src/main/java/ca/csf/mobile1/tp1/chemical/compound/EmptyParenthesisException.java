package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */

/**
 * Exception: Il y a une parenthèse vide.
 */
public class EmptyParenthesisException extends Throwable {

    /**
     * Retourne le message de l'exception.
     * @return le message de l'exception.
     */
    public String getMessage()
    {
        return "Chemical compound contains an illegal empty parenthesis.";
    }
}
