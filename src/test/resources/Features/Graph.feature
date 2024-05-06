#Feature: As a user I want to navigate to the Array home page
  #so that I can access its functionalities
#
  #Background: 
    #Given User navigates to the login page
    #When User enters "testscripters" and "test12345"
    #And Clicks the login button
    #Then User should be logged in successfully
#
  #Scenario Outline: The user clicks the graph Topic links and runs the python code
    #Given The user is on the graph page
    #When the user clicks the links from the graph page under "<Topics>"
    #Then the user redirected to the clicked  graph link page
    #When the user clicks the try here button on the graph page
    #Then the user is redirected to the graph Editor page with Run button
    #When the user clicks on run button after providing the graph python code from given sheetname "<Sheetname>" and rowno <RowNumber>
    #Then the user should be able to see the output on the console for the valid graph python code
#
    #Then the user should be able to see a alertbox with the "message" syntaxerror
    #Examples: 
      #| Topics                |  | Sheetname  |  | RowNumber |
      #| Graph                 |  | PythonCode |  |         0 |
      #| Graph Representations |  | PythonCode |  |         0 |
