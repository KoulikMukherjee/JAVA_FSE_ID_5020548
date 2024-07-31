public class Test {
    public static void main(String[] args) {

        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        System.out.println("Displaying image1");
        image1.display();
        System.out.println();

        //Image1 will not be loaded again as it is already loaded
        System.out.println("Again displaying image1");
        image1.display();
        System.out.println();

        System.out.println("Displaying image2");
        image2.display();

    }
}