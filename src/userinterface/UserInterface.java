package userinterface;

import iteminformation.Item;
import java.util.HashMap;
import utility.InputReader;

/**
 * Represents the user interface of the Warehouse Management System.
 * Here the user can choose what action they wish to perform.
 */
public class UserInterface
{
    private InputReader userInput;

    // Kanskje lag hashmap av alle prints med startMenuAnswer som key (altså 1-8)
    String startMenu = String.join("\n", "",
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

    // HashMap kan fjernes fordi jeg bruker switch case
    private HashMap<Integer, String> startMenuPages;

    public UserInterface()
    {
        userInput = new InputReader();

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

    public void startMenu()
    {
        boolean quit = false;
        int menuSelection = 0;

        while (!quit)
        {
            printStartMenu();
            menuSelection =  userInput.readStartMenuAnswer();
            printPage(menuSelection);
            switch (menuSelection)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    addItem();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    quit = userInput.readYesNoAnswer();
                    break;
                default:
            }
        }
        System.out.println("The program is shutting down...");
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

    public void addItem()
    {
        boolean continueAdding = false;
        boolean confirmedAdd = false;
        String idNumberOfItemToAdd = "";
        String descriptionOfItemToAdd = "";
        int priceOfItemToAdd = 0;
        String brandNameOfItemToAdd = "";
        float weightOfItemToAdd = 0.0f;
        float lengthOfItemToAdd = 0.0f;
        float widthOfItemToAdd = 0.0f;
        String colorOfItemToAdd = "";
        int amountOfItemToAdd = 0;
        byte categoryOfItemToAdd = 0;
        do
        {
            do
            {
                System.out.println("ID number of item:");
                idNumberOfItemToAdd = userInput.readStringInput();
                System.out.println("Item description:");
                descriptionOfItemToAdd = userInput.readStringInput();
                System.out.println("Price of Item:");
                priceOfItemToAdd = userInput.readIntInput();
                System.out.println("Item brand name:");
                brandNameOfItemToAdd = userInput.readStringInput();
                System.out.println("Weight of item:");
                weightOfItemToAdd = userInput.readFloatInput();
                System.out.println("Length of item:");
                lengthOfItemToAdd = userInput.readFloatInput();
                System.out.println("Width of item:");
                widthOfItemToAdd = userInput.readFloatInput();
                System.out.println("Color of item:");
                colorOfItemToAdd = userInput.readStringInput();
                System.out.println("The amount of the item in the warehouse:");
                amountOfItemToAdd = userInput.readIntInput();
                System.out.println(String.join("\n",
                        "The category of the item:",
                        "[1] Floor Laminates",
                        "[2] Windows",
                        "[3] Doors",
                        "[4] Lumber"));
                categoryOfItemToAdd = userInput.readByteInput();

                System.out.println("\n" + "Is this right?");
                System.out.println(
                      idNumberOfItemToAdd + "\n"
                    + descriptionOfItemToAdd + "\n"
                    + priceOfItemToAdd + "\n"
                    + brandNameOfItemToAdd + "\n"
                    + weightOfItemToAdd + "\n"
                    + lengthOfItemToAdd + "\n"
                    + widthOfItemToAdd + "\n"
                    + colorOfItemToAdd + "\n"
                    + amountOfItemToAdd + "\n"
                    + categoryOfItemToAdd);
                confirmedAdd = userInput.readYesNoAnswer();
            } while (!confirmedAdd);
            Item itemToAdd = new Item(idNumberOfItemToAdd, descriptionOfItemToAdd,
                priceOfItemToAdd, brandNameOfItemToAdd, weightOfItemToAdd, lengthOfItemToAdd,
                widthOfItemToAdd, colorOfItemToAdd, amountOfItemToAdd, categoryOfItemToAdd);

            System.out.println("Do you wish to add another item? (y/n)");
            continueAdding = userInput.readYesNoAnswer();
        } while (continueAdding);
    }

    


}
