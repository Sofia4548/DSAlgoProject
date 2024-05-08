Feature: Login Functionality

Background: User Enters valid username and Password
		Given User navigates to the login page
     When User enters "testscripters" and "test12345"
     And Clicks the login button
     Then User should be logged in successfully