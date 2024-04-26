package dsalgo_stepdefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;

import dsalgoPOM.LoginPage;

import dsutilities.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_stepdefinition {

	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on DS Algo Introduction Page")
	public void user_is_on_ds_algo_introduction_page() throws FileNotFoundException, IOException {
		loginPage.homePage();
	}

	@When("The user should click the Sign in link")
	public void the_user_should_click_the_sign_in_link() {
		loginPage.signInLink();
	}

	@Given("user is on DS Algo Sign in Page")
	public void user_is_on_ds_algo_sign_in_page() throws FileNotFoundException, IOException {

		// driver.get("https://dsportalapp.herokuapp.com/");
		loginPage.homePage();
		loginPage.signInLink();
	}

	@When("The user clicks login button after leaving the username textbox and password textbox blank")
	public void the_user_clicks_login_button_after_leaving_the_username_textbox_and_password_textbox_blank() {
		//loginPage.usernameEnterBlank();
		loginPage.submitClick();
	}

	@Then("The error message {string} appears below Username textbox")
	public void the_error_message_appears_below_username_textbox(String string) {
		String messageStr = loginPage.validationMsgForPassword();
		assertEquals(messageStr,string);
		System.out.println("Actual message appeared on screen: " + messageStr);
	}
	
	
	@When("The user clicks login button after entering the {string} textbox leaving the password textbox blank")
	public void the_user_clicks_login_button_after_entering_the_textbox_leaving_the_password_textbox_blank(String usr) {
		
		loginPage.usernameEnter(usr);
		loginPage.submitClick();
	}

	@When("The user clicks login button after entering invalid {string} and invalid {string}")
	public void the_user_clicks_login_button_after_entering_invalid_and_invalid(String usr, String pwd) {
		loginPage.usernameEnter(usr);
		loginPage.passwordEnter(pwd);
		loginPage.submitClick();
	}






	@Then("The error message {string} appears below Password textbox")
	public void the_error_message_appears_below_password_textbox(String string) {
		String messageStr = loginPage.validationMsgForPassword();
		assertEquals(messageStr,string);
		System.out.println("Actual message appeared on screen: " + messageStr);
	}




	@Then("The user should able to see an error message {string}.")
	public void the_user_should_able_to_see_an_error_message(String string) {
		String messageStr = loginPage.invalidErrorMessag();
		System.out.println("Actual message appeared on screen: " + messageStr);
		assertEquals(messageStr,string);
	}

	@When("The user clicks login button after entering valid {string} and valid {string}")
	public void the_user_clicks_login_button_after_entering_valid_and_valid(String username, String password) {
		
		loginPage.usernameEnter(username);
		loginPage.passwordEnter(password);
		loginPage.submitClick();
	}

	@Then("The user should land in Data Structure Home Page")
	public void the_user_should_land_in_data_structure_home_page() {
		String messageStr = loginPage.numpaNinjaText();
		assertEquals(messageStr,"NumpyNinja");
	}

}
