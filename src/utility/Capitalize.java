package utility;

/**
 * Is used to capitalize a variable containing text.
 *
 * @author Simon Husås Houmb
 * @version 1.0 (2022-12-10)
 */
public class Capitalize
{
    /**
     * Capitalizes a given text (String). If the text has multiple words, the first letter of each
     * word gets written as a capital. The rest of the letters are made lowercase.
     * It then returns the result as a text (String).
     *
     * @param stringToCapitalize The given String to be capitalized.
     * @return The result of capitalizing the stringToCapitalize as a String.
     */
    public String capitalizeString(String stringToCapitalize)
    {
        String[] words = stringToCapitalize.split("\\s");
        StringBuilder capitalizeWord = new StringBuilder();


        if (stringToCapitalize.isBlank() || stringToCapitalize.isEmpty())
        {
            return stringToCapitalize;
        } else
        {
            for (String word : words)
            {
                String firstLetter = word.substring(0, 1);
                String afterFirstLetter = word.substring(1);
                capitalizeWord.append(firstLetter.toUpperCase())
                    .append(afterFirstLetter.toLowerCase()).append(" ");
            }

            return capitalizeWord.toString().trim();
        }
    }
}
