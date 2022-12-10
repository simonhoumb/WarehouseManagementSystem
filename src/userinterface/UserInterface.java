package userinterface;

import iteminformation.Item;
import iteminformation.ItemCategory;
import iteminformation.ItemInventory;
import java.util.ArrayList;
import java.util.Iterator;
import utility.Capitalize;
import utility.ErrorMessage;
import utility.InputReader;

/**
 * Represents the user interface of the Warehouse Management System.
 * Here the user can choose what action they wish to perform.
 *
 * @author Simon Husås Houmb
 * @version 1.0 (2022-12-10)
 */
public class UserInterface
{
    private ItemInventory inventory;
    private InputReader userInput;
    private Capitalize capitalizeInput;
    private ErrorMessage printErrorMessage;

    private static final int SHOW_ITEMS = 1;
    private static final int SEARCH = 2;
    private static final int ADD_NEW_ITEM = 3;
    private static final int INCREASE_AMOUNT_OF_ITEM = 4;
    private static final int DECREASE_AMOUNT_OF_ITEM = 5;
    private static final int REMOVE_ITEM = 6;
    private static final int CHANGE_INFORMATION_OF_ITEM = 7;
    private static final int EXIT = 8;
    private static final int CHANGE_ITEM_NAME = 1;
    private static final int CHANGE_ITEM_PRICE = 2;
    private static final int CHANGE_ITEM_DESCRIPTION = 3;

    /**
     * Creates an instance of the UserInterface.
     */
    public UserInterface()
    {
        this.userInput = new InputReader();
        this.inventory = new ItemInventory();
        this.capitalizeInput = new Capitalize();
        this.printErrorMessage = new ErrorMessage();
    }

    /**
     * The main loop of the program. It waits for the users input according to what action they
     * wish to perform.
     * This is where the user returns until they decide to exit the program.
     */
    public void startMenu()
    {
        boolean quit = false;
        int menuSelection;

        while (!quit)
        {
            printStartMenu();
            menuSelection =  userInput.readIntInput();
            switch (menuSelection)
            {
                case SHOW_ITEMS -> printInventory();
                case SEARCH -> searchInventory();
                case ADD_NEW_ITEM -> addItem();
                case INCREASE_AMOUNT_OF_ITEM -> increaseItemAmount();
                case DECREASE_AMOUNT_OF_ITEM -> decreaseItemAmount();
                case REMOVE_ITEM -> removeItem();
                case CHANGE_INFORMATION_OF_ITEM -> changeItemInformationMenu();
                case EXIT ->
                {
                    System.out.println("Are you sure you wish to exit? (y/n)");
                    quit = userInput.readYesNoAnswer();
                }
                default -> printErrorMessage.startMenuSelectionError();
            }
        }
        System.out.println("The program is shutting down...");
    }

    /**
     * Shows a menu for the user to choose what action to perform.
     */
    public void printStartMenu()
    {
        System.out.println(String.join("\n", "",
            "Welcome to The Warehouse Management System! Choose an option:",
            "[1] Show all items in the warehouse",
            "[2] Search after an item using the item number/item description",
            "[3] Add a new item to warehouse inventory",
            "[4] Increase the amount of an item in the warehouse inventory",
            "[5] Decrease the amount of an item in the warehouse inventory",
            "[6] Remove an item from the warehouse inventory",
            "[7] Change discount, price and/or description of an item",
            "[8] Exit App"));
    }

    /**
     * Prints a list of all the Items in the ItemInventory.
     */
    public void printInventory()
    {
        int idColumnWidth = 15;
        int nameColumnWidth = 15;
        int categoryColumnWidth = 15;
        int amountColumnWidth = 19;

        Iterator<Item> inventoryIterator = this.inventory.getInventoryIterator();
        // https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html <- fjern!
        String format = "%" + -idColumnWidth + "s | %" + -nameColumnWidth + "s | %"
            + -categoryColumnWidth + "s | %" + -amountColumnWidth + "s%n";
        System.out.println("Inventory:");
        System.out.printf(format, "Item ID", "Name", "Category",
            "Amount in warehouse");
        boolean goBack = false;
        while (inventoryIterator.hasNext())
        {
            Item item = inventoryIterator.next();
            System.out.printf(format, item.getItemIdNumber(),
                item.getItemBrandName(),
                ItemCategory.valueOfNumber(item.getItemCategory()).getLabel(),
                item.getItemAmountInWarehouse());
        }
        do
        {
            System.out.println("Do you wish to go back to the main menu? (y/n)");
            goBack = userInput.readYesNoAnswer();

        } while (!goBack);

    }

    /**
     * Prints the information of a given Item.
     *
     * @param itemToPrintOut The Item to print the information of.
     */
    public void printItemInformation(Item itemToPrintOut)
    {
        System.out.println(
            "Item ID: " + itemToPrintOut.getItemIdNumber() + "\n"
                + "Description: " + itemToPrintOut.getItemDescription() + "\n"
                + "Price: " + itemToPrintOut.getItemPrice() + " kr" + "\n"
                + "Name: " + itemToPrintOut.getItemBrandName() + "\n"
                + "Weight: " + itemToPrintOut.getItemWeight() + " kg" + "\n"
                + "Length: " + itemToPrintOut.getItemLength() + " mm" + "\n"
                + "Width: " + itemToPrintOut.getItemWidth() + " mm" + "\n"
                + "Color: " + itemToPrintOut.getItemColor() + "\n"
                + "Amount in warehouse: " + itemToPrintOut.getItemAmountInWarehouse() + "\n"
                + "Category: "
                + ItemCategory.valueOfNumber(itemToPrintOut.getItemCategory()).getLabel());
    }

    /**
     * Creates and adds a new Item to the ItemInventory by taking input from the user.
     */
    public void addItem()
    {
        boolean continueAdding = false;
        boolean confirmedAdd = false;
        String idNumberOfItemToAdd;
        String descriptionOfItemToAdd;
        int priceOfItemToAdd;
        String brandNameOfItemToAdd;
        float weightOfItemToAdd;
        float lengthOfItemToAdd;
        float widthOfItemToAdd;
        String colorOfItemToAdd;
        int amountOfItemToAdd;
        Integer categoryOfItemToAdd;
        boolean idTaken;
        do
        {
            do
            {
                do
                {
                    System.out.println("ID number of item:");
                    idNumberOfItemToAdd = userInput.readStringInput();
                    idTaken = inventory.containsItem(idNumberOfItemToAdd);
                    if (idTaken)
                    {
                        printErrorMessage.itemIdAlreadyExistsError();
                    }
                } while (idTaken);
                System.out.println("Item description:");
                descriptionOfItemToAdd = userInput.readStringInput();
                System.out.println("Price of Item (kr):");
                priceOfItemToAdd = userInput.readPositiveIntInput();
                System.out.println("Item brand name:");
                brandNameOfItemToAdd = userInput.readStringInput();
                brandNameOfItemToAdd = capitalizeInput.capitalizeString(brandNameOfItemToAdd);
                System.out.println("Weight of item (kg):");
                weightOfItemToAdd = userInput.readPositiveFloatInput();
                System.out.println("Length of item (mm):");
                lengthOfItemToAdd = userInput.readPositiveFloatInput();
                System.out.println("Width of item (mm):");
                widthOfItemToAdd = userInput.readPositiveFloatInput();
                System.out.println("Color of item:");
                colorOfItemToAdd = userInput.readOnlyLetterStringInput();
                colorOfItemToAdd = capitalizeInput.capitalizeString(colorOfItemToAdd);
                System.out.println("The amount of the item in the warehouse:");
                amountOfItemToAdd = userInput.readPositiveIntInput();
                System.out.println(String.join("\n",
                        "The category of the item:",
                        "[1] Floor Laminates",
                        "[2] Windows",
                        "[3] Doors",
                        "[4] Lumber"));
                categoryOfItemToAdd = userInput.readCategoryInput();

                System.out.println(
                      "Item ID: " + idNumberOfItemToAdd + "\n"
                    + "Description: " + descriptionOfItemToAdd + "\n"
                    + "Price: " + priceOfItemToAdd + " kr" + "\n"
                    + "Name: " + brandNameOfItemToAdd + "\n"
                    + "Weight: " + weightOfItemToAdd + " kg" + "\n"
                    + "Length: " + lengthOfItemToAdd + " mm" + "\n"
                    + "Width: " + widthOfItemToAdd + " mm" + "\n"
                    + "Color: " + colorOfItemToAdd + "\n"
                    + "Amount in warehouse: " + amountOfItemToAdd + "\n"
                    + "Category: " + ItemCategory.valueOfNumber(categoryOfItemToAdd).getLabel());
                System.out.println("\n" + "Is this right? (y/n)");
                confirmedAdd = userInput.readYesNoAnswer();
            } while (!confirmedAdd);
            Item itemToAdd = new Item(idNumberOfItemToAdd, descriptionOfItemToAdd,
                priceOfItemToAdd, brandNameOfItemToAdd, weightOfItemToAdd, lengthOfItemToAdd,
                widthOfItemToAdd, colorOfItemToAdd, amountOfItemToAdd, categoryOfItemToAdd);
            inventory.addItemToInventory(itemToAdd);

            System.out.println("Do you wish to add another item? (y/n)");
            continueAdding = userInput.readYesNoAnswer();
        } while (continueAdding);
    }

    /**
     * Removes an Item from the ItemInventory by using the Item ID.
     */
    public void removeItem()
    {
        System.out.println("Enter the ID number of the item you want removed from the warehouse");
        String itemId = userInput.readStringInput();
        if (inventory.containsItem(itemId))
        {
            System.out.println("Are you sure you wish to remove " + itemId + "? (y/n)");
            if (userInput.readYesNoAnswer())
            {
                inventory.removeItemFromInventory(itemId);
                System.out.printf("%s was removed from the warehouse inventory.", itemId);
            }

        } else
        {
            printErrorMessage.itemIdNotFoundError();
        }
    }

    /**
     * Increases the amount of an Item in the warehouse by using the Item ID.
     */
    public void increaseItemAmount()
    {
        int amountToIncrease;
        int previousAmount;
        String itemId;
        System.out.println("Enter the ID of the item you wish to increase the amount of?");
        itemId = userInput.readStringInput();
        if (inventory.containsItem(itemId))
        {
            previousAmount = inventory.getInventory().get(itemId).getItemAmountInWarehouse();
            System.out.printf("The current amount of item %s: %d%n"
                + "Enter the amount you wish to increase:%n", itemId, previousAmount);
            amountToIncrease = userInput.readPositiveIntInput();
            inventory.getInventory().get(itemId)
                .increaseItemAmountInWarehouse(amountToIncrease);
            System.out.printf("Amount of item %s, was increased from %d to %d.", itemId,
                previousAmount,
                previousAmount + amountToIncrease);
        } else
        {
            printErrorMessage.itemIdNotFoundError();
        }

    }

    /**
     * Decreases the amount of an Item in the warehouse by using the Item ID.
     */
    public void decreaseItemAmount()
    {
        int amountToDecrease;
        int previousAmount;
        String itemId;
        System.out.println("Enter the ID of the item you wish to decrease the amount of?");
        itemId = userInput.readStringInput();
        if (inventory.containsItem(itemId))
        {
            previousAmount = inventory.getInventory().get(itemId).getItemAmountInWarehouse();
            System.out.printf("The current amount of item %s: %d%n"
                + "Enter the amount you wish to decrease:%n", itemId, previousAmount);
            amountToDecrease = userInput.readPositiveIntInput();
            if (previousAmount - amountToDecrease >= 0)
            {
                inventory.getInventory().get(itemId)
                    .decreaseItemAmountInWarehouse(amountToDecrease);
                System.out.printf("Amount of item %s, was decreased from %d to %d.", itemId,
                    previousAmount,
                    previousAmount - amountToDecrease);
            } else
            {
                printErrorMessage.itemAmountLessThanZeroError();
            }
        } else
        {
            printErrorMessage.itemIdNotFoundError();
        }
    }

    /**
     * Searches the ItemInventory for an Item by using the user input.
     * It then prints out the information of the found Items.
     */
    public void searchInventory()
    {
        boolean goBack = false;
        int numberOfItemsFound = 0;
        String searchWord;
        ArrayList<Item> itemsFound = new ArrayList<>();
        Iterator<Item> itemIterator = this.inventory.getInventoryIterator();
        do
        {
            System.out.println("Item Search\n"
                + "Please enter a search word. E.g. item ID, description or brand name.");
            searchWord = userInput.readStringInput();
            while (itemIterator.hasNext())
            {
                Item item = itemIterator.next();
                if (item.getItemIdNumber().equalsIgnoreCase(searchWord)
                    || item.getItemDescription().toLowerCase().contains(searchWord.toLowerCase())
                    || item.getItemBrandName().toLowerCase().contains(searchWord.toLowerCase()))
                {
                    numberOfItemsFound++;
                    itemsFound.add(item);
                }
            }
            if (numberOfItemsFound > 0)
            {
                System.out.printf("%d item(s) found:%n", numberOfItemsFound);
                System.out.println("--------------------");
                for (Item itemFound : itemsFound)
                {
                    printItemInformation(itemFound);
                    System.out.println("--------------------");
                }
            } else
            {
                printErrorMessage.itemNotFoundInSearchError();
            }
            System.out.println("Do you wish to go back to the main menu? (y/n)");
            goBack = userInput.readYesNoAnswer();
        } while (!goBack);

    }

    /**
     * Shows the menu where the user can change an Items information. It waits for the users input
     * according to what they wish to change. The options of what to change is the brand name,
     * the price and the description.
     */
    public void changeItemInformationMenu()
    {
        String itemId;
        int menuSelection;
        System.out.println("What item do you wish to change price and/or description of?");
        itemId = userInput.readStringInput();
        if (inventory.containsItem(itemId))
        {
            System.out.println(String.join("\n",
                "What information do you wish to change?",
                "[1] Brand Name",
                "[2] Price",
                "[3] Description"));
            menuSelection = userInput.readIntInput();
            switch (menuSelection)
            {
                case CHANGE_ITEM_NAME -> changeItemBrandName(itemId);
                case CHANGE_ITEM_PRICE -> changeItemPrice(itemId);
                case CHANGE_ITEM_DESCRIPTION -> changeItemDescription(itemId);
                default -> printErrorMessage.itemInformationMenuSelectionError();
            }

        } else
        {
            printErrorMessage.itemIdNotFoundError();
        }
    }

    /**
     * Changes the brand name of an Item to the users input.
     *
     * @param itemId The ID of the Item to change the brand name of.
     */
    public void changeItemBrandName(String itemId)
    {
        String itemName = inventory.getInventory().get(itemId).getItemBrandName();
        System.out.printf("Current name of the item %s: %s%n"
            + "Enter the new name of the item:%n", itemId, itemName);
        String newItemName = userInput.readStringInput();
        newItemName = capitalizeInput.capitalizeString(newItemName);
        inventory.getInventory().get(itemId).setItemBrandName(newItemName);
        System.out.printf("Item %s's name was changed from %s to %s.", itemId, itemName,
            newItemName);
    }

    /**
     * Changes the price of an Item to the users input.
     *
     * @param itemId The ID of the Item to change the price of.
     */
    public void changeItemPrice(String itemId)
    {
        int itemPrice = inventory.getInventory().get(itemId).getItemPrice();
        System.out.printf("Current price of item %s: %s%n"
            + "Enter the new price of the item:%n", itemId, itemPrice);
        int newItemPrice = userInput.readPositiveIntInput();
        inventory.getInventory().get(itemId).setItemPrice(newItemPrice);
        System.out.printf("Item %s's price was changed from %s to %s.", itemId, itemPrice,
            newItemPrice);
    }

    /**
     * Changes the description of an Item to the users input.
     *
     * @param itemId The ID of the Item to change the description of.
     */
    public void changeItemDescription(String itemId)
    {
        String itemDescription = inventory.getInventory().get(itemId).getItemDescription();
        System.out.printf("Current Description of item %s: %s%n"
            + "Enter the new price of the item:%n", itemId, itemDescription);
        String newItemDescription = userInput.readStringInput();
        inventory.getInventory().get(itemId).setItemDescription(newItemDescription);
        System.out.printf("Item %s's description was changed.", itemId);
    }
}
