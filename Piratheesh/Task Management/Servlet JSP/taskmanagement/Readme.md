cat <<EOL > TaskManagementApplication/ServletVersion/README.md
# Task Management Application - Servlet Version

## Introduction
This Task Management application is developed using Java, Servlets, JSP, Maven, Oracle JDBC, and MyBatis.

## Features

### For Employees
- Create and manage personal tasks
- Search for assigned tasks based on deadlines
- Update task status
- View and manage their profile

### For Managers
- Create and assign tasks
- Search for employees
- View and manage their profile
- Create and manage personal tasks

### For Admins
- Manage user accounts
- Monitor performance
- Add new employees and managers
- Add new admins

## Technologies Used
- Java
- Maven
- Oracle Database
- JDBC
- MyBatis
- Servlet
- JSP
- HTML
- CSS
- Bootstrap
- JavaScript
- jQuery

## Prerequisites
Before you begin, ensure you have the following installed on your machine:
- Java 8 or higher
- Maven
- Oracle Database
- IDE (Eclipse, IntelliJ, etc.)

## Getting Started

1. Clone the repository:
   \`\`\`bash
   git clone https://github.com/yourusername/TaskManagementApplication.git
   \`\`\`
2. Navigate to the servlet version directory:
   \`\`\`bash
   cd TaskManagementApplication/ServletVersion
   \`\`\`
3. Open the project in your IDE.
4. Update the \`db.properties\` file with your Oracle DB credentials.
5. Build the project using Maven:
   \`\`\`bash
   mvn clean install
   \`\`\`
6. Deploy the generated WAR file to your servlet container (Tomcat).
7. Access the application at \`http://localhost:8080/TaskManagementApplication/ServletVersion\`.

## Contributing

Contributions are welcome! Please fork this repository and submit pull requests.
