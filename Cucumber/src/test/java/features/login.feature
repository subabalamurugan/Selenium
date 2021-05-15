Feature: Login Functionality for LeafTabs


Scenario Outline: TC001_Login with Postive Credential
    
    Given Enter the username as <username>
    And Enter the password as <password>
    When click on login button   
    When HomePage Should be displayed
    When CRM/SFA click
    When Click on Leads
    Examples:
    |username|password|
    |'DemoSalesManager'|'crmsfa'|
   
    
 
