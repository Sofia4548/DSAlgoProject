@Stack
Feature:F3 The signedin user selects the  stack datastructure module and runs the python code

Background: The signed in user clicks on the getstarted button of stack and directed to the stack page
Given User navigates to the login page
     When User enters "testscripters" and "test12345"
     And Clicks the login button
     Then User should be logged in successfully

@F3Tag1
Scenario Outline: The user clicks the Topic links and runs the  valid python code
Given The user is on the stack page
When the user clicks the links from the stack page under "<Topics>"
Then the user redirected to the clicked  link page
When the user clicks the try here button on the page
Then the user is redirected to the Editor page with Run button 
When the user clicks on run button after providing the python code from given sheetname "<Sheetname>" and rowno <RowNumber>
Then the user should be able to see the output on the console for the valid  input data
Examples:
|Topics 	|								|	Sheetname||RowNumber|
|Operations in Stack| 		|PythonCode||0|
|Implementation|					|PythonCode||0|
|Applications|						|PythonCode||0|

Scenario Outline: The user clicks the Topic links and runs the invalid python code:
Given The user is on the stack page
When the user clicks the links from the stack page under "<Topics>"
Then the user redirected to the clicked  link page
When the user clicks the try here button on the page
Then the user is redirected to the Editor page with Run button 
When the user clicks on run button after providing the invalidpython code from given sheetname "<Sheetname>" and rowno <RowNumber>
Then the user should be able to see a alertbox syntaxerror
Examples:
|Topics 	|								|	Sheetname||RowNumber|
|Operations in Stack|			|PythonCode||1|
|Implementation|	 				|PythonCode||1|
|Applications|						|PythonCode||1|
