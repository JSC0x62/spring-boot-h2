# spring-boot-h2
Sample Spring Boot JDBC API with Junit 5. The project is based on the following  
<https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/namedparam/NamedParameterJdbcTemplate.html>  
<https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/namedparam/MapSqlParameterSource.html> 

## Workspace setup
Download and install java <https://jdk.java.net/>

Setting JAVA_HOME  <https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html>

Download IntelliJ IDEA: <https://www.jetbrains.com/idea/download/#section=windows>

Download and Install Gradle <https://docs.gradle.org/current/userguide/installation.html>

## Running the application
Clone or download the project
To run the application from Terminal / Command Prompt
Change directory to the project root directory and type gradle bootRun
To run the application inside IntelliJ IDEA
The starting point is Application.java
Right click the Application.java and select Run -> Application.main()

## Testing the application
Download and install postman <https://www.getpostman.com/downloads/>
The test scripts are under the project root directory in the postman folder

## Database - h2
By default, Spring Boot will configure an H2 database for us
H2 is a  database to develop against because it has an Oracle compatibility mode
The application.properties initializes the datasource, data and schema
The h2 console can be accessed at the following location http://127.0.0.1:8080/h2-console
To sign onto the console the credentials are in the following directory /src/main/resources/application.properties  
