
@Queue
Feature: F3 As a Signedin User 
 I want to navigate to the  Queue home page and have access to its functionalities
 
Background: 
Given User navigates to the login page
When User enters "testscripters" and "test12345"
And  User clicks the login button
Then The user should be logged in successfully
 
 @F3T1
Scenario Outline: The user clicks the Queue topic links and runs the  python code
Given The user is on the queue page
When The user clicks the links from the queue page under "<Topics>"
Then The user redirected to the clicked  link page in the queue data structure
When The user clicks the try here button on the queue page
Then The user is redirected to the Editor page with Run button in the queue page
When The user clicks on run button after providing the valid python code in queue page from given sheetname "<Sheetname>" and rowno <Rownumber>
Then The user should be able to see the output on the console for the valid  input data for the queue datastructure module

Examples:

|Topics |                                      |Sheetname | |Rownumber|
|Implementation of Queue in Python|            |PythonCode| |0 |
|Implementation using collections.deque |      |PythonCode| |0 |
|Implementation using array |                  |PythonCode| |0 |
|Queue Operations |                            |PythonCode| |0 |

@F3T2
Scenario Outline: The user clicks the Queue topic links and runs the  invalid python code
Given The user is on the queue page
When The user clicks the links from the queue page under "<Topics>"
Then The user redirected to the clicked  link page in the queue data structure
When The user clicks the try here button on the queue page
Then The user is redirected to the Editor page with Run button in the queue page
When The user clicks on run button after providing the invalid python code in queue page from given sheetname "<Sheetname>" and rowno <Rownumber>
Then The user should be able to see a alertbox syntaxerror for the queue page 
When The user navigate back and clicks the signout link in the queue page 
Then The user should be able to see the "Logged out successfully"  message for the queue data structure page
Examples:

|Topics |                                      |Sheetname | |Rownumber|
|Implementation of Queue in Python|            |PythonCode| |1 |
|Implementation using collections.deque |      |PythonCode| |1 |
|Implementation using array |                  |PythonCode| |1 |
|Queue Operations |                            |PythonCode| |1 |
 

    
