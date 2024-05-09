@DataStructures
Feature: F0 As a user I want to navigate to the Datastructures home page
  so that I can access its functionalities

  Background: 
    Given User navigates to the login page
    When User enters "testscripters" and "test12345"
    And Clicks the login button
    Then User should be logged in successfully

  @F0T1
  Scenario Outline: The user clicks the Datastructures topic links and runs the  python code
    Given The user is on the datastructures page
    When the user clicks the links from the datastructures page under "<Topics>"
    Then the user redirected to the clicked  link page in the datastructures page
    When the user clicks the try here button on the datastructures page
    Then the user is redirected to the Editor page with Run button in the datastructures page
    When the user clicks on run button after providing the valid python code in datastructures page from given sheetname "<Sheetname>" and rowno <Rownumber>
    Then the user should be able to see the output on the console for the valid  input data for the datastructures
    And user navigate back and clicks the signout link in the datastructures page
    Then the user is logged out of the datastructures and the dsalgoportal and the "Logged out successfully"  message is displayed

    Examples: 
      | Topics          |  | Sheetname  |  | Rownumber |
      | Time Complexity |  | PythonCode |  |         0 |

  @F6T2
  Scenario Outline: The user clicks the Datastructures topic links and runs the  invalid python code
    Given The user is on the datastructures page
    When the user clicks the links from the datastructures page under "<Topics>"
    Then the user redirected to the clicked  link page in the datastructures page
    When the user clicks the try here button on the datastructures page
    Then the user is redirected to the Editor page with Run button in the datastructures page
    When the user clicks on run button after providing the invalid python code in datastructures page from given sheetname "<Sheetname>" and rowno <Rownumber>
    Then the user should be able to see a alertbox syntaxerror for the datastructures page
    And user navigate back and clicks the signout link in the datastructures page
    Then the user is logged out of the datastructures and the dsalgoportal and the "Logged out successfully"  message is displayed

    Examples: 
      | Topics          |  | Sheetname  |  | Rownumber |
      | Time Complexity |  | PythonCode |  |         1 |
