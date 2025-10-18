# Report Generator Application

A simple Java project demonstrating the **Template Method Design Pattern**.

## Overview
This application generate different types of report — **Sales, Employee, and Inventory** — using a shared workflow defined in an abstract class `ReportTemplate`.  
Each report type customize how data is gathered and processed while reusing the overall report generation process.

## UML Diagram
```text
        +----------------------+
        |   ReportTemplate     |
        +----------------------+
        | + generateReport()   |
        | + formatReport()     |
        | + printReport()      |
        | # gatherData()       |
        | # processData()      |
        +----------^-----------+
                   |
   -------------------------------------------
   |                   |                     |
+----------+      +-------------+      +----------------+
| SalesReport |   | EmployeeReport |   | InventoryReport |
+----------+      +-------------+      +----------------+
| + gatherData()  | + gatherData()    | + gatherData()  |
| + processData() | + processData()   | + processData() |
+-----------------+------------------+-----------------+
