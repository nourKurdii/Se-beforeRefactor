package software;


public class book {
    private int id ;
    private String ISBN;
    private String Title;
    private String Author;
    private String Signature;
    
    public book (String i ,String t,String A, String s) {
    	this.ISBN=i;
    	this.Title=t;
    	this.Author=A;
    	this.Signature=s;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public void setSignature(String signature) {
    	this.Signature = signature; }

    public String getSignature() {
        return Signature;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }
    public int getid() {
    	
    	return id;
    }
    public void setid(int id) {
    	
    	this. id=id;
    }
    public book(String keys) {
    	String keysplit[] = keys.split("_");
    	//this.id=0;
    	this.Title =keysplit[0];
    	this.Author =keysplit[1];
    	this.ISBN=keysplit[2];
    	this.Signature = keysplit[3];

}

    @Override
    public String toString() {
    	 return "book[title="+this.Title+",author="+this.Author+",isbn="+this.ISBN+",signature="+this.Signature+"]";
    			 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
