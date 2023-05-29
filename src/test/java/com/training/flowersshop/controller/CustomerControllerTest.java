package com.training.flowersshop.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddNewCustomer() throws Exception {
        this.mockMvc
                .perform(post("/customer/add")
                    .param("name", "Ahmed")
                    .param("phone", "0123456789")
                    .param("email", "a.b@d.e")
                    .param("address", "Haar, Germany")).andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteCustomerById() throws Exception {
        this.mockMvc
                .perform(get("/customer/delete/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testListAllCustomer() throws Exception {
        this.mockMvc.perform(get("/customer/all")).andDo(print()).andExpect(status().isOk()).andExpect(
                status().isOk());
    }

    @Test
    void testUpdateCustomer() throws Exception {
        this.mockMvc
                .perform(post("/customer/add")
                        .param("id", "1")
                        .param("name", "Ahmed")
                        .param("phone", "0123456789")
                        .param("email", "a.b@d.e")
                        .param("address", "Haar, Germany"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
