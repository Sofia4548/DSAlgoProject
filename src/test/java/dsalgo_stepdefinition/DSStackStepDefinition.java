package dsalgo_stepdefinition;


import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dsalgoPOM.StackPage;
import dsutilities.DriverFactory;
import dsutilities.TestDataReadingWriting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSStackStepDefinition {
	
	public StackPage stackpage=new StackPage(DriverFactory.getDriver());
	private String outputdata;
	private String outputdata1;
	
	

	@Given("User navigates to the login page")
	public void user_navigates_to_the_login_page() throws IOException {
	   stackpage.dsalgohomepage();
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String uname, String pswrd)
	{
		stackpage.LoginProcess(uname, pswrd);
	}
	@When("Clicks the login button")
	public void clicks_the_login_button()
	{
		stackpage.clicklogin();
		
	}
	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		String messageStr = stackpage.numpaNinjaText();
		System.out.println(messageStr);
		assertEquals(messageStr,"NumpyNinja");
	
	}

	@Given("The user is on the stack page")
	public void the_user_is_on_the_stack_page() throws FileNotFoundException, IOException, InterruptedException {
		stackpage.StackHomePage();
	   
	}

	@When("the user clicks the links from the stack page under {string}")
	public void the_user_clicks_the_links_from_the_stack_page_under(String topic) throws InterruptedException {
		
		//List<WebElement> links=new ArrayList<WebElement>();
		List<WebElement> links=stackpage.getLinkByTopics(topic);
		
		
		for(WebElement link:links)
		{
			String linknames=link.getText();
			System.out.println("Links in the stack page:"+linknames);
			Thread.sleep(100);
			link.click();
			
		}
	}
		
	

	@Then("the user redirected to the clicked  link page")
	public void the_user_redirected_to_the_clicked_link_page()
	{
		String msg=stackpage.GetCurrentlinkurl();
		System.out.println("The user landed on:"+msg);
	}

	@When("the user clicks the try here button on the page")
	public void the_user_clicks_the_try_here_button_on_the_page() {

	   stackpage.clicktryherebutton();
	}

	@Then("the user is redirected to the Editor page with Run button")
	public void the_user_is_redirected_to_the_editor_page_with_run_button() {
		String title=stackpage.geturltitle();
		System.out.println("The current page is :"+ title);
	   
	}
	//To read Valid input data
	@When("the user clicks on run button after providing the python code from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_python_code_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {

		 TestDataReadingWriting reader= new TestDataReadingWriting();
		
		// List<Map<String, String>>gettextdata= reader.getData("C:/Users/gayathri/eclipse-workspace/DSAlgoProject/src/test/resources/TestData/Testexceldata.xlsx",sheetname);
		 List<Map<String, String>>gettextdata= reader.getData("C:/Users/gayathri/Desktop/TestExcelData1.xlsx",sheetname);
		 
		String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
		outputdata=gettextdata.get(rowno).get("ExpectedOutput");
		System.out.println(inputdata);
		stackpage.EnterCode(inputdata);
		Thread.sleep(2000);
//		String invaliddata=gettextdata.get(rowno).get("Input");
//		outputdata1=gettextdata.get(rowno).get("output");
//		  
//		System.out.println(invaliddata);
//		stackpage.EnterCode(invaliddata);
		
	}

		 


	
	@Then("the user should be able to see the output on the console for the valid  input data")
	public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_input_data() throws InterruptedException{
		
		String printoutput=stackpage.Getoutput();
		
		//stackpage.invalidata();
		assertEquals(printoutput,outputdata);
		System.out.println(printoutput);
	
		
	}
	
	@When("the user clicks on run button after providing the invalidpython code from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_invalidpython_code_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InterruptedException, InvalidFormatException, IOException {
TestDataReadingWriting reader= new TestDataReadingWriting();
		
		// List<Map<String, String>>gettextdata= reader.getData("C:/Users/gayathri/eclipse-workspace/DSAlgoProject/src/test/resources/TestData/Testexceldata.xlsx",sheetname);
		 List<Map<String, String>>gettextdata= reader.getData("C:/Users/gayathri/Desktop/TestExcelData1.xlsx",sheetname);
		 
		String inputdata1= gettextdata.get(rowno).get("Inputpythoncode");
		outputdata1=gettextdata.get(rowno).get("ExpectedOutput");
		System.out.println(inputdata1);
		stackpage.EnterCode(inputdata1);
	    
	}

	@Then("the user should be able to see a alertbox syntaxerror")
	public void the_user_should_be_able_to_see_a_alertbox_syntaxerror() {
		String alertmsg=stackpage.getAlertMsg();
		assertEquals(alertmsg,outputdata1);
		System.out.println(alertmsg);
	    
	}
}

