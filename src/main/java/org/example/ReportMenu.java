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
            System.out.println("0) Back");
            System.out.print("Choose an option: ");


            String reportChoice = scanner.nextLine().trim().toUpperCase();


            switch (reportChoice){
                case "1":
                    List<Transaction> monthToDateTransactions = CsvFileService.getMonthToDateTransactions();
                    System.out.println(monthToDateTransactions);
                    break;
                case "2":
                    List<Transaction> previousMonthTransaction = CsvFileService.getPreviousMonth();
                    System.out.println(previousMonthTransaction);
                    break;

            }


        }
    }

}
