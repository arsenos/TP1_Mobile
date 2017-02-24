package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */

/**
 * Exception: Il y a un caractère illégal.
 */
public class IllegalCharacterException extends Throwable {

    Character character = ' ';

    /***
     * Constructeur prennant en paramètre un caractère illégal.
     * @param character le caractère illégal.
     */
    public IllegalCharacterException(Character character)
    {
        this.character = character;
    }


    /**
     * Retourne le message de l'exception.
     * @return le message de l'exception.
     */
    public Character getCharacter()
    {
        return this.character;
    }
}
