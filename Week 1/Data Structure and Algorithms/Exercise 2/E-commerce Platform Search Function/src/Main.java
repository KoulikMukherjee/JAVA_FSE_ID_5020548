public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product("P100", "Desktop", "Electronics"),
                new Product("P25", "Power Bank", "Accessories"),
                new Product("P46", "Headphones", "Accessories"),
                new Product("P10", "Laptop", "Electronics"),
                new Product("P57", "Charger", "Accessories")
        };

        // Linear Search
        System.out.println("Linear Search");
        System.out.println("Linear Search by ID: " + LinearSearch.SearchById(products, "P25"));
        System.out.println();

        System.out.println("Linear Search by Name: " + LinearSearch.SearchByName(products, "Headphones"));
        System.out.println();

        System.out.println("Linear Search by Category: " + LinearSearch.SearchByCategory(products, "Accessories"));
        System.out.println();

        // Binary Search
        System.out.println("Linear Search");
        System.out.println("Binary Search by ID: " + BinarySearch.SearchById(products, "P46"));
        System.out.println();

        System.out.println("Binary Search by Name: " + BinarySearch.SearchByName(products, "Laptop"));
        System.out.println();

        System.out.println("Binary Search by Category: " + BinarySearch.SearchByCategory(products, "Electronics"));
    }
}