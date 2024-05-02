Feature: As a user I want to navigate to the Array home page
  so that I can access its functionalities

  Background: 
    Given User navigates to the login page
    When User enters "testscripters" and "test12345"
    And Clicks the login button
    Then User should be logged in successfully


  Scenario Outline: The user clicks the datastructure Topic links and runs the python code
    Given The user is on the datastructure page
    When the user clicks the links from the datastructure page under "<Topics>"
    Then the user redirected to the clicked  datastructure link page
    When the user clicks the try here button on the datastructure page
    Then the user is redirected to the datastructure Editor page with Run button
    When the user clicks on run button after providing the datastructure python code from given sheetname "<Sheetname>" and rowno <RowNumber>
    Then the user should be able to see the output on the console for the valid datastructure python code
    #Then the user should be able to see a alertbox with the "message" syntaxerror
    Examples: 
      | Topics                    |  | Sheetname  |  | RowNumber |
      | Time Complexity          |  | PythonCode |  |         0 |
     