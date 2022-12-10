package iteminformation;

/**
 * Represents an item in a warehouse. Each item
 * holds some information about that specific item.
 *
 * @author Simon Husås Houmb
 * @version 1.0 (2022-12-10)
 */
public class Item
{
    private String itemIdNumber;
    private String itemDescription;
    private int itemPrice;
    private String itemBrandName;
    private float itemWeight;
    private float itemLength;
    private float itemWidth;
    private String itemColor;
    private int itemAmountInWarehouse;
    private Integer itemCategory;

    /**
     * Creates an item with the specified item number, item description, item price,
     * item brand name, item weight, item length, item width, item color, item amount
     * and item category.
     *
     * @param itemIdNumber number for the new item
     * @param itemDescription description of the new item
     * @param itemPrice price of the new item
     * @param itemBrandName brand name of the new item
     * @param itemWeight weight of the new item
     * @param itemLength length of the new item
     * @param itemWidth width of the new item
     * @param itemColor color of the new item
     * @param itemAmountInWarehouse amount in the warehouse for the new item
     * @param itemCategory category for the new item
     */
    public Item(String itemIdNumber, String itemDescription, int itemPrice, String itemBrandName,
                float itemWeight, float itemLength, float itemWidth, String itemColor,
                int itemAmountInWarehouse, Integer itemCategory)
    {
        this.itemIdNumber = itemIdNumber;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.itemBrandName = itemBrandName;
        this.itemWeight = itemWeight;
        this.itemLength = itemLength;
        this.itemWidth = itemWidth;
        this.itemColor = itemColor;
        this.itemAmountInWarehouse = itemAmountInWarehouse;
        this.itemCategory = itemCategory;
    }


    /**
     * Returns the number of a given item as a text
     * (String). The returned string consists of both
     * digits and letters.
     *
     * @return the number of the item as a String.
     */
    public String getItemIdNumber()
    {
        return itemIdNumber;
    }

    /**
     * Sets the item number of an item to the new item
     * number provided.
     *
     * @param newItemNumber the new item number to be set.
     */
    public void setItemIdNumber(String newItemNumber)
    {
        this.itemIdNumber = newItemNumber;
    }

    /**
     * Returns the description of a given item as a text
     * (String).
     *
     * @return the description of an item as a String.
     */
    public String getItemDescription()
    {
        return itemDescription;
    }

    /**
     * Sets the description of an item to the new description
     * provided.
     *
     * @param newItemDescription the new item description to be set.
     */
    public void setItemDescription(String newItemDescription)
    {
        this.itemDescription = newItemDescription;
    }

    /**
     * Returns the price of an item as a whole number
     * (int).
     *
     * @return the price of an item as an int.
     */
    public int getItemPrice()
    {
        return itemPrice;
    }

    /**
     * Sets the price of an item to the new price
     * provided.
     *
     * @param newItemPrice the new item price to be set.
     */
    public void setItemPrice(int newItemPrice)
    {
        this.itemPrice = newItemPrice;
    }

    /**
     * Returns the brand name of an item as a text
     * (String).
     *
     * @return the brand name of an item as a String.
     */
    public String getItemBrandName()
    {
        return itemBrandName;
    }

    /**
     * Sets the brand name of an item to the new brand
     * name provided.
     *
     * @param newItemBrandName the new item brand name to be set.
     */
    public void setItemBrandName(String newItemBrandName)
    {
        this.itemBrandName = newItemBrandName;
    }

    /**
     * Returns the weight of an item as a decimal
     * (float).
     *
     * @return the weight of an item as a float.
     */
    public float getItemWeight()
    {
        return itemWeight;
    }

    /**
     * Sets the weight of an item to the new weight
     * provided.
     *
     * @param newItemWeight the new item weight to be set.
     */
    public void setItemWeight(float newItemWeight)
    {
        this.itemWeight = newItemWeight;
    }

    /**
     * Returns the length of an item as a decimal
     * (float).
     *
     * @return the length of an item as a float.
     */
    public float getItemLength()
    {
        return itemLength;
    }

    /**
     * Sets the length of an item to the new length
     * provided.
     *
     * @param newItemLength the new item length to be set.
     */
    public void setItemLength(float newItemLength)
    {
        this.itemLength = newItemLength;
    }

    /**
     * Returns the width of an item as a decimal
     * (float).
     *
     * @return the width of an item as a float.
     */
    public float getItemWidth()
    {
        return itemWidth;
    }

    /**
     * Sets the width of an item to the new width
     * provided.
     *
     * @param newItemWidth the new item width to be set.
     */
    public void setItemWidth(float newItemWidth)
    {
        this.itemWidth = newItemWidth;
    }

    /**
     * Returns the color of an item as a text
     * (String).
     *
     * @return the color of an item as a String
     */
    public String getItemColor()
    {
        return itemColor;
    }

    /**
     * Sets the color of an item to the new color
     * provided.
     *
     * @param newItemColor the new item color to be set.
     */
    public void setItemColor(String newItemColor)
    {
        this.itemColor = newItemColor;
    }

    /**
     * Returns the amount of an item in a warehouse
     * as a whole number (int).
     *
     * @return the amount of an item in a warehouse as an int.
     */
    public int getItemAmountInWarehouse()
    {
        return itemAmountInWarehouse;
    }

    /**
     * Sets the amount of an item in a warehouse to
     * the new amount provided.
     *
     * @param newItemAmountInWarehouse the new item amount to be set.
     */
    public void setItemAmountInWarehouse(int newItemAmountInWarehouse)
    {
        this.itemAmountInWarehouse = newItemAmountInWarehouse;
    }

    /**
     * Increases the amount of an item in the warehouse.
     *
     * @param amountToAdd The amount of an item to be added to the warehouse.
     */
    public void increaseItemAmountInWarehouse(int amountToAdd)
    {
        this.itemAmountInWarehouse += amountToAdd;
    }

    /**
     * Decreases the amount of an item in the warehouse.
     *
     * @param amountToSubtract The amount of an item to be subtracted from the warehouse.
     */
    public void decreaseItemAmountInWarehouse(int amountToSubtract)
    {
        this.itemAmountInWarehouse -= amountToSubtract;
    }

    /**
     * Returns the category of an item.
     *
     * @return the category of an item as an Integer.
     */
    public Integer getItemCategory()
    {
        return itemCategory;
    }

    /**
     * Sets the category of an item to a new category
     * provided.
     *
     * @param newItemCategory the new category to be set.
     */
    public void setItemCategory(Integer newItemCategory)
    {
        this.itemCategory = newItemCategory;
    }
}