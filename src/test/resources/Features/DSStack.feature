@Stack
Feature:F3 The signedin user selects the  stack datastructure module and runs the python code


Background: Login Functionality
		 Given User navigates to the login page
     When User enters "testscripters" and "test12345"
     And Clicks the login button
     Then User should be logged in successfully

@F3T1
Scenario Outline: The user clicks the Stack topic links and runs the  python code
Given The user is on the stack page
When the user clicks the links from the stack page under "<Topics>"
Then the user redirected to the clicked  link page in the stack data structure
When the user clicks the try here button on the stack page
Then the user is redirected to the Editor page with Run button in the stack page
When the user clicks on run button after providing the valid python code in stack page from given sheetname "<Sheetname>" and rowno <Rownumber>
Then the user should be able to see the output on the console for the valid  input data for the stack datastructure


Examples:
|Topics 	|								|	Sheetname||Rownumber|
|Operations in Stack| 		|PythonCode||0|
|Implementation|					|PythonCode||0|
|Applications|						|PythonCode||0|

@F3T2
Scenario Outline: The user clicks the Stack topic links and runs the  invalid python code
Given The user is on the stack page
When the user clicks the links from the stack page under "<Topics>"
Then the user redirected to the clicked  link page in the stack data structure
When the user clicks the try here button on the stack page
Then the user is redirected to the Editor page with Run button in the stack page
When the user clicks on run button after providing the invalid python code in stack page from given sheetname "<Sheetname>" and rowno <Rownumber>
Then the user should be able to see a alertbox syntaxerror for the stack page 
When The user navigate back and clicks the signout link in the stack page 
Then the user is logged out of the stack and the dsalgoportal and the "Logged out successfully"  message is displayed


Examples:
|Topics 	|								|	Sheetname||Rownumber|
|Operations in Stack|			|PythonCode||1|
|Implementation|	 				|PythonCode||1|
|Applications|						|PythonCode||1|


