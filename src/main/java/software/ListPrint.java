package software;
import java.util.ArrayList;

public class ListPrint {
	String s;
/*public boolean equality(book returned ,book mustReturned) {
	if(returned.getTitle().equals(mustReturned.getTitle())) {
		if(returned.getAuthor().equals(mustReturned.getAuthor())) {
			if(returned.getISBN().equals(mustReturned.getISBN())){
				if(returned.getSignature().equals(mustReturned.getSignature()))
					return true;
			} return false;
		}
		return false;
	}
	return false;
}
public boolean equalList (ArrayList<book> returned ,ArrayList<book> mustReturned) {
  if (returned.size()!= mustReturned.size())
		return false ;
	else {
		for(int i=0;i<mustReturned.size();i++) {
			if(!returned.get(i).equals(mustReturned.get(i)))
				return false;
		}
	}
	return true;
	
	
  }*/
public void PrintList(ArrayList<book> b) {
	for(int i=0;i<b.size();i++) {
		System.out.println(b.get(i).toString());
}

}
public void PrintBook(book b) {
	s=b.toString();
	System.out.println(s);
}
}
