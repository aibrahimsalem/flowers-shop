package com.training.flowersshop.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddItem() throws Exception {
        this.mockMvc
                .perform(post("/item/add")
                        .param("name", "FlowerA")
                        .param("quantity", "10")
                        .param("type", "natural")
                        .param("color", "Haar, Germany")
                        .param("price", "1.25")
                        .param("material", "plastic"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteItemById() throws Exception {
        this.mockMvc
                .perform(get("/item/delete/{itemId}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testListAllItems() throws Exception {
        this.mockMvc
                .perform(get("/item/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateItem() throws Exception {
        this.mockMvc.perform(post("/item/update")
                        .param("id", "1")
                        .param("name", "FlowerA")
                        .param("quantity", "10")
                        .param("type", "natural")
                        .param("color", "Haar, Germany")
                        .param("price", "1.25")
                        .param("material", "plastic"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
