package utility;

/**
 * Is used to check if a variable is valid.
 * Can be used for Strings, ints and floats,
 * but also for more specific instances.
 *
 * @author Simon Husås Houmb
 * @version 1.0 (2022-12-10)
 */
public class CheckValid
{
    /**
     * Checks if the string is valid. It is not valid if it is empty
     * or only consists of whitespaces (" "). It then returns
     * true or false (boolean) accordingly.
     *
     * @param stringToCheck The String to be checked.
     * @return If the String is valid, as boolean.
     */
    public boolean checkString(String stringToCheck)
    {
        return (!stringToCheck.isEmpty() && !stringToCheck.isBlank());
    }

    /**
     * Checks if the string is valid. It is not valid if it is empty
     * or only consists of whitespaces (" ") and it can only consist of letters.
     * It then returns true or false (boolean) accordingly.
     *
     * @param stringToCheck The String to be checked.
     * @return If the String is valid, as a boolean.
     */
    public boolean checkStringOnlyLetters(String stringToCheck)
    {
        //https://stackoverflow.com/questions/5238491/check-if-string-contains-only-letters <-fjern
        return (!stringToCheck.isEmpty() && !stringToCheck.isBlank())
            && stringToCheck.matches("[a-zA-Z]+");
    }

    /**
     * Checks if the whole number (int) is valid. It is not valid if it
     * is less than zero. It then returns true or false (boolean)
     * accordingly.
     *
     * @param intToCheck The int to be checked.
     * @return If the int is valid, as a boolean.
     */
    public boolean checkIfIntPositive(int intToCheck)
    {
        return (intToCheck >= 0);
    }

    /**
     * Checks if the decimal number (float) is valid. It is not valid if it is less than zero.
     * It then returns true or false (boolean) accordingly.
     *
     * @param floatToCheck The float to be checked.
     * @return If the float is valid, as a boolean.
     */
    public boolean checkIfFloatPositive(float floatToCheck)
    {
        return (floatToCheck >= 0);
    }

    /**
     * Checks if the category answer is valid. The answer is a whole number (int). It is not
     * valid if it is less than 1 and more than 4. It then returns true or false (boolean)
     * accordingly.
     *
     * @param answerToCheck The answer (int) to be checked.
     * @return If the answer (int) is valid, as a boolean.
     */
    public boolean checkCategoryAnswer(int answerToCheck)
    {
        return (answerToCheck >= 1 && answerToCheck <= 4);
    }
}
