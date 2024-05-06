Feature: As a user I want to navigate to the Array home page
  so that I can access its functionalities

  Background: 
    Given User navigates to the login page
	 When User enters "testscripters" and "test12345"
    And Clicks the login button
    Then User should be logged in successfully

  Scenario Outline: The user clicks the Arrays Practise link and run the python code
    Given The user is on the array page
    When the user clicks the link from the array page under Arrays in Python
    Then the user redirected to the clicked  link page
    When the user clicks the practise question links on the page
    Then the user is redirected to the practise question page
    When the user clicks the link from the practise page under "<Topics>"
      When the user clicks on run button after providing the vaild practise question python code from given sheetname "<Sheetname>" and rowno <Rownumber>
#		Then the user should be able to see the output on the console 
    #Then the user should be able to see a alertbox with the "message" syntaxerror
    Examples: 
      | Topics           |  | Sheetname  |  | Rownumber |
      | Search the array |  | PythonCode |  |         1 |
      #| Search the array |  | PythonCode |  |         1 |
     #
