package iteminformation;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * Represents an inventory of all the items in the warehouse.
 *
 * @author Simon Husås Houmb
 * @version 1.0 (2022-12-10)
 */
public class ItemInventory
{
    /*
    * https://www.javatpoint.com/java-lambda-expressions <-fjern
    */

    private TreeMap<String, Item> inventory;

    /**
     * Creates an instance of the ItemInventory.
     */
    public ItemInventory()
    {
        this.inventory = new TreeMap<>();
    }

    /**
     * Adds an Item to the ItemInventory.
     *
     * @param itemToAdd The Item to be added to the ItemInventory.
     */
    public void addItemToInventory(Item itemToAdd)
    {
        inventory.put(itemToAdd.getItemIdNumber(), itemToAdd);
    }

    /**
     * Removes an Item from the ItemInventory.
     *
     * @param itemIdOfItemToRemove The Item to be removed from the ItemInventory.
     */
    public void removeItemFromInventory(String itemIdOfItemToRemove)
    {
        inventory.remove(itemIdOfItemToRemove);
    }

    /**
     * Returns the ItemInventory.
     *
     * @return A TreeMap of the ItemInventory.
     */
    public TreeMap<String, Item> getInventory()
    {
        return this.inventory;
    }

    /**
     * Returns an Iterator to iterate over the ItemInventory.
     *
     * @return An Iterator that iterates over the ItemInventory.
     */
    public Iterator<Item> getInventoryIterator()
    {
        return this.inventory.values().iterator();
    }

    /**
     * Checks if the ItemInventory already contains a given itemId.
     *
     * @param itemId The itemId to check.
     * @return If the given itemId already exists in the ItemInventory, as a boolean.
     */
    public boolean containsItem(String itemId)
    {
        return (this.inventory.containsKey(itemId));
    }
}


