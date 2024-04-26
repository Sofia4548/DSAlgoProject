@TS_signin_03
Feature: As a user, I am able to open the browser and Sign In in dsalgo portal

  Background: 
    Given user is on signin page with vaild creditinals 
   	When The user clicks login button after entering valid '<username>' and valid '<password>'
    Then The user should land in Data Structure Home Page 

  