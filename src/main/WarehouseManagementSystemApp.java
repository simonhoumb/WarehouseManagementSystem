package main;

import userinterface.UserInterface;

/**
 * WarehouseManagementSystemApp class that runs the Warehouse Management System.
 *
 * @author Simon Husås Houmb
 * @version 1.0 (2022-12-10)
 */
public class WarehouseManagementSystemApp
{
    /**
     * The main method that runs the WarehouseManagementSystemApp.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args)
    {
        UserInterface appInterface = new UserInterface();
        appInterface.startMenu();
    }
}