package org.example;

import java.time.LocalDateTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MainMenu.showMenu();

        TransactionLedger.showLedgerMenu();

        ReportMenu.showReportMenu();


    }
}