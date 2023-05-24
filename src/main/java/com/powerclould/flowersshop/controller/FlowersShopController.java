package com.powerclould.flowersshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.powerclould.flowersshop.model.Customer;
import com.powerclould.flowersshop.model.FlowersOrder;
import com.powerclould.flowersshop.model.Item;
import com.powerclould.flowersshop.model.ItemType;
import com.powerclould.flowersshop.model.OrderItem;
import com.powerclould.flowersshop.repository.CustomerRepository;
import com.powerclould.flowersshop.repository.FlowersOrderRepository;
import com.powerclould.flowersshop.repository.ItemRepository;
import com.powerclould.flowersshop.repository.ItemTypeRepository;
import com.powerclould.flowersshop.repository.OrderItemRepository;

@Controller
@RequestMapping(path = "/flowersshop")
public class FlowersShopController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemTypeRepository itemTypeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private FlowersOrderRepository flowersOrderRepository;

    @PostMapping(path = "/flowers/add")
    public @ResponseBody String addFreshFlower(@RequestParam String name, @RequestParam String type,
            @RequestParam float price, @RequestParam int quantity) {
        Item flower = new Item();

        flower.setName(name);
        flower.setPrice(price);
        flower.setType(type);
        flower.setQuantity(quantity);
        flower.setItemType(getItemType(1));
        itemRepository.save(flower);

        return "Added a new flower";
    }

    @PostMapping(path = "/wrappers/add")
    public @ResponseBody String addNewWrapper(@RequestParam String name, @RequestParam String type,
            @RequestParam float price, @RequestParam int quantity) {
        Item wrapper = new Item();

        wrapper.setName(name);
        wrapper.setPrice(price);
        wrapper.setType(type);
        wrapper.setQuantity(quantity);
        wrapper.setItemType(getItemType(2));
        itemRepository.save(wrapper);

        return "Added a new flower";
    }

    @GetMapping(path = "/flowers/all")
    private @ResponseBody List<Item> listAllFlowers() {
        Optional<ItemType> itemType = itemTypeRepository.findById(1);
        if(itemType.isPresent()) {
            return itemRepository.findByItemType(itemType.get());
        }
        else {
            return null;
        }
    }
    
    @GetMapping(path = "/wrappers/all")
    private @ResponseBody List<Item> listAllWrappers() {
        Optional<ItemType> itemType = itemTypeRepository.findById(2);
        if (itemType.isPresent()) {
            return itemRepository.findByItemType(itemType.get());
        } else {
            return null;
        }
    }

    private ItemType getItemType(int itemTypeId) {
        Optional<ItemType> itemType = itemTypeRepository.findById(itemTypeId);
        if (itemType.isPresent()) {
            return itemType.get();
        }

        return null;
    }

    @PostMapping(path = "/customers/add")
    public @ResponseBody String addNewCustomer(@RequestParam String name, @RequestParam String phone,
            @RequestParam String email, @RequestParam String address) {
        Customer customer = new Customer(name, phone, email, address);

        customerRepository.save(customer);

        return "Added a new customer";
    }

    @GetMapping(path = "/flowers/buy")
    public @ResponseBody String buyFlowers() {
        //find customer
        List<Customer> customers = customerRepository.findByEmail("abc@d.com");
        //Create Order
        FlowersOrder flowersOrder = new FlowersOrder();
        //Create Order items
        OrderItem flowerOrderItem = new OrderItem();
        OrderItem wrapperOrderItem = new OrderItem();
        //set customer id in order
        customers.stream().findFirst().ifPresent(customer -> flowersOrder.setCustomer(customer));
        // find products
        Optional<Item> daliaFlower = itemRepository.findById(2);
        Optional<Item> indigoWrapper = itemRepository.findById(1);
        // save order
        flowersOrderRepository.save(flowersOrder);
        // if the products are there  insert them into the order item table
        daliaFlower.ifPresent(flower -> {flowerOrderItem.setItem(flower); flowerOrderItem.setFlowersOrderId(flowersOrder);});
        indigoWrapper.ifPresent(wrapper -> {wrapperOrderItem.setItem(wrapper); wrapperOrderItem.setFlowersOrderId(flowersOrder);});
        orderItemRepository.save(flowerOrderItem);
        orderItemRepository.save(wrapperOrderItem);

        return "done";
    }
}
