package loginPackage;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import software.admin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class logOutSteps {
	
	private ArrayList<admin> adminArray= new ArrayList<admin>(); 

	String user;
	boolean logStatus;
			@Given("admin with username {string} wanna log out")
			public void admin_with_username_wanna_log_out(String string) {
				 user=string;
				for(int i=0;i<adminArray.size();i++) {
					if(adminArray.get(i).getUser().equals(user)){
						logStatus= adminArray.get(i).getStatus();
					}
				}
			}

			@When("admin logging status is {string} and wanna log out")
			public void admin_logging_status_is_and_wanna_log_out(String string) {
				//boolean b= Boolean.parseBoolean(string);
				if(logStatus) {
					for(int i=0;i<adminArray.size();i++) {
						if(adminArray.get(i).getUser().equals(user)){
							adminArray.get(i).setStatus(false);
						}
					}
				 }
				}
			
			@Then("admin logging status become {string}")
			public void admin_logging_status_become(String string) {
				String b=string; 
				String n;
				for(int i=0;i<adminArray.size();i++) {
					if(adminArray.get(i).getUser().equals(user)){
					  n=adminArray.get(i).getStatus()+"";
					  assertEquals(b,n); //check if the logging status became false(user logged out successfully)
					}
				}
			}
}
