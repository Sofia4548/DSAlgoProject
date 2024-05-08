@Practice
Feature: P1 As a user I want to navigate to the Array Practice home page
  so that I can access its functionalities

  Background: 
    Given User navigates to the login page
    When User enters "testscripters" and "test12345"
    And Clicks the login button
    Then User should be logged in successfully

  @P1T1
  Scenario Outline: The user clicks the Array Practice topic links and runs the  python code
     Given The user is on the array page
    When the user clicks the link from the array page under Arrays in Python
    #Then the user redirected to the clicked  link page
    When the user clicks the practise question links on the page
    Then the user is redirected to the practise question page
    When the user clicks the links from the array practise page under "<Topics>"
    Then the user redirected to the clicked  link page in the array practise page
    When the user clicks on run button after providing the valid python code in array practise page from given sheetname "<Sheetname>" and rowno <Rownumber>
    #Then the user should be able to see the output on the console for the valid  input data for the array practise page
    And user navigate back and clicks the signout link in the array practise page
    Then the user is logged out of the array practise and the dsalgoportal and the "Logged out successfully"  message is displayed

    Examples: 
      | Topics           |  | Sheetname  |  | Rownumber |
      | Search the array |  | PythonCode |  |         0 |
      | Search the array |  | PythonCode |  |         1 |

  @P1T2
  Scenario Outline: The user clicks the Array Practice topic links and runs the  invalid python code
    Given The user is on the array page
    When the user clicks the link from the array page under Arrays in Python
    #Then the user redirected to the clicked  link page
    When the user clicks the practise question links on the page
    Then the user is redirected to the practise question page
    When the user clicks the links from the array practise page under "<Topics>"
    Then the user redirected to the clicked  link page in the array practise page
   When the user clicks on run button after providing the invalid python code in array practise page from given sheetname "<Sheetname>" and rowno <Rownumber>
    #Then the user should be able to see a alertbox syntaxerror for the array practise page
    And user navigate back and clicks the signout link in the array practise page
    Then the user is logged out of the array practise and the dsalgoportal and the "Logged out successfully"  message is displayed

    Examples: 
      | Topics           |  | Sheetname  |  | Rownumber |
      | Search the array |  | PythonCode |  |         2 |
