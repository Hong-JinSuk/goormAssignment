package assignment;

import assignment.cart.Cart;
import assignment.product.Product;

import java.util.HashSet;
import java.util.Set;

public class CartApp {
    public static void main(String[] args) {
        Set<Product> productSet = new HashSet<>();

        System.out.println("고유한 상품 목록 : ");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        Cart myCart = new Cart();
    }
}