import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Product product;
    private Map<String, Product> products;

    public Inventory() {
        products = new HashMap<String, Product>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Added " + product.getProductId());
    }

    public void updateProduct(String productId, Product product) {
        if (products.containsKey(product.getProductId())) {
            products.put(product.getProductId(), product);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product with ID " + product.getProductId() + " does not exist.");
        }
    }

    public void deleteProduct(String productId) {
        Product remove = products.remove(productId);
        if (remove != null) {
            System.out.println("Product removed: " + remove);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    public void displayProducts() {
        if(products.isEmpty()) {
            System.out.println("No products found.");
        }
        else {
            for (Product product : products.values()) {
                System.out.println(product.toString());
            }
        }
    }
}
