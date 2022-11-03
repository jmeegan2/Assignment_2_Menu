import java.util.*;

public class Client {

    public static final int min = 0;
    public static final int max = 8;
    public static void main(String[] args) {
        Menu eatAtJoesMenu = new Menu();
        //Scanner used for detecting user input
        Scanner input = new Scanner(System.in);
        int choice;
        MenuIterator itr;
        //New menu with items created
        newMenuCreated(eatAtJoesMenu);
        //min and max in this case will be 0 and 8 for the choices available
        choice = menu(input, min, max);

        //While the choice given from the user is valid continue to run while loop
        while (choice != 0) {
            String name;
            int category;
            String ans;
            double price;
            switch (choice) {
                //Case 1 will iterate over all the items in the menu and display them
                case 1:
                    MenuItem item;
                    itr = eatAtJoesMenu.getAllItemsIterator();
                    System.out.println("\tALL MENU ITEMS");
                    while (itr.hasNext()) {
                        item = itr.next();
                        System.out.println("\t" + item.getItemName() + " $" + item.getPrice());
                    }
                    break;
                //Case 2 will iterate over all appetizers and display them
                case 2:
                    MenuItem appItem;
                    itr = eatAtJoesMenu.getItemIterator(Menu.APPETIZERS);
                    System.out.println("\tAPPETIZERS");
                    while (itr.hasNext()) {
                        appItem = itr.next();
                        if (appItem.getCategory() == Menu.APPETIZERS)
                            System.out.println("\t" + appItem.getItemName() + " $" + appItem.getPrice());
                    }
                    break;
                //Case 3 will iterate over all appetizers and display them
                case 3:
                    MenuItem mainDish;
                    itr = eatAtJoesMenu.getItemIterator(Menu.MAIN_DISH);
                    System.out.println("\tMAIN DISHES");
                    while (itr.hasNext()) {
                        mainDish = itr.next();
                        if (mainDish.getCategory() == Menu.MAIN_DISH)
                            System.out.println("\t" + mainDish.getItemName() + " $" + mainDish.getPrice());
                    }
                    break;
                //Case 4 will iterate over all dessert items and display them
                case 4:
                    MenuItem desertItem;
                    itr = eatAtJoesMenu.getItemIterator(Menu.DESSERT);
                    System.out.println("\tDESSERTS");
                    while (itr.hasNext()) {
                        desertItem = itr.next();
                        if (desertItem.getCategory() == Menu.DESSERT)
                            System.out.println("\t" + desertItem.getItemName() + " $" + desertItem.getPrice());
                    }
                    break;
                //Case 5 will iterate over all the heart healthy items and display them
                case 5:
                    itr = eatAtJoesMenu.getHeartHealthyIterator();
                    System.out.println("\tHEART HEALTHY ITEMS");
                    while (itr.hasNext()) {
                        item = itr.next();
                        if (item.getHeartHealthy())
                            System.out.println("\t" + item.getItemName() + " $" + item.getPrice());
                    }
                    break;
                //Case 6 will iterate over items under a specific price and display them along with what
                //the specific price under that the items are
                case 6:
                    double specificPrice;
                    System.out.print("\tEnter price: ");
                    specificPrice = getDouble(input, 0, 10000);
                    itr = eatAtJoesMenu.getPriceIterator(specificPrice);
                    //Shows the price that the main dish items are under
                    System.out.println("\tAll ITEMS UNDER $" + specificPrice);
                    while (itr.hasNext()) {
                        mainDish = itr.next();
                        if (mainDish.getPrice() <= specificPrice && mainDish.getCategory() == Menu.MAIN_DISH)
                            System.out.println("\t" + mainDish.getItemName() + " $" + mainDish.getPrice());
                    }
                    break;
                //Case 7 adds the menuItem to the menu
                case 7:
                    System.out.print("\tEnter the name of item: ");
                    name = input.next();
                    System.out.println

                                    ("\t1 - APPETIZERS\n" +
                                    "\t2 - Main Dish\n" +
                                    "\t3 - Desert\n" +
                                    "\tChoose the category of the item:");

                    category = getInt(input, 1, 3);
                    System.out.print("\tEnter the price: ");
                    price = getDouble(input, 0, 10000);
                    System.out.print("\tIs it a heart healthy item? (type yes/no) : ");
                    ans = input.next().toLowerCase();
                    if (ans.equals("yes"))
                        eatAtJoesMenu.add(new MenuItem(name, category, true, price));
                    else if (ans.equals("no"))
                        eatAtJoesMenu.add(new MenuItem(name, category, false, price));
                    else {
                        System.out.println("\tInvalid.");
                        choice = menu(input, min, max);
                    }
                    break;
                    //This will delete the users choice
                case 8:
                    System.out.println("\tEnter the name of item: ");
                    name = input.next();
                    //if this function returns true it will delete the menu item
                    if (eatAtJoesMenu.searchItem(name) == true) {
                        System.out.println("\tItem has been removed.");
                    } else {
                        System.out.println("\tError, Could not find item.");
                        choice = menu(input, min, max);
                    }


            }
            choice = menu(input, min, max);
        }

        System.out.println("Menu Terminated");
    }
    //Menu that displays the options.
    public static int menu(Scanner input, int min, int max) {
        int ans;
        System.out.println

                ("\t--------------------------------------------------------\n" +
                        "\t1 – Display all menu items\n" +
                        "\t2 – Display all appetizers\n" +
                        "\t3 – Display all main dishes\n" +
                        "\t4 – Display all desserts\n" +
                        "\t5 – Display all heart healthy items\n" +
                        "\t6 – Display all main dishes under a specified price\n" +
                        "\t7 - Add items to menu\n" +
                        "\t8 - Remove items from menu\n" +
                        "\t0 - Terminate menu\n" +
                        "\t--------------------------------------------------------\n");

        System.out.print("\tEnter your choice: ");;
        ans = getInt(input, min, max);
        return ans;
    }
    //Input validation for integer choices.
    public static int getInt(Scanner input, int min, int max) {
        while (!input.hasNextInt()) {
            System.out.println("Invalid.");
            input.next();
        }
        int choice = input.nextInt();
        if (choice < min || choice > max) {
            System.out.println("Invalid range.");
            choice = getInt(input, min, max);
        }
        System.out.println("\t--------------------------------------------------------");
        return choice;
    }
    //input validation for double.
    public static double getDouble(Scanner input, int min, int max) {
        while (!input.hasNextDouble()) {
            System.out.println("Invalid");
            input.next();
        }
        double choice = input.nextDouble();
        if (choice < min || choice > max) {
            System.out.println("Invalid range.");
            choice = getDouble(input, min, max);
        }
        return choice;
    }
    // function to create menu with items
    public static void newMenuCreated(Menu menu) {
        menu.add(new MenuItem("Lamb Chop", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 14.99));
        menu.add(new MenuItem("Pork Shoulder", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 12.49));
        menu.add(new MenuItem("Buffalo Short Rib", Menu.MAIN_DISH, Menu.NOT_HEART_HEALTHY, 22.99));
        menu.add(new MenuItem("Mashed Potatoes", Menu.APPETIZERS, Menu.NOT_HEART_HEALTHY, 4.99));
        menu.add(new MenuItem("Asparagus", Menu.APPETIZERS, Menu.HEART_HEALTHY, 1.99));
        menu.add(new MenuItem("Kale Chips", Menu.APPETIZERS, Menu.HEART_HEALTHY, 11.99));
        menu.add(new MenuItem("Local Ice cream", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, 7.99));
        menu.add(new MenuItem("Crème brûlée", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, 7.99));
        menu.add(new MenuItem("Tiramisu Layer Cake", Menu.DESSERT, Menu.NOT_HEART_HEALTHY, 4.99));
        menu.add(new MenuItem("2 parts hydrogen 1 part oxygen", Menu.DESSERT, Menu.HEART_HEALTHY, 1.99));


    }
}
