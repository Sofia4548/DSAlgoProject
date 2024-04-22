Feature:F4 As a user, I am able to open the browser and Sign In in dsalgo portal

@F4T1
Scenario:F4S1 On DS Algo Introduction Page, test that user should be able to click Sign in link											
Given user is on DS Algo Introduction Page
When The user should click the Sign in link				
Then The user should be redirected to Sign in page and the user is able to see "Register" link  below the text boxes		
And Take a screenshot and saving it in "src/test/resources/Screenshot"

@F4T2
Scenario:F4S2 DS Algo Sign in Page, test that user Sign In successfully											
Given user is on DS Algo Sign in Page
When The user clicks login button after leaving the "<username>" textbox and "<password>" textbox blank					
Then The error message "Please fill out this field." appears below Username textbox	
When The user clicks login button after entering the "<username>" textbox leaving the "<password>" textbox blank	
Then The error message "Please fill out this field." appears below Password textbox	
When The user clicks login button after entering the "<password>" only	and leaving the username blank
Then The error message "Please fill out this field." appears below Username textbox	
When The user clicks login button after entering invalid username and invalid password	
Then The user should able to see an error message "Invalid username and password".		
When The user clicks login button after entering valid username and valid password	
Then The user should land in Data Structure Home Page 			
And Take a screenshot and saving it in "src/test/resources/Screenshot"





