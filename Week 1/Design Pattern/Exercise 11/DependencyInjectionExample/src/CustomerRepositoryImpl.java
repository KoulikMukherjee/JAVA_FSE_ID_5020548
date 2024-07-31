public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        return "Finding customer by id: " + id;
    }

    @Override
    public String findCustomerByName(String name) {
        return "Finding customer by name: " + name;
    }
}
