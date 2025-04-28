package org.example;

import java.time.LocalDateTime;
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

                    System.out.println("Enter the description");
                    String description = scanner.nextLine();

                    System.out.print("Enter the vendor: ");
                    String vendor = scanner.nextLine();

                    System.out.print("Enter the amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    // Create a  Transaction
                    Transaction transaction = new Transaction(description, vendor, amount);

                    CsvFileService.saveTransaction(transaction);




                    break;
                case "P":
                    System.out.println("You chose to Make a Payment (Debit).");
                    // Later: call method to make a payment



                    System.out.println("Enter the description");
                    String payDescription = scanner.nextLine();

                    System.out.println("Enter the vendor");
                    String payVendor = scanner.nextLine();


                    System.out.println("Enter the amount");
                    double payAmount = Double.parseDouble(scanner.nextLine());

                    if (payAmount > 0) {
                        System.err.println("payment should be negative");
                        return;
                    }

                    Transaction paymentTransaction = new Transaction(payDescription, payVendor, payAmount);

                    CsvFileService.saveTransaction(paymentTransaction);

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