public class Test {
    public static void main(String[] args) {

        StockMarket stockmarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockmarket.Register(mobileApp);
        stockmarket.Register(webApp);
        System.out.println("First Update");
        stockmarket.setPrice(5856.25);
        System.out.println();

        stockmarket.Deregister(mobileApp);

        System.out.println("Second Update");
        stockmarket.setPrice(4582.76);

    }
}