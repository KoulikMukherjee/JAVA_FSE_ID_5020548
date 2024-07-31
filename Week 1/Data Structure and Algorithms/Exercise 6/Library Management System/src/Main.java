public class Main {
    public static void main(String[] args) {
        Book[] books = {
                new Book("B1", "Book3", "John"),
                new Book("B2", "Book1", "Rose"),
                new Book("B3", "Book2", "Agatha")
        };

        System.out.println("Linear Search:");
        Book book = LinearSearchBook.linearSearchByTitle(books, "Book1");
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
        System.out.println();

        System.out.println("Binary Search:");
        Book[] sortedBooks = {
                new Book("B2", "Book1", "Rose"),
                new Book("B3", "Book2", "Agatha"),
                new Book("B1", "Book3", "John")
        };

        book = BinarySearchBook.binarySearchByTitle(sortedBooks, "Book2");
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }
}