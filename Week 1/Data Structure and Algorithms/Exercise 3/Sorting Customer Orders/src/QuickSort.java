class QuickSort {
    public static void quickSortByTotalPrice(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSortByTotalPrice(orders, low, pi - 1);
            quickSortByTotalPrice(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Swap.swap(orders, i, j);
                // Swap orders[i] and orders[j]
//                Order temp = orders[i];
//                orders[i] = orders[j];
//                orders[j] = temp;
            }
        }
        Swap.swap(orders, i + 1 , high);
        return i + 1;
    }
}