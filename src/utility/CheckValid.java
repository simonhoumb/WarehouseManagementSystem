package utility;

/**
 * Is used to check if a variable is valid.
 * Can be used for Strings, ints and chars,
 * but also for more specific instances.
 *
 * @author Simon Husås Houmb
 * @version 0.3 (2022-10-26)
 */
public class CheckValid
{
    /**
     * Checks if the string is valid. It is not valid if it is empty
     * or only consists of whitespaces (" "). It then returns
     * true or false (boolean) accordingly.
     *
     * @param stringToCheck the String to be checked.
     * @return if the String is valid as boolean.
     */
    public boolean checkString(String stringToCheck)
    {
        return (!stringToCheck.isEmpty() && !stringToCheck.isBlank());
    }

    /**
     * Checks if the character is valid. It is not valid if it
     * is empty. It then returns true or false (boolean)
     * accordingly.
     *
     * @param charToCheck the character (char) to be checked.
     * @return if the char is valid as boolean.
     */
    public boolean checkChar(char charToCheck)
    {
        return (charToCheck != ' ');
    }

    /**
     * Checks if the number (int) is valid. It is not valid if it
     * is less than zero. It then returns true or false (boolean)
     * accordingly.
     *
     * @param intToCheck the int to be checked.
     * @return if the int is valid as a boolean.
     */
    public boolean checkIntPositive(int intToCheck)
    {
        return (intToCheck >= 0);
    }

    /**
     * Checks if the start menu answer is valid. The answer
     * is a whole number (int). It is not valid if it is less than 1
     * and more than 8. It then returns true or false (boolean)
     * accordingly.
     *
     * @param answerToCheck the answer (int) to be checked.
     * @return if the answer is valid as a boolean.
     */
    public boolean checkStartMenuAnswer(int answerToCheck)
    {
        return (answerToCheck >= 1 && answerToCheck <= 8);
    }
}
