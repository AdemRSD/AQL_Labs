package TP3.Partie1.Exo2;

public class Order {
    private final long id;
    private final String product;

    public Order(long id, String product) {
        this.id = id;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }
}
