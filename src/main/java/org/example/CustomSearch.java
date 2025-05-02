package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.CsvFileService.readTransaction;

public class CustomSearch {
    public static void runCustomSearch() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Start Date (yyyy-MM-dd) or press Enter to skip: ");
        String startDateInput = scanner.nextLine();
        LocalDate startDate = startDateInput.isEmpty() ? null : LocalDate.parse(startDateInput, formatter);

        System.out.print("End Date (yyyy-MM-dd) or press Enter to skip: ");
        String endDateInput = scanner.nextLine();
        LocalDate endDate = endDateInput.isEmpty() ? null : LocalDate.parse(endDateInput, formatter);

        System.out.print("Description or press Enter to skip: ");
        String description = scanner.nextLine().trim();

        System.out.print("Vendor or press Enter to skip: ");
        String vendor = scanner.nextLine().trim();

        System.out.print("Amount or press Enter to skip: ");
        String amountInput = scanner.nextLine().trim();
        Double amount = amountInput.isEmpty() ? null : Double.parseDouble(amountInput);

        List<Transaction> allTransactions = CsvFileService.readTransaction();
        List<Transaction> results = new ArrayList<>();

        for (Transaction t : allTransactions) {
            boolean match = true;

            if (startDate != null && t.getDateTime().toLocalDate().isBefore(startDate)) match = false;
            if (endDate != null && t.getDateTime().toLocalDate().isAfter(endDate)) match = false;
            if (!description.isEmpty() && !t.getDescription().toLowerCase().contains(description.toLowerCase()))
                match = false;
            if (!vendor.isEmpty() && !t.getVendor().toLowerCase().contains(vendor.toLowerCase())) match = false;
            if (amount != null && t.getAmount() != amount) match = false;

            if (match) results.add(t);
        }
        if (results.isEmpty()) {
            System.out.println("No matching transactions found.");
        } else {
            for (Transaction t : results) {
                System.out.println(t);
            }
        }
    }
}


