# Job Finder Project Documentation

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
   - [Job Seeker](#job-seeker)
   - [Admin](#admin)
   - [Employer](#employer)
3. [System Architecture](#system-architecture)
4. [User Roles and Permissions](#user-roles-and-permissions)
5. [User Guides](#user-guides)
   - [Job Seeker Guide](#job-seeker-guide)
   - [Admin Guide](#admin-guide)
   - [Employer Guide](#employer-guide)
6. [Database Schema](#database-schema)
7. [API Documentation](#api-documentation)
8. [Conclusion](#conclusion)
9. [Author](#author)

## 1. Introduction
The "Job Finder" project is a web-based job portal designed to connect job seekers with employers. It offers a platform for job posting, application management, and user management.

## 2. Features

### Job Seeker
- User registration and profile creation
- Job search by location, title, and company
- Job application submission
- Application status tracking

### Admin
- User management (job seekers and employers)
- Job listing approval
- Analytics dashboard for monitoring activity
- Content management for FAQs and policies

### Employer
- Job posting and management
- Application review and status update
- Company profile management

## 3. System Architecture
The "Job Finder" application is designed using a layered architecture, which separates the different components for better maintainability and scalability. The architecture consists of the following layers:

### Frontend Layer
- Built using HTML, CSS, JavaScript, and Bootstrap for responsive design and user interface. AJAX is used for asynchronous data fetching to enhance user experience.

### Controller Layer
- Implemented using Spring MVC, this layer handles incoming HTTP requests, processes them, and returns appropriate responses. It interacts with the service layer to perform business logic.

### Service Layer
- Contains business logic and service methods. This layer communicates with the data access layer to perform operations related to job seekers, employers, and job postings.

### Data Access Layer
- Utilizes MyBatis for Object-Relational Mapping (ORM) to interact with the Oracle database. This layer is responsible for executing SQL queries and mapping the results to Java objects.

### Database Layer
- An Oracle database is used to store all application data, including job seekers, employers, job listings, and applications.

## 4. User Roles and Permissions
- **Job Seeker**: Can register, search jobs, apply, and view application statuses.
- **Admin**: Has full access to manage users and job listings.
- **Employer**: Can post jobs and manage applications.

## 5. User Guides

### Job Seeker Guide
1. **Registration**: Navigate to the registration page and fill in the required fields.
2. **Job Search**: Use the search functionality on the homepage.
3. **Application**: Click on job titles to view details and apply.

### Admin Guide
1. **Login**: Admins can access the admin panel using credentials.
2. **User Management**: View and manage job seeker and employer profiles.
3. **Job Management**: Approve or reject job listings submitted by employers.

### Employer Guide
1. **Registration**: Sign up to create an employer profile.
2. **Job Posting**: Use the dashboard to post new job listings.
3. **Application Review**: Access the applications section to review submissions.

## 6. Database Schema
- **Job Seekers**: id, name, email, password, phone, resume
- **Employers**: id, company name, email, password
- **Jobs**: id, title, description, employer_id, status
- **Applications**: id, job_id, seeker_id, status, application_date

## 7. API Documentation
- **POST /api/jobseekers**: Create a new job seeker.
- **GET /api/jobs**: Retrieve job listings.
- **POST /api/application**: Submit a job application.
- **POST /api/send-otp**: Send an OTP to the user's email for account verification.
- **POST /api/verify-otp**: Verify the OTP entered by the user during registration.

## 8. Conclusion
The "Job Finder" project aims to streamline the job searching and application process, providing a user-friendly experience for job seekers and employers alike.

## 9. Author
**Gopal**  
Contact: [krishsri520@gmail.com](mailto:krishsri520@gmail.com)

