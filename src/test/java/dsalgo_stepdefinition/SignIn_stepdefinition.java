package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import dsalgoPOM.LoginPage;
import dsalgoPOM.SignInPage;
import dsutilities.ConfigurationReader;
import dsutilities.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignIn_stepdefinition {
	SignInPage signInPage = new SignInPage(DriverFactory.getDriver());

@Given("User navigates to the login page")
public void user_navigates_to_the_login_page() {
	signInPage.signInURL();
}

@When("User enters {string} and {string}")
public void user_enters_and(String usr, String pwd) {
	signInPage.usernameEnter(usr);
	signInPage.passwordEnter(pwd);
}

@When("Clicks the login button")
public void clicks_the_login_button() {
	signInPage.submitClick();
}

@Then("User should be logged in successfully")
public void user_should_be_logged_in_successfully() {
	String messageStr = signInPage.numpaNinjaText();
	System.out.println(messageStr);
	assertEquals(messageStr,"NumpyNinja");
}
}
