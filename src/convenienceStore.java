import java.lang.System;
import java.util.Scanner;

class Product{
    String name, category, brand, variant;
    float price;
    int quantity;

    Product(String name, String category, String brand, String variant, int quantity, float price){
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.variant = variant;
        this.quantity = quantity;
        this.price = price;
    }

    void showProductInformation(){
        System.out.println(name + "\n");
        System.out.println(category + "\n");
        System.out.println(brand + "\n");
        System.out.println(variant + "\n");
        System.out.println(quantity + "\n");
        System.out.println(price + "\n");
    }
}

public class convenienceStore {
    static void main() {
        Scanner main = new Scanner(System.in);

        // Switch case for the Customer and Employee
        System.out.println("Welcome to U&P's Convenience Store Application!");
        System.out.println("version a.0.0.2\n");
        System.out.println("Please select your option:");
        System.out.println("[C]ustomer | [E]mployee\n");
        System.out.println("You're a/n: ");
        char identifyAs = main.next().charAt(0);

        switch(identifyAs){
            case 'C': case 'c':
                break;
            case 'E': case 'e':
                Scanner employed = new Scanner(System.in);

                System.out.println("Please enter your employee ID: ");
                int employeeID = employed.nextInt();
                if(employeeID > 7800000 && employeeID < 7900000)
                    System.out.println("Invalid employee ID");
                else
                    System.out.println("Invalid employee ID (really)");

                break;
            default:
                System.out.println("You entered an invalid option. The application will now exit.");
                break;
        }
    }
}