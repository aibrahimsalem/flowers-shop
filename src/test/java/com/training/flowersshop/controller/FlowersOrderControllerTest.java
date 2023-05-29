package com.training.flowersshop.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class FlowersOrderControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void testAddFlowersOrder() throws Exception {
        this.mockMvc
                .perform(post("/orders/add")
                        .param("customerId", "1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteFlowersOrderById() throws Exception {
        this.mockMvc
                .perform(get("/orders/delete/{flowersOrderId}", 2))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testGetAllFlowersOrder() throws Exception {
        this.mockMvc
                .perform(get("/orders/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateFlowersOrder() throws Exception {
        this.mockMvc
                .perform(post("/orders/update")
                        .param("id", "1")
                        .param("customerId", "2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
