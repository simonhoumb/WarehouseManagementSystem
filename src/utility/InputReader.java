package utility;

import java.util.Scanner;

public class InputReader
{
    private Scanner consoleReader;
    private CheckValid inputChecker;
    private ErrorMessage printErrorMessage;

    public InputReader()
    {
        consoleReader = new Scanner(System.in);
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
        int startMenuAnswer = 0;
        boolean validAnswer = false;
        do
        {
            if (consoleReader.hasNextInt())
            {
                startMenuAnswer = consoleReader.nextInt();
                validAnswer = inputChecker.checkStartMenuAnswer(startMenuAnswer);
                consoleReader.nextLine();
                if (!validAnswer)
                {
                    printErrorMessage.startMenuAnswerError();
                }

            } else
            {
                printErrorMessage.startMenuAnswerError();
                consoleReader.nextLine();
            }
        } while (!validAnswer);
        return startMenuAnswer;
    }
}
