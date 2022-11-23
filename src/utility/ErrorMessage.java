package utility;

public class ErrorMessage
{
    public void startMenuSelectionError()
    {
        System.err.println("Please choose from one of the listed options (1-8).");
    }

    public void yesNoAnswerError()
    {
        System.err.println("Please answer yes or no.");
    }

    public void intInputError()
    {
        System.err.println("Please enter a whole number.");
    }

    public void numberInputError()
    {
        System.err.println("Please enter a number. If input has decimals try using \",\"");
    }

    public void noStringInputError()
    {
        System.err.println("No input was entered, try again.");
    }
}
