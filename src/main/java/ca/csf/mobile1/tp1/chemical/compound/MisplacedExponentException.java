package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */
public class MisplacedExponentException extends Throwable {

    public String getMessage()
    {
        return "Exponent found before any other chemical element or parenthesis.";
    }
}
