# tree-spring-boot
The development was done in spring boot version 1.5.1.RELEASE, mysql and maven.
To create the .war run the following command.
-mvn package in the folder structure where the pom.xml file is located
Mysql was used for data manipulation
- The files for database configuration are in application.properties
- To upload the application it is necessary to create the schema in mysql with the name of "node".
- Once created is just run the application.
Follow the steps to upload the application
- In the project has an application.properties file with a property named:
--spring.jpa.hibernate.ddl-auto = create-drop
- This property is to upload the application by creating the database.
- The application is running on port -8888, in the application.properties there is a property named server.port that can be modified to not have conflicted in the application
- Run the ApplicationConfig class
- The swagger for API Rest was used.
- To verify which methods were used access the following url after the application is active:
- http://localhost:8888/swagger-ui.html


-OBS .: If the application is executed in an external Tomcat will be considered the port that is configured, the name of the application will be the name that was generated in the build by the mvn command.
- Below is the example of the path to external Tomcat:
--http://localhost:8080/tree-spring-boot-rest-0.0.1-SNAPSHOT/node
