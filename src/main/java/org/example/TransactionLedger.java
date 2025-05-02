package org.example;

import java.util.List;
import java.util.Scanner;
public class TransactionLedger {

    public static void showLedgerMenu(){

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println();
            System.out.println("========== Ledger Menu ==========");
            System.out.println("A) All Transactions");
            System.out.println("D) Deposits Only");
            System.out.println("P) Payments Only");
            System.out.println("R) Reports");
            System.out.println("H) Back to Home");
            System.out.print("Choose an option: ");

            String ledgerChoice = scanner.nextLine().trim().toUpperCase();
            List<Transaction> transactions = CsvFileService.readTransaction();

            switch (ledgerChoice) {
                case "A":
                    System.out.println("All Transaction:");
                    for (Transaction t : transactions)
                        System.out.println(t);
                    break;
                case "D":
                    for (Transaction transaction : transactions) {
                        if (transaction.getAmount() > 0)
                            System.out.println(transaction);
                    }
                    break;
                case "P":
                    for (Transaction transaction : transactions) {
                        if (transaction.getAmount() < 0)
                            System.out.println(transaction);
                    }
                    break;
                case "R" :
                    ReportMenu.showReportMenu();
                    break;

                case "H":
                    System.out.println("Returning to Home Menu...");
                    MainMenu.showMenu();
                    return;
            }
        }
    }
}











