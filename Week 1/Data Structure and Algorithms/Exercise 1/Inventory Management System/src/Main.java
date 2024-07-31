public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("V123","VP","1","50000");
        Product product2 = new Product("V456","VT","2","25000");

        Inventory inventory = new Inventory();

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.displayProducts();
        System.out.println();

        inventory.updateProduct("V123",
                new Product("V123","VP","1","100000"));

        inventory.deleteProduct("V456");

        inventory.displayProducts();


    }
}