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

	@Then("the user redirected to the clicked  graph link page")
	public void the_user_redirected_to_the_clicked_graph_link_page() {
		String actualTitle=graphPage.getCurrentTitle();
		LoggerLoad.info("Actual title of current page is*****"+actualTitle);	
	}

	@When("the user clicks the try here button on the graph page")
	public void the_user_clicks_the_try_here_button_on_the_graph_page() {
		graphPage.tryHereClick();
	}

	@Then("the user is redirected to the graph Editor page with Run button")
	public void the_user_is_redirected_to_the_graph_editor_page_with_run_button() {
		graphPage.getEditorTitle();
	}

	@When("the user clicks on run button after providing the graph python code from given sheetname {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_graph_python_code_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException {
		TestDataReadingWriting reader=new TestDataReadingWriting();
		   List<Map<String,String>> gettextdata=reader.getData("C:/Users/sofia/eclipse-workspace/DSAlgoProject/src/test/resources/Exceldata/dsAlgoTestData.xlsx",sheetname);
		   String inputdata=gettextdata.get(rowno).get("Inputpythoncode");
		    outputdata=gettextdata.get(rowno).get("ExpectedOutput");
		   System.out.println("inputdata is "+inputdata);
		   System.out.println("outputdata is "+outputdata);
		   graphPage.enterCode(inputdata);
	}

	@Then("the user should be able to see the output on the console for the valid graph python code")
	public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_graph_python_code() {
		String actualOutput=graphPage.getOutput();
		  
	    assertEquals(actualOutput,outputdata);
	}

}
