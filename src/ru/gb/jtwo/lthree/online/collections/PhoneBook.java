package ru.gb.jtwo.lthree.online.collections;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    HashMap<String, Person> phoneBook;

    public PhoneBook(HashMap<String, Person> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void addEntry(Person person) {
        phoneBook.put(person.getSurname(), person);
    }

    //По хорошему оба нижеследуюших метода объеденить бы в один, тк DRY, но
    // сугубо из-за условий поставленной задачи оставляю оба :)
    ArrayList<String> findNumber(String surname) {
        ArrayList<String> phones = new ArrayList<>();
        if (phoneBook.containsKey(surname)) {
            phones.add(phoneBook.get(surname).number);
        }

        return phones;
    }

    ArrayList<String> findEmail(String surname) {
        ArrayList<String> emails = new ArrayList<>();
        if (phoneBook.containsKey(surname)) {
            emails.add(phoneBook.get(surname).email);
        }

        return emails;
    }
}
