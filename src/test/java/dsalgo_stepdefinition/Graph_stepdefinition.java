package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

import dsalgoPOM.GraphPage;
import dsutilities.DriverFactory;
import dsutilities.LoggerLoad;
import dsutilities.TestDataReadingWriting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Graph_stepdefinition {
	GraphPage graphPage=new GraphPage(DriverFactory.getDriver());
	String outputdata;
	
	@Given("The user is on the graph page")
	public void the_user_is_on_the_graph_page() {
		graphPage.graphHomePage();
	}

	@When("the user clicks the links from the graph page under {string}")
	public void the_user_clicks_the_links_from_the_graph_page_under(String topic) {
		List<WebElement>links= graphPage.getlinksByTopic(topic);
		for(WebElement link:links)
		{
			String linkNames=link.getText();
			link.click();
		}
	}

	@Then("the user redirected to the clicked  link page in the graph data structure")
	public void the_user_redirected_to_the_clicked_link_page_in_the_graph_data_structure() {
		String actualTitle=graphPage.getCurrentTitle();
		LoggerLoad.info("Actual title of current page is*****"+actualTitle);
	}

	@When("the user clicks the try here button on the graph page")
	public void the_user_clicks_the_try_here_button_on_the_graph_page() {
		graphPage.tryHereClick();
	}

	@Then("the user is redirected to the Editor page with Run button in the graph page")
	public void the_user_is_redirected_to_the_editor_page_with_run_button_in_the_graph_page() {
		graphPage.getEditorTitle();
	}

	@When("the user clicks on run button after providing the valid python code in graph page from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_valid_python_code_in_graph_page_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {
		TestDataReadingWriting reader= new TestDataReadingWriting();
		 List<Map<String, String>>gettextdata=reader.getData("C:\\Users\\sofia\\eclipse-workspace\\DSAlgoProject\\src\\test\\resources\\ExcelData\\TestExcelData1.xlsx",sheetname);
		 
		String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
		outputdata=gettextdata.get(rowno).get("ExpectedOutput");
		System.out.println(inputdata);
		System.out.println(outputdata);
		graphPage.enterCode(inputdata);
		Thread.sleep(2000);   
	    
	}

	@Then("the user should be able to see the output on the console for the valid  input data for the graph datastructure")
	public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_input_data_for_the_graph_datastructure() {
		String actualOutput=graphPage.getOutput();
		assertEquals(actualOutput,outputdata);
	}

	@Then("user navigate back and clicks the signout link in the graph page")
	public void user_navigate_back_and_clicks_the_signout_link_in_the_graph_page() {
		String title=graphPage.NavigateBack();
	    System.out.println(title);
	    graphPage.LogOut();
	}

	@Then("the user is logged out of the graph and the dsalgoportal and the {string}  message is displayed")
	public void the_user_is_logged_out_of_the_graph_and_the_dsalgoportal_and_the_message_is_displayed(String actualmsg) {
		String logoutmsg=graphPage.ReadLogoutmsg();
		assertEquals(logoutmsg,actualmsg);
		LoggerLoad.info(logoutmsg);
	}

	@When("the user clicks on run button after providing the invalid python code in graph page from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_invalid_python_code_in_graph_page_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {
		TestDataReadingWriting reader= new TestDataReadingWriting();
		 List<Map<String, String>>gettextdata=reader.getData("C:\\Users\\sofia\\eclipse-workspace\\DSAlgoProject\\src\\test\\resources\\ExcelData\\TestExcelData1.xlsx",sheetname);
		 
		String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
		outputdata=gettextdata.get(rowno).get("ExpectedOutput");
		System.out.println(inputdata);
		System.out.println(outputdata);
		graphPage.enterCode(inputdata);
		Thread.sleep(2000); 
	}

	@Then("the user should be able to see a alertbox syntaxerror for the graph page")
	public void the_user_should_be_able_to_see_a_alertbox_syntaxerror_for_the_graph_page() {
		String alertmsg=graphPage.getAlertMsg();

		assertEquals(alertmsg,outputdata);
		System.out.println(alertmsg);
		System.out.println(outputdata); 
	}



	
	

}
