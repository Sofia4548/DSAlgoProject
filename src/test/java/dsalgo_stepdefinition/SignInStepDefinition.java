package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import dsalgoPOM.SigninPage;
import dsutilities.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SignInStepDefinition {
	public SigninPage signinpage=new SigninPage(DriverFactory.getDriver());
	private String outputdata;
	
	
	@Given("User navigates to the login page")
	public void user_navigates_to_the_login_page() throws IOException {
		signinpage.dsalgohomepage();
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String uname, String pswrd)
	{
		signinpage.LoginProcess(uname, pswrd);
	}
	@When("Clicks the login button")
	public void clicks_the_login_button()
	{
		signinpage.clicklogin();
		
	}
	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		String messageStr = signinpage.numpaNinjaText();
		System.out.println(messageStr);
		assertEquals(messageStr,"NumpyNinja");
	
	}

}
