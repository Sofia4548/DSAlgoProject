package dsalgo_stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

import dsalgoPOM.PractisePage;
import dsutilities.DriverFactory;
import dsutilities.TestDataReadingWriting;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Practise_stepdefinition {
	String outputdata;
	PractisePage practisePage=new PractisePage(DriverFactory.getDriver());
	
	@When("the user clicks the link from the array page under Arrays in Python")
	public void the_user_clicks_the_link_from_the_array_page_under_arrays_in_python() {
		practisePage.arraysInPythonlinkClick();
	}

	@When("the user clicks the practise question links on the page")
	public void the_user_clicks_the_practise_question_links_on_the_page() {
		practisePage.practiseLinkClick();
	}

	@Then("the user is redirected to the practise question page")
	public void the_user_is_redirected_to_the_practise_question_page() {
		String actualPractisePageTitle=practisePage.practisePageTitle();
		System.out.println("Actual Practise Page Title is "+ actualPractisePageTitle);
	}

	@When("the user clicks the link from the practise page under {string}")
	public void the_user_clicks_the_link_from_the_practise_page_under(String topic) {
		List<WebElement>links= practisePage.getlinksByTopic(topic);
		for(WebElement link:links)
		{
			String linkNames=link.getText();
			link.click();
		}
	}
	@When("the user clicks on run button after providing the python code for array practice from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_python_code_for_array_practice_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException {
		TestDataReadingWriting reader=new TestDataReadingWriting();
		   List<Map<String,String>> gettextdata=reader.getData("C:/Users/sofia/eclipse-workspace/DSAlgoProject/src/test/resources/Exceldata/dsaAlgoPractiseTestData.xlsx",sheetname);
		   String inputdata=gettextdata.get(rowno).get("Inputpythoncode");
		    outputdata=gettextdata.get(rowno).get("ExpectedOutput");
		   System.out.println("inputdata is "+inputdata);
		   System.out.println("outputdata is "+outputdata);
		  practisePage.enterCode(inputdata);
	}

	@Then("the user should be able to see the output on the console")
	public void the_user_should_be_able_to_see_the_output_on_the_console() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
