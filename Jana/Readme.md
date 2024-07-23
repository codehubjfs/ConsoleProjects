#!/bin/bash

# Create the repository structure
mkdir -p AssessmentToolProject/{ConsoleVersion,ServletVersion,SpringVersion}

# Create the README file
cat <<EOL > AssessmentToolProject/README.md
# Assessment Tool Project

This repository contains three versions of an assessment tool project that enables admins to manage students, teachers, and courses. The tool also allows teachers to create and schedule assessments, and students to attend these assessments and view their scores. The three versions are: Console Version, Servlet Version, and Spring Version.

## Features

### Admin
- CRUD operations on students, teachers, and courses.
- Assign courses to students and teachers.
- Assign multiple courses to teachers.

### Teachers
- Create and schedule assessments for courses.
- Add existing questions from the question bank to assessments or add new questions (only MCQs).
- View students' performance on assessments.

### Students
- Attend assessments on the scheduled time.
- View scores upon completion of assessments.

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

- **Assessment_Tool_Console_Version/**: Contains the console-based version of the assessment tool.
- **Assessment_Tool_Servlet/**: Contains the JSP/Servlet version of the assessment tool.
- **Assessment_Tool_Spring/**: Contains the Spring version of the assessment tool.

## Prerequisites

Before you begin, ensure you have the following installed on your machine:
- Java 8 or higher
- Maven
- Oracle Database
- IDE (Eclipse, IntelliJ, etc.)

## Getting Started

### Console Version
1. Navigate to the \`Assessment_Tool_Console_Project\` directory.
2. Open the project in your IDE.
3. Import Oracle_Script.
4. Run the project using your IDE.

### Servlet Version
1. Navigate to the \`*Assessment_Tool_Servlet\` directory.
2. Open the project in your IDE.
3. Import Oracle_Script.
4. Build the project using Maven: \`mvn clean install\`.
5. Deploy the generated WAR file to your servlet container (Tomcat).
6. Access the application at \`http://localhost:8080/Assessment_Tool_Servlet\`.

### Spring Version
1. Navigate to the \`Assessment_Tool_Spring\` directory.
2. Open the project in your IDE.
3. Import Oracle_Script.
4. Build the project using Maven: \`mvn clean install\`.
5. Deploy the generated WAR file to your servlet container (Tomcat).
6. Access the application at \`http://localhost:8080/Assessment_Tool_Spring\`.

## Contributing

Contributions are welcome! Please fork this repository and submit pull requests.

For any issues or questions, please open an issue on GitHub.

Happy coding!
EOL


