@Stack
Feature:F3 The signedin user selects the datastructure module and runs the python code

Background: The signed in user clicks on the getstarted button of stack and directed to the stack page
Given The user landed in the dsalgo login page
When the user clicks login button after entering credentials <"Testscripters"> <"test12345">
Then The user should directed to Data Structure Home Page 
When the user clicks the Getstarted button below the stack or select the stack from datastructure dropdown
Then the user is directed to the stack home page 

@F3Tag1
Scenario Outline: The user clicks the Topic links and runs the python code

Given The user is on the stack page
When the user clicks the links from the stack page under "<Topics>"
Then the user redirected to the clicked  link page
When the user clicks the try here button on the page
Then the user is redirected to the Editor page with Run button 
When the user clicks on run button after providing the python code from given sheetname "<Sheetname>" and rowno <RowNumber>
Then the user should be able to see the output on the console for the valid data 
#Then the user should be able to see a alertbox with the "message" syntaxerror

Examples:
|Topics 	|								|	Sheetname||RowNumber|
|Operations in Stack| 		|PythonCode||0|
|Implementation|					|PythonCode||0|
|Applications|						|PythonCode||0|
#|Implementation|					|PythonCode||1|
#|Operations in Stack| 		|PythonCode||1|
#|Applications|						|PythonCode||1|

