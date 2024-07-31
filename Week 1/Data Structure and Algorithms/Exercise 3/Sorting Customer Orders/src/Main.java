public class Main {
    public static void main(String[] args) {

        Order[] orders = {
                new Order("O01", "John", 356.89),
                new Order("O02", "Rose", 156.89),
                new Order("O03", "Chad", 367.53),
                new Order("O04", "Raven", 541.22)
        };

        System.out.println("Original Orders:");
        for (Order order : orders) {
            System.out.println(order);
        }

        BubbleSort.bubbleSortByTotalPrice(orders);
        System.out.println("\nOrders Sorted by Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Reinitialize orders
        orders = new Order[] {
                new Order("O01", "John", 356.89),
                new Order("O02", "Rose", 156.89),
                new Order("O03", "Chad", 367.53),
                new Order("O04", "Raven", 541.22)
        };

        QuickSort.quickSortByTotalPrice(orders, 0, orders.length - 1);
        System.out.println("\nOrders Sorted by Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}