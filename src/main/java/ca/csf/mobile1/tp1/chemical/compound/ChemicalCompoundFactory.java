package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElementRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Samuel A on 2017-02-22.
 */
public class ChemicalCompoundFactory{

    private ChemicalElementRepository elements;

    public ChemicalCompoundFactory(ChemicalElementRepository elements)
    {
        this.elements = elements;
    }

    public ChemicalCompound createFromString(String string) throws EmptyFormulaException,
                                                                   EmptyParenthesisException,
                                                                   IllegalCharacterException,
                                                                   IllegalClosingParenthesisException,
                                                                   MisplacedExponentException,
                                                                   MissingClosingParenthesisException,
                                                                   UnknownChemicalElementException
    {
        if (!string.isEmpty())
        {
            Pattern pattern = Pattern.compile("\\(");
            Matcher matcher = pattern.matcher(string);
            int openBracketCount = 0;
            while (matcher.find())
                openBracketCount++;
            pattern = Pattern.compile("\\)");
            matcher = pattern.matcher(string);
            int closeBracketCount = 0;
            while (matcher.find())
                closeBracketCount++;

            if (openBracketCount != closeBracketCount)
            {
                if (openBracketCount > closeBracketCount)
                {
                    throw new MissingClosingParenthesisException();
                }
                else
                {
                    throw new IllegalClosingParenthesisException();
                }
            }
        }
        else
        {
            throw new EmptyFormulaException();
        }


        return null;
    }
}
