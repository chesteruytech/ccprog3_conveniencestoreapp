import java.lang.System;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Represents a listed item of the product.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
class Product{
    private String name;
    protected String category;
    private String brand;
    private String variant;
    private float price;
    private int quantity;

    /*
     * Stores the product information. A product should have five (5) key
     * fields before listing the item.
     *
     * @param  name     the name of the particular product
     * @param  brand    the brand of the particular product
     * @param  variant  type of purpose in the particular product
     * @param  quantity product's current availability stock
     * @param  price    cost of the price that the customer needs to pay
     */
    public Product(String name, String brand, String variant, int quantity, float price){
        this.name = name;
        this.brand = brand;
        this.variant = variant;
        this.quantity = quantity;
        this.price = price;
    }

    /*
     * Registers the text to the Command Prompt to display the product
     * information. Each printed line releases the output of these key
     * fields.
     */
    public void showProductInformation(){
        System.out.println(name);
        System.out.println(category);
        System.out.println(brand);
        System.out.println(variant);
        System.out.println(quantity);
        System.out.println(price);
    }

    /*
     * Retrieves the registered price of the product listed by
     * the Employee.
     *
     * @return the value of float price of the product
     */
    public float getPrice(){
        return price;
    }

    /*
     * Retrieves the registered name of the product listed by
     * the Employee.
     *
     * @return the value of String name of the product
     */
    public String getName(){
        return name;
    }

//    public String getCategory(){
//        return category;
//    }

    /*
     * Retrieves the registered brand of the product listed by
     * the Employee.
     *
     * @return the value of String brand of the product
     */
    public String getBrand(){
        return brand;
    }

    /*
     * Retrieves the registered variant of the product listed by
     * the Employee.
     *
     * @return the value of String variant of the product
     */
    public String getVariant(){
        return variant;
    }

    /*
     * Retrieves the registered quantity of the product listed by
     * the Employee.
     *
     * @return the value of int quantity of the product
     */
    public int getQuantity(){
        return quantity;
    }

    /*
     * Updates the values of the product information. One and any of
     * the key fields may update just by taking the setValues()
     * parameters and assign it to the same set of attributes.
     *
     * @param  name     the name of the particular product
     * @param  brand    the brand of the particular product
     * @param  variant  type of purpose in the particular product
     * @param  quantity product's current availability stock
     * @param  price    cost of the price that the customer needs to pay
     */
    public void setValues(String name, String brand, String variant, int quantity, float price){
        this.name = name;
        this.brand = brand;
        this.variant = variant;
        this.quantity = quantity;
        this.price = price;
    }
}

/*
 * Filters the product into categories by Food.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
class Food extends Product{
    public Food(String name, String brand, String variant, int quantity, float price){
        super(name, brand, variant, quantity, price);
        this.category = "Food";
    }
}

/*
 * Filters the product into categories by Beverages.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
class Beverages extends Product{
    public Beverages(String name, String brand, String variant, int quantity, float price){
        super(name, brand, variant, quantity, price);
        this.category = "Beverages";
    }
}

/*
 * Filters the product into categories by Toiletries.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
class Toiletries extends Product{
    public Toiletries(String name, String brand, String variant, int quantity, float price){
        super(name, brand, variant, quantity, price);
        this.category = "Toiletries";
    }
}

/*
 * Filters the product into categories by Cleaning Products.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
class Cleaning_Products extends Product{
    public Cleaning_Products(String name, String brand, String variant, int quantity, float price){
        super(name, brand, variant, quantity, price);
        this.category = "Cleaning_Products";
    }
}

/*
 * Filters the product into categories by Medications.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
class Medications extends Product{
    public Medications(String name, String brand, String variant, int quantity, float price){
        super(name, brand, variant, quantity, price);
        this.category = "Medications";
    }
}

/*
 * Represents the actions that an employee of the convenienceStore can do.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
class Employee{
    String name;
    private static ArrayList<Product> stockInventory;

    public Employee(String name){
        this.name = name;
    }

    public static void addProduct(){
        Scanner createProduct = new Scanner(System.in);

        System.out.println("Product name: ");
        String productName = createProduct.nextLine();
        System.out.println("Brand: ");
        String productBrand = createProduct.nextLine();
        System.out.println("Variant: ");
        String productVariant = createProduct.nextLine();
        System.out.println("Quantity: ");
        int productQuantity = createProduct.nextInt();
        System.out.println("Price: ");
        float productPrice = createProduct.nextFloat();

        stockInventory.add(new Product(productName, productBrand, productVariant, productQuantity, productPrice));
    }

    public void categorizeToFood(int index){
        Food foodHolder = new Food(stockInventory.get(index).getName(),  stockInventory.get(index).getBrand(), stockInventory.get(index).getVariant(), stockInventory.get(index).getQuantity(), stockInventory.get(index).getPrice());
        stockInventory.set(index, foodHolder);
    }

    public void categorizeToBev(int index){
        Beverages bevHolder = new Beverages(stockInventory.get(index).getName(),  stockInventory.get(index).getBrand(), stockInventory.get(index).getVariant(), stockInventory.get(index).getQuantity(), stockInventory.get(index).getPrice());
        stockInventory.set(index, bevHolder);
    }

    public void categorizeToToil(int index){
        Toiletries toilHolder = new Toiletries(stockInventory.get(index).getName(),  stockInventory.get(index).getBrand(), stockInventory.get(index).getVariant(), stockInventory.get(index).getQuantity(), stockInventory.get(index).getPrice());
        stockInventory.set(index, toilHolder);
    }

    public void categorizeToClean(int index){
        Cleaning_Products cleanHolder = new Cleaning_Products(stockInventory.get(index).getName(),  stockInventory.get(index).getBrand(), stockInventory.get(index).getVariant(), stockInventory.get(index).getQuantity(), stockInventory.get(index).getPrice());
        stockInventory.set(index, cleanHolder);
    }

    public void categorizeToMed(int index){
        Medications medHolder = new Medications(stockInventory.get(index).getName(),  stockInventory.get(index).getBrand(), stockInventory.get(index).getVariant(), stockInventory.get(index).getQuantity(), stockInventory.get(index).getPrice());
        stockInventory.set(index, medHolder);
    }

    public static void reStock(Shelf shelf){
        for (Product newStock : stockInventory){
            shelf.getProducts().add(newStock);
        }
        stockInventory.clear();
    }

    public static void reStock(Shelf shelf, int noOfProductStock){
        for (int i = 0; i < noOfProductStock; i++) {
            shelf.getProducts().add(stockInventory.get(i));
        }

        for (int i = 0; i < noOfProductStock; i++) {
            stockInventory.remove(stockInventory.get(i));
        }
    }

    public String getName(){
        return name;
    }
}

/*
 * Represents the identification of the products based on the Shelf.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
class Shelf{
    private final int shelf_number;
    private ArrayList<Product> products;

    public Shelf(int shelf_number){
        this.shelf_number = shelf_number;
    }

    public void showProducts(){
        for(Product product : products){
            product.showProductInformation();
        }
    }

    public int getShelfNumber(){
        return shelf_number;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }
}

/*
 * Represents the customer information. This is a commented out code.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
//class Customer{
//    private String name;
//    private boolean membership;
//    private int age;
//    private float money;
//    private ArrayList<Product> products_got;
//
//    public Customer(String name, boolean membership, int age, float money){
//        this.name = name;
//        this.membership = membership;
//        this.age = age;
//        this.money = money;
//    }
//
//    public void selectProduct(Shelf shelf, Product product){
//        products_got.add(product);
//    }
//
//    public ArrayList<Product> getAllProducts(){
//        return products_got;
//    }
//
//    public String getName(){
//        return name;
//    }
//
//    public int getAge(){
//        return age;
//    }
//
//    public boolean getMembership(){
//        return membership;
//    }
//}

/*
 * Calculates the checkout based on the given requirements. This is a commented out code.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
//class Checkout{
//    private float total_cost;
//    private float amount_given;
//    private Customer customer;
//
//    public void setCustomer(Customer customer){
//        this.customer = customer;
//    }
//
//    public float computeDiscountLogic(){
//        if (customer.getAge() >= 60 && customer.getMembership()){  // Senior and Member
//            return 0.30f;
//        } else if (customer.getAge() <= 60 && customer.getMembership()) {  // Member only
//            return 0.10f;
//        } else if (customer.getAge() >= 60 && !customer.getMembership()) {  // Senior only
//            return 0.20f;
//        } else {
//            return 0.00f;
//        }
//    }
//
//    public float CalculateTotal(){
//        for(int i = 0; i < customer.getAllProducts().size(); i++){
//           total_cost += customer.getAllProducts().get(i).multiplyProductByQuantity();
//        }
//
//        return total_cost - (this.computeDiscountLogic() * total_cost);
//    }
//
//    public float giveChange(){
//        Scanner iLoveCash = new Scanner(System.in);
//
//        System.out.print("Enter amount given: Php");
//        amount_given = iLoveCash.nextFloat();
//
//        if(amount_given >= this.CalculateTotal())
//            return amount_given - this.CalculateTotal();
//
//        return 0;
//    }
//
//    public Receipt printReceipt(){
//        return new Receipt(customer.getAllProducts(), CalculateTotal(), amount_given, giveChange());
//    }
//}

/*
 * Displays the receipt upon purchasing our products. This is a commented out code.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
//class Receipt{
//    private final ArrayList<Product> purchases;
//    private final float total_cost;
//    private final float received_amount;
//    private final float change;
//    private final float timestamp;
//
//    public Receipt(ArrayList<Product> purchases, float total_cost, float received_amount, float change){
//        this.purchases = purchases;
//        this.total_cost = total_cost;
//        this.received_amount = received_amount;
//        this.change = change;
//        this.timestamp = timestamp;
//    }
//
//    public void issueReceipt(){
//        System.out.println("Purchased Items: ");
//        for (Product boughtItems : purchases){
//            System.out.println(boughtItems.getName() + " | Quantity: " + boughtItems.getQuantity() + " | Total Price:" + boughtItems.multiplyProductByQuantity());
//        }
//
//        System.out.println("Total Cost: " + total_cost);
//        System.out.println("Received Amount: " + received_amount);
//        System.out.println("Change: " + change);
//        System.out.println("Time Stamped: " + timestamp);
//    }
//}

/*
 * System-logged usage of the convenienceStore application. Some of the associated codes are commented out.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
class Store_System{
    private ArrayList<Employee> employees;
    private ArrayList<Product> products;
//    private int total_products;
//    private ArrayList<Shelf> shelves = new ArrayList<>();
//    private Checkout checkout;
//    private ArrayList<Customer> customers;

    public Store_System(){
        this.employees = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public void setEmployees(ArrayList<Employee> employees){
        this.employees = employees;
    }

    public void setProducts(ArrayList<Product> products){
        this.products = products;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

//    public void addCustomer(Customer customer){
//        customers.add(customer);
//    }
//
//
//    public showCustomers(){
//        for (Customer customer_pick : customers){
//            System.out.println(customer_pick.getName());
//        }
//    }

    public ArrayList<Employee> getEmployees(){
        return employees;
    }

//    public ArrayList<Customer> getCustomers(){
//        return customers;
//    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public void stockInitialProducts(Product product){
        products.add(product);
    }

//    public void proceedToCheckout(Customer customer){
//        checkout.setCustomer(customer);
//    }
}

/*
 * Driver function of the convenienceStore Application. Some of the associated codes are commented out.
 * Interacts between User and itself.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */
public class convenienceStore {
    static void main() {
        Store_System convenience = new Store_System(); 
        Scanner main = new Scanner(System.in);
        Employee Jose = new Employee("Jose Perez");
        Employee Chester = new Employee("Chester Aldrin Uy");
//        Customer Buddy = new Customer("Buddy", false, 65, 10000.50f);
//        Customer Friend = new Customer("Friend", true, 18, 1000.50f);
        convenience.addEmployee(Jose);
        convenience.addEmployee(Chester);
//        convenience.addCustomer(Buddy);
//        convenience.addCustomer(Friend);

        Food Cloud9Classic =  new Food("CLoud9Classic", "Cloud9", "Classic", 10, 10.55f);
        Food VcutBarbeque = new Food("VcutBarbeque", "Vcut", "Barbeque", 10, 18.70f);
        Food VcutCheese = new Food("VcutCheese", "Vcut", "Cheese", 10, 18.70f);
        Food PiattosSourCream = new Food("PiattosSourCream", "Piattos", "SourCream", 10, 16.31f);
        Food PiattosCheese = new Food("PiattosCheese", "Piattos", "Cheese", 10, 16.31f);
        Beverages C2Red = new Beverages("C2Red", "C2", "Red", 10, 26.50f);
        Beverages C2Yellow = new Beverages("C2Yellow", "C2", "Yellow", 10, 26.50f);
        Beverages CokeRegular = new Beverages("CokeRegular", "Coke", "Regular", 10, 28.50f);
        Beverages CokeZero = new Beverages("CokeZero", "Coke", "Zero", 10, 28.50f);
        Beverages RoyalClassic = new Beverages("RoyalClassic", "Royal", "Classic", 10, 27.25f);
        Toiletries ColgateTripleAction  = new Toiletries("ColgateTripleAction", "Colgate", "TripleAction", 10, 76.50f);
        Toiletries ColgateAntiCavity  = new Toiletries("ColgateAntiCavity", "Colgate", "AntiCavity", 10, 76.50f);
        Toiletries SafeguardPureWhite = new Toiletries("SafeguardPureWhite", "Safeguard", "PureWhite", 10, 50.25f);
        Toiletries SafeguardLemon = new Toiletries("SafeguardLemon", "Safeguard", "Lemon", 10, 50.25f);
        Toiletries OldSpiceOriginal = new Toiletries("OldSpiceOriginal", "OldSpice", "Original", 10, 243.00f);
        Cleaning_Products GreenCrossAlcoholClassic  = new Cleaning_Products("GreenCrossAlcoholClassic", "GreenCross", "AlcoholClassic", 10, 65.75f);
        Cleaning_Products TideDetergent  = new Cleaning_Products("TideDetergent", "Tide", "Detergent", 10, 262.50f);
        Cleaning_Products TideBar  = new Cleaning_Products("TideBar", "Tide", "Bar", 10, 14.70f);
        Cleaning_Products ScotchBriteYellow  = new Cleaning_Products("ScotchBriteYellow", "ScotchBrite", "Yellow", 10, 71.50f);
        Cleaning_Products ScotchBriteBlue  = new Cleaning_Products("ScotchBriteBlue", "ScotchBrite", "Blue", 10, 71.50f);
        Medications TempraForte = new Medications("TempraForte", "Tempra", "Forte", 10, 12.50f);
        Medications SolmuxCapsule = new Medications("SolmuxCapsule", "Solmux", "Capsule", 10, 11.25f);
        Medications Dolfenal = new Medications("DolfenalTablet", "Dolfenal", "Tablet", 10, 15.00f);
        Medications DecolgenNonDrowsy = new Medications("DecolgenNonDrowsy", "Decolgen", "NonDrowsyTablet", 10, 13.15f);
        Medications Trimox = new Medications("Trimox", "Trimox", "Tablet", 10, 28.35f);

        convenience.stockInitialProducts(Cloud9Classic);
        convenience.stockInitialProducts(VcutBarbeque);
        convenience.stockInitialProducts(VcutCheese);
        convenience.stockInitialProducts(PiattosSourCream);
        convenience.stockInitialProducts(PiattosCheese);
        convenience.stockInitialProducts(C2Red);
        convenience.stockInitialProducts(C2Yellow);
        convenience.stockInitialProducts(CokeRegular);
        convenience.stockInitialProducts(CokeZero);
        convenience.stockInitialProducts(RoyalClassic);
        convenience.stockInitialProducts(ColgateTripleAction);
        convenience.stockInitialProducts(ColgateAntiCavity);
        convenience.stockInitialProducts(SafeguardPureWhite);
        convenience.stockInitialProducts(SafeguardLemon);
        convenience.stockInitialProducts(OldSpiceOriginal);
        convenience.stockInitialProducts(GreenCrossAlcoholClassic);
        convenience.stockInitialProducts(TideDetergent);
        convenience.stockInitialProducts(TideBar);
        convenience.stockInitialProducts(ScotchBriteYellow);
        convenience.stockInitialProducts(ScotchBriteBlue);
        convenience.stockInitialProducts(TempraForte);
        convenience.stockInitialProducts(SolmuxCapsule);
        convenience.stockInitialProducts(Dolfenal);
        convenience.stockInitialProducts(DecolgenNonDrowsy);
        convenience.stockInitialProducts(Trimox);

        // Switch case for the Customer and Employee
        System.out.println("Welcome to U&P's Convenience Store Application!");
        System.out.println("version a.0.0.13\n");
        System.out.println("Please select your option:");
        System.out.println("[C]ustomer | [E]mployee\n");
        System.out.print("You're a/n: ");
        char identifyAs = main.next().charAt(0);

        switch(identifyAs){
            case 'C': case 'c':
//                System.out.println("Pick a customer: ");
//                convenience.showCustomers();
//                String customer_name = main.nextLine();
//                Customer customer_chosen;
//                for (int i = 0; i < convenience.getCustomers().size(); i++){
//                    if (customer_name == convenience.getCustomers().get(i).getName()){
//                        customer_chosen = convenience.getCustomers().get(i);
//                        i = convenience.getCustomers().size();
//                    }
//                }
//
//                ArrayList<Product> productQuery = convenience.getProducts();
//
//                System.out.println("Good day, customer! What would you like to buy?\n");
//                System.out.println("Shelf: [1][2][3][4][5][6][7][8][9][10]");
//                System.out.println("Category: [F]ood, [B]everages, [T]oiletries, [C]leaning Products, [M]edications");
//
//                System.out.println("Product Name | Category | Brand | Variant | Quantity | Price");
//                for(Product showProducts : productQuery) {
//                    System.out.println(showProducts.getName() + " | " + showProducts.getCategory() + " | " + showProducts.getBrand() + " | " + showProducts.getVariant() + " | " + showProducts.getPrice() + " | " );
//                }
//
//                Scanner view = new Scanner(System.in);
//                System.out.println("Copy the Product Name below to view the product: ");
//                String inputProductName = view.nextLine();
//
//                for(Product showProducts : productQuery) {
//                    if (showProducts.getName().equals(inputProductName)) {
//                        Product currentProduct = new Product(showProducts.getName(), showProducts.getBrand(), showProducts.getVariant(), showProducts.getQuantity(), showProducts.getPrice());
//                        currentProduct.showProductInformation();
//
//                        Scanner productAction = new Scanner(System.in);
//                        System.out.println("Actions: ");
//                        System.out.println("[B]uy Now | [A]dd to Cart | [<] Back");
//                        char action = productAction.next().charAt(0);
//                        Checkout checkout = new Checkout();
//
//                        switch(action){
//                            case 'B': case 'b':
//                                proceedtoCheckout();
//                                checkout.CalculateTotal();
//                                checkout.giveChange();
//                                checkout.printReceipt();
//                                break;
//                            case 'A': case 'a':
//                                break;
//                            case '<':
//                                break;
//                        }
//                    }
//                }
                System.out.println("This function is currently under maintenance. The program will now exit.");
                break;
            case 'E': case 'e':
                ArrayList<Employee> authorizedEmployeeList = convenience.getEmployees();

                Scanner employed = new Scanner(System.in);
                System.out.print("Please enter your name for verification: ");
                String employee = employed.nextLine();

                for (Employee unp : authorizedEmployeeList) {
                    if (unp.getName().equals(employee)) {
                        System.out.println("Welcome to U&P, " + employee + "!\n");
                        System.out.println("What would you like to do?");
                        System.out.println("[A]dd Product to Shelf");
                        System.out.println("[R]estock Product\n");

                        Scanner stockInventory = new Scanner(System.in);
                        System.out.print("Choose an option: ");
                        char productMod = stockInventory.next().charAt(0);

                        switch (productMod) {
                            case 'A': case 'a':
                                Employee.addProduct();
                                break;
                            case 'R': case 'r':
                                Scanner chooseShelf = new Scanner(System.in);
                                Scanner restockItems = new Scanner(System.in);

                                System.out.println("Shelf: [1][2][3][4][5][6][7][8][9][10]");
                                System.out.print("Choose Shelf: ");
                                int shelf = chooseShelf.nextInt();

                                System.out.print("Choose Shelf: How many are you going to restock? ");
                                int restock = restockItems.nextInt();

                                if(restock == 1)
                                    Employee.reStock(new Shelf(shelf));
                                else if (restock > 1)
                                    Employee.reStock(new Shelf(shelf), restock);

                                break;
                        }
                    } else
                        System.out.println("Please wait as we verify your name...");
                }
                break;
            default:
                System.out.println("You entered an invalid option. The application will now exit.");
                break;
        }
    }
}