package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

import dsalgoPOM.PractisePage;
import dsutilities.DriverFactory;
import dsutilities.LoggerLoad;
import dsutilities.TestDataReadingWriting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Practise_stepdefinition {
	PractisePage practisePage = new PractisePage(DriverFactory.getDriver());
	private String outputdata;
	String file = System.getProperty("user.dir") + "\\src\\test\\resources\\Exceldata\\TestExcelData2.xlsx";

	@When("the user clicks the link from the array page under Arrays in Python")
	public void the_user_clicks_the_link_from_the_array_page_under_arrays_in_python() {
		practisePage.arraysInPythonlinkClick();
	}

//	@Then("the user redirected to the clicked  link page")
//	public void the_user_redirected_to_the_clicked_link_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@When("the user clicks the practise question links on the page")
	public void the_user_clicks_the_practise_question_links_on_the_page() {
		practisePage.practiseLinkClick();
	}

	@Then("the user is redirected to the practise question page")
	public void the_user_is_redirected_to_the_practise_question_page() {
		String actualPractisePageTitle = practisePage.practisePageTitle();
		System.out.println("Actual Practise Page Title is " + actualPractisePageTitle);
	}

	@When("the user clicks the links from the array practise page under {string}")
	public void the_user_clicks_the_links_from_the_array_practise_page_under(String topic) {
		List<WebElement> links = practisePage.getlinksByTopic(topic);
		for (WebElement link : links) {
			// String linknames=link.getText();
			System.out.println();
			link.click();
		}
	}

	@Then("the user redirected to the clicked  link page in the array practise page")
	public void the_user_redirected_to_the_clicked_link_page_in_the_array_practise_page() {
		String actualTitle = practisePage.getCurrentTitle();
		// System.out.println("Actual title of current page is*****" + actualTitle);
		LoggerLoad.info("Actual title of current page is*****" + actualTitle);
	}

	@When("the user clicks on run button after providing the valid python code in array practise page from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_valid_python_code_in_array_practise_page_from_given_sheetname_and_rowno(
			String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {
		TestDataReadingWriting reader = new TestDataReadingWriting();
		List<Map<String, String>> gettextdata = reader.getData(file, sheetname);

		String inputdata = gettextdata.get(rowno).get("Inputpythoncode");
		outputdata = gettextdata.get(rowno).get("ExpectedOutput");
		System.out.println(inputdata);
		System.out.println(outputdata);

		practisePage.enterCode(inputdata);
		Thread.sleep(2000);
	}

	@Then("the user should be able to see the output on the console for the valid  input data for the array practise page")
	public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_input_data_for_the_array_practise_page() {
		String printoutput = practisePage.getOutput();
		assertEquals(printoutput, outputdata);
		System.out.println(printoutput);
	}

	@Then("user navigate back and clicks the signout link in the array practise page")
	public void user_navigate_back_and_clicks_the_signout_link_in_the_array_practise_page() {
		String title = practisePage.NavigateBack();
		System.out.println(title);
		practisePage.LogOut();
	}

	@Then("the user is logged out of the array practise and the dsalgoportal and the {string}  message is displayed")
	public void the_user_is_logged_out_of_the_array_practise_and_the_dsalgoportal_and_the_message_is_displayed(
			String actualmsg) {
		String logoutmsg = practisePage.ReadLogoutmsg();
		assertEquals(logoutmsg, actualmsg);
		LoggerLoad.info(logoutmsg);
	}

	@When("the user clicks on run button after providing the invalid python code in array practise page from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_invalid_python_code_in_array_practise_page_from_given_sheetname_and_rowno(
			String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {
		TestDataReadingWriting reader = new TestDataReadingWriting();
		List<Map<String, String>> gettextdata = reader.getData(file, sheetname);

		String inputdata = gettextdata.get(rowno).get("Inputpythoncode");
		outputdata = gettextdata.get(rowno).get("ExpectedOutput");
		System.out.println(inputdata);
		System.out.println(outputdata);
		practisePage.enterCode(inputdata);
		Thread.sleep(2000);
	}

	@Then("the user should be able to see a alertbox syntaxerror for the array practise page")
	public void the_user_should_be_able_to_see_a_alertbox_syntaxerror_for_the_array_practise_page() {
		String alertmsg = practisePage.getAlertMsg();

		assertEquals(alertmsg, outputdata);
		System.out.println(alertmsg);
		System.out.println(outputdata);
	}

}
