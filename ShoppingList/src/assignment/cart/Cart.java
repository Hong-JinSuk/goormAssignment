package assignment.cart;

import assignment.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Cart {

    private List<Product> productList;


    public Cart() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        for (Product pro : productList) {
            if (pro.equals(product)) {
                pro.plusQuantity(quantity);
                return;
            }
        }
        productList.add(product);
    }

    public void removeProduct(Product product, int quantity) {
        for (Product pro : productList) {
            if (pro.equals(product)) {
                pro.removeQuantity(quantity);
                if (pro.getQuantity() <= 0) productList.remove(pro);
                return;
            }
        }
        throw new NoSuchElementException(product.getName() + "is not exist in cart");
    }

    public void showItems() {
        int totalPrice = 0;
        for (Product product : productList) {
            System.out.println(
                    "name : " + product.getName()
                            + "\nQuantity : " + product.getQuantity()
                            + "\n" + product.getName() + "'s total price : " + product.getQuantity() * product.getPrice()
            );
            totalPrice += product.getQuantity() * product.getPrice();
        }
        System.out.println("All products total price : " + totalPrice);
    }
}
