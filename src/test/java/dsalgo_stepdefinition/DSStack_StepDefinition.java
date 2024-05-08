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
import org.openqa.selenium.WebElement;

import dsalgoPOM.DSStack_Page;
import dsalgoPOM.TreePage;
import dsutilities.DriverFactory;
import dsutilities.LoggerLoad;
import dsutilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dsutilities.TestDataReadingWriting;


public class DSStack_StepDefinition {
	public DSStack_Page stackpage1=new DSStack_Page(DriverFactory.getDriver());
	private String outputdata;
	private String outputdata1;
	
	@Given("The user is on the stack page")
	public void the_user_is_on_the_stack_page() throws FileNotFoundException, IOException, InterruptedException {
	    stackpage1.StackHomePage();
	    
	}

	@When("the user clicks the links from the stack page under {string}")
	public void the_user_clicks_the_links_from_the_stack_page_under(String topic) {
List<WebElement> links=stackpage1.getLinkByTopics(topic);
		
		
		for(WebElement link:links)
		{
			//String linknames=link.getText();
			
			link.click();
			//Thread.sleep(1000);
			
		}
	    
	}

	@Then("the user redirected to the clicked  link page in the stack data structure")
	public void the_user_redirected_to_the_clicked_link_page_in_the_stack_data_structure() {
		String msg=stackpage1.GetCurrentlinkurl();
		System.out.println("The user landed on:"+msg);
	    
	}

	@When("the user clicks the try here button on the stack page")
	public void the_user_clicks_the_try_here_button_on_the_stack_page() {
	    stackpage1.clicktryherebutton();
	    
	}

	@Then("the user is redirected to the Editor page with Run button in the stack page")
	public void the_user_is_redirected_to_the_editor_page_with_run_button_in_the_stack_page() {
		String title=stackpage1.geturltitle();
		System.out.println("The current page is :"+ title);
	    
	}

	@When("the user clicks on run button after providing the valid python code in stack page from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_valid_python_code_in_stack_page_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {
		TestDataReadingWriting reader= new TestDataReadingWriting();
		
		
		 List<Map<String, String>>gettextdata= reader.getData("C:/Users/gayathri/eclipse-workspace/DSAlgoProject/src/test/resources/ExcelData/TestExcelData1.xlsx",sheetname);
		 
		String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
		outputdata=gettextdata.get(rowno).get("ExpectedOutput");
		System.out.println(inputdata);
		System.out.println(outputdata);
		stackpage1.EnterCode(inputdata);
		Thread.sleep(2000);   
	    
	}
	@Then("the user should be able to see the output on the console for the valid  input data for the stack datastructure")
	public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_input_data_for_the_stack_datastructure() {
		String printoutput=stackpage1.Getoutput();
		assertEquals(printoutput,outputdata);
		System.out.println(printoutput);
	}

	@When("the user clicks on run button after providing the invalid python code in stack page from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_invalid_python_code_in_stack_page_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {
		TestDataReadingWriting reader= new TestDataReadingWriting();
		 List<Map<String, String>>gettextdata=reader.getData("C:/Users/gayathri/eclipse-workspace/DSAlgoProject/src/test/resources/ExcelData/TestExcelData1.xlsx",sheetname);
		 
		String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
		outputdata=gettextdata.get(rowno).get("ExpectedOutput");
		System.out.println(inputdata);
		System.out.println(outputdata);
		stackpage1.EnterCode(inputdata);
		Thread.sleep(2000);   
	    
	}
	@Then("the user should be able to see a alertbox syntaxerror for the stack page")
	public void the_user_should_be_able_to_see_a_alertbox_syntaxerror_for_the_stack_page() {
		String alertmsg=stackpage1.getAlertMsg();

		assertEquals(alertmsg,outputdata);
		System.out.println(alertmsg);
		System.out.println(outputdata); 
	}

	@When("The user navigate back and clicks the signout link in the stack page")
	public void the_user_navigate_back_and_clicks_the_signout_link_in_the_stack_page() {
	    
		String title=stackpage1.NavigateBack();
	    System.out.println(title);
	    stackpage1.LogOut();
	}

	@Then("the user is logged out of the stack and the dsalgoportal and the {string}  message is displayed")
	public void the_user_is_logged_out_of_the_stack_and_the_dsalgoportal_and_the_message_is_displayed(String actualmsg) {
		String logoutmsg=stackpage1.ReadLogoutmsg();
		assertEquals(logoutmsg,actualmsg);
		//System.out.println(logoutmsg);
		LoggerLoad.info(logoutmsg);
	    
	    
	}




}
