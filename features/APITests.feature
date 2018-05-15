Feature: Testing the OMDb API

Scenario: Test that the API works as intended
  Given a film exits with the title of "IT"
  And the film has a given year of "2017"
  When a user gets the film from this information
  Then the status code reads "200"


