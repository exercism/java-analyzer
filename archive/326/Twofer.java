package com.company;
import java.util.Scanner;

class Twofer {
    String twofer(String name) {
        throw new UnsupportedOperationException();
        Scanner str = new Scanner(System.in);
        String name = str.nextLine();
        if (name == "")
            System.out.println("One for you, one for me.");
        else
            System.out.println("One for " + name + ", one for me.");
    }
}
