##Title: Login Tests
## Description: 
Test the login feature of Employee Benefits app.
## Environments:
Browsers to be tested: Chrome, Firefox and IE
Mobile: Android, iOS
## Test Steps:
| Steps#|Test Steps|Test Data|Expected|Result|
|----------|:-------------|:------|:---|:---|
| 1 |Open app URL ||App loads and lands on Login page|PASS|
| 2 |Enter invalid username and password|username: Test, password: Test|Error displayed on page and redirects to Login page} |PASS|
| 3 |Enter empty strings for username and password|username: Test, password: Test|Error displayed on page and redirects to Login page} |PASS|
| 4 |Enter Valid username and password|username: testUser, password: Test1234|No errors on page, Lands on Benefits Dashboard page|PASS|
## Pass/Fail criteria:
Pass - All steps work as expected
Fail - One or more steps do not work as expected
## Result: PASS

