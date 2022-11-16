package iteminformation;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Represents a register of all the items in the warehouse.
 */
public class ItemInventory
{
    /*
    * Mulig løsning på register: Hashmap m/ kategorier som keys
    * og arraylist som verdier. Arraylistene inneholder varer.
    * https://stackoverflow.com/questions/12134687/how-to-add-element-into-arraylist-in-hashmap
    * https://www.javatpoint.com/java-lambda-expressions
    * Kan kanskje leses fra listen med stream.
     */
    /*
    private ArrayList<Item> listOfFloorLaminateItems;
    private ArrayList<Item> listOfWindowItems;
    private ArrayList<Item> listOfDoorItems;
    private ArrayList<Item> listOfLumberItems;
    */

    private TreeSet<Item> listOfFloorLaminateItems;
    private TreeSet<Item> listOfWindowItems;
    private TreeSet<Item> listOfDoorItems;
    private TreeSet<Item> listOfLumberItems;

    private TreeMap<Integer, ArrayList<Item>> inventory;

    // Se på bluej chapter 5 music-organizer
    public ItemInventory()
    {
        /*
        listOfFloorLaminateItems = new ArrayList<>();
        listOfWindowItems = new ArrayList<>();
        listOfDoorItems = new ArrayList<>();
        listOfLumberItems = new ArrayList<>();
        */

        inventory = new TreeMap<>();

    }

}


