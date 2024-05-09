package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;

import dsalgoPOM.QueuePage;
import dsutilities.DriverFactory;
import dsutilities.LoggerLoad;
import dsutilities.TestDataReadingWriting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QueuePage_stepdefination {
	public QueuePage queuepage=new QueuePage(DriverFactory.getDriver());
	private String outputdata;
	private String outputdata1;
	String file = System.getProperty("user.dir") + "\\src\\test\\resources\\Exceldata\\TestExcelData1.xlsx";
@Given("The user is on the queue page")
public void the_user_is_on_the_queue_page() throws FileNotFoundException, IOException, InterruptedException {
	queuepage.QueuehomePage();
}

@When("The user clicks the links from the queue page under {string}")
public void the_user_clicks_the_links_from_the_queue_page_under(String topic) {
    
List<WebElement> links=queuepage.getLinkByTopics(topic);
	
	
	for(WebElement link:links)
	{
		//String linknames=link.getText();
		
		link.click();
		//Thread.sleep(1000);
		
	}
    
}

@Then("The user redirected to the clicked  link page in the queue data structure")
public void the_user_redirected_to_the_clicked_link_page_in_the_queue_data_structure() {
	String msg=queuepage.GetCurrentlinkurl();
	System.out.println("The user landed on:"+msg);
	
}

@When("The user clicks the try here button on the queue page")
public void the_user_clicks_the_try_here_button_on_the_queue_page() {
	 queuepage.clicktryherebutton();
	
}

@Then("The user is redirected to the Editor page with Run button in the queue page")
public void the_user_is_redirected_to_the_editor_page_with_run_button_in_the_queue_page() {
	String title=queuepage.geturltitle();
	System.out.println("The current page is :"+ title);
}

@When("The user clicks on run button after providing the valid python code in queue page from given sheetname {string} and rowno {int}")
public void the_user_clicks_on_run_button_after_providing_the_valid_python_code_in_queue_page_from_given_sheetname_and_rowno(String sheetname,Integer rowno) throws InterruptedException, InvalidFormatException, IOException {
    
	TestDataReadingWriting reader= new TestDataReadingWriting();
	
	
	 List<Map<String, String>>gettextdata= reader.getData(file,sheetname);
	 
	String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
	outputdata=gettextdata.get(rowno).get("ExpectedOutput");
	System.out.println(inputdata);
	System.out.println(outputdata);
	queuepage.EnterCode(inputdata);
	Thread.sleep(2000);   
}

@Then("The user should be able to see the output on the console for the valid  input data for the queue datastructure module")
public void the_user_should_be_able_to_see_the_output_on_the_console_for_the_valid_input_data_for_the_queue_datastructure_module() {
	String printoutput=queuepage.Getoutput();
	assertEquals(printoutput,outputdata);
	System.out.println(printoutput);
	
}

@When("The user clicks on run button after providing the invalid python code in queue page from given sheetname {string} and rowno {int}")
public void the_user_clicks_on_run_button_after_providing_the_invalid_python_code_in_queue_page_from_given_sheetname_and_rowno_rownumber(String sheetname,Integer rowno) throws InterruptedException, InvalidFormatException, IOException {
    
	TestDataReadingWriting reader= new TestDataReadingWriting();
	 List<Map<String, String>>gettextdata=reader.getData(file,sheetname);
	 
	String inputdata= gettextdata.get(rowno).get("Inputpythoncode");
	outputdata=gettextdata.get(rowno).get("ExpectedOutput");
	System.out.println(inputdata);
	System.out.println(outputdata);
	queuepage.EnterCode(inputdata);
	Thread.sleep(2000);   
   	
}

@Then("The user should be able to see a alertbox syntaxerror for the queue page")
public void the_user_should_be_able_to_see_a_alertbox_syntaxerror_for_the_queue_page() {
	String alertmsg=queuepage.getAlertMsg();

	assertEquals(alertmsg,outputdata);
	System.out.println(alertmsg);
	System.out.println(outputdata); 
}

@When("The user navigate back and clicks the signout link in the queue page")
public void the_user_navigate_back_and_clicks_the_signout_link_in_the_queue_page() throws InterruptedException {
	String title=queuepage.NavigateBack();
    System.out.println(title);
    queuepage.LogOut();
    Thread.sleep(2000);
}

@Then("The user should be able to see the {string}  message for the queue data structure page")
public void the_user_should_be_able_to_see_the_message_for_the_queue_data_structure_page(String ExpectedMsg) {
    
	String logoutMsg=queuepage.Logoutmsg();
	assertEquals(logoutMsg,ExpectedMsg);
	System.out.println(logoutMsg);
	LoggerLoad.info(logoutMsg);
}
}
