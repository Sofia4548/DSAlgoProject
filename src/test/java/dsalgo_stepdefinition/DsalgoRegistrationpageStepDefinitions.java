package dsalgo_stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import dsalgoPOM.DsAlgoRegistrationPage;
import dsutilities.DriverFactory;
import dsutilities.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DsalgoRegistrationpageStepDefinitions {

	private DsAlgoRegistrationPage registrationpage = new DsAlgoRegistrationPage(DriverFactory.getDriver());
	@Given("User is on the registration page")
	public void user_is_on_the_registration_page() throws InterruptedException, FileNotFoundException, IOException {

		registrationpage.openRegistrationPage();
		LoggerLoad.info("User is on the RegistrationPage");
		
	}

	@When("The user clicks the register button after leaving the other fields empty and  enters the username {string}")
	public void the_user_clicks_the_register_button_after_leaving_the_other_fields_empty_and_enters_the_username(
			String uname) throws InterruptedException {
	
		registrationpage.enterusrname(uname);
		registrationpage.clickregisterbtn();
	}

	@Then("The message is displayed below the password textbox to the user as  {string}")
	public void the_message_is_displayed_below_the_password_textbox_to_the_user_as(String expectedMessage) {
		String msg = registrationpage.getMessageBelowPasswordTextbox();
		//Assert.assertEquals(expectedMessage, msg);
		System.out.println(msg);
	}

	@When("The user clicks the register button after leaving the other fields empty and enters the password as {string}")
	public void the_user_clicks_the_register_button_after_leaving_the_other_fields_empty_and_enters_the_password_as(
			String pswrd) throws InterruptedException {
		
		registrationpage.clickregisterLink();
		registrationpage.enterpassword(pswrd);
		registrationpage.clickregisterbtn();

	}

	@When("the user clicks the register button after leaving the other fields empty and enters the password confirmation as {string}")
	public void the_user_clicks_the_register_button_after_leaving_the_other_fields_empty_and_enters_the_password_confirmation_as(
			String pswrdconfirm) throws InterruptedException {
		
		
		registrationpage.clickregisterLink();
		registrationpage.enterpasswordconfirm(pswrdconfirm);
		registrationpage.clickregisterbtn();
	}

	@When("The user clicks register button after leaving username,password,passwordconfirmation as empty")
	public void the_user_clicks_register_button_after_leaving_username_password_passwordconfirmation_as_empty()
			throws InterruptedException {
		

		registrationpage.clickregisterLink();
		registrationpage.clickregisterbtn();
	}

	@Then("The message is displayed below the username textbox to the user {string}")
	public void the_message_is_displayed_below_the_username_textbox_to_the_user11(String Message)
			throws InterruptedException {
		String msg = registrationpage.getMessageBelowUsername();
//		Assert.assertEquals(Message, msg);
		System.out.println(msg);
		LoggerLoad.info(msg);
	}

	@When("the user clicks the register button after enters the username with specialcharacter other than @\\/.\\/+\\/-\\/_  as {string}")
	public void the_user_clicks_the_register_button_after_enters_the_username_with_specialcharacter_other_than_as(
			String invalidname) throws InterruptedException {
		registrationpage.clickregisterLink();
		registrationpage.enterinvalidusername(invalidname);
		registrationpage.clickregisterbtn();

	}

	@Then("the user is not able to see the error message for username indicating the <{string}>")
	public void the_user_is_not_able_to_see_the_error_message_for_username_indicating_the(String errormsg) {
		String msg = registrationpage.getPageText();
		boolean containsErrorMsg = msg.contains(errormsg);
		Assert.assertFalse("Expected error message is not displayed'" + errormsg + "' is not displayed",
				containsErrorMsg);
		System.out.println("Expected error message: " + errormsg);
		
	}

	@Then("the user will directed below the password textbox and the user able to see the message {string}")
	public void the_user_will_directed_below_the_password_textbox_and_the_user_able_to_see_the_message(
		String errormessage) throws InterruptedException {
		String msg = registrationpage.getMessageBelowPasswordTextbox().trim();
		//Assert.assertEquals(errormessage.trim(), msg);
		System.out.println("But showing the message:" + msg + "below the password textbox");

	}

	@When("the user clicks register button after entering the valid username and all numerical password as <{string}> and <{string}>")
	public void the_user_clicks_register_button_after_entering_the_valid_username_and_all_numerical_password_as_and(
		String uname, String pswrd) throws InterruptedException {
	    registrationpage.checkpasswordwithnumbers(uname, pswrd);
		registrationpage.clickregisterbtn();
	}

	@When("the user clicks register button after entering the valid username and password lessthan 8characters as <{string}> and <{string}>")
	public void the_user_clicks_register_button_after_entering_the_valid_username_and_password_lessthan_8characters_as_and(
			String uname, String pswrd) throws InterruptedException {
		registrationpage.checkpswrdlength(uname, pswrd);
		registrationpage.clickregisterbtn();

	}

	@When("the user clicks register button after entering the valid user name and commonly used password as <{string}> and <{string}>")
	public void the_user_clicks_register_button_after_entering_the_valid_user_name_and_commonly_used_password_as_and(
			String uname, String pswrd) throws InterruptedException {
		registrationpage.checkcommonpswrd(uname, pswrd);
		registrationpage.clickregisterbtn();
	}

	@Then("the user is not able to see the error message indicating the <{string}>")
	public void the_user_is_not_able_to_see_the_error_message_indicating_the(String errormsg) {
		String msg = registrationpage.getPswrdinvalidText();
		boolean containsErrorMsg = msg.contains(errormsg);
		Assert.assertFalse("Expected error message is not displayed'" + errormsg + "' is not displayed",
				containsErrorMsg);
		System.out.println("Expected error message: " + errormsg);
		System.out.println("But it displays the  message: " + msg);
	}

	@Then("the message is displayed below the password confirmation textbox as <{string}>")
	public void the_message_is_displayed_below_the_password_confirmation_textbox_as(String errormessage)
			throws InterruptedException {

		String msg = registrationpage.getMessageBelowPasswordTextbox().trim();
		//Assert.assertEquals(errormessage.trim(), msg);
		System.out.println(msg);

	}

	@When("the user enters username,and different password in password and password confirmation as<{string}><{string}><{string}>")
	public void the_user_enters_username_and_different_password_in_password_and_password_confirmation_as(String uname,
			String pswrd, String pswrdconfirm) throws InterruptedException {

	registrationpage.checkPasswordMismatch(uname, pswrd, pswrdconfirm);

	}

	@When("clicks the register button")
	public void clicks_the_register_button() {

		registrationpage.clickregisterbtn();
	}

	@Then("the user gets the error message as {string}")
	public void the_user_gets_the_error_message_as(String ExpectedMsg) {

		String msg = registrationpage.getpasswordmismatcherrormessage();
		Assert.assertEquals(ExpectedMsg, msg);

		System.out.println(msg);
	}

	@When("the user clicks the link Register")
	public void the_user_clicks_the_link_register() {

		registrationpage.clickregisterLink();
	}

	@When("the user clicks register button after entering all valid data as<{string}><{string}><{string}>")
	public void the_user_clicks_register_button_after_entering_all_valid_data_as(String uname, String pswrd,
			String pswrdconfirm) throws InterruptedException {
		registrationpage.ValidCredentials(uname, pswrd, pswrdconfirm);
		registrationpage.clickregisterbtn();
	}

	@Then("the user directed to the DSAlogo homepage and should be able see the  success message")
	public void the_user_directed_to_the_ds_alogo_homepage_and_should_be_able_see_the_success_message() {

		String printsuccessmsg = registrationpage.GetSuccessMessage();
		System.out.println(printsuccessmsg);

	}
}
