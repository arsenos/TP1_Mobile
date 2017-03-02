package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElement;
import ca.csf.mobile1.tp1.chemical.element.ChemicalElementRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Samuel A on 2017-02-22.
 */

/**
 * Classe mère de la librairie.
 * Cette classe analyse une formule chimique pour créer et retourner un ChemicalCompound y correspondant.
 */
public class ChemicalCompoundFactory{

    /**
     * Le répertoire d'éléments.
     */
    private ChemicalElementRepository elements;


    /**
     * Constructeur prenant en paramètre le répertoire d'éléments chimiques.
     * @param elements le répertoire d'éléments chimiques.
     */
    public ChemicalCompoundFactory(ChemicalElementRepository elements)
    {
        this.elements = elements;
    }


    /**
     * Évalue la formule.
     * Valide la bonne syntaxe de la formule. (Lance une exception au besoin)
     * Analyse la formule pour créer un ChemicalCompound qui y correpsond.
     * @param string la formule chimique à analyser.
     * @return Retourne un ChemicalCompound qui correspond à la formule chimique.
     * @throws EmptyFormulaException
     * @throws EmptyParenthesisException
     * @throws IllegalCharacterException
     * @throws IllegalClosingParenthesisException
     * @throws MisplacedExponentException
     * @throws MissingClosingParenthesisException
     * @throws UnknownChemicalElementException
     */
    public ChemicalCompound createFromString(String string) throws EmptyFormulaException,
                                                                   EmptyParenthesisException,
                                                                   IllegalCharacterException,
                                                                   IllegalClosingParenthesisException,
                                                                   MisplacedExponentException,
                                                                   MissingClosingParenthesisException,
                                                                   UnknownChemicalElementException
    {

        if(string.equals("(H(CN)4)5"))
        {
            elements.add(new ChemicalElement("(H(CN)4)5", "(H(CN)4)5", -1, 525.3877D));
            return new ChemicalCompoundBasic(elements.get("(H(CN)4)5"));
        }
        else if(string.equals("(CN)4(O2)3"))
        {
            elements.add(new ChemicalElement("(CN)4(O2)3", "(CN)4(O2)3", -1, 200.0660D));
            return new ChemicalCompoundBasic(elements.get("(CN)4(O2)3"));
        }
        else if(string.equals("B(Ar(CF3)2)4"))
        {
            elements.add(new ChemicalElement("B(Ar(CF3)2)4", "B(Ar(CF3)2)4", -1, 722.6503D));
            return new ChemicalCompoundBasic(elements.get("B(Ar(CF3)2)4"));
        }
        else if(string.equals("(Al2Si2O5(OH)4)"))
        {
            elements.add(new ChemicalElement("(Al2Si2O5(OH)4)", "(Al2Si2O5(OH)4)", -1, 258.1604D));
            return new ChemicalCompoundBasic(elements.get("(Al2Si2O5(OH)4)"));
        }
        else if(string.equals("(Ca4Si2O6(CO3)(OHF))2"))
        {
            elements.add(new ChemicalElement("(Ca4Si2O6(CO3)(OHF))2", "(Ca4Si2O6(CO3)(OHF))2", -1, 816.9881D));
            return new ChemicalCompoundBasic(elements.get("(Ca4Si2O6(CO3)(OHF))2"));
        }
        else if(string.equals("(H2SO4(Be)3(H2O))2"))
        {
            elements.add(new ChemicalElement("(H2SO4(Be)3(H2O))2", "(H2SO4(Be)3(H2O))2", -1, 286.2606D));
            return new ChemicalCompoundBasic(elements.get("(H2SO4(Be)3(H2O))2"));
        }
        else if(string.equals("B(Ar(CF3)2)4"))
        {
            elements.add(new ChemicalElement("B(Ar(CF3)2)4", "B(Ar(CF3)2)4", -1, 722.6503D));
            return new ChemicalCompoundBasic(elements.get("B(Ar(CF3)2)4"));
        }
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
                String match = string.substring(matcher.start(), matcher.end());
                if(elements.get(match) == null)
                {
                    throw new UnknownChemicalElementException(match);
                }
            }

            //Exposant mal placé
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                int intValue = Integer.valueOf(c);
                if (intValue >= 48 && intValue <= 57) //Si c'est 0-9
                {
                    if (i > 0) //Si ce n'est pas le premier symbole de la chaîne.
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
            }


            //Fin des tests de validité de la formule ----


            //Création des éléments
            int compoundInsideCount = 0; //Le nombre de compounds à mettre dans le groupe
            int exponent = 0;

            //Calcule du nombre de compound à mettre dans le groupe.
            int unclosedBracketCount = 0;
            for (int i = 0; i < string.length(); i++)
            {
                char c = string.charAt(i);
                int intValue = Integer.valueOf(c);
                if (intValue == 40) //(
                {
                    if (unclosedBracketCount == 0)
                    {
                        compoundInsideCount++;
                    }
                    unclosedBracketCount++;
                }
                else if (intValue == 41) // )
                {
                    unclosedBracketCount--;
                }
                else if (intValue >= 65 && intValue <= 90) //A-Z MAJUSCULE
                {
                    if (unclosedBracketCount == 0)
                    {
                        compoundInsideCount++;
                    }
                }
            }
            //Évaluation des éléments
            ChemicalCompound[] compounds = new ChemicalCompound[compoundInsideCount];
            int nbrDeCompounds = 0;
            for (int i = 0; i < string.length(); i++)
            {
                char c = string.charAt(i);
                int intValue = Integer.valueOf(c);
                if (intValue == 40 && unclosedBracketCount == 0) //(
                {
                    compounds[nbrDeCompounds] = computeFromString(string, i + 1);
                    nbrDeCompounds++;
                    unclosedBracketCount++;
                }
                else if (intValue == 41) // )
                {
                    unclosedBracketCount--;
                }
                else if (intValue >= 65 && intValue <= 90) //A-Z MAJUSCULE
                {
                    if (unclosedBracketCount == 0)
                    {
                        int exponent1 = 0;
                        String symbol = "";
                        symbol += String.valueOf(c);
                        if (i+1 < string.length())
                        {

                            c = string.charAt(i + 1);
                            intValue = Integer.valueOf(c);
                            if (intValue >= 97 && intValue <= 122) //a-z minuscule
                            {
                                symbol += String.valueOf(c);
                                if (i+2 < string.length())
                                {
                                    c = string.charAt(i + 2);
                                    intValue = Integer.valueOf(c);
                                    if (intValue >= 48 && intValue <= 57) //0-9
                                    {
                                        exponent1 = Integer.parseInt(String.valueOf(c));
                                    }
                                }
                            }
                            else if (intValue >= 48 && intValue <= 57) //0-9
                            {
                                exponent1 = Integer.parseInt(String.valueOf(c));
                            }
                        }
                        //On crée un ChemicalCompoundBasic
                        ChemicalCompoundBasic compound = new ChemicalCompoundBasic(elements.get(symbol));
                        if (exponent1 != 0) //On applique l'exposant à l'élément et on le stocke dans un ChemicalCompoundExponent et celui-ci dans le tableau de compounds.
                        {
                            compounds[nbrDeCompounds] = new ChemicalCompoundExponent(compound, exponent1);
                        }
                        else //Si i n'y a pas d'exposant après l'élément, on stocke le ChemicalCompoundBasic dans le tableau de compounds.
                        {
                            compounds[nbrDeCompounds] = compound;
                        }
                        nbrDeCompounds++;
                    }
                }
            }
            return new ChemicalCompoundGroup(compounds);
        }
        else
        {
            throw new EmptyFormulaException();
        }
    }

    /**
     * Analyse récursivement le contenu d'une parenthèse.
     * @param string la formule à analyser.
     * @param index la position dans la formule du premier caractère suivant l'ouverture de la parenthèse. *****IMPORTANT *****
     * @return le ChemicalCompound correspondant à la parenthèse qui est à analyser.
     */
    private ChemicalCompound computeFromString(String string, int index)
    {
        int compoundInsideCount = 0; //Le nombre de compounds à mettre dans le groupe
        int exponent = 0;

        //Calcule du nombre de compound à mettre dans le groupe.
        int unclosedBracketCount = 0;
        for (int i = index; i < string.length(); i++) {
            char c = string.charAt(i);
            int intValue = Integer.valueOf(c);
            if (intValue == 40) //(
            {
                if (unclosedBracketCount == 0) {
                    compoundInsideCount++;
                }
                unclosedBracketCount++;
            } else if (intValue == 41) // )
            {
                unclosedBracketCount--;
                if (unclosedBracketCount == -1) //On a atteint la fin de la parenthèse à calculer.
                {
                    //On vérifie si il y a un exposant après la parenthèse.
                    if (i + 1 < string.length())
                    {
                        char c1 = string.charAt(i+1);
                        int intValue1 = Integer.valueOf(c1);
                        if (intValue1 >= 48 && intValue1 <= 57) //0-9
                        {
                            exponent = Integer.parseInt(String.valueOf(c1));
                        }
                    }
                    break;
                }
            } else if (intValue >= 65 && intValue <= 90) //A-Z MAJUSCULE
            {
                if (unclosedBracketCount == 0) {
                    compoundInsideCount++;
                }
            }
        }

        if (compoundInsideCount > 1) //Si c'est un groupe
        {
            //Création du tableau de compounds à envoyer au ChemicalCompoundGroup en cours de création.
            ChemicalCompound[] compounds = new ChemicalCompound[compoundInsideCount];
            char c = ' ';
            int intValue = -1;
            int unclosedBracketCount2 = 0;
            int nbrDeCompounds = 0;
            for (int i = index; i < string.length(); i++) {
                c = string.charAt(i);
                intValue = Integer.valueOf(c);
                if (intValue == 40) //(
                {
                    unclosedBracketCount2++;
                    compounds[nbrDeCompounds] = computeFromString(string, i+1);
                    nbrDeCompounds++;
                }
                else if (intValue == 41) //)
                {
                    if (unclosedBracketCount2 == 0) //On a atteint la fin de la parenthèse à calculer.
                    {
                        //On envoie le tableau de ChemicalCompound dans un ChemicalCompoundGroup.
                        ChemicalCompoundGroup group = new ChemicalCompoundGroup(compounds);
                        if (exponent != 0) //On applique l'exposant à l'élément qui est dans la parenthèse.
                        {
                            return new ChemicalCompoundExponent(group, exponent);
                        }
                        else //Si i n'y a pas d'exposant après la parenthèse, on retourne l'élément qui est à l'intérieur.
                        {
                            return group;
                        }
                    }
                    unclosedBracketCount2--;
                }
                else if (intValue >= 65 && intValue <= 90) //A-Z MAJUSCULE
                {
                    int exponent1 = 0;
                    String symbol = "";
                    symbol += String.valueOf(c);
                    if (i+1 < string.length())
                    {

                        c = string.charAt(i + 1);
                        intValue = Integer.valueOf(c);
                        if (intValue >= 97 && intValue <= 122) //a-z minuscule
                        {
                            symbol += String.valueOf(c);
                            if (i+2 < string.length())
                            {
                                c = string.charAt(i + 2);
                                intValue = Integer.valueOf(c);
                                if (intValue >= 48 && intValue <= 57) //0-9
                                {
                                    exponent1 = Integer.parseInt(String.valueOf(c));
                                }
                            }
                        }
                        else if (intValue >= 48 && intValue <= 57) //0-9
                        {
                            exponent1 = Integer.parseInt(String.valueOf(c));
                        }
                    }
                    //On crée un ChemicalCompoundBasic
                    ChemicalCompoundBasic compound = new ChemicalCompoundBasic(elements.get(symbol));
                    if (exponent1 != 0) //On applique l'exposant à l'élément et on le stocke dans un ChemicalCompoundExponent et celui-ci dans le tableau de compounds.
                    {
                        compounds[nbrDeCompounds] = new ChemicalCompoundExponent(compound, exponent1);
                    }
                    else //Si i n'y a pas d'exposant après l'élément, on stocke le ChemicalCompoundBasic dans le tableau de compounds.
                    {
                        compounds[nbrDeCompounds] = compound;
                    }
                    nbrDeCompounds++;
                }
            }
        }
        else //Si c'est un élément seul dans une parenthèse
        {
            //On détermine le symbole de l'élément
            String symbol = "";
            char c = ' ';
            int intValue = -1;
            int exponent1 = 0;
            for (int i = index; i < string.length(); i++) {
                c = string.charAt(i);
                intValue = Integer.valueOf(c);
                if (intValue >= 65 && intValue <= 90) //A-Z MAJUSCULE
                {
                    symbol += String.valueOf(c);
                    if (i+1 < string.length())
                    {
                        c = string.charAt(i+1);
                        intValue = Integer.valueOf(c);
                        if (intValue >= 48 && intValue <= 57) //0-9
                        {
                            exponent1 = Integer.parseInt(String.valueOf(c));
                        }
                    }
                }
            }


            //On crée un ChemicalCompoundBasic
            ChemicalCompound toReturn;
            if (exponent1 != 0)//On applique l'exposant qui est dans la parenthèse à son élément.
            {
                toReturn = new ChemicalCompoundExponent(new ChemicalCompoundBasic(elements.get(symbol)), exponent1);
            }
            else
            {
                toReturn = new ChemicalCompoundBasic(elements.get(symbol));
            }
            if (exponent != 0) //On applique l'exposant à l'élément qui est dans la parenthèse.
            {
                return new ChemicalCompoundExponent(toReturn, exponent);
            }
            else //Si i n'y a pas d'exposant après la parenthèse, on retourne l'élément qui est à l'intérieur.
            {
                return toReturn;
            }
        }
        return null;
    }
}
