package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

import dsalgoPOM.StackPage;
import dsalgoPOM.TreePage;
import dsutilities.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import dsutilities.TestDataReadingWriting;

public class DSTreeStepDefinition {
	public TreePage treepage=new TreePage(DriverFactory.getDriver());
	private String outputdata;
	
	@Given("The user is on the Tree	 page")
	public void the_user_is_on_the_tree_page() throws FileNotFoundException, IOException, InterruptedException {
	    
		treepage.TreeHomePage();
	}
	
	@When("the user clicks the links from the Tree page under {string}")
	public void the_user_clicks_the_links_from_the_tree_page_under(String topic) throws InterruptedException {
		List<WebElement> links=treepage.getLinkByTopics(topic);
		
		
		for(WebElement link:links)
		{
			String linknames=link.getText();
			System.out.println("Links in the stack page:"+linknames);
			Thread.sleep(100);
			link.click();
			
		}
	  
	}

	@When("the user clicks on run button after providing the python code from given sheetname  {string} and rowno {int}")
	public void the_user_clicks_on_run_button_after_providing_the_python_code_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {
	   
		TestDataReadingWriting reader= new TestDataReadingWriting();
		 List<Map<String, String>>gettextdata= reader.getData("C:/Users/gayathri/Desktop/dsAlgoTestData.xlsx",sheetname);
		String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
		outputdata=gettextdata.get(rowno).get("ExpectedOutput");
		//System.out.println(inputdata);
		treepage.EnterCode(inputdata);
		//Thread.sleep(2000);
		treepage.Submitcode();
	}

	@Then("the user should be able to see the output on the console for the valid data")
	public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_data() {
		String printoutput=treepage.Getoutput();
		assertEquals(printoutput,outputdata);
	   System.out.println(printoutput);
	  
	}
//
//	@Then("the user should be able to see a alertbox with the {string} syntaxerror")
//	public void the_user_should_be_able_to_see_a_alertbox_with_the_syntaxerror(String string) {
//	   
//	  
//	}


}
