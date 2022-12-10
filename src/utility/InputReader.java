package utility;

import java.util.Locale;
import java.util.Scanner;

/**
 * Is used to read different input from the user. Takes use of the Scanner class,
 * CheckValid class and ErrorMessage class.
 *
 * @author Simon Husås Houmb
 * @version 1.0 (2022-12-10)
 */
public class InputReader
{
    private Scanner consoleReader;
    private CheckValid inputChecker;
    private ErrorMessage printErrorMessage;

    /**
     * Creates new instances of the other classes that is used.
     * The Scanner is using the German format.
     */
    public InputReader()
    {
        consoleReader = new Scanner(System.in).useLocale(Locale.GERMAN);
        inputChecker = new CheckValid();
        printErrorMessage = new ErrorMessage();
    }

    /**
     * Uses the Scanner method to get user input as a String.
     * The input can only be "yes"/"y" or "no"/"n".
     * The letter case does not matter. I.e. both "y" and "Y" is valid.
     * If the input is not valid it uses the ErrorMessage class to print an error message.
     * Returns the answer as a boolean where "yes" is true and "no" is false.
     *
     * @return The answer as a boolean.
     */
    public boolean readYesNoAnswer()
    {
        String inputAnswer;
        boolean answer = false;
        boolean valid = false;

        do
        {
            if (consoleReader.hasNext())
            {
                inputAnswer = consoleReader.nextLine();
                valid = inputChecker.checkString(inputAnswer);
                if (inputAnswer.equalsIgnoreCase("yes")
                    || inputAnswer.equalsIgnoreCase("y"))
                {
                    answer = true;
                } else if (inputAnswer.equalsIgnoreCase("no")
                    || inputAnswer.equalsIgnoreCase("n"))
                {
                    answer = false;
                } else
                {
                    valid = false;
                }
            }
            if (!valid)
            {
                printErrorMessage.yesNoAnswerError();
            }
        } while (!valid);
        return answer;
    }

    /**
     * Uses the Scanner method to get user input as a String.
     * The input is not valid if it is empty. If not valid it will use the ErrorMessage class
     * to print an error message.
     * Returns the input as a String when it is valid.
     *
     * @return The input as a String.
     */
    public String readStringInput()
    {
        String input = "";
        boolean valid = false;
        do
        {
            if (consoleReader.hasNext())
            {
                input = consoleReader.nextLine();
                valid = inputChecker.checkString(input);
            }
            if (!valid)
            {
                printErrorMessage.noStringInputError();
            }
        } while (!valid);

        return input;
    }

    /**
     * Uses the Scanner method to get user input as a String.
     * The input is not valid if it is empty or if it contains something else than letters.
     * If not valid it will use the ErrorMessage class to print an error message.
     * Returns the input as a String when it is valid.
     *
     * @return The input as a String.
     */
    public String readOnlyLetterStringInput()
    {
        String input = "";
        boolean valid = false;
        do
        {
            if (consoleReader.hasNext())
            {
                input = consoleReader.nextLine();
                valid = inputChecker.checkStringOnlyLetters(input);
            }
            if (!valid)
            {
                printErrorMessage.stringNotOnlyLettersError();
            }
        } while (!valid);

        return input;
    }

    /**
     * Uses the Scanner method to get user input as an int.
     * The input is not valid if it is not an int. If not valid it will use the ErrorMessage class
     * to print an error message.
     * Returns the input as an int when it is valid.
     *
     * @return The input as an int.
     */
    public int readIntInput()
    {
        int input = 0;
        boolean valid = false;
        do
        {
            if (consoleReader.hasNextInt())
            {
                input = consoleReader.nextInt();
                valid = true;
                consoleReader.nextLine();
            }
            if (!valid)
            {
                printErrorMessage.intInputError();
                consoleReader.nextLine();
            }
        } while (!valid);
        return input;
    }

    /**
     * Uses the Scanner method to get user input as an int.
     * The input is not valid if it is not a positive int.
     * If not valid it will use the ErrorMessage class to print an error message.
     * Returns the input as an int when it is valid.
     *
     * @return The input as an int.
     */
    public int readPositiveIntInput()
    {
        int input = 0;
        boolean valid = false;
        do
        {
            if (consoleReader.hasNextFloat())
            {
                input = consoleReader.nextInt();
                valid = inputChecker.checkIfIntPositive(input);
                consoleReader.nextLine();
            }
            if (!valid)
            {
                printErrorMessage.positiveIntInputError();
                consoleReader.nextLine();
            }
        } while (!valid);
        return input;
    }

    /**
     * Uses the Scanner method to get user input as a float.
     * The input is not valid if it is not a float.
     * If not valid it will use the ErrorMessage class to print an error message.
     * Returns the input as a float when it is valid.
     *
     * @return The input as a float.
     */
    public float readFloatInput()
    {
        float input = 0.0f;
        boolean valid = false;
        do
        {
            if (consoleReader.hasNextFloat())
            {
                input = consoleReader.nextFloat();
                valid = true;
                consoleReader.nextLine();
            }
            if (!valid)
            {
                printErrorMessage.decimalNumberInputError();
                consoleReader.nextLine();
            }
        } while (!valid);
        return input;
    }

    /**
     * Uses the Scanner method to get user input as a float.
     * The input is not valid if it is not a positive float.
     * If not valid it will use the ErrorMessage class to print an error message.
     * Returns the input as a float when it is valid.
     *
     * @return The input as a float.
     */
    public float readPositiveFloatInput()
    {
        float input = 0.0f;
        boolean valid = false;
        do
        {
            if (consoleReader.hasNextFloat())
            {
                input = consoleReader.nextFloat();
                valid = inputChecker.checkIfFloatPositive(input);
                consoleReader.nextLine();
            }
            if (!valid)
            {
                printErrorMessage.positiveDecimalNumberInputError();
                consoleReader.nextLine();
            }
        } while (!valid);
        return input;
    }

    /**
     * Uses the Scanner method to get user input as an Integer.
     * The input is not valid if it is not an Integer between 1 and 4.
     * If not valid it will use the ErrorMessage class to print an error message.
     * Returns the input as an Integer when it is valid.
     *
     * @return the input as an Integer.
     */
    public Integer readCategoryInput()
    {
        Integer input = 0;
        boolean valid = false;
        do
        {
            if (consoleReader.hasNextInt())
            {
                input = consoleReader.nextInt();
                valid = inputChecker.checkCategoryAnswer(input);
                consoleReader.nextLine();
            }
            if (!valid)
            {
                printErrorMessage.categoryInputError();
            }
        } while (!valid);
        return input;
    }
}
