#!/bin/bash

# Create the repository structure
mkdir -p TaskManagementApplication/{ConsoleVersion,SpringMVCVersion,ServletVersion}

# Create the README file for the main project
cat <<EOL > TaskManagementApplication/README.md
# Task Management Application

This repository contains three versions of a Task Management Application: Console Version, Spring MVC Version, and Servlet Version.

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
- MyBatis (for Spring MVC and Servlet versions)

## Prerequisites
Before you begin, ensure you have the following installed on your machine:
- Java 8 or higher
- Maven
- Oracle Database
- IDE (Eclipse, IntelliJ, etc.)
