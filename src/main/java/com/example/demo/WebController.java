package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/get")
    public String get(@RequestParam("bookId") int bookId, Model model) {
        AddressBook addressBook = addressBookRepository.findById(bookId);
        model.addAttribute("addressBook", addressBook);
        return "AddressBook";
    }

}