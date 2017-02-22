package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */
public class EmptyFormulaException extends Throwable {

    public EmptyFormulaException()
    {
        super("Chemical compound formula is empty.");
    }
}
