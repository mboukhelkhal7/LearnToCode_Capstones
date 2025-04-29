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
            String choice = scanner.nextLine().trim();

            String reportChoice = scanner.nextLine().trim().toUpperCase();
            List<Transaction> transactions = CsvFileService.readTransaction();

            switch (reportChoice){
                case "1":
                    for (Transaction transaction : transactions){
                        
                    }

            }


        }
    }

}
