package software;
import java.util.ArrayList;


public class bookTitel {
	
	public ArrayList<book> book_Title (ArrayList<book> allBooks,String searchedBook){
		
		ArrayList<book> returnedBooks=new ArrayList<book>();
		for(int i = 0; i<allBooks.size(); i++) {
			if(allBooks.get(i).getTitle().equalsIgnoreCase(searchedBook)) {
				returnedBooks.get(i).setTitle(searchedBook);
			}
		}
		return returnedBooks;
		/*method takes array list of type book and a string(title) it checks if there is any book with 
		this title it will be stored and returned in the arrayList */
	}

}
