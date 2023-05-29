package com.training.flowersshop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddOrderItem() throws Exception {
        this.mockMvc.perform(post("/order/item/add").param("quantity", "10")
        .param("flowersOrderId", "2").param("itemId", "2"))
        .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testDeleteItemById() throws Exception {
        this.mockMvc.perform(get("/order/item/delete/{orderItemId}", "1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testListAllOrderItemss() throws Exception {
        this.mockMvc.perform(get("/order/item/all"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testUpdateOrderItem() throws Exception {
        this.mockMvc.perform(post("/order/item/update").param("id","1").param("quantity", "10")
                .param("flowersOrderId", "2").param("itemId", "2"))
                .andDo(print()).andExpect(status().isOk());
    }
}
