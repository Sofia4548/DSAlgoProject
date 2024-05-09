@Array
Feature: F1 As a user I want to navigate to the Array home page
  so that I can access its functionalities

  Background: 
    Given User navigates to the login page
    When User enters "testscripters" and "test12345"
    And Clicks the login button
    Then User should be logged in successfully

  @F1T1
  Scenario Outline: The user clicks the Array topic links and runs the  python code
    Given The user is on the array page
    When the user clicks the links from the array page under "<Topics>"
    Then the user redirected to the clicked  link page in the array data structure
    When the user clicks the try here button on the array page
    Then the user is redirected to the Editor page with Run button in the array page
    When the user clicks on run button after providing the valid python code in array page from given sheetname "<Sheetname>" and rowno <Rownumber>
    Then the user should be able to see the output on the console for the valid  input data for the array datastructure
    And user navigate back and clicks the signout link in the array page
    Then the user is logged out of the array and the dsalgoportal and the "Logged out successfully"  message is displayed

    Examples: 
      | Topics                    |  | Sheetname  |  | Rownumber |
      | Arrays in Python          |  | PythonCode |  |         0 |
      | Arrays Using List         |  | PythonCode |  |         0 |
      | Basic Operations in Lists |  | PythonCode |  |         0 |
      | Applications of Array     |  | PythonCode |  |         0 |

  @F1T2
  Scenario Outline: The user clicks the Array topic links and runs the  invalid python code
    Given The user is on the array page
    When the user clicks the links from the array page under "<Topics>"
    Then the user redirected to the clicked  link page in the array data structure
    When the user clicks the try here button on the array page
    Then the user is redirected to the Editor page with Run button in the array page
    When the user clicks on run button after providing the invalid python code in array page from given sheetname "<Sheetname>" and rowno <Rownumber>
    Then the user should be able to see a alertbox syntaxerror for the array page
    And user navigate back and clicks the signout link in the array page
    Then the user is logged out of the array and the dsalgoportal and the "Logged out successfully"  message is displayed

    Examples: 
      | Topics                    |  | Sheetname  |  | Rownumber |
      | Arrays in Python          |  | PythonCode |  |         1 |
      | Arrays Using List         |  | PythonCode |  |         1 |
      | Basic Operations in Lists |  | PythonCode |  |         1 |
      | Applications of Array     |  | PythonCode |  |         1 |
