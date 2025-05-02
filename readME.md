# Accounting Ledger App

## 📊 Overview

The **Accounting Ledger App** is a Java-based command-line interface (CLI) tool designed to help users track financial transactions, generate reports, and search records efficiently. It stores all transactions in a CSV file (`transactions.csv`) and supports a variety of built-in and custom reporting features.

This project showcases beginner-friendly object-oriented programming, file handling, and user interaction through terminal input.

---

## 🚀 Features

- ✅ Add new **deposits** and **payments**
- 📋 Display:
    - All transactions
    - Deposits only
    - Payments only
- 🧾 Generate Reports:
    - Month to Date
    - Previous Month
    - Year to Date
    - Previous Year
    - Search by Vendor
    - 🔍 **Custom Search** *(filter by date, vendor, description, and amount)*

---

## 📁 Data Format

All transactions are saved to a file named `transactions.csv` in the format:

```
yyyy-MM-dd|HH:mm:ss|description|vendor|amount
```

### Example:
```
2025-04-28|15:30:12|Office Chair|Amazon|-120.00
```

---

## 🛠 Technologies Used

- **Java 17+**
- **CSV file I/O** with `BufferedReader` and `BufferedWriter`
- **Date/Time** with `java.time`
- **OOP** design: multiple classes for service, data, and UI separation

---

## 📌 Interesting Code Snippet

The custom search feature allows dynamic filtering across multiple optional fields. Users can skip fields by pressing Enter. Here’s how filtering logic works:

```java
if (startDate != null && t.getDateTime().toLocalDate().isBefore(startDate)) match = false;
if (endDate != null && t.getDateTime().toLocalDate().isAfter(endDate)) match = false;
if (!description.isEmpty() && !t.getDescription().toLowerCase().contains(description.toLowerCase())) match = false;
if (!vendor.isEmpty() && !t.getVendor().toLowerCase().contains(vendor.toLowerCase())) match = false;
if (amount != null && t.getAmount() != amount) match = false;
```

This approach demonstrates conditional filtering based on user input without overcomplicating the logic, perfect for beginner Java learners.

---


## 🧑‍💻 How to Run

1. Clone this repository or download the source code.
2. Open the project in IntelliJ or your preferred Java IDE.
3. Run `Main.java`.
4. Follow on-screen prompts to interact with the app.

---

## 📚 Folder Structure

```
src/
├── org.example/
│   ├── Main.java
│   ├── MainMenu.java
│   ├── Transaction.java
│   ├── TransactionLedger.java
│   ├── ReportMenu.java
│   ├── CustomSearch.java
│   └── CsvFileService.java
└── resources/
    └── transactions.csv
```

---

## 🙌 Credits

Developed by Mahmoud Boukhelkhal  
For learning and portfolio purposes.

---

## 📌 Future Improvements

- Add sorting and pagination
- Export report results to a separate CSV
- GUI version with JavaFX or Swing
