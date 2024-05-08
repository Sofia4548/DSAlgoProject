#Author: Sofia
#@Login
#Feature:F4 As a user, I am able to open the browser and Sign In in dsalgo portal
#@F4T1
#Scenario:F4S1 On DS Algo Introduction Page, test that user should be able to click Sign in link											
#Given user is on DS Algo Introduction Page
#When The user should click the Sign in link				
#
#
#@F4T2
#Scenario Outline:F4S2 DS Algo Sign in Page, test that user Sign In successfully											
#Given user is on DS Algo Sign in Page
#When The user clicks login button after leaving the username textbox and password textbox blank					
#Then The error message "Please fill out this field." appears below Username textbox	
#When The user clicks login button after entering the "sofia" textbox leaving the password textbox blank	
#Then The error message "Please fill out this field." appears below Password textbox	
#When The user clicks login button after entering invalid "testers" and invalid "12345"	
#Then The user should able to see an error message "Invalid Username and Password".		
#When The user clicks login button after entering valid '<username>' and valid '<password>'
#Then The user should land in Data Structure Home Page 			
#
#
#Examples:
#
#| username    | password     |
#|Coders|code12345|
#|Testscripters|test12345  |
#
#
#
