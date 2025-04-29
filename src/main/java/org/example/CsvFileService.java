package org.example;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvFileService {


    private static final String FILENAME = "transactions.csv";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");

    public static void saveTransaction(Transaction transaction) {

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            final String line = transaction.getDateTime().format(dateFormatter) + "|" +
                    transaction.getDateTime().format(timeFormatter) + "|" +
                    transaction.getDescription() + "|" +
                    transaction.getVendor() + "|" +
                    transaction.getAmount();

            writer.write(line + System.lineSeparator());
            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    public static List<Transaction> readTransaction (){

        List<Transaction> transactions = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));

            String line;

            while ((line = reader.readLine()) != null) {
                 Transaction transaction = parseTransaction(line);
                 if (transaction != null){
                     transactions.add(transaction);
                 }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return transactions;
    }

    private static Transaction parseTransaction(String line) {
        try {
            String[] parts = line.split("\\|");
            if (parts.length != 5)
                return null;

            LocalDateTime dateTime = parse(parts[0] + "|" + parts[1]); // date|time together
            String description = parts[2];
            String vendor = parts[3];
            double amount = Double.parseDouble(parts[4]);

            Transaction transaction = new Transaction();
            transaction.setDateTime(dateTime);
            transaction.setDescription(description);
            transaction.setVendor(vendor);
            transaction.setAmount(amount);

            return transaction;
        } catch (Exception e) {
            System.err.println("Failed to parse transaction line: " + line);
            return null;
        }
    }

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }

    public static LocalDateTime parse(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, FORMATTER);
    }
}




