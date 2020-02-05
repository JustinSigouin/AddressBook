package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    public AddressBookController() {
    }

    @GetMapping("/create")
    public AddressBook create() {
        AddressBook addressBook = new AddressBook();
        addressBook = addressBookRepository.save(addressBook);
        return addressBook;
    }

    @GetMapping("/addBuddy")
    public AddressBook createBuddy(@RequestParam("bookId") int bookId,
                                   @RequestParam("name") String name,
                                   @RequestParam("number") String number,
                                   @RequestParam("address") String address) {
       AddressBook addressBook = addressBookRepository.findById(bookId);
       addressBook.addBuddy(new BuddyInfo(name, number, address));
       addressBookRepository.save(addressBook);
       return addressBook;
    }

    @GetMapping("/removeBuddy")
    public AddressBook removeBuddy(@RequestParam("bookId") int bookId, @RequestParam("buddyId") int buddyId) {
        AddressBook addressBook = addressBookRepository.findById(bookId);
        addressBook.removeBuddy(buddyId);
        addressBookRepository.save(addressBook);
        return addressBook;
    }
}
