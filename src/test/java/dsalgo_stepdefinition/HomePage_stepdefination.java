package dsalgo_stepdefinition;

import org.junit.Assert;

import dsalgoPOM.HomePage;
import dsutilities.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage_stepdefination {
private HomePage homepage = new HomePage(DriverFactory.getDriver());
	
	

    @Given("The User should open the DS_Algo Portal URL in a browser")
    public void the_user_should_open_the_ds_algo_portal_url_in_a_browser() {
    	 //driver.get("https://dsportalapp.herokuapp.com/");
    	homepage.openDSAlgoPortalURL();
    }

    @When("The User should be on the Website with a massage {string}")
    public void the_user_should_be_on_the_website_with_a__massage(String string) {
        
    
   	homepage.getmassage(string);
    	
    }

    @Given ("The user clicks GetStarted button")
    public void the_user_clicks_getstarted_button() {
    	homepage.clickgetstartedbtn();
    	
    }


@When("The user is on Data Structure Introduction Page and should be able to see the NumpyNinja heading, Register and Sign in links")
public void the_user_is_on_data_structure_introduction_page_and_should_be_able_to_see_the_numpy_ninja_heading_register_and_sign_in_links() {
    
    	homepage. dataStructureIntroductionPageRegisterSigninLinks();

   	  
    }

    @Given("The User is on the Data Stucture home page")
    public void the_user_is_on_the_data_stucture_home_page() {
    	 homepage.DataStucturePage();
    	
    }

    @When("User clicks the dropdown arrow on the Data Structure")
    public void user_clicks_the_dropdown_arrow_on_the_data_structure() {
    	 homepage.clickDropdownDataStructure();

    }

    @Then("The User should see all the items Arrays,Linked List,Stack,Queue,Tree,Graph in dropdown menue")
    public void the_user_should_see_all_the_items_arrays_linked_list_stack_queue_tree_graph_in_dropdown_menue() {
      homepage.dropdownMenueItem();
    	
    }

    @When("The User clicks any option from the dropdown menue list without Sigh in")
    public void the_user_clicks_any_option_from_the_dropdown_menue_list_without_sigh_in() throws InterruptedException {

    	Thread.sleep(5000);
    	homepage.clickArrays();
    	 
    }

    @Then("The User should see the warning massage {string}")
    public void the_user_should_see_the_warning_massage(String ExpectedMsg ) {
    	String msg = homepage. warningMessag();
    	Assert.assertEquals(ExpectedMsg, msg);

		System.out.println(msg);
    }

    @When("The User clicks The Get Started button of Data Structure from DS introduction page")
    public void the_user_clicks_the_get_started_button_of_data_structure_from_ds_introduction_page() throws InterruptedException  {
    Thread.sleep(5000);
    homepage.clickGetStartedbtn();
    }

    @Then("The User should get the warning massage {string}")
    public void the_user_should_get_the_warning_massage(String ExpectedMassage ) {
    		
    	String msg= homepage.getwarningMessag();
		Assert.assertEquals(ExpectedMassage, msg);

		System.out.println(msg);
	
    }
}
