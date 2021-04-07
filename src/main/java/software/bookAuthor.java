package software;

import java.util.ArrayList;


public class bookAuthor {
public ArrayList<book> book_Author (ArrayList<book> allBooks,String searchedBook){
		
		ArrayList<book> returnedBooks=new ArrayList<book>();
		for(int i = 0; i<allBooks.size(); i++) {
			if(allBooks.get(i).getAuthor().equalsIgnoreCase(searchedBook)) {
				returnedBooks.get(i).setAuthor(searchedBook);
			}
		}
		return returnedBooks;
		/*method takes array list of type book and a string(title) it checks if there is any book with 
		this title it will be stored and returned in the arrayList */
	}
}
