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
        // Switch case for the Customer and Employee
        Scanner scanner = new Scanner(System.in);
    }
}