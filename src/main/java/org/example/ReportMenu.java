package org.example;

import java.util.List;
import java.util.Scanner;

public class ReportMenu {

    public static void showReportMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n======= Reports Menu =======");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");

            String reportChoice = scanner.nextLine().trim().toUpperCase();

            switch (reportChoice){
                case "1":
                    List<Transaction> monthToDateTransactions = CsvFileService.getMonthToDateTransactions();
                    for (Transaction transaction : monthToDateTransactions)
                        System.out.println(transaction);
                    break;
                case "2":
                    List<Transaction> previousMonthTransaction = CsvFileService.getPreviousMonth();
                    for (Transaction transaction : previousMonthTransaction)
                        System.out.println(transaction);
                    break;
                case "3":
                    List<Transaction> yearToDateTransactions = CsvFileService.getYearToDateTransaction();
                    for (Transaction transaction : yearToDateTransactions)
                        System.out.println(transaction );
                    break;
                case "4":
                    List<Transaction> previousYear = CsvFileService.getPreviousYearTransaction();
                    for (Transaction transaction : previousYear)
                        System.out.println(transaction);
                    break;
                case "5":
                    System.out.print("Enter vendor name to search: ");
                    String vendorName = scanner.nextLine();
                    List<Transaction> vendorTransaction = CsvFileService.getTransactionByVendor(vendorName);
                    if (vendorTransaction.isEmpty()) {
                        System.out.println("No transactions found for vendor: " + vendorName);
                    } else {
                        for (Transaction transaction : vendorTransaction) {
                            System.out.println(transaction);
                        }
                    }
                    break;
                case "0":
                    System.out.println("Returning to Ledger Menu...");
                    //TransactionLedger.showLedgerMenu();
                    return;

                case "6":
                    CustomSearch.runCustomSearch();
                    break;

            }

        }
    }

}
