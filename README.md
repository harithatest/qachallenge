# QA Challenge 
I have successfully completed the QA Challenge provided to me and I have documented all the necessary solutions in this repository.

## What did I demonstrate?
Here is what I was aiming to demenstrate:  
-- Understanding the features/user stories  
-- Test Strategy/Test Planning  
-- Test case authoring and execution (Manual)  
-- Exploratory/Adhoc testing  
-- Test Automation (building test framework from scratch, authoring test scripts, executing them)  
-- Page Object model  
-- OOPs demostration (Java)  
-- Build automation framework from ground up (gradle)  
-- Version control system (Git)  
-- Issue reporting  
-- Documentation  

## Manual Testing
Manual test cases are included in /manual/tests folder.    
I simply wrote the test cases in .md files for easy accessibility and readability  

## Automation Testing
Automation tests can be found in /automation folder  
Test framework: TestNG  
Browser automation: Selenium Webdriver  
Browser driver: Chrome  
Language: Java  
Build framework: gradle with groovy DSL  
Commands to use: 
gradle build  
gradle test  
Results: Not all tests will pass as some buttons were non-interactable for me (Issue#6) - Need more troubleshooting/investigation  

## Issues
Some of the issues I found are listed in Issues section of this repository  

## Improvements on Test Automation
If I had more time I would work on the following areas to improve test stability and easy maintanance  
-- Error/Exception handling  
-- Proper logging and reporting  
-- Timing issues (use these methods in areas of concern -  eg: WaitForPageLoads, WaitForElementPresent etc)  
-- Build a CI/CD pipeline with jenkins which includes testNg test reporting  
