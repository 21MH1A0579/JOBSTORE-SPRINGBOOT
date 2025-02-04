# JobStore

JobStore is a web application built with Spring Boot that simplifies the job application and recruitment process. Administrators can post job listings, and users can register, log in, and apply for jobs. The app incorporates a skill and job profile matching algorithm to help administrators find the most suitable candidates.

## Features

- **User Functionality:**
  - Register and log in to the application.
  - Upload resumes and apply for job listings.
  - Track application status.

- **Admin Functionality:**
  - Create and manage job postings.
  - View and approve/reject job applications based on compatibility scores.
  - Monitor job profile and skill matching details.

- **Skill and Job Profile Matching:**
  - Algorithm to calculate compatibility scores between user profiles and job requirements.
  - Scores are stored in the MySQL database and displayed to the admin.

## Technology Stack

- **Backend:**
  - Spring Boot (Web, Data JPA, Security, DevTools)
  - MySQL for data storage
- **Frontend:**
  - Thymeleaf for server-side rendering
- **Testing:**
  - Spring Boot Starter Test
  - Spring Security Test

## How to Set Up the Project

1. **Clone the Repository**  
   Clone the project to your local system:
   ```bash
   git clone https://github.com/21mh1a0579/jobstore.git
   cd jobstore

2. **Set Up the Database** includes MySQL setup steps, SQL command for creating the database, and configuration for `application.properties`.  
3. **Access the Application** provides clear instructions for accessing the admin and user panels.  
