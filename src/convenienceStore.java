import java.lang.System;
import java.util.ArrayList;
import java.util.Scanner;

class Product{
    private String name, category, brand, variant;
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
        super();
        this.category = "Food";
    }
}

class Beverages extends Product{
    public Beverages(String name, String brand, String variant, int quantity, float price){
        super();
        this.category = "Beverages";
    }
}

class Toiletries extends Product{
    public Toiletries(String name, String brand, String variant, int quantity, float price){
        super();
        this.category = "Toiletries";
    }
}

class Cleaning_Products extends Product{
    public Cleaning_Products(String name, String brand, String variant, int quantity, float price){
        super();
        this.category = "Cleaning_Products";
    }
}

class Medications extends Product{
    public Medications(String name, String brand, String variant, int quantity, float price){
        super();
        this.category = "Medications";
    }
}

class Employee{
    String name;
    private ArrayList<Product> stockInventory;

    public Employee(String name){
        this.name = name;
    }

    public void addProduct(){
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

    public void reStock(Shelf shelf){
        for (int i = 0; i < stockInventory.size(); i++){
            shelf.getProducts().add(stockInventory.get(i));
        }
    }

    public void reStock(Shelf shelf, int noOfProductStock){
        for (int i = 0; i < noOfProductStock; i++){
            shelf.getProducts().add(stockInventory.get(i));
        }
    }

    public String getName(){
        return name;
    }
}

class Shelf{
    private int shelf_number;
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

public class convenienceStore {
    static void main() {
        Scanner main = new Scanner(System.in);
        ArrayList<String> employees = new ArrayList<>();
        employees.add("Jose Perez");
        employees.add("Chester Aldrin Uy");

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
                if(employees.contains(new Employee(employee)))
                    System.out.println("Welcome to U&P, " + employee + "!");
                else
                    System.out.println("Invalid employee name (really)");
                break;
            default:
                System.out.println("You entered an invalid option. The application will now exit.");
                break;
        }
    }
}