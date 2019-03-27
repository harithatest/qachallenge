# benefitsapp
Employee Benefits App

Testing Challenge Overview:
Each of our Paylocity product teams operates like a small startup, empowered to deliver business value in whatever way they see fit.   Because our teams are close knit and fast moving it is imperative that you are able to work collaboratively with your fellow teammates.   
This coding challenge is designed to allow you to demonstrate your abilities and discuss your approach to testing and automation with your potential colleagues. You are free to use whatever technologies you prefer but please be prepared to discuss the choices you’ve made.
Please take this as an opportunity to demonstrate the best of your abilities – feel free to mock out pieces of the automation and focus your time on exactly what you’d like to show us.  We’re not looking for you to give up your weekend for this project, we want something to start a meaningful conversation.
Business Need:
One of the critical functions that we provide for our clients is the ability to pay for their employees’ benefits packages.  A portion of these costs are deducted from their paycheck, and we handle that deduction.  Given a set of acceptance criteria, please:
•	Write up any bugs found
•	Write up 3 test cases
•	Choose any test case and automate in the tool of your choice
This is of course a contrived example.  We want to know how you would test and automate and get a brief preview of how you work.
Assumptions:
•	All employees are paid $2000 per paycheck before deductions
•	There are 26 paychecks in a year
•	The cost of benefits is $1000/year for each employee
•	Each dependent incurs a cost of $500/year
 
User Story:
As an Employer, I want to input my employee data so that I can get a preview of benefit costs.
Data:
Username: testUser
Password: Test1234
Acceptance Criteria
Scenario 1: Add Employee no Discount
GIVEN an Employer
AND I am on the Benefits Dashboard page
WHEN I select Add Employee
THEN I should be able to enter employee details
AND First Name does not begin with “A” or “a”
AND the employee should save
AND I should see the employee in the table
AND the benefit cost calculations are correct
Scenario 2: Add Employee with Discount
GIVEN an Employer
AND I am on the Benefits Dashboard page
WHEN I select Add Employee
THEN I should be able to enter employee details
AND First Name begins with “A” or “a”
AND the employee should save
AND I should see the employee in the table
AND the employee has a 10% discount
AND the benefit cost calculations are correct
Scenario 3: Edit Employee
GIVEN an Employer
AND I am on the Benefits Dashboard page
WHEN I select the Action Edit
THEN I can edit employee details
AND the data should change in the table
Scenario 4: Delete Employee
GIVEN an Employer
AND I am on the Benefits Dashboard page
WHEN I click the Action X
THEN the employee should be deleted
