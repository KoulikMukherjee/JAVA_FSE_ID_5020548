public class Test {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService(new CustomerRepositoryImpl());

        System.out.println(customerService.findCustomerById(1234));
        System.out.println();
        System.out.println(customerService.findCustomerByName("John"));



    }
}