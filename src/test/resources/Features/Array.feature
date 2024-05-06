Feature: As a user I want to navigate to the Array home page
  so that I can access its functionalities

  Background: 
    Given User navigates to the login page
    When User enters "testscripters" and "test12345"
    And Clicks the login button
    Then User should be logged in successfully

  Scenario Outline: The user clicks the Arrays Topic links and runs the python code
    Given The user is on the array page
    When the user clicks the links from the array page under "<Topics>"
    Then the user redirected to the clicked  link page
    When the user clicks the try here button on the page
    Then the user is redirected to the Editor page with Run button
    When the user clicks on run button after providing the python code from given sheetname "<Sheetname>" and rowno <Rownumber>


    Examples: 
      | Topics                    |  | Sheetname  |  | Rownumber |
      | Arrays in Python          |  | PythonCode |  |         1 |
      | Arrays Using List         |  | PythonCode |  |         1 |
      | Basic Operations in Lists |  | PythonCode |  |         1 |
      | Applications of Array     |  | PythonCode |  |         1 |

 
  Scenario Outline: The user clicks the Arrays Topic links and runs the python code
    Given The user is on the array page
    When the user clicks the links from the array page under "<Topics>"
    Then the user redirected to the clicked  link page
    When the user clicks the try here button on the page
    Then the user is redirected to the Editor page with Run button
    When the user clicks on run button after providing the invaild python code from given sheetname "<Sheetname>" and rowno <Rownumber>


    Examples: 
      | Topics                    |  | Sheetname  |  | Rownumber |
      | Arrays in Python          |  | PythonCode |  |         2 |
      | Arrays Using List         |  | PythonCode |  |         2 |
      | Basic Operations in Lists |  | PythonCode |  |         2 |
      | Applications of Array     |  | PythonCode |  |         2 |
      
      
      
