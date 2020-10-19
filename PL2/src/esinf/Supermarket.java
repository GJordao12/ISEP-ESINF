/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.time.LocalDate;
import java.util.*;

/**
 * @author DEI-ISEP
 */
public class Supermarket {
    Map<Invoice, Set<Product>> m;

    Supermarket() {
        m = new HashMap<>();
    }

    // Reads invoices from a list of String
    void getInvoices(List<String> l) throws Exception {

        Invoice i = null;
        Set<Product> products = new HashSet<>();

        for (String s : l) {
            String[] info = s.split(",");
            if (info[0].equals("I")) {
                if (i != null) {
                    this.m.put(i, products);
                }
                i = new Invoice(info[1], info[2]);
                products = new HashSet<>();
            }
            if (info[0].equals("P")) {
                Product p = new Product(info[1], Integer.parseInt(info[2]), Long.parseLong(info[3]));
                products.add(p);
            }
        }
        this.m.put(i, products);
    }

    // returns a set in which each number is the number of products in the r
    // invoice 
    Map<Invoice, Integer> numberOfProductsPerInvoice() {

        Map<Invoice, Integer> map = new HashMap<>();

        for (Invoice i : this.m.keySet()) {
            map.put(i, this.m.get(i).size());
        }

        return map;
    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set<Invoice> betweenDates(LocalDate d1, LocalDate d2) {

        Set<Invoice> invoices = new HashSet<>();

        for (Invoice i : this.m.keySet()) {
            if (i.getDate().isAfter(d1) && i.getDate().isBefore(d2)) {
                invoices.add(i);
            }
        }

        return invoices;
    }

    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {

        long total = 0;

        for (Invoice i : this.m.keySet()) {
            for (Product p : this.m.get(i)) {
                if (p.getIdentification().equalsIgnoreCase(productId)) {
                    total = total + (p.getPrice() * p.getQuantity());
                }
            }
        }
        return total;

    }

    // converts a map of invoices and products to a map which key is a product
    // identification and the values are a set of the invoice references 
    // in which it appears
    Map<String, Set<Invoice>> convertInvoices() {

        Map<String, Set<Invoice>> map = new HashMap<>();

        for (Invoice i : m.keySet()) {
            for (Product p : m.get(i)) {
                if (map.isEmpty() || !map.containsKey(p.getIdentification())) {
                    map.put(p.getIdentification(), new HashSet<>());
                }

                map.get(p.getIdentification()).add(i);
            }
        }
        return map;
    }
}
