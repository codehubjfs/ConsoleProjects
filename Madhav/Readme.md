# Issue Raise System

This repository contains a project that allows students to raise issues, wardens to allocate issues to supervisors, supervisors to allocate workers for particular issues, and admins to manage CRUD operations for students, wardens, and supervisors.

## Features

### Students
- Raise issues related to their accommodation.
- View the status of raised issues.

### Wardens
- View issues raised by students.
- Assign the issues to specific supervisors.

### Supervisors
- View assigned issues.
- Allocate workers to handle specific issues.

### Admin
- CRUD operations on students, wardens, and supervisors.
- View all issues raised by students.
- Oversee the overall issue management process.

## Technologies Used

### Console Version
- Java
- Maven
- Oracle DB
- JDBC

### Servlet Version
- Java
- Maven
- Oracle DB
- JDBC
- JSP
- Servlet
- HTML
- CSS
- Bootstrap
- JavaScript
- jQuery

### Spring Version
- Java
- Maven
- Oracle DB
- MyBatis
- JSP
- Spring
- HTML
- CSS
- Bootstrap
- JavaScript
- jQuery

## Repository Structure

- *Issue_Raise_Console_Version/*: Contains the console-based version of the issue raise system.
- *Issue_Raise_Servlet/*: Contains the JSP/Servlet version of the issue raise system.
- *Issue_Raise_Spring/*: Contains the Spring version of the issue raise system.

## Prerequisites

Before you begin, ensure you have the following installed on your machine:
- Java 8 or higher
- Maven
- Oracle Database
- IDE (Eclipse, IntelliJ, etc.)

## Getting Started

### Console Version
1. Navigate to the \Issue_Raise_Console_Project\ directory.
2. Open the project in your IDE.
3. Update the \application.properties\ file with your Oracle DB credentials.
4. Run the project using your IDE.

### Servlet Version
1. Navigate to the \Issue_Raise_Servlet\ directory.
2. Open the project in your IDE.
3. Update the \db.properties\ file with your Oracle DB credentials.
4. Build the project using Maven: \mvn clean install\.
5. Deploy the generated WAR file to your servlet container (Tomcat).
6. Access the application at \http://localhost:8080/Issue_Raise_Servlet\.

### Spring Version
1. Navigate to the \Issue_Raise_Spring\ directory.
2. Open the project in your IDE.
3. Update the \application.properties\ file with your Oracle DB credentials.
4. Build the project using Maven: \mvn clean install\.
5. Deploy the generated WAR file to your servlet container (Tomcat).
6. Access the application at \http://localhost:8080/Issue_Raise_Spring\.

## Contributing

Contributions are welcome! Please fork this repository and submit pull requests.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

---

For any issues or questions, please open an issue on GitHub.

Happy coding!

