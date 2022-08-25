Feature: Login to HRM Application 
  

   Scenario: Login with valid credentials
      
    Given User is on Login page
    When User enters username as "Admin"
    And User enters password as "admin123"
    Then User should be able to login successfully
    
   Scenario: Login with correct credentials
    Given User Launch the application
    When User Enter valid credentials
    And User clicks the sign in button
    Then User should be logged in successfully

  Scenario: Login with incorrect credentials
    Given User Launch the application
    When User Enter invalid credentials
    And User clicks the sign in button
    Then User should be unsuccessfull in login
 