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
public class ItemTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAddItemType() throws Exception {
        this.mockMvc.perform(post("/itemType/add").param("name", "flower")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testDeleteItemById() throws Exception {
        this.mockMvc.perform(get("/itemType/delete/{itemTypeId}", 1)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testListAllItemTypess() throws Exception {
        this.mockMvc.perform(get("/itemType/all")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testUpdateItemType() throws Exception {
        this.mockMvc.perform(post("/itemType/update").param("id","1").param("name", "flower")).andDo(print()).andExpect(status().isOk());
    }
}
