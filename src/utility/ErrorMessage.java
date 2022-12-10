package utility;

/**
 * Is a collection of error messages.
 * Uses "System.err" instead of "System.out" to print them out.
 *
 * @author Simon Husås Houmb
 * @version 1.0 (2022-12-10)
 */
public class ErrorMessage
{
    /**
     * Prints an error message for when the start menu selection is not valid.
     * I.e. if the selection is less than 1 and more than 8.
     */
    public void startMenuSelectionError()
    {
        System.err.println("Please choose from one of the listed options (1-8).");
    }

    /**
     * Prints an error message for when the answer is not yes/y or no/n.
     */
    public void yesNoAnswerError()
    {
        System.err.println("Please answer yes or no.");
    }

    /**
     * Prints an error message for when the input is not a whole number (int).
     */
    public void intInputError()
    {
        System.err.println("Please enter a whole number.");
    }

    /**
     * Prints an error message for when the input is not a whole (int) and positive number.
     */
    public void positiveIntInputError()
    {
        System.err.println("Please enter a positive whole number.");
    }

    /**
     * Prints an error message for when the input is not a number or
     * is written with "." instead of "," for decimals.
     */
    public void decimalNumberInputError()
    {
        System.err.println("Please enter a number. If input has decimals try using \",\"");
    }

    /**
     * Prints an error message for when the input is not a positive number or
     * is written with "." instead of "," for decimals.
     */
    public void positiveDecimalNumberInputError()
    {
        System.err.println("Please enter a positive number. If input has decimals try using \",\"");
    }

    /**
     * Prints an error message for when the input for the category (int) is
     * less than 1 and more than 4.
     */
    public void categoryInputError()
    {
        System.err.println("Please choose from one of the listed options (1-4).");
    }

    /**
     * Prints an error message for when the String input is empty.
     */
    public void noStringInputError()
    {
        System.err.println("No input was entered, try again.");
    }

    /**
     * Prints an error message for when the String input does not only contain letters.
     */
    public void stringNotOnlyLettersError()
    {
        System.err.println("String can only contain letters, try again.");
    }

    /**
     * Prints an error message for when no items were found in a search.
     */
    public void itemNotFoundInSearchError()
    {
        System.err.println("No items were found..." + "\n"
            + "You can find the item ID numbers in the inventory list.");
    }

    /**
     * Prints an error message for when the item ID is not found.
     */
    public void itemIdNotFoundError()
    {
        System.err.println("The item ID was not found..." + "\n"
            + "You can find the item ID numbers in the inventory list.");
    }

    /**
     * Prints an error message for when the item ID already exists.
     */
    public void itemIdAlreadyExistsError()
    {
        System.err.println("The item ID is taken, try another...");
    }

    /**
     * Prints an error message for when it is tried to set the item amount to less than zero.
     */
    public void itemAmountLessThanZeroError()
    {
        System.err.println("The item amount cannot be less than 0...");
    }

    /**
     * Prints an error message for when the item information menu selection is not valid.
     * I.e. if the selection is less than 1 and more than 3.
     */
    public void itemInformationMenuSelectionError()
    {
        System.err.println("Please choose from one of the listed options (1-3).");
    }
}
