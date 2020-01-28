package ru.gb.jtwo.lthree.online.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MainClass {
    static String[] strings = {"Опять", "как", "в", "избы", "золотые", "Три", "стертых", "треплются",
        "шлеи", "И", "вязнут", "слезы", "расписные", "В", "расхлябанные", "колеи", "Россия",
        "нищая", "Россия", "Мне", "избы", "серые", "Твои", "Твои", "мне", "песни", "ветровые",
        "Как", "слезы", "первые", "любви"};

    public static void main(String[] args) {
        HashSet<String> uniqueWords = makeSet(strings);
        System.out.println("В массиве уникальных слов: " + uniqueWords.size());

        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(countWords(map));

        Person person1 = new Person("Иванов", "222333", "ivanov@mail.com");
        Person person2 = new Person("Иванов", "555555", "ivanov@somemail.net");
        Person person3 = new Person("Петров", "7777777", "petrov@mail.com");

        ArrayList<Person> personsList = new ArrayList<>();
        personsList.add(person1);
        personsList.add(person2);
        personsList.add(person3);

        HashMap<String, Person> phoneBook = new HashMap<>();
        PhoneBook book = new PhoneBook(phoneBook);
        for (int i = 0; i < personsList.size() ; i++) {
            book.addEntry(personsList.get(i));
        }

        //Не получается запихнуть две одинаковые фамилии,
        // тк PhoneBook - это Hashmap c ключом по фамилии или я что то не понимаю.. :(
        ArrayList<String> phones = book.findNumber("Иванов");
        System.out.println(phones);

        ArrayList<String> emails = book.findEmail("Петров");
        System.out.println(emails);
    }

    private static HashMap<String, Integer> countWords(HashMap<String, Integer> map) {
        for (int i = 0; i < strings.length; i++) {
            if (!map.containsKey(strings[i]))
                map.put(strings[i], 0);
            map.put(strings[i], map.get(strings[i]) + 1);
        }
        return map;
    }

    private static HashSet<String> makeSet(String[] array) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        return set;
    }
}
