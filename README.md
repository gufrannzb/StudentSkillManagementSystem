# 🎓 Student Skill Management System

> A Java EE web application for managing student skills, assessments, learning resources, progress tracking, recommendations, and certificates using **Servlets, JSP, JDBC, MySQL, and MVC Architecture**.

---

## 📖 Overview

The **Student Skill Management System (SSMS)** is a Java EE web application developed to help educational institutions manage students' technical skills and learning progress efficiently.

The system allows students to register, learn skills through structured topics and resources, take assessments, monitor progress, receive personalized recommendations, and download certificates after successful completion.

Administrators can manage students, skills, topics, learning resources, assessments, recommendations, certificates, and overall system data from a dedicated admin dashboard.

---

# ✨ Features

### 👨‍🎓 Student Module

* Student Registration
* Secure Login & Logout
* Forgot Password using OTP
* Update Profile
* Browse Available Courses
* View Course Details
* Learn Topics
* Access Learning Resources
* Take Skill Assessments
* View Assessment Results
* Progress Tracking
* Personalized Recommendations
* Download Certificates
* Certificate Verification
* Skill History

---

### 👨‍💼 Admin Module

* Admin Authentication
* Dashboard
* Student Management
* Skill Management
* Topic Management
* Learning Resource Management
* Assessment Question Management
* Recommendation Management
* Result Management
* Certificate Management

---

# 🛠 Tech Stack

## Frontend

* JSP
* HTML5
* CSS3
* JavaScript

## Backend

* Java
* Servlet
* JSP
* JDBC

## Database

* MySQL

## Server

* Apache Tomcat

## Build Tool

* Maven

## IDE

* NetBeans

## Version Control

* Git
* GitHub

---

# 🏗 Architecture

The project follows the **MVC (Model View Controller)** architecture.

```text
                 Browser
                     │
                     ▼
                JSP Pages
                     │
                     ▼
          Servlet (Controller Layer)
                     │
                     ▼
              Service Layer
                     │
                     ▼
                DAO Layer
                     │
                     ▼
               MySQL Database
```

---

# 📂 Project Structure

```text
StudentSkillManagementSystem
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── controller
│   │   │   ├── dao
│   │   │   ├── filter
│   │   │   ├── model
│   │   │   ├── service
│   │   │   └── util
│   │   │
│   │   ├── resources
│   │   │
│   │   └── webapp
│   │       ├── admin
│   │       ├── student
│   │       ├── assets
│   │       └── WEB-INF
│
├── pom.xml
├── .gitignore
└── README.md
```

---

# ⚙ Installation Guide

## 1. Clone Repository

```bash
git clone git@github.com:gufrannzb/StudentSkillManagementSystem.git
```

---

## 2. Open Project

Open the project using **NetBeans IDE**.

---

## 3. Configure MySQL

Create a database named:

```sql
student_skill_management_system
```

---

## 4. Import Database

Import the SQL file into MySQL.

```text
student_skill_management_system.sql
```

---

## 5. Configure Database Connection

Update your database credentials inside:

```text
DBConnection.java
```

Example:

```java
URL = jdbc:mysql://localhost:3306/student_skill_management_system

Username = root

Password = root
```

---

## 6. Build Project

```bash
mvn clean install
```

---

## 7. Deploy

Deploy the generated WAR file to **Apache Tomcat**.

---

## 8. Run

Open:

```text
http://localhost:8080/StudentSkillManagementSystem
```

---

# 🗄 Database

Database Name

```text
student_skill_management_system
```

Main Tables

* students
* admins
* skills
* topics
* resources
* recommendations
* test_results
* certificates

---

# 📸 Screenshots

The UI screenshots will be added after the CSS implementation.

* Login Page
* Register Page
* Student Dashboard
* Admin Dashboard
* Skill Assessment
* Recommendations
* Certificate
* Progress Tracking

---

# 🚀 Future Enhancements

* Spring Boot Migration
* REST API Integration
* Docker Support
* Cloud Deployment
* JWT Authentication
* Role-Based Authorization
* Analytics Dashboard
* AI-Based Skill Recommendation
* Email Notifications
* Responsive UI

---

# 👨‍💻 Author

**Mohd Gufran**

Java Backend Developer

---

# 📫 Connect

GitHub

https://github.com/gufrannzb

LinkedIn

(Add your LinkedIn profile URL here)

---

# ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.
