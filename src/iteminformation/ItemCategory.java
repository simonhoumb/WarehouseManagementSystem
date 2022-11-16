package iteminformation;

import java.util.HashMap;

//https://www.baeldung.com/java-enum-values <---- fjern!!
public enum ItemCategory
{
    FLOOR_LAMINATES("Floor Laminates", 1),
    WINDOWS("Windows", 2),
    DOORS("Doors", 3),
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

    private ItemCategory(String label, Integer number)
    {
        this.label = label;
        this.number = number;
    }

    public static ItemCategory valueOfLabel(String label)
    {
        return BY_LABEL.get(label);
    }

    public static ItemCategory valueOfNumber(Integer number)
    {
        return BY_NUMBER.get(number);
    }

    /**
     * Returns the label of an item category as text (String).
     *
     * @return the label of an item category as a String.
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Returns the number associated with the category as a whole number (int).
     *
     * @return the number associated with the category as an int.
     */
    public int getNumber()
    {
        return number;
    }
}


