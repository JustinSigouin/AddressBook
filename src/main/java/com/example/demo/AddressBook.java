package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id = null;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    protected List<BuddyInfo> buddies;

    public AddressBook () {
        buddies = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
    }

    public void removeBuddy(int buddyId) {
        buddies.removeIf(b -> b.getId() == buddyId);
    }

    public List<BuddyInfo> getBuddyList() {
        return buddies;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "buddies=" + buddies +
                '}';
    }

    public static void main(String []args) {
        AddressBook book = new AddressBook();
        book.addBuddy(new BuddyInfo("Justin", "123"));
        book.addBuddy(new BuddyInfo("An", "1234"));
        book.addBuddy(new BuddyInfo("Josh", "12345"));
        System.out.println(book);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

