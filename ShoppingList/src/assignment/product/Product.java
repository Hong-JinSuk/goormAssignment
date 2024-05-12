package assignment.product;

import java.util.Objects;

public class Product {

    private Long key;
    private String name;
    private int price;
    public int quantity = 0;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
        this.key = (long) hashCode(name, price);
    }

    public void removeQuantity(int quantity) {
        this.quantity -= quantity;
        if (this.quantity < 0) this.quantity = 0;
    }

    public void plusQuantity(int quantity) {
        this.quantity += quantity;
    }

    @Override
    public boolean equals(Object obj) {
        Product product = (Product) obj;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (this.getKey() != product.getKey()) return false;
        return true;
    }

    public int hashCode(String name, int price) {
        return Objects.hash(name, price);
    }

    // Getter & Setter

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
