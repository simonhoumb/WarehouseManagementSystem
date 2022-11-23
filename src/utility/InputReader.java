package utility;

import java.util.Locale;
import java.util.Scanner;

public class InputReader
{
    private Scanner consoleReader;
    private CheckValid inputChecker;
    private ErrorMessage printErrorMessage;

    public InputReader()
    {
        consoleReader = new Scanner(System.in).useLocale(Locale.GERMAN);
        inputChecker = new CheckValid();
        printErrorMessage = new ErrorMessage();
    }

    /**
     * Uses the Scanner method to get user input.
     * The input can only be a number (int) between 1 and 8.
     *
     * @return startMenuAnswer as an int.
     */
    public int readStartMenuAnswer()
    {
        int startMenuSelection = 0;
        boolean validSelection = false;
        do
        {
            if (consoleReader.hasNextInt())
            {
                startMenuSelection = consoleReader.nextInt();
                validSelection = inputChecker.checkStartMenuAnswer(startMenuSelection);
                consoleReader.nextLine();
                if (!validSelection)
                {
                    printErrorMessage.startMenuSelectionError();
                    consoleReader.nextLine();
                }

            } else
            {
                printErrorMessage.startMenuSelectionError();
                consoleReader.nextLine();
            }
        } while (!validSelection);
        return startMenuSelection;
    }

    public boolean readYesNoAnswer()
    {
        String inputAnswer = "";
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
                consoleReader.nextLine();
            }
        } while (!valid);
        return answer;
    }
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
                consoleReader.nextLine();
            }
        } while (!valid);

        return input;
    }

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
            } else
            {
                printErrorMessage.intInputError();
                consoleReader.nextLine();
            }
        } while (!valid);
        return input;
    }

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
            } else
            {
                printErrorMessage.numberInputError();
                consoleReader.nextLine();
            }
        } while (!valid);
        return input;
    }

    public byte readByteInput()
    {
        byte input = 0;
        boolean valid = false;
        do
        {
            if(consoleReader.hasNextByte())
            {
                input = consoleReader.nextByte();
                valid = true;
                consoleReader.nextLine();
            }
            else
            {
                printErrorMessage.intInputError();
                consoleReader.nextLine();
            }
        } while(!valid);
        return input;
    }


}
