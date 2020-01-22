package ru.gb.jtwo.ltwo.online.exceptions;

import java.util.Arrays;

public class MainClass {
    static String string = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

    public static void main(String[] args) {
        String[][] result;
        int halfSumma;

        try {
            result = fillArray(string);
        } catch (IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Arrays.deepToString(result));

        try {
            halfSumma = halfSumOfArray(result);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Сумма массива деленная пополам: " + halfSumma);
    }


    static String[][] fillArray(String s) {
        String[] tempArray = s.split("\\n");
        String[][] result = new String[4][];

        for (int i = 0; i < tempArray.length; i++) {
            result[i] = tempArray[i].split("\\s");
        }

        return result;
    }


    static int halfSumOfArray(String[][] array) {
        int summa = 0;

        for (String[] strings : array) {
            for (String s : strings) {
                summa += Integer.parseInt(s);
            }
        }

        return summa / 2;
    }
}
