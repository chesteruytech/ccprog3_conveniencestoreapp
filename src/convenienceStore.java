import java.lang.System;
import java.util.ArrayList;
import java.util.Scanner;

class Product{
    private String name;
    String category;
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

class Food extends Product{
    public Food(String name, String brand, String variant, int quantity, float price){
        super(name, brand, variant, quantity, price);
        this.category = "Food";
    }
}

class Beverages extends Product{
    public Beverages(String name, String brand, String variant, int quantity, float price){
        super(name, brand, variant, quantity, price);
        this.category = "Beverages";
    }
}

class Toiletries extends Product{
    public Toiletries(String name, String brand, String variant, int quantity, float price){
        super(name, brand, variant, quantity, price);
        this.category = "Toiletries";
    }
}

class Cleaning_Products extends Product{
    public Cleaning_Products(String name, String brand, String variant, int quantity, float price){
        super(name, brand, variant, quantity, price);
        this.category = "Cleaning_Products";
    }
}

class Medications extends Product{
    public Medications(String name, String brand, String variant, int quantity, float price){
        super(name, brand, variant, quantity, price);
        this.category = "Medications";
    }
}

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
        for (int i = 0; i < stockInventory.size(); i++){
            shelf.getProducts().add(stockInventory.get(i));
        }

        stockInventory.clear();
    }

    public static void reStock(Shelf shelf, int noOfProductStock){
        for (int i = 0; i < noOfProductStock; i++){
            shelf.getProducts().add(stockInventory.get(i));
        }

        stockInventory.removeRange(0, noOfProductStock - 1);
    }

    public String getName(){
        return name;
    }
}

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


class Customer{
   private String name;
   private boolean membership;
   private int age;
   private ArrayList<Product> products_got;


   public void selectProduct(Shelf shelf, Product product){
       products_got.add(product);
   } 

   public ArrayList<Product> getAllProducts(){
       return products_got;
   }

   public int getAge(){
       return age;
   }

   public boolean getMembership(){
       return membership;
   }  

}

class Checkout{
    private float amount_given;
    private Customer customer;


    public double computeDiscountLogic(){
        if (customer.getAge() >= 60 && customer.getMembership() == true){  // Senior and Member
            return 0.30;
        } else if (customer.getAge() <= 60 && customer.getMembership() == true) {  // Member only
            return 0.10;
        } else if (customer.getAge() >= 60 && customer.getMembership() == false) {  // Senior only
            return 0.20;
        } else {
            return 0.00;
        }
    }

    public double CalculateTotal(){

    }

    public double giveChange(){

    }
}

class Receipt{
    private ArrayList<Product> purchases;
    private float total_cost;
    private float received_amount;
    private float change;
    private String timestamp;

    public void issueReceipt(){
        System.out.println("Purchased Items: ");
        for (int i = 0; i < purchases.size(); i++){
            System.out.println(purchases.get(i).getName() + " | Quantity: " + purchases.get(i).getQuantity() + " | Total Price:" + purchases.get(i).multiplyProductByQuantity());
        }

        System.out.println("Total Cost: " + total_cost);
        System.out.println("Received Amount: " + received_amount);
        System.out.println("Change: " + change);
        System.out.println("Time Stamped: " + timestamp);
   }
}


public class convenienceStore {
    static void main() {
        Scanner main = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Employee Jose = new Employee("Jose Perez");
        Employee Chester = new Employee("Chester Aldrin Uy");
        employees.add(Jose);
        employees.add(Chester);

        // Switch case for the Customer and Employee
        System.out.println("Welcome to U&P's Convenience Store Application!");
        System.out.println("version a.0.0.13\n");
        System.out.println("Please select your option:");
        System.out.println("[C]ustomer | [E]mployee\n");
        System.out.println("You're a/n: ");
        char identifyAs = main.next().charAt(0);

        switch(identifyAs){
            case 'C': case 'c':
                break;
            case 'E': case 'e':
                Scanner employed = new Scanner(System.in);

                System.out.println("Please enter your name: ");
                String employee = employed.nextLine();

                if(employees.contains(employee)){
                    Scanner stockInventory = new Scanner(System.in);

                    System.out.println("Welcome to U&P, " + employee + "!\n");
                    System.out.println("What would you like to do?");
                    System.out.println("[A]dd Product to Shelf");
                    System.out.println("[R]estock Product");
                    char productMod = stockInventory.next().charAt(0);

                    switch(productMod){
                        case 'A': case 'a':
                            Employee.addProduct();
                            break;
                        case 'R': case 'r':
                            Employee.reStock();
                            break;
                    }
                }
                else
                    System.out.println("Invalid employee name (really)");
                break;
            default:
                System.out.println("You entered an invalid option. The application will now exit.");
                break;
        }
    }
}