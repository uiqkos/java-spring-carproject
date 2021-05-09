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
    Customer createVehicle(@RequestBody Customer salesAgent) {
        return customerRepository.save(salesAgent);
    }

    @GetMapping(path = "/list")
    public  @ResponseBody
    List<Customer> list() {
        return (List<Customer>) customerRepository.findAll();
    }
}
