# Employee Onboarding Application

1. [Pre-Requisites]()
2. [GitHub Repository Setup]()
3. [Eclipse Workspace Setup]()
4. [Execute the SpringBoot Application]()

## 1. Pre-Requisites:
---
1. Create a GitHub account
2. Verify access to the Employee application repository - `https://github.com/justinmraj1984/employee-onboarding-app`
3. Install GitHub Desktop
4. Install Java 8 and setup the JAVA_HOME environment variable in system parameters
5. Install Maven and complete the necessary configuration
6. Install Eclipse and verify the Java, Maven and GitHub settings inside eclipse

## 2. GitHub Repository Setup:
---
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

## 3. Eclipse Workspace Setup:
---
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
 
## 4. Execute the SpringBoot Application:
---
1. Open this path - `c:\mywork\github_repo\employee-onboarding-app` in command line
2. Execute the maven command from command line to run the spring boot application

    `mvn spring-boot:run`
> **Note:** 
> *After executing the above command, do not click or press any key in the command line till the application starts. If the application did not start for long time, then press Enter key to resume application starting.*
3. After the application has started successfully, open the below links in browser,
    - Welcome Page - `http://localhost:8080/welcome`
    - H2 Database Console - `http://localhost:8080/h2`
4. In the H2 Database Console, enter the following values as available in the `application.properties` file
    - Driver Class: `org.h2.Driver`
    - JDBC URL: `jdbc:h2:file:c:/mywork/h2-db-files/emp-app/empdb`
    - User Name: `gwcusr`
    - Password: `gwcpwd`
5. Click Connect to connect to the H2 database and open the console
6. Once the H2 database is connected successfully, Explore the list of Tables and data in it.

### _Activities:_
1. Initialize project development using Spring Initializr
    - Use Spring Initializr (`https://start.spring.io/`) to create a Maven project similiar to the Employee onboarding application
    - Add necessary dependencies to the project, as required for the Spring Boot project
    - Download the project and import into eclipse and explore the project structure

2. Employee Database (Use H2 Database console for below activities)
    - Create new Tables as per the Data model designed for the application
    - Insert the sample data from excel sheet into the table
    - `Push` the new codes to GitHub once the above 2 activities are completed
