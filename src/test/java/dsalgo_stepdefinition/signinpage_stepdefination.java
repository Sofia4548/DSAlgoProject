package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import dsalgoPOM.LinkedList;
import dsalgoPOM.LoginPage;
import dsalgoPOM.SigninPage;
import dsutilities.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signinpage_stepdefination {

	SigninPage signinPage = new SigninPage(DriverFactory.getDriver());

	@Given("User navigates to the login page")
	public void user_navigates_to_the_login_page() throws IOException {
	   
	signinPage.dsalgohomepage();
}


@When("User enters {string} and {string}")
public void user_enters_and(String Usrname, String Pswd) {
	signinPage.usernameEnter(Usrname);
	signinPage.passwordEnter(Pswd);


}

@When("User clicks the login button")
public void user_clicks_the_login_button() {
   
   signinPage.clicklogin();
            	             	  
            	  
}

@Then("The user should be logged in successfully")
public void the_user_should_be_logged_in_successfully() {
	String messageStr = signinPage.numpaNinjaText();
	System.out.println(messageStr);
	assertEquals(messageStr,"NumpyNinja");
}



}