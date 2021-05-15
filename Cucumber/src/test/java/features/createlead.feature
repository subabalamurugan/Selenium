Feature: Create Lead for LeafTaps


Scenario Outline: TC0001_login with positive credential
And Enter the username as 'Demosalesmanager'
And Enter the password as 'crmsfa'
When click on login button
Then HomePage Should be displayed
When Click on crm/sfa button

And Click on Create Lead
And Enter the Company Name as <companyname>
And Enter the First Name as <firstname>
And Enter the Last Name as <lastname>
Then Submit button is clicked
Examples:
    |companyname|firstname|lastname|
    |'CTS'|'Rakshana'|'Akshith'|