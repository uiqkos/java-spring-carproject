package ru.uiqkos.carproject.services.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping(path = "/list")
    public  @ResponseBody
    List<Customer> list() {
        return (List<Customer>) customerRepository.findAll();
    }
    
    @DeleteMapping(path = "/{id}/delete")
    public boolean delete(@PathVariable String id) {
        try {
            customerRepository.delete(
                customerRepository
                    .findById(id)
                    .orElseThrow()
            );
        } catch(Exception e) { return false; }
        return true;
    }

    @PutMapping(path = "/{id}/update")
    public @ResponseBody
    Customer update(@RequestBody Customer newCustomer, @PathVariable String id) {
        return customerRepository
            .findById(id)
            .map((customer) -> {
                customer.setCustomerFirstName(newCustomer.getCustomerFirstName());
                customer.setCustomerLastName(newCustomer.getCustomerLastName());
                customer.setEmail(newCustomer.getEmail());
                customer.setPhoneNumber(newCustomer.getPhoneNumber());
                return customer;
            })
            .orElseGet(() -> customerRepository.save(newCustomer));
    }
}
