package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

import dsalgoPOM.TreePage;
import dsutilities.DriverFactory;
import dsutilities.LoggerLoad;
import dsutilities.TestDataReadingWriting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DSTreeStepDefinition {
	public TreePage treepage=new TreePage(DriverFactory.getDriver());
	private String outputdata;
	private String outputdata1;
	String file = System.getProperty("user.dir") + "\\src\\test\\resources\\Exceldata\\TestExcelData1.xlsx";
	@Given("The user is on the Tree page")
	public void the_user_is_on_the_tree_page() throws FileNotFoundException, IOException, InterruptedException {
		treepage.TreeHomePage();
	  }

	@When("the user clicks the links from the Tree page under {string}")
	public void the_user_clicks_the_links_from_the_tree_page_under(String topic) throws InterruptedException {
		List<WebElement> links=treepage.getLinkByTopics(topic);
		for(WebElement link:links)
		{
			link.click();
		}
	}
	@Then("the user redirected to the clicked  link page in the Tree datastructure")
public void the_user_redirected_to_the_clicked_link_page_in_the_tree_datastructure()
	{
		String msg=treepage.GetCurrentlinkurl();
		//System.out.println("The user landed on:"+msg);
		LoggerLoad.info("Actual title of current page is*****"+msg);
	}
@When("the user clicks the try here button on the page in tree datastructure")
public void the_user_clicks_the_try_here_button_on_the_page_in_tree_datastructure() {

	   treepage.clicktryherebutton();
	}
//
	@Then("the user is redirected to the Editor page ot the tree datastructure with Run button")
public void the_user_is_redirected_to_the_editor_page_ot_the_tree_datastructure_with_run_button() {
		String title=treepage.geturltitle();
		System.out.println("The current page is :"+ title);
		//LoggerLoad.info("Current page is :"+title);
	   
	}
	//To read Valid input data
	@When("the user clicks on run button in tree page after providing the python code from given sheetname {string} and rowno {int}")
public void the_user_clicks_on_run_button_in_tree_page_after_providing_the_python_code_from_given_sheetname_and_rowno(String sheetname, Integer rowno) throws InvalidFormatException, IOException, InterruptedException {

		 TestDataReadingWriting reader= new TestDataReadingWriting();
		 List<Map<String, String>>gettextdata= reader.getData(file,sheetname);
		 
		String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
		outputdata=gettextdata.get(rowno).get("ExpectedOutput");
		System.out.println(inputdata);
		System.out.println(outputdata);
		treepage.EnterCode(inputdata);
		}

@Then("the user should be able to see the output on the console for the valid  input data for the tree datastructure")
public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_input_data_for_the_tree_datastructure() throws InterruptedException{
		
		String printoutput=treepage.Getoutput();
		assertEquals(printoutput,outputdata);
		System.out.println(printoutput);
	
	}
	

@Then("the user should be able to see a alertbox syntaxerror for the tree page")
public void the_user_should_be_able_to_see_a_alertbox_syntaxerror_for_the_tree_page(){
		String alertmsg=treepage.getAlertMsg();
        assertEquals(alertmsg,outputdata);
		System.out.println(alertmsg);
		System.out.println(outputdata);
	    
	}
	@Given("The user is on the editor page and user navigated back from the editor page in the tree")
	public void the_user_is_on_the_editor_page_and_user_navigated_back_from_the_editor_page_in_the_tree() {

		 String title=treepage.NavigateBack();
		    System.out.println(title);
	}

	@When("The user clicks the signout link from the tree data structure")
	public void the_user_clicks_the_signout_link_from_the_tree_data_structure() {
		
		 treepage.LogOut();
	}

	@Then("the user is logged out of the tree datastructure and the dsalgoportal and the {string}  message is displayed")
	public void the_user_is_logged_out_of_the_tree_datastructure_and_the_dsalgoportal_and_the_message_is_displayed(String actualmsg) {
		String logoutmsg=treepage.ReadLogoutmsg();
		assertEquals(logoutmsg,actualmsg);
		LoggerLoad.info(logoutmsg);

	}

}
