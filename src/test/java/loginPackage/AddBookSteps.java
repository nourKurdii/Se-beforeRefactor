package loginPackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import software.ListPrint;
import software.admin;
import software.book;
import software.validation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class AddBookSteps {
	private ArrayList<admin> adminArray= new ArrayList<admin>(); 
	private ArrayList<book> bookArray= new ArrayList<book>();
	String user;
	boolean logStatus;
	boolean bookStatus=false;
	boolean invalidAddition=true;
	ListPrint lp;
	//add book feature when admin is logged in
	
			@Given("admin with username {string} and logging status is {string}")
			public void admin_with_username_and_logging_status_is(String string, String string2) {
				 user=string;
				 logStatus=Boolean.parseBoolean(string2);
					for(int i=0;i<adminArray.size();i++) {
						if(adminArray.get(i).getUser().equals(user)){
							adminArray.get(i).setStatus(logStatus);
						}
					}
					}
			@When("admin wanna add a book with {string} and {string} and {string} and {string}")
			public void admin_wanna_add_a_book_with_and_and_and(String string, String string2, String string3, String string4) {
				boolean logB = logStatus;
				String title=string;
				String author=string2;
				String isbn=string3;
				String sig=string4;
				
				if (logB) { 
					//if admin is logged check if isbn is valid
					validation v = new validation();
						 if (v.isValidISBN(isbn)) { 
						 // if isbn is valid check unique Signature 
							 for (int i=0;i<bookArray.size();i++) {
								 if(bookArray.get(i).getSignature().equals(sig)) {
									 break;
								 }
								 else { // if Signature is unique add book
									 book newBook= new book(title,author,isbn,sig); 
									 bookArray.add(newBook);
									 bookStatus=true;
									 invalidAddition=false;
								 }
							 }
			} // if ISBN is invalid by default bookStatus=false invalidAddition=true
					 
				}
				}
			
			@Then("addition status will be {string}")
			public void addition_status_will_be(String string) {
			String added = string;
			String bs = bookStatus+"";
			 if(invalidAddition)
			 assertNotEquals(added,bs);
			 else 
			assertEquals(added,bs);
			}
//-----------------------------------------------------------------------------------------------
			//add book when admin is not logged in  scenario 
			
			@When("admin wanna add a book with title {string} and author {string} and isbn {string} and sign {string}")
			public void admin_wanna_add_a_book_with_title_and_author_and_isbn_and_sign(String string, String string2, String string3, String string4) {
				//logStatus =false
				//invalidAddition=true by default
				//bookStatus=false by default
			}

			@Then("addition status will not be {string}")
			public void addition_status_will_not_be(String string) {
				String added = string;
				String bs = bookStatus+""; 
			    assertNotEquals(added,bs); 
			}
}
