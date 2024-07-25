# Hotel Management System

Welcome to the **Hotel Management System**, a comprehensive application developed in Java to streamline hotel operations and enhance customer experiences. This system uses SQL for robust data management and storage, ensuring that all information is handled efficiently and securely.

## Features

- **Room Booking:** Seamlessly manage room bookings, availability, and pricing.
- **Customer Management:** Maintain detailed records of customer information, preferences, and history.
- **Staff Management:** Organize staff schedules, roles, and responsibilities.
- **Billing and Invoicing:** Generate invoices, track payments, and manage financial transactions.
- **Inventory Management:** Monitor inventory levels, track supplies, and manage stock.
- **Reporting:** Generate insightful reports on occupancy, revenue, and performance metrics.

## Technology Stack

- **Java:** Core application logic and functionality.
- **SQL:** Database management for storing and retrieving data efficiently.
- **JDBC:** Java Database Connectivity for seamless interaction with the database.
- **Swing:** User interface for desktop applications.

## Packages and Tools Required

- **IntelliJ-IDEA:** The IDE used for make develop this project.
- **WAMP Server:** Wampp server needs to be installed in your system.
- **mysql-connector-j-9.0.0.jar:** This file is located in project root directory, import it as reference jar file to connect mySQL.
- **rs2xml.jar:** This file is also located in project root directory, import it as reference jar file to resolve the package ***import net.proteanit.sql.DbUtils;***
- **mySQL workbench:** It is needed to view or modify the databse running over the ***port:3306***

### Note:
**By default username is admin and password is root, you can further change the username and password by updating the entry:**
```shell
INSERT INTO login (username, password)
VALUES ('admin', 'root');
```
**in *HMS.sql* file located in project root directory.***