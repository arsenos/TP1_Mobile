package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */
public class MissingClosingParenthesisException extends Throwable {

    public String getMessage()
    {
        return "Chemical compound is missing a closing parenthesis.";
    }
}
