@Tree
Feature:F3 The signedin user selects the Tree datastructure module and access the page 

Background: The signed in user clicks on the getstarted button of stack and directed to the stack page
		 Given User navigates to the login page
     When User enters "testscripters" and "test12345"
     And Clicks the login button
     Then User should be logged in successfully
@F5Tag1
Scenario Outline: The user clicks the Topic links  from Tree DataStructure and runs the python code

Given The user is on the Tree	 page
When the user clicks the links from the Tree page under "<Topics Covered>"
Then the user redirected to the clicked  link page
When the user clicks the try here button on the page
Then the user is redirected to the Editor page with Run button 
When the user clicks on run button after providing the python code from given sheetname  "<Sheetname>" and rowno <RowNumber>
Then the user should be able to see the output on the console for the valid data 
#Then the user should be able to see a alertbox with the "message" syntaxerror

Examples:
|Topics Covered 	|						  	|Sheetname|	|RowNumber|
|Overview of Trees| 							|PythonCode|	|0|
|Terminologies|										|PythonCode|	|0|
|Types of Trees|									|PythonCode|	|0|
|Traversals-Illustration|					|PythonCode|	|0|
|Binary Trees| 										|PythonCode|	|0|
|Types of Binary Trees|						|PythonCode|	|0|
|Implementation in Python|				|PythonCode|	|0|
|Binary Tree Traversals|					|PythonCode|	|0|
|Implementation of Binary Trees|	|PythonCode|	|0|
|Applications of Binary trees | 	|PythonCode|	|0|
|Binary Search Trees|							|PythonCode|	|0|
|Implementation Of BST|						|PythonCode|	|0|

