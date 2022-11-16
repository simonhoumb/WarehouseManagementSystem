package userinterface;

import java.util.HashMap;

/**
 * Represents the user interface of the Warehouse Management System.
 * Here the user can choose what action they wish to perform.
 */
public class UserInterface
{
    // Kanskje lag hashmap av alle prints med startMenuAnswer som key (altså 1-8)
    String startMenu = String.join("\n",
            "Welcome to The Warehouse Management System! Choose an option:",
            "[1] Show all items in the warehouse",
            "[2] Search after an item using the item number/item description",
            "[3] Add a new item to register/warehouse",
            "[4] Increase the amount of an item in the register/warehouse",
            "[5] Decrease the amount of an item in the register/warehouse",
            "[6] Remove an item from the register/warehouse",
            "[7] Change discount, price and/or description of an item",
            "[8] Exit App");

    String allItemsPage = ("All items in the inventory:");

    String itemSearchPage = String.join("\n",
            "Item Search",
    "Please enter an item number or item description");

    String addNewItemPage = ("New item to add: ");

    String increaseItemAmountPage = ("What item do you wish to increase the amount of?");

    String decreaseItemAmountPage = ("What item do you wish to decrease the amount of?");

    String removeItemPage = ("What item do you wish to remove?");

    String changeItemInfoPage = ("What item do you wish to change price and/or description of?");

    String exitAppPage = ("Are you sure you wish to exit? (y/n)");

    private HashMap<Integer, String> startMenuPages;

    public UserInterface()
    {
        startMenuPages = new HashMap<>();
        startMenuPages.put(1, allItemsPage);
        startMenuPages.put(2, itemSearchPage);
        startMenuPages.put(3, addNewItemPage);
        startMenuPages.put(4, increaseItemAmountPage);
        startMenuPages.put(5, decreaseItemAmountPage);
        startMenuPages.put(6, removeItemPage);
        startMenuPages.put(7, changeItemInfoPage);
        startMenuPages.put(8, exitAppPage);
    }

    /**
     * Shows a menu for the user to choose what action to perform.
     * To choose, the user must enter a number (int) from 1-8 according
     * to the action they wish to perform.
     */
    public void printStartMenu()
    {
        System.out.println(startMenu);
    }

    public void printPage(Integer pageNumber)
    {
        System.out.println(startMenuPages.get(pageNumber));
    }


    


}
