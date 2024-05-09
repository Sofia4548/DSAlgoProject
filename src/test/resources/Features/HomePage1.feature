
@HomePage 
Feature: As a User I am able to open the website and have access to the home page


Scenario: User is opening the DS_Algo website and navigates the Home Page
Given The User should open the DS_Algo Portal URL in a browser 
When The User should be on the Website with a massage "you are at the right palce"
Given The user clicks GetStarted button

When  The user is on Data Structure Introduction Page and should be able to see the NumpyNinja heading, Register and Sign in links

When User clicks the dropdown arrow on the Data Structure
Then The User should see all the items Arrays,Linked List,Stack,Queue,Tree,Graph in dropdown menue

When The User clicks any option from the dropdown menue list without Sigh in 
Then The User should see the warning massage "You are not logged in"

When The User clicks The Get Started button of Data Structure from DS introduction page 
Then The User should get the warning massage "You are not logged in"
