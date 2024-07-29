public class Test {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        System.out.println("1st Call for object: "+logger1.hashCode());
        Logger logger2 = Logger.getInstance();
        System.out.println("2nd Call for object: "+logger2.hashCode());
        // The hashcode is same for both the object calls so it means that it is following Singleton Pattern
    }
}
