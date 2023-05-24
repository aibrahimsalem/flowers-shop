package com.powerclould.flowersshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.powerclould.flowersshop.facade.CustomerFacade;

@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    
    @Autowired
    private CustomerFacade customerFacade;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewCustomer(@RequestParam String name, @RequestParam String phone,
            @RequestParam String email, @RequestParam String address) {
        return customerFacade.addNewCustomer(name, phone, email, address);

    }
    
}
