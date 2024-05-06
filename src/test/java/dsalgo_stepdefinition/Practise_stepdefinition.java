package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

import dsalgoPOM.PractisePage;
import dsutilities.DriverFactory;
import dsutilities.ExcelUtils;
import dsutilities.TestDataReadingWriting;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Practise_stepdefinition {
	String outputdata;
	String expectedOutput;
	int i;
	ExcelUtils excelUtils = new ExcelUtils();
	String file = System.getProperty("user.dir") + "\\src\\test\\resources\\Exceldata\\dsaAlgoPractiseTestData.xlsx";
	int rows = ExcelUtils.getRowCount(file, "PythonCode");
	PractisePage practisePage=new PractisePage(DriverFactory.getDriver());
	public Practise_stepdefinition() throws IOException {
		// Call superclass constructor
		super();

	}
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

@When("the user clicks on run button after providing the vaild practise question python code from given sheetname {string} and rowno {int}")
public void the_user_clicks_on_run_button_after_providing_the_vaild_practise_question_python_code_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws IOException {
	// read data from excel file
			String inputPythonCode = ExcelUtils.getCellData(file, sheetname, rowno, 0);
			expectedOutput = ExcelUtils.getCellData(file, sheetname, rowno, 1);
			System.out.println("input code isssssssss" + inputPythonCode);
			System.out.println("Expected Output isssssssss" + expectedOutput);

			// pass data to app
			practisePage.enterCode(inputPythonCode);
			//validation and update results in excel
		
		String actualOutput = practisePage.getOutput();
//			System.out.println("Actual output issssssssss" + actualOutput);
//			assertEquals(actualOutput,expectedOutput);
//			if (expectedOutput.equals(actualOutput)) {
//				System.out.println("Test Passed");
//				ExcelUtils.setCellData(file, sheetname, rowno, 3, "Passed");
//				ExcelUtils.fillGreenColor(file, sheetname, rowno, 3);
//			}
}
	
//	@When("the user clicks on run button after providing the python code for array practice from given sheetname {string} and rowno {int}")
//	public void the_user_clicks_on_run_button_after_providing_the_python_code_for_array_practice_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException {
//		TestDataReadingWriting reader=new TestDataReadingWriting();
//		   List<Map<String,String>> gettextdata=reader.getData("C:/Users/sofia/eclipse-workspace/DSAlgoProject/src/test/resources/Exceldata/dsaAlgoPractiseTestData.xlsx",sheetname);
//		   String inputdata=gettextdata.get(rowno).get("Inputpythoncode");
//		    outputdata=gettextdata.get(rowno).get("ExpectedOutput");
//		   System.out.println("inputdata is "+inputdata);
//		   System.out.println("outputdata is "+outputdata);
//		  practisePage.enterCode(inputdata);
//	}

	@Then("the user should be able to see the output on the console")
	public void the_user_should_be_able_to_see_the_output_on_the_console() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
