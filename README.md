# User Accounts RestAPI Testing using Robot Framework
This is automated RestAPI testing. Its using BDD (Behavior Driven Development) framework as a testing approach. Its using 2 folders in the root directory.
* **UserAccountsTest folder**
    * This folder contain UserAccountsTest.robot file and 3 results files which are generated after executing this file using Robot Framework.
* **UserAccounts folder**
    * This folder contain UserAccounts Spring Stater project which is created in "Spring Tool Suite 4" using Spring Web, Spring Data JPA and H2 Database.


## What's needed?

### Python
1. Install Python (32-bit) 
	Download python-3.8.5.exe
	Select Custom Installation
	Select Add Python to PATH option

2. Check if Python installed successfully using command prompt by following command

  $ python --version
  
3. Check if pip installed successfully using command prompt by following command

  $ pip --version

### Robot Framework
1. Install Robot Framework using command prompt by following command

  $ pip install robotframework

2. Check if Robot Framework installed successfully by following command

  $ robot --version

### Requests Library
1. Install Requests Library using command prompt by following command
  
  $ pip install robotframework-requests


### Starting UserAccounts Project
1. From command prompt, go to the UserAccounts directory
2. Run the project using the following command

  $ mvnw spring-boot:run
  
  
## Running Test Cases
1. From command prompt, go to the UserAccountsTest directory
2. Run the test cases using the following command

  $ robot -T UserAccountsTest.robot

3. Wait until tests executing has finished
4. See the output of tests result
5. See the log of tests result
6. See the report of tests result

# UserAccountsTest
User Accounts Test
