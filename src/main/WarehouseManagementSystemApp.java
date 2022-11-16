package main;

import iteminformation.Item;
import iteminformation.ItemCategory;
import java.util.ArrayList;
import java.util.Scanner;
import userinterface.UserInterface;
import utility.InputReader;


/**
 * WarehouseManagementSystemApp class that runs the Warehouse Management System.
 *
 * @author Simon Husås Houmb
 * @version 0.3 (2022-10-19)
 */
public class WarehouseManagementSystemApp
{
    private UserInterface appInterface;
    private InputReader userInput;

    /**
     *
     */
    public WarehouseManagementSystemApp()
    {
        appInterface = new UserInterface();
        userInput = new InputReader();
    }

    /**
     * Runs the WarehouseManagementSystemApp.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args)
    {
        WarehouseManagementSystemApp warehouseManagementSystem = new WarehouseManagementSystemApp();
        warehouseManagementSystem.appInterface.printStartMenu();
        warehouseManagementSystem.appInterface.printPage(warehouseManagementSystem.userInput.readStartMenuAnswer());

        /*
        Kanskje bruk Comparator class for søking
        (https://www.baeldung.com/java-map-with-case-insensitive-keys)
        (https://www.geeksforgeeks.org/treemap-comparator-method-in-java-with-examples/)

        System.out.println("Category: " + ItemCategory.valueOfLabel("Floor Laminates"));
        System.out.println("Category: " + ItemCategory.valueOfNumber(1));
        System.out.println("Category: " + ItemCategory.valueOfLabel("Doors"));
        System.out.println("Category: " + ItemCategory.valueOfNumber(2));
         */

        /*
        Item item1 = new Item("aa01", 150, "Egger", 73, (byte) 3);
        System.out.println(item1);
         */


    }


    private void exitApp()
    {
        System.exit(0);
    }
}