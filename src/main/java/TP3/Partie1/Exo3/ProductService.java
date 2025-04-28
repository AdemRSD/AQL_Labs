package TP3.Partie1.Exo3;

public class ProductService {
    private final ProductApiClient productApiClient;

    public ProductService(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Product getProduct(String productId) {
        return productApiClient.getProduct(productId);
    }
}
