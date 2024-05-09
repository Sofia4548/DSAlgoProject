@LinkedList
Feature: F2 As a user I want to navigate to the Linked List home page
  So that I can access its functionalities


Background: 
Given User navigates to the login page
When User enters "testscripters" and "test12345"
And Clicks the login button
    Then User should be logged in successfully


@F2T1
Scenario Outline: The user clicks the Linked List topic links and runs the  python code
Given The user is on the linked list page
When The user clicks the links from the linked list page under "<Topics>"
Then The user redirected to the clicked  link page in the linked list data structure
When The user clicks the try here button on the linked list page
Then The user is redirected to the Editor page with Run button in the linked list page
When The user clicks on run button after providing the valid python code in linked list page from given sheetname "<Sheetname>" and rowno <Rownumber>
Then The user should be able to see the output on the console for the valid  input data for the linked list datastructure

Examples:

|Topics |                                      |Sheetname | |Rownumber|
|Introduction |                                |pythonCode| |0 |
|Creating Linked LIst |                        |pythonCode| |0 |
|Types of Linked List |                        |pythonCode| |0 |
|Implement Linked List in Python |             |pythonCode| |0 |
|Traversal |                                   |pythonCode| |0 |
|Insertion |                                   |pythonCode| |0 |
|Deletion  |                                   |pythonCode| |0 |

@F2T2
Scenario Outline: The user clicks the Linked List topic links and runs the  invalid python code
Given The user is on the linked list page
When The user clicks the links from the linked list page under "<Topics>"
Then The user redirected to the clicked  link page in the linked list data structure
When The user clicks the try here button on the linked list page
Then The user is redirected to the Editor page with Run button in the linked list page
When The user clicks on run button after providing the invalid python code in linked list page from given sheetname "<Sheetname>" and rowno <Rownumber>
Then The user should be able to see a alertbox syntaxerror for the linked list page 
When The user navigate back and clicks the signout link in the linked list page 
Then The user should be able to see the "Logged out successfully"  message for the linked list page

Examples:

|Topics |                                      |Sheetname | |Rownumber|
|Introduction |                                |pythonCode| |1|
|Creating Linked LIst |                        |pythonCode| |1 |
|Types of Linked List |                        |pythonCode| |1 |
|Implement Linked List in Python |             |pythonCode| |1 |
|Traversal |                                   |pythonCode| |1 |
|Insertion |                                   |pythonCode| |1 |
|Deletion  |                                   |pythonCode| |1 |   