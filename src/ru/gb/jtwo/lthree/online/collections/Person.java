package ru.gb.jtwo.lthree.online.collections;

public class Person {
    String surname;
    String email;
    String number;

    public Person(String surname, String number, String email) {
        this.surname = surname;
        this.email = email;
        this.number = number;
    }

    public String getSurname() {
        return surname;
    }
}
