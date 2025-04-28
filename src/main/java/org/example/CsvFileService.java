package org.example;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvFileService {


    private static final String FileName = "transactions.csv";

    public static void saveTransaction(Transaction transaction) {

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(FileName, true))) {
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
            BufferedReader reader = new BufferedReader(new FileReader(FileName));

            String line;

            while ((line = reader.readLine()) !=null){
                 Transaction transaction = parseTransaction(line);
                 if (transaction !=null){
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
            if (parts.length != 5) {
                return null;
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}




