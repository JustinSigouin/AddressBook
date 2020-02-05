package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AddressBookController.class)
public class TestWebApp {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressBookRepository service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        AddressBook addressBook = new AddressBook();
        when(service.findById(1)).thenReturn(addressBook);
        this.mockMvc.perform(get("/create"));
        this.mockMvc.perform(get("/addBuddy?bookId=1&name=justin&number=55")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":null,\"buddyList\":[{\"id\":null,\"name\":\"justin\",\"phoneNumber\":\"55\"}]}")));
    }
}