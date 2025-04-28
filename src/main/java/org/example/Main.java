package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            //Display Menu

            System.out.println();
            System.out.println("===============================");
            System.out.println("       Transaction Tracker");
            System.out.println("===============================");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice){
                case "D":
                    System.out.println("You chose to Add a Deposit.");
                    // Later: call method to add a deposit
                    break;
                case "P":
                    System.out.println("You chose to Make a Payment (Debit).");
                    // Later: call method to make a payment
                    break;
                case "L":
                    System.out.println("You chose to View Ledger.");
                    // Later: call method to view ledger
                    break;
                case "X":
                    System.out.println("Goodbye!");
                   return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }


    }
}