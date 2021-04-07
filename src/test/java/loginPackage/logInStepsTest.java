package loginPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


import java.util.ArrayList;
import software.admin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logInStepsTest {
	
	private ArrayList<admin> adminArray= new ArrayList<admin>(); 
	String validPassword;
	String invalidPassword;
	String user;
	
	// admin tries to log in with valid credentials scenario
	@Given("those Administrator valid credentials are stored in the system username is {string} password is {string}")
	public void those_administrator_valid_credentials_are_stored_in_the_system_username_is_password_is(String string, String string2) {
		user=string;
		String Pass=string2;
		admin a = new admin (user,Pass);
		adminArray.add(a);
	}
	@When("Admin enter userName {string} and password {string}")
		public void adminEnterUserName(String string,String s) {
			for(int i=0;i<adminArray.size();i++) {
				if(adminArray.get(i).getUser().equals(string)&&(adminArray.get(i).getPass().equals(s))){
					validPassword=adminArray.get(i).getPass();
					adminArray.get(i).setStatus(true);
				}
			}
		}

		@Then("password must be {string}")
		public void passwordMustBe(String string) {
			String s=string;
			assertEquals(validPassword,s);
			
			 }
//----------------------------------------------------------------------------
// admin tries to log in with invalid credentials scenario
		
		@When("Admin enter Wrong userName {string} and Wrong password {string}")
		public void admin_enter_wrong_user_name_and_wrong_password(String string, String string2) {
			for(int i=0;i<adminArray.size();i++) {
					if(adminArray.get(i).getUser().equals(string)&&(adminArray.get(i).getPass().equals(string2))){
						validPassword=adminArray.get(i).getPass();
						adminArray.get(i).setStatus(true);
					}
					else {
					adminArray.get(i).setStatus(false);
					invalidPassword=string2;
					}
				}
			}

		@Then("password must not be {string}")
		public void password_must_not_be(String string) {
			String s=string;
			assertNotSame(invalidPassword, s);
		}

}
























