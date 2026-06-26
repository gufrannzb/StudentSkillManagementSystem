-- MySQL dump 10.13  Distrib 8.4.5, for macos15 (arm64)
--
-- Host: localhost    Database: student_skill_management_system
-- ------------------------------------------------------
-- Server version	8.4.5

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `certificates`
--

DROP TABLE IF EXISTS `certificates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificates` (
  `certificate_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `skill_id` int DEFAULT NULL,
  `percentage` decimal(5,2) DEFAULT NULL,
  `issue_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `certificate_code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`certificate_id`),
  UNIQUE KEY `certificate_code` (`certificate_code`),
  KEY `user_id` (`user_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `certificates_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `certificates_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificates`
--

LOCK TABLES `certificates` WRITE;
/*!40000 ALTER TABLE `certificates` DISABLE KEYS */;
INSERT INTO `certificates` VALUES (74,2,1,90.91,'2026-06-19 19:13:54','SSMS-1-2-1781896434389');
/*!40000 ALTER TABLE `certificates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_topics`
--

DROP TABLE IF EXISTS `course_topics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_topics` (
  `topic_id` int NOT NULL AUTO_INCREMENT,
  `skill_id` int NOT NULL,
  `topic_name` varchar(200) NOT NULL,
  `topic_content` text NOT NULL,
  `topic_order` int DEFAULT NULL,
  PRIMARY KEY (`topic_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `course_topics_ibfk_1` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_topics`
--

LOCK TABLES `course_topics` WRITE;
/*!40000 ALTER TABLE `course_topics` DISABLE KEYS */;
INSERT INTO `course_topics` VALUES (1,1,'Introduction','\r\nJava is a high-level, object-oriented programming language developed by Sun Microsystems. you can learn , but not recommend\r\n\r\n',1),(2,1,'Variables','Variables are containers used to store data values in a Java program.',2),(3,1,'Data Types','Java supports primitive and non-primitive data types such as int, float, char and String.',3),(4,1,'Operators','Operators are symbols used to perform operations on variables and values.',4),(5,1,'Control Statements','Conditional statements like if-else and switch-case control the execution flow.',5),(6,1,'Loops','Loops are used to execute a block of code repeatedly.',6),(7,1,'Methods','Methods are blocks of code designed to perform specific tasks, promoting reusability.',7),(8,1,'Arrays','Arrays are used to store multiple values of the same type in a single variable.',8),(9,1,'OOP','Object Oriented Programming is based on classes, objects, inheritance, polymorphism, encapsulation, and abstraction.',9),(10,1,'String Handling','Strings are objects in Java that represent a sequence of characters, handled by String, StringBuilder, and StringBuffer classes.',10),(11,1,'Exception Handling','Exception handling is used to handle runtime errors in Java to maintain normal application flow.',11),(12,1,'Collections','Collections framework provides dynamic data structures like ArrayList, HashSet, and HashMap.',12),(13,1,'File Handling (I/O)','Java I/O streams are used to read data from and write data to files and other destinations.',13),(14,1,'Multithreading','Multithreading allows concurrent execution of two or more parts of a program for maximum CPU utilization.',14),(15,1,'Java 8 Features','Introduced functional programming concepts like Lambda Expressions, Functional Interfaces, and the Stream API.',15),(16,1,'JDBC (Database Connectivity)','Java Database Connectivity (JDBC) API is used to connect Java applications with relational databases like MySQL.',16);
/*!40000 ALTER TABLE `course_topics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile_update_history`
--

DROP TABLE IF EXISTS `profile_update_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile_update_history` (
  `history_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `field_name` varchar(50) NOT NULL,
  `old_value` varchar(255) DEFAULT NULL,
  `new_value` varchar(255) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`history_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `profile_update_history_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile_update_history`
--

LOCK TABLES `profile_update_history` WRITE;
/*!40000 ALTER TABLE `profile_update_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `profile_update_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `skill_id` int DEFAULT NULL,
  `question_text` text NOT NULL,
  `option_a` varchar(255) DEFAULT NULL,
  `option_b` varchar(255) DEFAULT NULL,
  `option_c` varchar(255) DEFAULT NULL,
  `option_d` varchar(255) DEFAULT NULL,
  `correct_answer` varchar(10) DEFAULT NULL,
  `topic` varchar(100) DEFAULT NULL,
  `difficulty_level` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`question_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,1,'What is JVM?','Java Variable Method','Java Virtual Machine','Java Verified Machine','Java Vendor Machine','B','JVM','Easy'),(2,2,'Which SQL keyword is used to fetch data?','GET','SELECT','FETCH','SHOW','B','SELECT Query','Easy'),(5,2,'Which symbol is used for comments in Python?','//','<!-- -->','#','/* */','B','SQL','Easy'),(6,3,'what is programming language','hman','whshe','dgdgd','dbdv','B','Python','Easy'),(7,1,'Java is a?','OS','Programming Language','Browser','Database','B',NULL,NULL),(8,1,'Java file extension?','.java','.py','.txt','.html','A',NULL,NULL),(9,1,'JVM stands for?','Java Virtual Machine','Java Variable Machine','Java Version Manager','None','A',NULL,NULL),(10,1,'Who developed Java?','Microsoft','Sun Microsystems','Google','IBM','B',NULL,NULL),(11,1,'Java is?','Platform Independent','Platform Dependent','OS','Database','A',NULL,NULL),(12,1,'Entry point method?','run()','start()','main()','execute()','C',NULL,NULL),(13,1,'Object is created using?','create','make','new','object','C',NULL,NULL),(14,1,'Which is not primitive?','int','char','String','boolean','C',NULL,NULL),(15,1,'Java supports?','OOP','POP','DBMS','Network Only','A',NULL,NULL),(16,1,'Default package?','java.io','java.sql','java.lang','java.util','C',NULL,NULL),(17,2,'Which command fetches data?','GET','SELECT','SHOW','FETCH','B',NULL,NULL),(18,2,'Which command inserts data?','INSERT','ADD','PUT','SAVE','A',NULL,NULL),(19,2,'Which command deletes data?','DELETE','REMOVE','DROP','ERASE','A',NULL,NULL),(20,2,'Primary key is?','Duplicate','Unique','Null','Optional','B',NULL,NULL),(21,2,'SQL stands for?','Structured Query Language','Simple Query Language','System Query Language','Standard Query Logic','A',NULL,NULL),(22,2,'Which clause filters rows?','WHERE','ORDER','GROUP','SORT','A',NULL,NULL),(23,2,'Which command updates data?','CHANGE','UPDATE','MODIFY','EDIT','B',NULL,NULL),(24,2,'Which command removes table?','DELETE','REMOVE','DROP','CLEAR','C',NULL,NULL),(25,2,'Which keyword sorts data?','GROUP BY','SORT BY','ORDER BY','FILTER BY','C',NULL,NULL),(26,2,'Which join returns matching rows?','INNER JOIN','FULL JOIN','LEFT JOIN','RIGHT JOIN','A',NULL,NULL),(27,3,'Python is?','Database','Programming Language','Browser','OS','B',NULL,NULL),(28,3,'Comment symbol?','//','#','/* */','--','B',NULL,NULL),(29,3,'Print function?','echo()','printf()','print()','display()','C',NULL,NULL),(30,3,'Python extension?','.java','.py','.txt','.html','B',NULL,NULL),(31,3,'Which datatype stores text?','int','float','str','bool','C',NULL,NULL),(32,3,'Function keyword?','function','define','def','func','C',NULL,NULL),(33,3,'Python is?','Compiled','Interpreted','OS','Browser','B',NULL,NULL),(34,3,'List uses?','{}','()','[]','<>','C',NULL,NULL),(35,3,'Boolean value?','TRUE','true','True','yes','C',NULL,NULL),(36,3,'Input function?','read()','get()','input()','scan()','C',NULL,NULL),(37,4,'HTML stands for?','Hyper Text Markup Language','High Text Markup Language','Hyper Tool Markup Language','None','A',NULL,NULL),(38,4,'CSS is used for?','Styling','Database','Backend','Security','A',NULL,NULL),(39,4,'JavaScript runs in?','Browser','Database','Compiler','OS','A',NULL,NULL),(40,4,'HTML file extension?','.html','.css','.js','.java','A',NULL,NULL),(41,4,'CSS file extension?','.html','.css','.js','.txt','B',NULL,NULL),(42,4,'JS file extension?','.html','.css','.js','.java','C',NULL,NULL),(43,4,'Which tag creates link?','<img>','<a>','<p>','<div>','B',NULL,NULL),(44,4,'Which tag inserts image?','<img>','<a>','<p>','<div>','A',NULL,NULL),(45,4,'CSS property for text color?','font','text','color','background','C',NULL,NULL),(46,4,'Which language adds interactivity?','HTML','CSS','JavaScript','SQL','C',NULL,NULL),(47,5,'Stack follows?','FIFO','LIFO','Random','Priority','B',NULL,NULL),(48,5,'Queue follows?','LIFO','FIFO','Random','Priority','B',NULL,NULL),(49,5,'Linked List stores data in?','Contiguous Memory','Nodes','Array','Table','B',NULL,NULL),(50,5,'Binary Tree max children?','1','2','3','4','B',NULL,NULL),(51,5,'Array index starts from?','0','1','-1','2','A',NULL,NULL),(52,5,'Which structure uses push and pop?','Queue','Tree','Stack','Graph','C',NULL,NULL),(53,5,'Queue operations are?','Push Pop','Insert Delete','Enqueue Dequeue','Add Remove','C',NULL,NULL),(54,5,'BST stands for?','Binary Search Tree','Basic Search Tree','Binary Sort Table','None','A',NULL,NULL),(55,5,'Linear structure?','Tree','Graph','Array','Network','C',NULL,NULL),(56,5,'Recursion means?','Loop','Function calling itself','Sorting','Searching','B',NULL,NULL),(64,2,'Which symbol is used for comments in Python?','vv','gg','gg','hhh','B','SQL','Medium');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommendations`
--

DROP TABLE IF EXISTS `recommendations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommendations` (
  `recommendation_id` int NOT NULL AUTO_INCREMENT,
  `skill_id` int DEFAULT NULL,
  `percentage_range` varchar(50) DEFAULT NULL,
  `suggestion_text` text,
  `next_topics` text,
  `career_roles` text,
  PRIMARY KEY (`recommendation_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `recommendations_ibfk_1` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommendations`
--

LOCK TABLES `recommendations` WRITE;
/*!40000 ALTER TABLE `recommendations` DISABLE KEYS */;
INSERT INTO `recommendations` VALUES (1,1,'0-40','Need Improvement','Core Java Basics','Junior Developer'),(2,1,'41-60','Average Performance','OOP, Collections','Java Trainee'),(3,1,'61-80','Good Progress','JDBC, Servlets','Java Developer'),(4,1,'81-100','Excellent Performance','Spring Boot, Hibernate','Full Stack Java Developer'),(5,3,'0-40','Need Improvement','Core Concepts','Junior Developer'),(6,3,'41-60','Average Performance','OOP, Collections','Trainee Developer'),(7,3,'61-80','Good Progress','Projects, Database','Developer'),(8,3,'81-100','Excellent Performance','Advanced Frameworks','Full Stack Developer');
/*!40000 ALTER TABLE `recommendations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resources`
--

DROP TABLE IF EXISTS `resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resources` (
  `resource_id` int NOT NULL AUTO_INCREMENT,
  `skill_id` int DEFAULT NULL,
  `percentage_range` varchar(50) DEFAULT NULL,
  `resource_type` varchar(50) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `link` text,
  `description` text,
  PRIMARY KEY (`resource_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `resources_ibfk_1` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources`
--

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
INSERT INTO `resources` VALUES (2,1,NULL,'Youtube','Java','https://youtu.be/xTtL8E4LzTQ?si=K-QhiS84fg9ASSB1','Full course of Java'),(3,1,'0-40','YouTube','Java Basics for Beginners','https://youtu.be/example1','Start with Java basics, variables, loops and conditions.'),(4,1,'41-60','YouTube','Java OOP Concepts','https://youtu.be/example2','Learn OOP concepts like class, object, inheritance and polymorphism.'),(5,1,'61-80','YouTube','Java JDBC and Exception Handling','https://youtu.be/example3','Improve Java database connectivity and exception handling concepts.'),(6,1,'81-100','YouTube','Advanced Java Interview Prep','https://youtu.be/example4','Practice advanced Java concepts, collections and interview questions.');
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skills` (
  `skill_id` int NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(100) NOT NULL,
  `description` text,
  `category` varchar(100) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES (1,'Java','Core Java Programming','Programming',NULL),(2,'SQL','Database Query Language','Database',NULL),(3,'Python','Python Programming','Programming',NULL),(4,'Web Development','HTML CSS JS','Web',NULL),(5,'Data Structures','DSA Concepts','Programming',NULL),(6,'JavaScript','Frontend Language','Programming',NULL),(8,'gsggsgsgsggs','sghsghsggs','sgsggsgs',NULL);
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_results`
--

DROP TABLE IF EXISTS `test_results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test_results` (
  `result_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `skill_id` int DEFAULT NULL,
  `percentage` decimal(5,2) DEFAULT NULL,
  `skill_level` varchar(50) DEFAULT NULL,
  `test_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `certificate_issued` tinyint(1) DEFAULT '0',
  `next_attempt_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`result_id`),
  KEY `user_id` (`user_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `test_results_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `test_results_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`skill_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_results`
--

LOCK TABLES `test_results` WRITE;
/*!40000 ALTER TABLE `test_results` DISABLE KEYS */;
INSERT INTO `test_results` VALUES (26,2,1,90.91,'Advanced','2026-06-19 19:13:54',1,'2026-06-29 19:13:54'),(27,2,5,40.00,'Beginner','2026-06-22 20:56:10',0,NULL);
/*!40000 ALTER TABLE `test_results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_details`
--

DROP TABLE IF EXISTS `topic_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_details` (
  `detail_id` int NOT NULL AUTO_INCREMENT,
  `topic_order` int DEFAULT NULL,
  `what_is` text,
  `why_need` text,
  `real_life_example` text,
  `code_example` text,
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_details`
--

LOCK TABLES `topic_details` WRITE;
/*!40000 ALTER TABLE `topic_details` DISABLE KEYS */;
INSERT INTO `topic_details` VALUES (1,1,'**What is it:** Java is a high-level, class-based, object-oriented, and secure programming language developed by Sun Microsystems in 1995. It operates on the principle of \"Write Once, Run Anywhere\" (WORA) using the Java Virtual Machine (JVM).','Java is required to build platform-independent applications, enterprise-level software, and secure banking systems. Its robust memory management, architectural neutrality, and built-in automatic Garbage Collection make it highly reliable.','Think of a Universal Remote Control. As long as a television supports the universal standard, one remote can control any brand of TV. Similarly, compiled Java code (Bytecode) can run on any operating system (Windows, Mac, Linux) as long as that system has a JVM installed.','// Standard Hello World Structure\npublic class Main {\n    public static void main(String[] args) {\n        System.out.println(\"Hello, Java World!\");\n    }\n}'),(2,2,'**What is it:** A variable is a named memory location or a temporary container used to store data values during the execution of a Java program. Every variable is associated with a specific data type.','Variables are essential for dynamic data manipulation, storing user inputs, holding runtime calculation results, and passing values between different components or methods of an application.','Consider kitchen storage containers labeled \"Sugar\", \"Salt\", or \"Flour\". The labels represent the variable names, the physical containers represent the allocated memory locations, and the ingredients inside represent the data values.','// Variable Declaration and Initialization\npublic class VariableExample {\n    public static void main(String[] args) {\n        int storageCapacity = 100;\n        System.out.println(\"Current Capacity: \" + storageCapacity);\n    }\n}'),(3,3,'**What is it:** Data Types specify the size and type of values that can be stored in a variable. Java is a statically-typed language, meaning all variables must be declared with a data type before they can be used. It is divided into Primitive (e.g., int, float, char) and Non-Primitive types (e.g., String, Arrays).','Data types are required to optimize memory allocation and enforce type safety. By explicitly defining data types, the Java compiler prevents runtime errors and ensures that operations are valid for that specific data category.','Think of a sorting mechanism at an airport luggage counter. Large suitcases go to the cargo section, while small backpacks are treated as hand luggage. Similarly, Java allocates a tiny 1 byte for a \"byte\" data type, but assigns 8 bytes for a highly precise \"double\" floating-point number.','// Demonstrating Primitive and Non-Primitive Data Types\npublic class DataTypeExample {\n    public static void main(String[] args) {\n        int itemQuantity = 5;\n        double pricePerItem = 19.99;\n        char currencySymbol = \'$\';\n        String productName = \"Laptop Bag\";\n        \n        System.out.println(productName + \" costs \" + currencySymbol + (itemQuantity * pricePerItem));\n    }\n}'),(4,4,'**What is it:** Operators are special symbols used to perform specific mathematical, logical, or relational manipulations on variables and values. The data elements being operated upon are called operands.','Operators are fundamental for building business logic, evaluating conditional expressions, calculating mathematical values, and controlling program execution flow based on operational results.','Think of a standard billing checkout counter. The system checks if your total bill is greater than $50 (Relational Operator: >) AND if you have a valid coupon code (Logical Operator: &&) to apply a discount (Arithmetic Operator: -).','// Evaluation using Arithmetic, Relational, and Logical Operators\npublic class OperatorExample {\n    public static void main(String[] args) {\n        double productPrice = 60.00;\n        double discount = 10.00;\n        boolean isMember = true;\n        \n        double finalPrice = productPrice - discount;\n        boolean eligibleForFreeShipping = (finalPrice >= 50.00) && isMember;\n        \n        System.out.println(\"Final Price: \" + finalPrice);\n        System.out.println(\"Free Shipping Eligible: \" + eligibleForFreeShipping);\n    }\n}'),(5,5,'**What is it:** Control Statements are constructs (like if-else and switch-case) that determine the execution flow of a program based on specific conditions.','**Why is it needed:** Programs need decision-making capabilities. Without control statements, code would only execute linearly from top to bottom, making it impossible to handle different scenarios dynamically.','**Real-Life Example:** Think of an Automated Teller Machine (ATM). The system checks a condition: **IF** your account balance is greater than or equal to the requested withdrawal amount, **THEN** it dispenses cash; **ELSE**, it displays an \"Insufficient Funds\" error.','// Demonstrating Conditional Decision Making\npublic class ControlStatementExample {\n    public static void main(String[] args) {\n        double accountBalance = 500.00;\n        double withdrawalAmount = 600.00;\n        \n        if (accountBalance >= withdrawalAmount) {\n            System.out.println(\"Transaction Successful. Dispensing cash...\");\n        } else {\n            System.out.println(\"Transaction Failed: Insufficient funds.\");\n        }\n    }\n}'),(6,6,'**What is it:** Loops (such as for, while, and do-while) are control structures used to execute a block of code repeatedly as long as a specified condition remains true.','**Why is it needed:** Loops eliminate manual code redundancy. Instead of writing the same line of code a hundred times, a loop allows you to write it once and execute it iteratively, saving memory and development time.','**Real-Life Example:** Think of a digital music playlist set on \"Repeat All\". The media player checks if there is a next song in the queue. If yes, it plays it. It keeps repeating this cycle until the entire playlist finishes or the user presses stop.','// Iterating using a standard for-loop\npublic class LoopExample {\n    public static void main(String[] args) {\n        for (int trackNumber = 1; trackNumber <= 5; trackNumber++) {\n            System.out.println(\"Playing song track number: \" + trackNumber);\n        }\n    }\n}'),(7,7,'**What is it:** A Method (also known as a function) is a self-contained block of code designed to perform a specific task. It only runs when it is explicitly called.','**Why is it needed:** Methods promote code reusability, structural organization, and modularity. Instead of rewriting complex logic across different parts of an application, you can wrap it in a method and invoke it whenever required.','**Real-Life Example:** Think of a standard Calculator app. It has dedicated modules or buttons for Addition, Subtraction, and Multiplication. Each button acts like a method: you pass it two numbers (parameters), it runs the internal formula, and returns the final result.','// Defining and Invoking a Reusable Method\npublic class MethodExample {\n    public static int calculateTotal(int price, int tax) {\n        return price + tax;\n    }\n    \n    public static void main(String[] args) {\n        int finalBill = calculateTotal(100, 18); // Method invocation\n        System.out.println(\"Total Amount Payable: $\" + finalBill);\n    }\n}'),(8,8,'**What is it:** An Array is a fixed-size, linear data structure used to store multiple elements of the identical data type in contiguous memory locations.','**Why is it needed:** Managing separate variables for large sets of related data (like 50 student grades) is highly inefficient. Arrays allow you to group all related elements under a single variable name and access them using index numbers.','**Real-Life Example:** Think of a multi-slot egg tray. Instead of keeping 12 individual eggs scattered across different shelves in the refrigerator, you store them in one organized tray where each slot can be accessed by its position (index 0 to 11).','// Array Declaration, Initialization, and Index-based Access\npublic class ArrayExample {\n    public static void main(String[] args) {\n        int[] productStock = {45, 12, 89, 33};\n        \n        System.out.println(\"Stock of first warehouse (Index 0): \" + productStock[0]);\n        System.out.println(\"Total tracked warehouses: \" + productStock.length);\n    }\n}'),(9,9,'**What is it:** Object-Oriented Programming (OOP) is a programming paradigm based on the concept of \"objects,\" which contain data (fields) and code (methods). It relies on 4 core pillars: Inheritance, Polymorphism, Encapsulation, and Abstraction.','**Why is it needed:** OOP models real-world entities cleanly. It makes large codebases modular, easier to maintain, scalable, and highly reusable, preventing messy spaghetti code in enterprise-scale software development.','**Real-Life Example:** Think of a generic **Car**. A Car is a class (blueprint). Your specific vehicle is an **Object** (an instance of that blueprint). The steering wheel and engine internals are **Encapsulated** (hidden away from you), while pressing the accelerator is **Polymorphism** (the car accelerates differently depending on whether it is a sports car or an electric car).','// Demonstrating Class, Object, and Encapsulation\npublic class Car {\n    private String modelName;\n    \n    public Car(String model) {\n        this.modelName = model;\n    }\n    \n    public void startEngine() {\n        System.out.println(modelName + \" engine started successfully.\");\n    }\n    \n    public static void main(String[] args) {\n        Car myCar = new Car(\"Tesla Model 3\");\n        myCar.startEngine();\n    }\n}'),(10,10,'**What is it:** String Handling refers to creating, mutating, and manipulating sequences of characters. In Java, Strings are immutable objects managed by the String class, while mutable alternatives are handled by StringBuilder and StringBuffer.','**Why is it needed:** Text processing is involved in almost every user interaction (usernames, emails, passwords, search queries). Understanding string manipulation, memory optimization (String Constant Pool), and immutability is essential for writing efficient backend code.','**Real-Life Example:** Think of a User Registration Form. When a user submits their email, the backend handles the string by removing accidental spaces at the edges (.trim()), converting characters to lowercase (.toLowerCase()), and checking for an \"@\" symbol (.contains()).','// Demonstrating Immutability and Basic String Methods\npublic class StringExample {\n    public static void main(String[] args) {\n        String originalText = \"  Java Developer  \";\n        String processedText = originalText.trim().toLowerCase();\n        \n        System.out.println(\"Processed String: \" + processedText);\n        System.out.println(\"Contains \'java\'?: \" + processedText.contains(\"java\"));\n    }\n}'),(11,11,'**What is it:** Exception Handling is a mechanism involving blocks like try, catch, finally, throw, and throws to intercept and manage runtime errors (Exceptions) without crashing the application.','**Why is it needed:** If a runtime error occurs (e.g., a database connection drops, a missing file, or dividing a number by zero), the application will instantly crash. Handling exceptions ensures a graceful fallback or error message, keeping the system running.','**Real-Life Example:** Think of streaming a video online. If your internet connection drops suddenly, the video application doesn\'t unexpectedly shut down and close entirely. Instead, it catches the network loss exception, displays a spinner, and gracefully shows a toast message: \"Please check your network connection.\"','// Handling Runtime Arithmetic Exception gracefully\npublic class ExceptionExample {\n    public static void main(String[] args) {\n        try {\n            int result = 50 / 0; // Will cause ArithmeticException\n        } catch (ArithmeticException e) {\n            System.out.println(\"System Alert: Cannot divide a number by zero.\");\n        } finally {\n            System.out.println(\"Execution completed clean-up operations.\");\n        }\n    }\n}'),(12,12,'**What is it:** The Collections Framework is a unified architecture providing ready-to-use data structures (like ArrayList, LinkedList, HashSet, and HashMap) to store and manipulate groups of objects dynamically.','**Why is it needed:** Standard primitive arrays have a static, fixed capacity. If you don\'t know how many items your application will process at runtime, Collections provide dynamic resizing, fast searching, sorting, and data deduplication capabilities out of the box.','**Real-Life Example:** Think of an E-commerce Shopping Cart. Users constantly add or remove items while browsing. A simple array cannot handle this dynamic growth, so the backend uses an `ArrayList` to dynamically expand as products are added, or a `HashMap` to map Product IDs directly to their quantities.','// Storing and accessing dynamic elements using ArrayList\nimport java.util.ArrayList;\n\npublic class CollectionExample {\n    public static void main(String[] args) {\n        ArrayList<String> shoppingCart = new ArrayList<>();\n        shoppingCart.add(\"Laptop Bag\");\n        shoppingCart.add(\"Wireless Mouse\");\n        \n        System.out.println(\"Items in cart: \" + shoppingCart);\n        System.out.println(\"Total items: \" + shoppingCart.size());\n    }\n}'),(13,13,'**What is it:** File Handling (Input/Output) in Java refers to the mechanism of reading data from and writing data to external storage files using streams (Streams of Bytes or Characters).','**Why is it needed:** Application memory (RAM) is volatile, meaning all data is lost when the program closes. File handling allows an application to persist data permanently by creating logs, reading configurations, or saving user reports.','**Real-Life Example:** Think of downloading and viewing an e-statement from a banking app. The application reads user transaction records from the database, writes that data structured into a `.pdf` or `.txt` file, and saves it onto your local device storage.','// Demonstrating writing a line of text to an external file\nimport java.io.FileWriter;\nimport java.io.IOException;\n\npublic class FileHandlingExample {\n    public static void main(String[] args) {\n        try {\n            FileWriter writer = new FileWriter(\"log.txt\");\n            writer.write(\"Application initialized successfully.\");\n            writer.close();\n            System.out.println(\"Data successfully written to file.\");\n        } catch (IOException e) {\n            System.out.println(\"An I/O error occurred.\");\n        }\n    }\n}'),(14,14,'**What is it:** Multithreading is a feature that allows concurrent execution of two or more parts of a single program (known as threads) to maximize the utilization of CPU capacity.','**Why is it needed:** Single-threaded applications run tasks one by one. If a heavy task takes 10 seconds, the whole app freezes. Multithreading allows background tasks (like file downloads or data processing) to run smoothly without blocking the main user interface.','**Real-Life Example:** Think of playing a modern multiplayer video game. A single application is handling your controller input, rendering the 3D graphics, playing background sound effects, and sync-loading player data from the internet network all at the exact same time.','// Creating a background thread by extending the Thread class\nclass BackgroundTask extends Thread {\n    public void run() {\n        System.out.println(\"Background worker thread running asynchronously.\");\n    }\n}\n\npublic class MultithreadingExample {\n    public static void main(String[] args) {\n        BackgroundTask thread = new BackgroundTask();\n        thread.start(); // Spawns the thread\n        System.out.println(\"Main thread execution continuing uninterrupted.\");\n    }\n}'),(15,15,'**What is it:** Java 8 Features introduce functional programming constructs to the language, fundamentally upgrading it with Lambda Expressions, Functional Interfaces, Optional classes, and the Stream API.','**Why is it needed:** Traditional Java code required extensive boilerplate blocks to process data sets. Java 8 features allow developers to write highly concise, readable, declarative, and parallel-ready pipeline code for collection filtering and mapping.','**Real-Life Example:** Think of processing an online food order inventory list. Instead of writing long nested loops to find open restaurants, filter them by rating > 4.5, and sort them by delivery time, Java 8 Streams allow you to chain these operations into a single clean line of declarative code.','// Filtering data using Java 8 Stream API and Lambda Expressions\nimport java.util.Arrays;\nimport java.util.List;\n\npublic class StreamExample {\n    public static void main(String[] args) {\n        List<String> products = Arrays.asList(\"Laptop Bag\", \"Wallet\", \"Backpack\", \"Keychain\");\n        \n        // Filter products that start with \"B\"\n        products.stream()\n                .filter(name -> name.startsWith(\"B\"))\n                .forEach(System.out.println);\n    }\n}'),(16,16,'**What is it:** JDBC (Java Database Connectivity) is a standard Java API that defines how a Java client application can access, query, update, and manage relational databases like MySQL, PostgreSQL, or Oracle.','**Why is it needed:** Software architectures keep data separated from code. To make a dynamic enterprise application, your backend code must be capable of establishing an active channel to a database server, executing SQL queries, and converting relational rows back into Java objects.','**Real-Life Example:** Think of logging into an e-commerce dashboard. When you enter credentials and submit, JDBC opens a pipeline from your Java backend to your MySQL database, executes a `SELECT * FROM users WHERE email = ?` statement, validates your password, and allows entry.','// Conceptual JDBC structural pattern block\nimport java.sql.Connection;\nimport java.sql.DriverManager;\nimport java.sql.ResultSet;\nimport java.sql.Statement;\n\npublic class JDBCExample {\n    public static void main(String[] args) {\n        // Note: Real implementation requires a running DB instance and driver dependency\n        System.out.println(\"1. Registering JDBC Driver Driver...\");\n        System.out.println(\"2. Establishing Connection via DriverManager.getConnection()...\");\n        System.out.println(\"3. Executing SQL Query statements via statement.executeQuery()...\");\n    }\n}');
/*!40000 ALTER TABLE `topic_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_progress`
--

DROP TABLE IF EXISTS `topic_progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_progress` (
  `progress_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `topic_id` int NOT NULL,
  `completed` tinyint(1) DEFAULT '1',
  `completed_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`progress_id`),
  UNIQUE KEY `unique_user_topic` (`user_id`,`topic_id`),
  KEY `topic_id` (`topic_id`),
  CONSTRAINT `topic_progress_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `topic_progress_ibfk_2` FOREIGN KEY (`topic_id`) REFERENCES `course_topics` (`topic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_progress`
--

LOCK TABLES `topic_progress` WRITE;
/*!40000 ALTER TABLE `topic_progress` DISABLE KEYS */;
INSERT INTO `topic_progress` VALUES (65,2,1,1,'2026-06-19 19:11:00'),(66,2,2,1,'2026-06-19 19:43:30'),(67,2,3,1,'2026-06-22 17:44:51');
/*!40000 ALTER TABLE `topic_progress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(20) DEFAULT 'student',
  `college_id` varchar(50) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `mobile` varchar(10) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `profile_image` varchar(255) DEFAULT NULL,
  `otp` varchar(10) DEFAULT NULL,
  `otp_expiry` timestamp NULL DEFAULT NULL,
  `account_locked` tinyint(1) DEFAULT '0',
  `failed_attempts` int DEFAULT '0',
  `lock_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Admin','admin@gmail.com','admin123','admin','ADMIN001','Administration','2026-06-01 21:31:38',NULL,NULL,NULL,NULL,NULL,NULL,0,1,NULL),(2,'Mohd Gufran','gufrannzb@gmail.com','$2a$10$eZCUKr4QTO9svidE1Kf2lef/V5neImnS3amfsl302p7yg3BTvB6RW','student','bca2023','Computer Science Engineering','2026-06-12 18:27:29','9122741638','2026-06-12','Male',NULL,NULL,NULL,0,0,NULL),(3,'Md Rashid','rashiid.cse@gmail.com','$2a$10$BH6LBU2l4b6QJgij8gZY8.QofO0eV7VxSZiLkwylkwnG4DMjvCrgm','student','bca2023','Computer Science Engineering','2026-06-12 18:41:27','9122741678','1999-12-26','Male',NULL,NULL,NULL,0,1,NULL),(4,'Rashid Bhai','mohdgufran.bca29@gmail.com','$2a$10$n2Vwlyr/T77rBI6PtlDVpeJlKXQXYWZFl4qYkFXssxybcy4ImYC4G','student','bca2023','Computer Science Engineering','2026-06-19 20:55:40','9122741638','2006-01-01','Male',NULL,NULL,NULL,0,0,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-26 21:54:58
