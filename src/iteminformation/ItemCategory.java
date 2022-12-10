package iteminformation;

import java.util.HashMap;

//https://www.baeldung.com/java-enum-values <---- fjern!!

/**
 * The categories used in the ItemInventory.
 */
public enum ItemCategory
{
    /**
     * The Floor Laminates category.
     * It holds the label "Floor Laminates" and the number 1.
     */
    FLOOR_LAMINATES("Floor Laminates", 1),

    /**
     * The Windows category.
     * It holds the label "Windows" and the number 2.
     */
    WINDOWS("Windows", 2),

    /**
     * The Doors category.
     * It holds the label "Doors" and the number 3.
     */
    DOORS("Doors", 3),

    /**
     * The Lumber category.
     * It holds the label "Lumber" and the number 4.
     */
    LUMBER("Lumber", 4);

    private static final HashMap<String, ItemCategory> BY_LABEL = new HashMap<>();
    private static final HashMap<Integer, ItemCategory> BY_NUMBER = new HashMap<>();

    static
    {
        for (ItemCategory category : values())
        {
            BY_LABEL.put(category.label, category);
            BY_NUMBER.put(category.number, category);
        }
    }

    private final String label;
    private final int number;

    ItemCategory(String label, Integer number)
    {
        this.label = label;
        this.number = number;
    }

    /**
     * Returns the enum constant by taking the given label.
     *
     * @param label The given String that matches one of the categories.
     * @return The enum constant that matches the value of the given label.
     */
    public static ItemCategory valueOfLabel(String label)
    {
        return BY_LABEL.get(label);
    }

    /**
     * Returns the enum constant by taking the given number.
     *
     * @param number The given Integer that matches one of the categories.
     * @return The enum constant that matches the value of the given number.
     */
    public static ItemCategory valueOfNumber(Integer number)
    {
        return BY_NUMBER.get(number);
    }

    /**
     * Returns the label of an item category as text (String).
     *
     * @return the label of an item category, as a String.
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Returns the number associated with the enum constant, as a whole number (int).
     *
     * @return the number associated with the enum constant, as an int.
     */
    public int getNumber()
    {
        return number;
    }
}


