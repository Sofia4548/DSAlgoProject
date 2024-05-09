package dsalgo_stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import dsalgoPOM.LinkedList;
import dsutilities.DriverFactory;
import dsutilities.LoggerLoad;
import dsutilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dsutilities.TestDataReadingWriting;


public class LinkedList_stepdefination {

public LinkedList linkedlist=new LinkedList(DriverFactory.getDriver());
	
private String outputdata;
private String outputdata1;


@Given("The user is on the linked list page")
public void the_user_is_on_the_linked_list_page() throws FileNotFoundException, IOException, InterruptedException {
       
	linkedlist.LinkedListhomePage();
}
@When("The user clicks the links from the linked list page under {string}")
public void the_user_clicks_the_links_from_the_linked_list_page_under(String topic) throws InterruptedException {
   
	List<WebElement> links=linkedlist.getLinkByTopics(topic);
	
	
	for(WebElement link:links)
	{
		//String linknames=link.getText();
		
		link.click();
		//Thread.sleep(1000);
		
	}
    
}

@Then("The user redirected to the clicked  link page in the linked list data structure")
public void the_user_redirected_to_the_clicked_link_page_in_the_linked_list_data_structure() {
    
	String msg=linkedlist.GetCurrentlinkurl();
	System.out.println("The user landed on:"+msg);
}

@When("The user clicks the try here button on the linked list page")
public void the_user_clicks_the_try_here_button_on_the_linked_list_page() {
   
  
   linkedlist.clicktryherebutton();
}
@Then("The user is redirected to the Editor page with Run button in the linked list page")
public void the_user_is_redirected_to_the_editor_page_with_run_button_in_the_linked_list_page() {
    
	String title=linkedlist.geturltitle();
	System.out.println("The current page is :"+ title);
}	

@When("The user clicks on run button after providing the valid python code in linked list page from given sheetname {string} and rowno {int}")
public void the_user_clicks_on_run_button_after_providing_the_valid_python_code_in_linked_list_page_from_given_sheetname_and_rowno_(String sheetname,Integer rowno) throws InterruptedException, InvalidFormatException, IOException {
   
	TestDataReadingWriting reader= new TestDataReadingWriting();
	
	
	 List<Map<String, String>>gettextdata= reader.getData("C:/MyCode/DSAlgoProject/src/test/resources/Exceldata/TestExcelData1.xlsx",sheetname);
	 
	String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
	outputdata=gettextdata.get(rowno).get("ExpectedOutput");
	System.out.println(inputdata);
	System.out.println(outputdata);
	linkedlist.EnterCode(inputdata);
	Thread.sleep(2000);   
   
}

	
@Then("The user should be able to see the output on the console for the valid  input data for the linked list datastructure")
public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_input_data_for_the_linked_list_datastructure() {
   
	String printoutput=linkedlist.Getoutput();
	assertEquals(printoutput,outputdata);
	System.out.println(printoutput);
	
}


@When("The user clicks on run button after providing the invalid python code in linked list page from given sheetname {string} and rowno {int}")
public void the_user_clicks_on_run_button_after_providing_the_invalid_python_code_in_linked_list_page_from_given_sheetname_and_rowno_(String sheetname,Integer rowno) throws InvalidFormatException, IOException, InterruptedException {
   
	TestDataReadingWriting reader= new TestDataReadingWriting();
	 List<Map<String, String>>gettextdata=reader.getData("C:/MyCode/DSAlgoProject/src/test/resources/Exceldata/TestExcelData1.xlsx",sheetname);
	 
	String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
	outputdata=gettextdata.get(rowno).get("ExpectedOutput");
	System.out.println(inputdata);
	System.out.println(outputdata);
	linkedlist.EnterCode(inputdata);
	Thread.sleep(2000);   
   	
}

@Then("The user should be able to see a alertbox syntaxerror for the linked list page")
public void the_user_should_be_able_to_see_a_alertbox_syntaxerror_for_the_linked_list_page() {
    
	String alertmsg=linkedlist.getAlertMsg();

	assertEquals(alertmsg,outputdata);
	System.out.println(alertmsg);
	System.out.println(outputdata); 
	
}

@When("The user navigate back and clicks the signout link in the linked list page")
public void the_user_navigate_back_and_clicks_the_signout_link_in_the_linked_list_page() throws InterruptedException {
    
	String title=linkedlist.NavigateBack();
    System.out.println(title);
    linkedlist.LogOut();
    Thread.sleep(2000);
}

@Then("The user should be able to see the {string}  message for the linked list page")
public void the_user_should_be_able_to_see_the_message_for_the_linked_list_page(String ExpectedMsg ) {
    
	String logoutMsg=linkedlist.Logoutmsg();
	assertEquals(logoutMsg,ExpectedMsg);
	System.out.println(logoutMsg);
	LoggerLoad.info(logoutMsg);
	
}

}


	