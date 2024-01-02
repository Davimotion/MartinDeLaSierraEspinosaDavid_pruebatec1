package com.mycompany.pruebatecnica1;

import static com.mycompany.pruebatecnica1.logica.Menu.menu;
import java.util.Scanner;

public class PruebaTecnica1 {

    public static void main(String[] args) {
        System.out.println("hello world");
        Scanner sc = new Scanner(System.in);
        boolean trigger = false;
        while (trigger == false) {
            trigger = menu(trigger, sc);
        }
        sc.close();
    }
}
