
@Tree
Feature:F3 The signedin user selects the Tree datastructure module and access the page 

Background:  Login Functionality
		 Given User navigates to the login page
     When User enters "testscripters" and "test12345"
     And Clicks the login button
     Then User should be logged in successfully
@F5T1
Scenario Outline: The user clicks the Topic links  from Tree DataStructure and runs the  valid python code

Given The user is on the Tree page
When the user clicks the links from the Tree page under "<Topics Covered>"
Then the user redirected to the clicked  link page in the Tree datastructure
When the user clicks the try here button on the page in tree datastructure
Then the user is redirected to the Editor page ot the tree datastructure with Run button 
When the user clicks on run button in tree page after providing the python code from given sheetname "<Sheetname>" and rowno <RowNumber>
Then the user should be able to see the output on the console for the valid  input data for the tree datastructure

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
@F5T2
Scenario Outline: The user clicks the Topic links  from Tree DataStructure and runs the invalid python code

Given The user is on the Tree page
When the user clicks the links from the Tree page under "<Topics Covered>"
Then the user redirected to the clicked  link page in the Tree datastructure
When the user clicks the try here button on the page in tree datastructure
Then the user is redirected to the Editor page ot the tree datastructure with Run button 
When the user clicks on run button in tree page after providing the python code from given sheetname "<Sheetname>" and rowno <RowNumber>
Then the user should be able to see a alertbox syntaxerror for the tree page 
Given The user is on the editor page and user navigated back from the editor page in the tree
When The user clicks the signout link from the tree data structure 
Then the user is logged out of the tree datastructure and the dsalgoportal and the "Logged out successfully"  message is displayed



Examples:
|Topics Covered 	|						  	|Sheetname||RowNumber|
|Overview of Trees| 							|PythonCode||1|
|Terminologies|										|PythonCode||1|
|Types of Trees|									|PythonCode|	|1|
|Traversals-Illustration|					|PythonCode|	|1|
|Binary Trees| 										|PythonCode|	|1|
|Types of Binary Trees|						|PythonCode|	|1|
|Implementation in Python|				|PythonCode|	|1|
|Binary Tree Traversals|					|PythonCode|	|1|
|Implementation of Binary Trees|	|PythonCode|	|1|
|Applications of Binary trees | 	|PythonCode|	|1|
|Binary Search Trees|							|PythonCode|	|1|
|Implementation Of BST|						|PythonCode|	|1|
