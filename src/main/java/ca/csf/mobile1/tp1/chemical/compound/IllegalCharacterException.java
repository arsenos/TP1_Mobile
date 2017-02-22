package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Samuel A on 2017-02-22.
 */
public class IllegalCharacterException extends Throwable {

    Character character = ' ';
    public IllegalCharacterException(Character character)
    {
        this.character = character;
    }

    public Character getCharacter()
    {
        return this.character;
    }
}
