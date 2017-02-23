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
            Pattern pattern;
            Matcher matcher;

            //On supprime les espaces pour faciliter les vérifications
            string = string.trim().replace(" ", "");

            //Vérification du nombre de parenthèses ouvrantes en comparaison avec le nombre de parenthèses fermantes.
            pattern = Pattern.compile("\\(");
            matcher = pattern.matcher(string);
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

            //Seulement des espaces
            pattern = Pattern.compile(" ");
            matcher = pattern.matcher(string);
            int spaceCount = 0;
            while (matcher.find()) {
                spaceCount++;
            }

            if(spaceCount == string.length())
            {
                throw new EmptyFormulaException();
            }

            //Charactères invalides
            for (int i = 0; i < string.length(); i++){
                char c = string.charAt(i);
                int intValue = Integer.valueOf(c);
                if (intValue < 48 || (intValue > 57 && intValue < 65) || (intValue < 97 && intValue > 122))
                {
                    if (intValue !=  32&& intValue != 40 && intValue != 41 && intValue != 8) {
                        if (intValue == 9 || intValue == 10)
                        {
                            throw new EmptyFormulaException();
                        }
                        else
                        {
                            throw new IllegalCharacterException(c);
                        }
                    }
                }

            }

            //Parenthèses vides
            pattern = Pattern.compile("\\(\\)");
            matcher = pattern.matcher(string);
            if (matcher.find())
            {
                throw new EmptyParenthesisException();
            }

            //Élément inconnu
            pattern = Pattern.compile("[A-ZÖ][a-zö]");
            matcher = pattern.matcher(string);
            while (matcher.find())
            {
                if(elements.get(matcher.toString()) == null)
                {
                    throw new UnknownChemicalElementException(matcher.toString());
                }
            }

            //Exposant mal placé
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                int intValue = Integer.valueOf(c);
                if (intValue >= 48 && intValue <= 57 && i > 0) //Si c'est 0-9 et que ce n'est pas le premier symbole de la chaîne.
                {
                    char c2 = string.charAt(i - 1);
                    int intValue2 = Integer.valueOf(c);
                    if ((intValue2 < 65 && intValue2 > 90) && (intValue2 < 97 && intValue2 > 122) && intValue != 41) //Si ce n'est pas une lettre majuscule, minuscule ou une parenthèse fermante.
                    {
                        throw new MisplacedExponentException();
                    }
                }
                else
                {
                    throw new MisplacedExponentException();
                }
            }

            //Fin des tests de validité de la formule ----


            //Création des éléments

            String openBracketindexes = "";
            int openBracketCount = 0;
            String closedBracketindexes = "";
            ChemicalCompound[] compounds = new ChemicalCompound[10];
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                int intValue = Integer.valueOf(c);
                if (intValue == 40) //(
                {
                    openBracketCount++;
                    openBracketindexes += String.valueOf(i);

                }
                else if (intValue == 41) // )
                {
                    closedBracketindexes += String.valueOf(i);


                    if (openBracketindexes.length() > 1)
                    {

                    }
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
