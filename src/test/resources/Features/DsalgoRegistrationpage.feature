Feature:F2 User creates new account in the registration page 

@F2Tag1
Scenario:Registration page validation

Given User is on the registration page
When The user clicks the register button after leaving the other fields empty and  enters the username "Testscripters" 
Then The message is displayed below the password textbox to the user as  "Please fill out this field." 

When The user clicks the register button after leaving the other fields empty and enters the password as "test123456"
When the user clicks the register button after leaving the other fields empty and enters the password confirmation as "test123456"
When The user clicks register button after leaving username,password,passwordconfirmation as empty
Then The message is displayed below the username textbox to the user "Please fill out this field." 

When the user clicks the register button after enters the username with specialcharacter other than @/./+/-/_  as "Testscripters###"
Then the user is not able to see the error message for username indicating the <"invalid username">
Then the user will directed below the password textbox and the user able to see the message " Please fill out this field." 

When the user clicks register button after entering the valid username and all numerical password as <"Testscripers"> and <"123456789">
When the user clicks register button after entering the valid username and password lessthan 8characters as <"Testscripers"> and <"Test12">
When the user clicks register button after entering the valid user name and commonly used password as <"Testscripers"> and <"password">
Then the user is not able to see the error message indicating the <"InvalidPassword">
Then the message is displayed below the password confirmation textbox as <"Please fill out this field.">

When the user enters username,and different password in password and password confirmation as<"Testscripers"><"Test@123456"><"Testuser12">
And clicks the register button
Then the user gets the error message as "password_mismatch:The two password fields didn’t match."

When the user clicks the link Register
When the user clicks register button after entering all valid data as<"TestScriptInnovators"><"test123456"><"test123456">
Then the user directed to the DSAlogo homepage and should be able see the  success message 
 