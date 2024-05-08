@Graph
Feature: F6 As a user I want to navigate to the Graph home page
  so that I can access its functionalities

  Background: 
    Given User navigates to the login page
    When User enters "testscripters" and "test12345"
    And Clicks the login button
    Then User should be logged in successfully

  @F6T1
  Scenario Outline: The user clicks the Graph topic links and runs the  python code
    Given The user is on the graph page
    When the user clicks the links from the graph page under "<Topics>"
    Then the user redirected to the clicked  link page in the graph data structure
    When the user clicks the try here button on the graph page
    Then the user is redirected to the Editor page with Run button in the graph page
    When the user clicks on run button after providing the valid python code in graph page from given sheetname "<Sheetname>" and rowno <Rownumber>
    Then the user should be able to see the output on the console for the valid  input data for the graph datastructure
    And user navigate back and clicks the signout link in the graph page
    Then the user is logged out of the graph and the dsalgoportal and the "Logged out successfully"  message is displayed

    Examples: 
      | Topics                |  | Sheetname  |  | Rownumber |
      | Graph                 |  | PythonCode |  |         0 |
      | Graph Representations |  | PythonCode |  |         0 |

  @F6T2
  Scenario Outline: The user clicks the Graph topic links and runs the  invalid python code
    Given The user is on the graph page
    When the user clicks the links from the graph page under "<Topics>"
    Then the user redirected to the clicked  link page in the graph data structure
    When the user clicks the try here button on the graph page
    Then the user is redirected to the Editor page with Run button in the graph page
    When the user clicks on run button after providing the invalid python code in graph page from given sheetname "<Sheetname>" and rowno <Rownumber>
    Then the user should be able to see a alertbox syntaxerror for the graph page
    And user navigate back and clicks the signout link in the graph page
    Then the user is logged out of the graph and the dsalgoportal and the "Logged out successfully"  message is displayed

    Examples: 
      | Topics                |  | Sheetname  |  | Rownumber |
      | Graph                 |  | PythonCode |  |         1|
      | Graph Representations |  | PythonCode |  |         1 |
