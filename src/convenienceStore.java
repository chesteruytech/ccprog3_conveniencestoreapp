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

    public Product(String name, String brand, String variant, int quantity, float price){
        this.name = name;
        this.brand = brand;
        this.variant = variant;
        this.quantity = quantity;
        this.price = price;
    }

    public void showProductInformation(){
        System.out.println(name);
        System.out.println(category);
        System.out.println(brand);
        System.out.println(variant);
        System.out.println(quantity);
        System.out.println(price);
    }

    public float multiplyProductByQuantity(){
        return price * quantity;
    }

    public float getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    public String getBrand(){
        return brand;
    }

    public String getVariant(){
        return variant;
    }

    public int getQuantity(){
        return quantity;
    }

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
        for (Product newStock : stockInventory) shelf.getProducts().add(newStock);

        stockInventory.clear();
    }

    public static void reStock(Shelf shelf, int noOfProductStock){
        for (int i = 0; i < noOfProductStock; i++) shelf.getProducts().add(stockInventory.get(i));

        stockInventory.removeRange(0, noOfProductStock - 1);
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
 * Represents the customer information.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */

class Customer{
    private String name;
    private boolean membership;
    private int age;
    private ArrayList<Product> products_got;

    public Customer(String name, boolean membership, int age, float money){
        this.name = name;
        this.membership = membership;
        this.age = age;
    }

    public void selectProduct(Shelf shelf, Product product){
        products_got.add(product);
    }

    public ArrayList<Product> getAllProducts(){
        return products_got;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public boolean getMembership(){
        return membership;
    }
}

/*
 * Calculates the checkout based on the given requirements.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */

class Checkout{
    private float total_cost;
    private float amount_given;
    private Customer customer;

    public float computeDiscountLogic(){
        if (customer.getAge() >= 60 && customer.getMembership()){  // Senior and Member
            return 0.30f;
        } else if (customer.getAge() <= 60 && customer.getMembership()) {  // Member only
            return 0.10f;
        } else if (customer.getAge() >= 60 && !customer.getMembership()) {  // Senior only
            return 0.20f;
        } else {
            return 0.00f;
        }
    }

    public float CalculateTotal(){
        for(int i = 0; i < customer.getAllProducts().size(); i++){
           total_cost += customer.getAllProducts().get(i).multiplyProductByQuantity();
        }

        return total_cost - (this.computeDiscountLogic() * total_cost);
    }

    public float giveChange(){
        Scanner iLoveCash = new Scanner(System.in);

        System.out.print("Enter amount given: Php");
        amount_given = iLoveCash.nextFloat();

        if(amount_given >= this.CalculateTotal())
            return amount_given - this.CalculateTotal();

        return 0;
    }

    public Receipt printReceipt(){
        return new Receipt(customer.getAllProducts(), CalculateTotal(), amount_given, giveChange());
    }
}

/*
 * Displays the receipt upon purchasing our products.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */

class Receipt{
    private final ArrayList<Product> purchases;
    private final float total_cost;
    private final float received_amount;
    private final float change;
//    private final float timestamp;

    public Receipt(ArrayList<Product> purchases, float total_cost, float received_amount, float change){
        this.purchases = purchases;
        this.total_cost = total_cost;
        this.received_amount = received_amount;
        this.change = change;
//        this.timestamp = timestamp;
    }

    public void issueReceipt(){
        System.out.println("Purchased Items: ");
        for (Product boughtItems : purchases){
            System.out.println(boughtItems.getName() + " | Quantity: " + boughtItems.getQuantity() + " | Total Price:" + boughtItems.multiplyProductByQuantity());
        }

        System.out.println("Total Cost: " + total_cost);
        System.out.println("Received Amount: " + received_amount);
        System.out.println("Change: " + change);
//        System.out.println("Time Stamped: " + timestamp);
    }
}

/*
 * System-logged usage of the convenienceStore application.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */

class Store_System{
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
//    private int total_products;
//    private ArrayList<Shelf> shelves = new ArrayList<>();
//    private Checkout checkout;

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }
}

/*
 * Driver function of the convenienceStore Application.
 * Interacts between User and itself.
 *
 * @author      Jose Perez, Chester Aldrin Uy
 * @version     %I%
 */

public class convenienceStore {
    public static void main() {
        Store_System convenience = new Store_System(); 
        Scanner main = new Scanner(System.in);
        Employee Jose = new Employee("Jose Perez");
        Employee Chester = new Employee("Chester Aldrin Uy");
        convenience.addEmployee(Jose);
        convenience.addEmployee(Chester);

        // Switch case for the Customer and Employee
        System.out.println("Welcome to U&P's Convenience Store Application!");
        System.out.println("version a.0.0.13\n");
        System.out.println("Please select your option:");
        System.out.println("[C]ustomer | [E]mployee\n");
        System.out.print("You're a/n: ");
        char identifyAs = main.next().charAt(0);

        switch(identifyAs){
            case 'C': case 'c':
                Store_System inside = new Store_System();
                ArrayList<Product> productQuery = inside.getProducts();

                System.out.println("Good day, customer! What would you like to buy?\n");
                System.out.println("Shelf: [1][2][3][4][5][6][7][8][9][10]");
                System.out.println("Category: [F]ood, [B]everages, [T]oiletries, [C]leaning Products, [M]edications");

                System.out.println("Product Name | Category | Brand | Variant | Quantity | Price");
                for(Product showProducts : productQuery) {
                    System.out.println(showProducts.getName() + " | " + showProducts.getCategory() + " | " + showProducts.getBrand() + " | " + showProducts.getVariant() + " | " + showProducts.getPrice() + " | " );
                }

                Scanner view = new Scanner(System.in);
                System.out.println("Copy the Product Name below to view the product: ");
                String inputProductName = view.nextLine();

                for(Product showProducts : productQuery) {
                    if (showProducts.getName().equals(inputProductName)) {
                        Product currentProduct = new Product(showProducts.getName(), showProducts.getBrand(), showProducts.getVariant(), showProducts.getQuantity(), showProducts.getPrice());
                        currentProduct.showProductInformation();

                        Scanner productAction = new Scanner(System.in);
                        System.out.println("Actions: ");
                        System.out.println("[B]uy Now | [A]dd to Cart | [<] Back");
                        char action = productAction.next().charAt(0);
                    }
                }
                break;
            case 'E': case 'e':
                Store_System system = new Store_System();
                ArrayList<Employee> authorizedEmployeeList = system.getEmployees();

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
                        System.out.println("Choose an option: ");
                        char productMod = stockInventory.next().charAt(0);

                        switch (productMod) {
                            case 'A': case 'a':
                                Employee.addProduct();
                                break;
                            case 'R': case 'r':
                                Employee.reStock();
                                break;
                        }
                    } else
                        System.out.println("Invalid employee name. Please try again.");
                }
                break;
            default:
                System.out.println("You entered an invalid option. The application will now exit.");
                break;
        }
    }
}