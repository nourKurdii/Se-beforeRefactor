package loginPackage;



import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import software.ListPrint;
import software.admin;
import software.book;
import software.bookAuthor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchSteps {
	List <List<String>> list;
	ArrayList<admin> adminArray= new ArrayList<admin>(); 
	ArrayList <book> books = new ArrayList <book>();
	ArrayList <book> returnedBooks=new ArrayList <book>(); //it will be used to store the returned list of books
	bookAuthor ba=new bookAuthor();
	ListPrint lp=new ListPrint();
	book returnedBook;
	String rT;
	String rA;
	String rI;
	String rS;
	String user;
	String SearchedAuthor;
	String SearchedTitle;
	String SearchedISBN;
	String SearchedSignature;
	boolean logStatus;
	boolean bookStatus=false;
	boolean NoBook=false;
	
	@Given("these books are contained in the system")
	public void these_books_are_contained_in_the_system(List <List> list) {
		
        //list=dataTable.asLists();
		//List <List<String>> list;
		for(List<String> columns: list) { //for each column of type List<String> in list
		books.add(new book(columns.get(0))); //add a book to books array with values in column 0
		}
		
	}

	@When("user searches about book by title {string}")
	public void user_searches_about_book_by_title(String string) {
		SearchedTitle=string; //the child
		
		for(int i=0;i<books.size();i++) {
			String Bt=books.get(i).getTitle(); //the child books .....
			if (Bt.toLowerCase().contains(SearchedTitle.toLowerCase()))
			{
					rT=books.get(i).getTitle();
					rA=books.get(i).getAuthor();
					rS=books.get(i).getSignature();
					rI=books.get(i).getISBN();
					returnedBook=new book(rI,rT,rA,rS);
					returnedBooks.add(returnedBook);
					NoBook=true;
					}
				}
				//else NoBook=false by default
		
	}

	@Then("A book or list of books with this title should be returned and printed on the console")
	public void a_book_or_list_of_books_with_this_title_should_be_returned_and_printed_on_the_console() {
		for(int i=0;i<returnedBooks.size();i++) {
			if(books.get(i).getTitle().equalsIgnoreCase(rT))
			{
				String rTt=returnedBooks.get(i).getTitle();
				assertEquals(rT,rTt);
			}
			}
			
		System.out.println("Book searched by Title"+" "+"{"+SearchedTitle+"}");
		if(NoBook) {
		lp.PrintList(returnedBooks);
		System.out.println("\n");
		}
		else if(!NoBook) {
			 System.out.println("No Book");
			 System.out.println("\n");
			}
		
	}
//--------------------------------------------------------------------------------
	@When("user searches for a book by author {string}")
	public void user_searches_for_a_book_by_author(String string) {
		SearchedAuthor=string;
		for(int i=0;i<books.size();i++) {
			String Bt=books.get(i).getAuthor(); //the child books .....
			if (Bt.toLowerCase().contains(SearchedAuthor.toLowerCase()))
			{
					rT=books.get(i).getTitle();
					rA=books.get(i).getAuthor();
					rS=books.get(i).getSignature();
					rI=books.get(i).getISBN();
					returnedBook=new book(rI,rT,rA,rS);
					returnedBooks.add(returnedBook);
					NoBook=true;
					}
				}


	}

	@Then("A book or list of books for this author should be returned and printed on the console")
	public void a_book_or_list_of_books__this_author_should_be_returned_and_printed_on_the_console() {
		for(int i=0;i<returnedBooks.size();i++) {
			if(books.get(i).getAuthor().equalsIgnoreCase(rA))
			{
				String rAa=returnedBooks.get(i).getTitle();
				assertEquals(rA,rAa);
			}
			}
		System.out.println("Book searched by Author"+" "+"{"+SearchedAuthor+"}");
		if(NoBook) {
		lp.PrintList(returnedBooks);
		System.out.println("\n");
		}
		
		else {
			 System.out.println("No Book");
			 System.out.println("\n");
			}

	}
	
//-----------------------------------------------------------------------------------
	@When("user searches for a book by isbn {string}")
	public void user_searches_for_a_book_by_isbn(String string) {
		SearchedISBN=string;
		for(int i=0;i<books.size();i++) {
				if(books.get(i).getISBN().equals(SearchedISBN)) {
				rT=books.get(i).getTitle();
				rA=books.get(i).getAuthor();
				rS=books.get(i).getSignature();
				rI=books.get(i).getISBN();
				returnedBook=new book(rI,rT,rA,rS);
				NoBook=true;
				}
		}
	}

	@Then("A book with this isbn should be returned and printed on the console")
	public void a_book_with_this_isbn_should_be_returned_and_printed_on_the_console() {
		assertEquals(rI,SearchedISBN);
		System.out.println("Book searched by ISBN"+" "+"{"+SearchedISBN+"}");
		if(NoBook) {
		lp.PrintBook(returnedBook);
		System.out.println("\n");
		}
		else {
			 System.out.println("No Book");
			 System.out.println("\n");
			}
	}
//-------------------------------------------------------------------------------------
	@When("admin with username {string} and logging status is {string} searches for a book with signature {string}")
	public void admin_with_username_and_logging_status_is_searches_for_a_book_with_signature(String string, String string2, String string3) {
		 user=string;
		 logStatus=Boolean.parseBoolean(string2);
		 SearchedSignature=string3;
			for(int i=0;i<adminArray.size();i++) {
				if(adminArray.get(i).getUser().equals(user)){
					adminArray.get(i).setStatus(logStatus);
				}
			}
			if (logStatus) { 
				//if admin is logged search for the book
				for(int i=0;i<books.size();i++) {
					if(books.get(i).getSignature().equals(SearchedSignature)) {
					rT=books.get(i).getTitle();
					rA=books.get(i).getAuthor();
					rS=books.get(i).getSignature();
					rI=books.get(i).getISBN();
					returnedBook=new book(rI,rT,rA,rS);
					NoBook=true;
					}
			}
			}
	}

	@Then("A book with this signature will be printed")
	public void a_book_with_this_signature_will_be_printed() {
		assertEquals(rS,SearchedSignature);
		System.out.println("Book searched by Signature"+" "+"{"+SearchedSignature+"}");
		if(NoBook) {
		lp.PrintBook(returnedBook);
		System.out.println("\n");
		}
		else {
			 System.out.println("No Book");
			 System.out.println("\n");
			}
	}
}










