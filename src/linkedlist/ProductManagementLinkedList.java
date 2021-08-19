package linkedlist;

import java.util.Collections;
import java.util.LinkedList;

public class ProductManagementLinkedList {
    LinkedList<Product> products = new LinkedList<>();

    public LinkedList<Product> getProducts() {
        return products;
    }

    public void setProducts(LinkedList<Product> products) {
        this.products = products;
    }

    public void addLast(Product product) {
        products.addLast(product);
    }

    public void addFirst(Product product) {
        products.addFirst(product);
    }

    public void displayProduct() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void deleteProduct(int index) {
        products.remove(index);
    }

    public void editProduct(int index, Product product) {
        products.set(index, product);
    }

    public Product findProduct(int index) {
        return products.get(index);
    }

    public void sortProduct() {
        Collections.sort(products);
    }
}
