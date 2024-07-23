
# Leave Management System

##Introduction

A comprehensive Leave Management System built with different technologies to simplify and automate the process of managing employee leaves. The project includes three versions: console-based, JSP/Servlet, and Spring MVC, each with different levels of user functionality.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Versions](#versions)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Contributing](#contributing)
- [Contact](#contact)

## Features

- Employee leave request submission
- Employee leave cancellation and updating leave requests
- Employees can view their leave history
- Leave balance tracking
- Manager leave approval/rejection
- Manager can view today's absentees
- Manager has a calendar display for a month with absentees' names
- Manager can view individual team member profiles
- All employees can view their profiles and update their passwords.
- Role-based access control
- Reports and analytics

## Technologies

- **Backend:** Spring MVC (with MyBatis), JSP/Servlet (with JDBC), Console-based (with JDBC)
- **Database:** Oracle DB
- **Frontend:** JSP, JSTL
- **Build Tool:** Maven
- **Others:** Lombok

## Versions

### Console-based

- **Users Supported:** Employee, Manager, System Admin
- **Features:**
  - Employees can submit, cancel, and update leave requests
  - View history of the leave applications
  - Track the approval status
  - Managers can approve or reject leave requests
  - Manager can view teams
  - Admins can manage users and departments
  - Basic leave balance tracking

### JSP/Servlet

- **Users Supported:** Employee, Manager
- **Features:**
  - Web-based interface for submitting and managing leave requests
  - View history of the leave applications
  - Track the approval status
  - Leave request cancellation and updates by employees
  - Manager approval and rejection of leave requests
  - View team count and the individual profile
  - View of today's absentees
  - Basic leave balance and reporting functionality

### Spring MVC

- **Users:** Employee, Manager
- **Features:** 
  - Enhanced web interface using JSP and JSTL for leave management
  - Employees can submit, cancel, and update leave requests
  - View history of the leave applications
  - Track the approval status
  - Managers can approve or reject leave requests and view today's absentees
  - Calendar view displaying absentees' names for the month
  - Ability for managers to view individual team member profiles

## Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/codehubjfs/ConsoleProjects.git
    cd ConsoleProjects
    cd Samrutha
    ```

2. **Configure the database:**

   ```properties
    url=jdbc:oracle:thin:@localhost:1521:xe
    username=LEAVEMANAGEMNT
    password=oracle123
   ```

3. **Run the application:**

    - For the Spring MVC version, deploy the WAR file to a servlet container like Tomcat and configure the datasource in the `DispatcherConfig` class. 
    - For JSP/Servlet version, deploy the WAR file to a servlet container like Tomcat.
    - For Console-based version, run the Java application from the command line.

## Configuration

For the Spring MVC version and the JSP/Servlet, the application is configured using the `DispatcherConfig` class where a bean for the datasource is created. Ensure that the datasource and other configurations are correctly set in the `DispatcherConfig` class.

For the console-based versions, configure the database and other settings in the respective configuration files or directly within the application code.

## Usage

Once the application is running, you can access it via `http://localhost:8080` for the web-based versions. Here are some basic operations you can perform:

- **Employee:** Submit a leave request, cancel a leave request, update leave request details, view leave balance, view leave history.
- **Manager:** Approve or reject leave requests, view today's absentees, view calendar with absentees' names, view individual team member profiles.
- **Admin (Console-based only):** Manage users and departments.
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