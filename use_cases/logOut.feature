Feature: AdminLogOut 
Scenario: Administrator logs out
Given admin with username "admin" wanna log out
When admin logging status is "true" and wanna log out
Then admin logging status become "false"
