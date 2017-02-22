package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */
public class UnknownChemicalElementException extends Throwable {
    String element = "";
    public UnknownChemicalElementException(String element)
    {
        this.element = element;
    }
    public String getElement()
    {
        return element;
    }

    public String getMessage()
    {
        return "Chemical element \"" + element +"\" is unknown.";
    }
}
