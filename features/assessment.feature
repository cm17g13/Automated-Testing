Feature: Using OrangeHRM
  As an administrator
  I want to manage the database
  So that the details it holds are up-to-date and relevant

Scenario: Search for a user
  Given the name of a user
  When I type this name into the search box
  Then I see information about the user

Scenario: Add a user to the CRM
  Given the Admin tab
  When I click the add button
  And I complete the necessary details
  Then the new user is selectable
 
Scenario: Delete a user from the CRM
  Given the Admin tab
  When I select a tab next to a user name
  And I click the Delete button
  Then the user is no longer selectable
  
Scenario: Add an employee to the CRM
  Given the Add Employee Tab
  When I fill out the details correctly
  And I click the Save button
  Then the employee can be searched for via the Employee List
  
Scenario: Add an employee to the CRM
  Given the Add Employee Tab
  When I fill out the details correctly
  And I choose to create Login Details
  And I click the Save button
  Then I see information about the user
  


