import java.util.Scanner;
public class RestaurantBillingSystem {
    public static void main(String[] args) {

        // Menu items and prices for food and drinks
        String[] foodItems = { "PULAO", "CHICKEN-THALI", "VEG-THALI", "CHICKEN BIRYANI", "CHICKEN SHAWARMA", "PIZZA", "PANEER CHILLI", "CHICKEN-NOODLES", "VEG-NOODLES", "SALAD" };
        double[] foodPrices = { 120, 250, 170, 180, 100, 130, 100, 140, 120, 90 };
        String[] drinkItems = { "Thumbs-Up", "Pepsi", "Sprite", "Fanta", "7UP" };
        double[] drinkPrices = { 50, 50, 50, 50, 50 };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Restaurant Billing System!\n");

        // Display the menu items with their prices using simple for loop
        System.out.println("Please select from the following food items by entering the corresponding code:");
        for (int i = 0; i < foodItems.length; i++) {
            System.out.println("\t" + (i+1) + " - " + foodItems[i] + "       (Rs. " + foodPrices[i] + ")"); // (i+1) to avoid another unneccssary i increment
        }
        System.out.println("\nPlease select from the following drinks by entering the corresponding code:");
        for (int i = 0; i < drinkItems.length; i++) {
            System.out.println("\t" + (i+11) + " - " + drinkItems[i] + "      (Rs. " + drinkPrices[i] + ")");
        }
        System.out.println("\nEnter 0 to exit the menu.");

        // Initialize variables for order taking and receipt generation
        double totalBill = 0.0;
        String orderedItems = "";
        int itemCount = 0;

        while(true) {
            // Prompt the user for the item code and quantity of each food/drink item everytime until its 0
            System.out.print("\nEnter the code of the food item/drink you would like to order (0 to exit): ");
            int itemCode = scanner.nextInt();

            if(itemCode == 0) {
                break;  // Exit the order taking loop bcoz there is no item in bill
            }

            int qty;
            double itemPrice = 0.0;
            String itemName;

            // Determine the item name and price based on the item code, and obtain the quantity from the user
            if (itemCode >= 1 && itemCode <= 10) {  // Food item codes
                itemName = foodItems[itemCode - 1];
                itemPrice = foodPrices[itemCode - 1];
            } else if (itemCode >= 11 && itemCode <= 15) {  // drink item codes assigned
                itemName = drinkItems[itemCode - 11]; // doing this drinks start from 11
                itemPrice = drinkPrices[itemCode - 11];
            } else {
                System.out.println("Invalid code. Try again!");
                continue;  // Repeat to take  order taking loop if the item code is invalid or if some error
            }

            System.out.print("Enter the quantity: ");
            qty = scanner.nextInt();

            // Add the item and quantity to the orderedItems string to add amount in one go
            String orderedItem = itemName + " x " + qty + "\n";
            orderedItems += orderedItem;
            itemCount += qty; // to tell the total quantity if food ordered in your receipt

            // Add the item price times the quantity to the total bill
            totalBill += (itemPrice * qty);
            System.out.println(orderedItem + " added to your order!\n");
        }

        // Print a message indicating that the order is being prepared
        System.out.println("\nOrder received successfully. Please wait while we prepare your order...");
        try {
            Thread.sleep(5000); // Showing preparation with a 5-second delay to show that it takes time to prepare food
        } catch (InterruptedException e) {
            System.out.println(e);// if somethings happen
        }

        // Generate and print a receipt for the ordered items, item quantities, and total bill
        if (totalBill > 0.0) {
            System.out.println("\n\n-----------------------------");
            System.out.println("\t     Receipt");
            System.out.println("-----------------------------");
            System.out.print(orderedItems);
            System.out.println("-----------------------------");
            System.out.println("Number of items: " + itemCount);
            System.out.println("Total Bill: Rs. " + String.format("%.2f", totalBill));
            System.out.println("-----------------------------");
        } else {
            System.out.println("\nNo items ordered.");
        }

        System.out.println("\nThank you for visiting our restaurant!\n\nPlease Visit Again !");
    }
}