package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import dsalgoPOM.ArrayPage;
import dsutilities.DriverFactory;
import dsutilities.ExcelUtils;
import dsutilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Array_stepdefinition {

	ArrayPage arrayPage = new ArrayPage(DriverFactory.getDriver());
	String expectedOutput;
	int i;
	ExcelUtils excelUtils = new ExcelUtils();
	String file = System.getProperty("user.dir") + "\\src\\test\\resources\\Exceldata\\dsAlgoTestData.xlsx";
	int rows = ExcelUtils.getRowCount(file, "PythonCode");


	public Array_stepdefinition() throws IOException {
		// Call superclass constructor
		super();

	}

	@Given("The user is on the array page")
	public void the_user_is_on_the_array_page() {

		arrayPage.arrayHomePage();
	}

	@When("the user clicks the links from the array page under {string}")
	public void the_user_clicks_the_links_from_the_array_page_under(String topic) {
		List<WebElement> links = arrayPage.getlinksByTopic(topic);
		for (WebElement link : links) {
			String linkNames = link.getText();
			link.click();
		}

		// arrayPage.getlinksByTopic(topic);
		// System.out.println("LINK IS"+links.getText());

	}

	@Then("the user redirected to the clicked  link page")
	public void the_user_redirected_to_the_clicked_link_page() {
		String actualTitle = arrayPage.getCurrentTitle();
		LoggerLoad.info("Actual title of current page is*****" + actualTitle);
		// System.out.println("Actual title of current page is***** "+actualTitle);

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
	public void the_user_clicks_on_run_button_after_providing_the_python_code_from_given_sheetname_and_rowno(
			String sheetname, Integer rowno) throws InvalidFormatException, IOException {

		// read data from excel file
		String inputPythonCode = ExcelUtils.getCellData(file, sheetname, rowno, 0);
		expectedOutput = ExcelUtils.getCellData(file, sheetname, rowno, 1);
		System.out.println("@@@@@@" + inputPythonCode);
		System.out.println("Expected Output isssssssss" + expectedOutput);

		// pass data to app
		arrayPage.enterCode(inputPythonCode);

		// validation and update results in excel

		String actualOutput = arrayPage.getOutput();
		System.out.println("Actual output issssssssss" + actualOutput);
		assertEquals(actualOutput, expectedOutput);
		if (expectedOutput.equals(actualOutput)) {
			System.out.println("Test Passed");
			ExcelUtils.setCellData(file, sheetname, rowno, 3, "Passed");
			ExcelUtils.fillGreenColor(file, sheetname, rowno, 3);
		}

	}

	@When("the user clicks on run button after providing the invaild python code from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_invaild_python_code_from_given_sheetname_and_rowno(
			String sheetname, Integer rowno) throws IOException, InterruptedException {
		String inputPythonCode = ExcelUtils.getCellData(file, sheetname, rowno, 0);
		expectedOutput = ExcelUtils.getCellData(file, sheetname, rowno, 1);
		System.out.println("@@@@@@" + inputPythonCode);
		System.out.println("Expected Output isssssssss" + expectedOutput);

		// pass data to app
		arrayPage.enterCode(inputPythonCode);
		String actualAlertText = arrayPage.getAlertMsg();
		System.out.println("Actual Alert Text is " + actualAlertText);
		assertEquals(actualAlertText, expectedOutput);
		if (expectedOutput.equals(actualAlertText)) {
			System.out.println("Test Failed");
			ExcelUtils.setCellData(file, "PythonCode", rowno, 3, "Failed");
			ExcelUtils.fillRedColor(file, "PythonCode", rowno, 3);
		}

	}

}
