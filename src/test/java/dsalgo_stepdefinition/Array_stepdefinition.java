package dsalgo_stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

import dsalgoPOM.ArrayPage;
import dsutilities.DriverFactory;
import dsutilities.LoggerLoad;
import dsutilities.TestDataReadingWriting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.testng.Assert.assertEquals;

public class Array_stepdefinition  {
	
	ArrayPage arrayPage=new ArrayPage(DriverFactory.getDriver());
	String outputdata;
//	@Given("The user is on the array page")
//	public void the_user_is_on_the_array_page() {
//		driver.get("https://dsportalapp.herokuapp.com/array/");
//	}

	@Given("The user is on the array page")
	public void the_user_is_on_the_array_page() {
	
		arrayPage.arrayHomePage();
	}

	@When("the user clicks the links from the array page under {string}")
	public void the_user_clicks_the_links_from_the_array_page_under(String topic) {
	List<WebElement>links= arrayPage.getlinksByTopic(topic);
	for(WebElement link:links)
	{
		String linkNames=link.getText();
		link.click();
	}
	
	//arrayPage.getlinksByTopic(topic);
	//System.out.println("LINK IS"+links.getText());
	
		
	}

	@Then("the user redirected to the clicked  link page")
	public void the_user_redirected_to_the_clicked_link_page() {
		String actualTitle=arrayPage.getCurrentTitle();
		LoggerLoad.info("Actual title of current page is*****"+actualTitle);	
		//System.out.println("Actual title of current page is***** "+actualTitle);
		
	}

	@When("the user clicks the try here button on the page")
	public void the_user_clicks_the_try_here_button_on_the_page() {
		arrayPage.tryHereClick();
	}

	@Then("the user is redirected to the Editor page with Run button")
	public void the_user_is_redirected_to_the_editor_page_with_run_button() {
		arrayPage.getEditorTitle();
	}

	@When("the user clicks on run button after providing the python code from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_python_code_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException {
	   TestDataReadingWriting reader=new TestDataReadingWriting();
	   List<Map<String,String>> gettextdata=reader.getData("C:/Users/sofia/eclipse-workspace/DSAlgoProject/src/test/resources/Exceldata/dsAlgoTestData.xlsx",sheetname);
	   String inputdata=gettextdata.get(rowno).get("Inputpythoncode");
	    outputdata=gettextdata.get(rowno).get("ExpectedOutput");
	   System.out.println("inputdata is "+inputdata);
	   System.out.println("outputdata is "+outputdata);
	   arrayPage.enterCode(inputdata);
	   
	}

	@Then("the user should be able to see the output on the console for the valid data")
	public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_data() {
	    String actualOutput=arrayPage.getOutput();
	  
	    assertEquals(actualOutput,outputdata);
	}








}
