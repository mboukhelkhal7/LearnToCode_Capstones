package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

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
}
