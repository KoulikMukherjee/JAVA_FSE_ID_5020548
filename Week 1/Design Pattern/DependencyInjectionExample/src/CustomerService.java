public class CustomerService {
    private CustomerRepository customerRepo;
    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public String findCustomerById(int id) {
        return customerRepo.findCustomerById(id);
    }

    public String findCustomerByName(String name) {
        return customerRepo.findCustomerByName(name);
    }
}
