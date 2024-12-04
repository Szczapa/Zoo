package org.example;

import org.example.Console.ConsoleMenu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConsoleMenu console = new ConsoleMenu();
        Scanner scanner = new Scanner(System.in);
        console.startMenu(scanner);
        scanner.close();
    }
}