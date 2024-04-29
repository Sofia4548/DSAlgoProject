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
	@Given("The user landed in the dsalgo login page")
	public void the_user_landed_in_the_dsalgo_login_page() throws IOException {
	   stackpage.dsalgohomepage();
	}
	   
	   @When("the user clicks login button after entering credentials <{string}> <{string}>")
	   public void the_user_clicks_login_button_after_entering_credentials(String uname, String pswrd)
	{
		stackpage.LoginProcess(uname, pswrd);
	}
	   @Then("The user should directed to Data Structure Home Page")
	   public void the_user_should_directed_to_data_structure_home_page() {
	    
		String messageStr = stackpage.numpaNinjaText();
		assertEquals(messageStr,"NumpyNinja");
	}


	@When("the user clicks the Getstarted button below the stack or select the stack from datastructure dropdown")
	public void the_user_clicks_the_getstarted_button_below_the_stack_or_select_the_stack_from_datastructure_dropdown() {
		stackpage.ClickStackGetStartedBtn();
	   
	}
	@Then("the user is directed to the stack home page")
	public void the_user_is_directed_to_the_stack_home_page() throws FileNotFoundException, IOException, InterruptedException {
		stackpage.StackHomePage();
	   
	}


	@Given("The user is on the stack page")
	public void the_user_is_on_the_stack_page() throws FileNotFoundException, IOException, InterruptedException {
		stackpage.StackHomePage();
	   
	}

	@When("the user clicks the links from the stack page under {string}")
	public void the_user_clicks_the_links_from_the_stack_page_under(String topic) throws InterruptedException {
		
		//List<WebElement> links=new ArrayList<WebElement>();
		List<WebElement> links=stackpage.getLinkByTopics(topic);
		//System.out.println("*********"+links);
		//System.out.println());
		for(WebElement link:links)
		{
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

	@When("the user clicks on run button after providing the python code from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_python_code_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {

		 TestDataReadingWriting reader= new TestDataReadingWriting();
		 List<Map<String, String>>gettextdata= reader.getData("C:/Users/gayathri/Desktop/dsAlgoTestData.xlsx",sheetname);
		String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
		outputdata=gettextdata.get(rowno).get("ExpectedOutput");
		//System.out.println(inputdata);
		stackpage.EnterCode(inputdata);
		Thread.sleep(2000);
		stackpage.Submitcode();
		
		//String printoutput=stackpage.Getoutput();
	   
	}
	@Then("the user should be able to see the output on the console for the valid data")
	public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_data(){
		String printoutput=stackpage.Getoutput();
		assertEquals(printoutput,outputdata);
	   System.out.println(printoutput);
	}
//	@Then("the user should be able to see a alertbox with the {string} syntaxerror")
//	public void the_user_should_be_able_to_see_a_alertbox_with_the_syntaxerror(String string) throws InterruptedException
//	{
//		//String invalidoutput=stackpage.invalidata();
//		String msg=stackpage.invalidata();
//		System.out.println(msg);
//		
//		
//	}
//

}
