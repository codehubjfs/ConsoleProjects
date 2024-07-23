
# Leave Management System

## Introduction

A comprehensive Leave Management System built with different technologies to simplify and automate the process of managing employee leaves. The project includes three versions: console-based, JSP/Servlet, and Spring web MVC, each with different levels of user functionality.

## Table of Contents

- [Phase 1: Console-based](#phase-1-console-based)
  - [Features](#features-1)
  - [Technologies](#technologies-1)
  - [Installation](#installation-1)
  - [Configuration](#configuration-1)
  - [Usage](#usage-1)
- [Phase 2: JSP/Servlet](#phase-2-jsps-ervlet)
  - [Features](#features-2)
  - [Technologies](#technologies-2)
  - [Installation](#installation-2)
  - [Configuration](#configuration-2)
  - [Usage](#usage-2)
- [Phase 3: Spring web MVC](#phase-3-spring-web-mvc)
  - [Features](#features-3)
  - [Technologies](#technologies-3)
  - [Installation](#installation-3)
  - [Configuration](#configuration-3)
  - [Usage](#usage-3)
- [Contributing](#contributing)
- [Contact](#contact)

## Phase 1: Console-based

### Features

- Employee leave request submission
- Employee leave cancellation and updating leave requests
- Employees can view their leave history
- Leave balance tracking
- Manager leave approval/rejection
- Managers can view teams
- Admins can manage users and departments
- Basic leave balance tracking
- Role-based access control

### Technologies

- **Backend:** Java with JDBC
- **Database:** Oracle DB

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/codehubjfs/ConsoleProjects.git
    cd ConsoleProjects
    cd Samrutha
    cd LeaveManagementSystem_Console
   ```

2. **Configure the database:**
   
   Run the script in your database with the below mentioned credentials

   ```properties
    url=jdbc:oracle:thin:@localhost:1521:xe
    username=LMS
    password=oracle123
   ```
3. **Run the application:**

   Run the Java application from the command line.

### Configuration

   Configure the database and other settings in the respective configuration files or directly within the application code.

### Usage

Once the application is running, you can perform the following operations:
- **Employee:** Submit a leave request, cancel a leave request, update leave request details, view leave balance, view leave history.  
- **Manager:** Approve or reject leave requests, view teams. 
- **Admin:** Manage users and departments.

## Phase 2: JSP/Servlet

### Features

- Web-based interface for submitting and managing leave requests
- Employee leave request submission
- Employee leave cancellation and updating leave requests
- View leave history
- Track leave balance
- Graph based analysis
- Manager leave approval/rejection
- View today's absentees
- View team count and individual profiles
- Role-based access control

### Technologies

- **Backend:** JSP/Servlet with JDBC
- **Database:** Oracle DB
- **Frontend:** JSP, JSTL
- **Build Tool:** Maven
- **Others:** Lombok

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/codehubjfs/ConsoleProjects.git
    cd ConsoleProjects
    cd Samrutha
    cd LeaveManagementSystem_Web
    cd lms
   ```

2. **Configure the database:**
   
   Run the script in your database with the below mentioned credentials

   ```properties
    url=jdbc:oracle:thin:@localhost:1521:xe
    username=LEAVEMANAGEMENT
    password=oracle123
   ```
3. **Run the application:**

   - Deploy the WAR file to a servlet container like Tomcat.
   - Configure the port number
   - Run the application on the server

### Configuration

   For the Spring MVC version and the JSP/Servlet, the application is configured using the `DispatcherConfig` class where a bean for the datasource is created. Ensure that the datasource and other configurations are correctly set in the `DispatcherConfig` class.


### Usage

Once the application is running, you can access it via http://localhost:8080 and perform the following operations:
- **Employee:** Submit a leave request, cancel a leave request, update leave request details, view leave balance, view leave history.  
- **Manager:** Approve or reject leave requests, view today's absentees, view calendar with absentees' names, view individual team member profiles.. 
- *Admin:** (Not yet implemented)
- **HR:** (Not yet implemented)


## Phase 3: Spring web MVC

### Features

- Enhanced web interface using JSP and JSTL for leave management
- Employee leave request submission
- Employee leave cancellation and updating leave requests
- View leave history
- Track leave balance
- Graph based analysis
- Manager leave approval/rejection
- View today's absentees
- View team count and individual profiles
- Calendar view displaying absentees' names for the month
- Role-based access control

### Technologies

- **Backend:** Spring web MVC with MyBatis
- **Database:** Oracle DB
- **Frontend:** JSP, JSTL
- **Build Tool:** Maven
- **Others:** Lombok

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/codehubjfs/ConsoleProjects.git
    cd ConsoleProjects
    cd Samrutha
    cd LeaveManagementSystem_Web
    cd leavemanagement
   ```

2. **Configure the database:**
   
   Run the script in your database with the below mentioned credentials

   ```properties
    url=jdbc:oracle:thin:@localhost:1521:xe
    username=LEAVEMANAGEMENT
    password=oracle123
   ```
3. **Run the application:**

   - Deploy the WAR file to a servlet container like Tomcat.
   - Configure the port number
   - Run the application on the server

### Configuration

   For the Spring MVC version and the JSP/Servlet, the application is configured using the `DispatcherConfig` class where a bean for the datasource is created. Ensure that the datasource and other configurations are correctly set in the `DispatcherConfig` class.


### Usage

Once the application is running, you can access it via http://localhost:8080 and perform the following operations:
- **Employee:** Submit a leave request, cancel a leave request, update leave request details, view leave balance, view leave history.  
- **Manager:** Approve or reject leave requests, view today's absentees, view calendar with absentees' names, view individual team member profiles.. 
- **Admin:** (Not yet implemented)
- **HR:** (Not yet implemented)


## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add new feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Create a new Pull Request.

## Contact

For any inquiries or issues, please contact:

- **Name:** Samrutha M
- **Email:** samsamrutha24@gmail.com
- **LinkedIn:** https://www.linkedin.com/in/samrutha-m/