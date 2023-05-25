package com.training.flowersshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.flowersshop.facade.CustomerFacade;
import com.training.flowersshop.model.Customer;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerFacade customerFacade;

    @PostMapping(path = "/add")
    public @ResponseBody Customer addNewCustomer(@RequestParam String name, @RequestParam String phone,
            @RequestParam String email, @RequestParam String address) {
        return customerFacade.addOrUpdate(name, phone, email, address);

    }

    @GetMapping(path = "/all")
    public @ResponseBody List<Customer> listAllCustomer() {
        return customerFacade.listAllCustomer();
    }

    @GetMapping(path = "/delete/{customerId}")
    public @ResponseBody String deleteCustomerById(@PathVariable int customerId) {
        customerFacade.deleteCustomerById(customerId);
        return "Customer " + customerId + " deleted successfully";
    }

    @PostMapping(path = "/update")
    public @ResponseBody Customer updateCustomer(@RequestParam String name, @RequestParam String phone,
            @RequestParam String email, @RequestParam String address) {
        return customerFacade.addOrUpdate(name, phone, email, address);
    }

}
