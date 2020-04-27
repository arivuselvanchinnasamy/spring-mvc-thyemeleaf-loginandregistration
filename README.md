# spring-mvc-thymeleaf-loginandregistration

Registration and Login Example with Spring Security - Custom Authentication Provider, Spring Boot, Spring Data JPA, MySql, FlyWay

# Prerequisites
JDK 1.8 or later
Maven 3 or later

# Technology Stack
- Spring Boot
- Spring MVC
- Spring Data JPA
- MySQL
- Flyway : [More Information:] (https://flywaydb.org/)
- Spring Security
- Thymeleaf
- Bootstrap 4
- jQuery

# Test User Details 
- Admin User: arivuselvan, Password: password
- User:  testuser, Password: password

# Setup MySql 
  Create DB schema name as "login" and remaining is taken care by Flyway as per script's specified in the directories ( src/main/resources/db/migration)
 
# Running the project
  As the application uses Spring Boot, follow any one of the step to run this project:
 - Run the main method from SpringMvcLoginApplication
 - Use the Maven Spring Boot Plugin: mvn spring-boot: run

 Then, visit http://localhost:8080 in your browser
