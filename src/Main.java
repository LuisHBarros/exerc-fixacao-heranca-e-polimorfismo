import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter brazilianDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Product #" + i + "data:");
            System.out.println("Common, used or imported? (c/u/i)? ");
            char c = sc.next().charAt(0);

            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if(c == 'i' || c == 'I'){
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));

            }
            else if(c == 'u' || c == 'U'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufactureDate = LocalDate.parse(sc.next(), brazilianDateTime);
                list.add(new UsedProduct(name, price, manufactureDate));


            }
            else{
                list.add(new Product(name, price));
            }
        }
        System.out.println("\nPRICE TAGS: ");

        for (Product prod : list){
            System.out.println(prod.priceTag());
        }

        sc.close();
    }

}