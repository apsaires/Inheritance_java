package Aplication;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {


        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat(("dd/MM/yyyy"));

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int np = sc.nextInt();
        for (int i = 1; i <= np; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used, imported (c, u, i):  ");
            char cui = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (cui == 'i') {
                System.out.print("Customs fee: ");
                double cf = sc.nextDouble();
                list.add(new ImportedProduct(name, price, cf));
            } else if (cui == 'u') {
                System.out.print("Manufacture date: ");
                Date md = sdf.parse(sc.next());
                list.add(new UsedProduct(name, price, md));
            }
            list.add(new Product(name, price));

        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        for(Product prd : list) {
            System.out.println(prd.priceTag());
        }
        sc.close();
    }

}