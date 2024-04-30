package dsalgo_stepdefinition;

import dsalgoPOM.PractisePage;
import dsutilities.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Practise_stepdefinition {
	PractisePage practisePage=new PractisePage(DriverFactory.getDriver());
	
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
	public void the_user_clicks_the_link_from_the_practise_page_under(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be able to see the output on the console")
	public void the_user_should_be_able_to_see_the_output_on_the_console() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
