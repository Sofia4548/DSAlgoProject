package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

import dsalgoPOM.DataStructurePage;
import dsutilities.DriverFactory;
import dsutilities.LoggerLoad;
import dsutilities.TestDataReadingWriting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataStructure_stepdefinition {
	DataStructurePage dataStructurePage = new DataStructurePage(DriverFactory.getDriver());
	String outputdata;
	String file = System.getProperty("user.dir") + "\\src\\test\\resources\\Exceldata\\TestExcelData1.xlsx";

	@Given("The user is on the datastructures page")
	public void the_user_is_on_the_datastructures_page() {
		dataStructurePage.dsHomePage();
	}

	@When("the user clicks the links from the datastructures page under {string}")
	public void the_user_clicks_the_links_from_the_datastructures_page_under(String topic) {
		List<WebElement> links = dataStructurePage.getlinksByTopic(topic);
		for (WebElement link : links) {
			String linkNames = link.getText();
			link.click();
		}
	}

	@Then("the user redirected to the clicked  link page in the datastructures page")
	public void the_user_redirected_to_the_clicked_link_page_in_the_datastructures_page() {
		String actualTitle = dataStructurePage.getCurrentTitle();
		LoggerLoad.info("Actual title of current page is*****" + actualTitle);
	}

	@When("the user clicks the try here button on the datastructures page")
	public void the_user_clicks_the_try_here_button_on_the_datastructures_page() {
		dataStructurePage.tryHereClick();
	}

	@Then("the user is redirected to the Editor page with Run button in the datastructures page")
	public void the_user_is_redirected_to_the_editor_page_with_run_button_in_the_datastructures_page() {
		dataStructurePage.getEditorTitle();
	}

	@When("the user clicks on run button after providing the valid python code in datastructures page from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_valid_python_code_in_datastructures_page_from_given_sheetname_and_rowno(
			String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {
		TestDataReadingWriting reader = new TestDataReadingWriting();
		List<Map<String, String>> gettextdata = reader.getData(file, sheetname);
		String inputdata = gettextdata.get(rowno).get("Inputpythoncode");
		outputdata = gettextdata.get(rowno).get("ExpectedOutput");
		System.out.println(inputdata);
		System.out.println(outputdata);
		dataStructurePage.enterCode(inputdata);
		Thread.sleep(2000);
	}

	@Then("the user should be able to see the output on the console for the valid  input data for the datastructures")
	public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_input_data_for_the_datastructures() {
		String actualOutput = dataStructurePage.getOutput();
		assertEquals(actualOutput, outputdata);
	}

	@Then("user navigate back and clicks the signout link in the datastructures page")
	public void user_navigate_back_and_clicks_the_signout_link_in_the_datastructures_page() {

		String title = dataStructurePage.NavigateBack();
		System.out.println(title);
		dataStructurePage.LogOut();
	}

	@Then("the user is logged out of the datastructures and the dsalgoportal and the {string}  message is displayed")
	public void the_user_is_logged_out_of_the_datastructures_and_the_dsalgoportal_and_the_message_is_displayed(
			String actualmsg) {
		String logoutmsg = dataStructurePage.ReadLogoutmsg();
		assertEquals(logoutmsg, actualmsg);
		LoggerLoad.info(logoutmsg);
	}

	@When("the user clicks on run button after providing the invalid python code in datastructures page from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_invalid_python_code_in_datastructures_page_from_given_sheetname_and_rowno(
			String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {
		TestDataReadingWriting reader = new TestDataReadingWriting();
		List<Map<String, String>> gettextdata = reader.getData(file, sheetname);

		String inputdata = gettextdata.get(rowno).get("Inputpythoncode");
		outputdata = gettextdata.get(rowno).get("ExpectedOutput");
		System.out.println(inputdata);
		System.out.println(outputdata);
		dataStructurePage.enterCode(inputdata);
		Thread.sleep(2000);
	}

	@Then("the user should be able to see a alertbox syntaxerror for the datastructures page")
	public void the_user_should_be_able_to_see_a_alertbox_syntaxerror_for_the_datastructures_page() {
		String alertmsg = dataStructurePage.getAlertMsg();

		assertEquals(alertmsg, outputdata);
		System.out.println(alertmsg);
		System.out.println(outputdata);
	}

}
