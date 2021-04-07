Feature: AdminLogIn
Background: those Administrator valid credentials are stored in the system
Given those Administrator valid credentials are stored in the system username is "admin" password is "adminPassword"
    
  Scenario: Administrator log in with valid credentials
    When Admin enter userName "admin" and password "adminPassword"
    Then password must be "adminPassword"
   
  Scenario: Administrator log in with invalid credentials
    When Admin enter Wrong userName "admin" and Wrong password "123"
    Then password must not be "adminPassword"
   
