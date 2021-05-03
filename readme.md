# Employee Onboarding Application

1. [Pre-Requisites](#1-pre-requisites)
2. [GitHub Repository Setup](#2-github-repository-setup)
3. [Eclipse Workspace Setup](#3-eclipse-workspace-setup)
4. [Starting the SpringBoot Application](#4-starting-the-springboot-application)
5. [Explore H2 Database console](#5-explore-h2-database-console)
6. [Explore REST APIs using Swagger UI](#6-explore-rest-apis-using-swagger-ui)


## 1. Pre-Requisites
1. Create a GitHub account
2. Verify access to the Employee application repository - `[https://github.com/justinmraj1984/employee-onboarding-app](https://github.com/justinmraj1984/employee-onboarding-app)`
3. Install GitHub Desktop
4. Install Java 11 and setup the JAVA_HOME environment variable in system parameters
    - Download JDK 11 from `[https://download.java.net/openjdk/jdk11/ri/openjdk-11+28_windows-x64_bin.zip](https://download.java.net/openjdk/jdk11/ri/openjdk-11+28_windows-x64_bin.zip)`
    - On extracting this zip file `jdk-11` folder is available with the JDK installation.
    - In the windows system parameters, set `JAVA_HOME=<jdk-11 folder path>`
    - In path parameter, add `%JAVA_HOME%/bin`
    - In path parameter, remove any references to other JDK installation
    - Save and exit the system variables windows
    - Open a new command prompt and execute the command `java -version`

5. Install Maven and complete the necessary configuration
6. Install Eclipse and verify the Java, Maven and GitHub settings inside eclipse

## 2. GitHub Repository Setup
### _1. Configure GitHub Desktop to use the GitHub account_
  - Open GitHub Desktop
  - Navigate to ***File -> Options -> Accounts***
  - Sign-in into GitHub account

### _2. Configure name and email in GitHub Desktop_
  - Inside GitHub Desktop, navigate to ***File -> Options -> GitHub***
  - Provide values for ***Name*** and ***Email*** in lowercase
  - Click ***Save*** to complete

### _3. Clone the repository by providing the following values_
  - **GitHub repository URL** : `https://github.com/justinmraj1984/employee-onboarding-app.git`
  - **Local repository path** : `c:\mywork\github_repo\employee-onboarding-app`

> **Note:** 
> *In case of any issues, delete the local folder and clone again*

### _4. Once the repository is cloned successfully, explore the following in the repository_
- Branch
- No. of Commits inside this branch
- Lines of code associated with each Commit

### _Activities:_
- In GitHub Desktop, Create a new branch with the naming convention `<group_number>_<name>` in lowercase *(use the name value from Step 2.2)*
- In GitHub Desktop, switch to the new branch you have created
- Add a new file to this branch and push it to the github repository
- Change this file and push the changes again to the repository
- Login to your GitHub account in browser and explore the new branch and the commits inside it

## 3. Eclipse Workspace Setup
1. Ensure the repository is successfully cloned *(as per Step 2.4)*
2. In GitHub Desktop, execute a `Pull` in order to sync the latest code from GitHub repository
3. In Eclipse, select ***File -> Import -> General -> Projects from File System or Archive***
4. Enter ***Import Source*** value as `c:\mywork\github_repo\employee-onboarding-app`
5. Ensure the folder name is selected in the list below.
6. Click ***Finish*** to initiate the project import into Eclipse 
7. After the project is imported successfully, explore the following files in Eclipse
    - `pom.xml`
    - `application.properties`
    - `data.sql`
8. Create a new folder - `c:\mywork\h2-db-files\emp-app` and ensure this path is available in the properties file.

> **Note:** 
> *This folder is used to store the H2 database file for the application.*

## 4. Starting the SpringBoot Application
1. Open this path - `c:\mywork\github_repo\employee-onboarding-app` in command line
2. Execute the maven command from command line to run the spring boot application

    `mvn clean spring-boot:run`
> **Note:** 
> *After executing the above command, do not click or press any key in the command line till the application starts. If the application did not start for long time, then press Enter key to resume application starting.*
> *If the application does not start and has error related to log statement then execute Step 7 below.*
3. Project Lombok setup in Eclipse IDE:
    - Once the application has started successfully, terminate it and close Eclipse IDE.
    - Goto the path - `C:\Users\<user-name>\.m2\repository\org\projectlombok\lombok\<version>`
    - Right click the file - `lombok-<version>.jar` and select ***Open***. This opens the Project Lombok installer window.
    - Click on ***Specify location...*** and select the folder where Eclipse software is installed.
    - Click on ***Install / Update*** and complete the installation. 
    - Start Eclipse IDE, and goto ***Help -> About Eclipse IDE*** 
    - Maximize this window and check if Project Lombok is successfully installed into Eclipse.
    - After verifying the Lombok installation in Eclipse, execute the application and check if it is working fine.

### _Activities:_
1. Initialize project development using Spring Initializr
    - Use Spring Initializr (`https://start.spring.io/`) to create a Maven project similiar to the Employee onboarding application
    - Add necessary dependencies to the project, as required for the Spring Boot project
    - Download the project and import into eclipse and explore the project structure

2. Employee Database (Use H2 Database console for below activities)
    - Create new Tables as per the Data model designed for the application
    - Insert the sample data from excel sheet into the table
    - `Push` the new codes to GitHub once the above 2 activities are completed

## 5. Explore H2 Database console
1. After the application has started successfully, open the below links in browser,
    - Welcome Page - `[http://localhost:8080/welcome](http://localhost:8080/welcome)`
    - H2 Database Console - `[http://localhost:8080/h2](http://localhost:8080/h2)`
2. In the H2 Database Console, enter the following values as available in the `application.properties` file
    - Driver Class: `org.h2.Driver`
    - JDBC URL: `jdbc:h2:file:c:/mywork/h2-db-files/emp-app/empdb`
    - User Name: `gwcusr`
    - Password: `gwcpwd`
3. Click Connect to connect to the H2 database and open the console
4. Once the H2 database is connected successfully, Explore the list of Tables and data in it.

## 6. Explore REST APIs using Swagger UI
1. After the application has started successfully, open the below links in browser,
    - Swagger UI page - `[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)`
2. Inside the Swagger page, enter `/empapp-api-docs` and click ***Explore*** to view the REST API documentation
3. Explore the APIs and check if the data in the table are getting updated accordingly.
4. Explore the Open API specification JSON by accessing this URL - `[http://localhost:8080/empapp-api-docs](http://localhost:8080/empapp-api-docs)`.

> **Note:** 
> *Use a JSON formatter - `[https://jsonformatter.curiousconcept.com/](https://jsonformatter.curiousconcept.com/)` to understand the structure of the Open API specification document for API-First development*

### _Activities:_
1. Switch to master branch and pull the latest code from Github repository.
2. Create a new branch from master branch in the naming convention - `<group-id>_<user-name>-<date>`.
3. Switch to this branch.
4. Inside the application, go through each class file and add your understanding as comments.
5. Check-in your comments periodically into your branch.
