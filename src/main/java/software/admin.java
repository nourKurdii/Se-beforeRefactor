package software;

public class admin {
private String userName;
private String password;
private boolean status;
public admin(String u,String P) {
	this.userName=u;
	this.password=P;
}

public void setUser(String user) {
    this.userName = user;
}

public void setPass(String pass) {
    this.password = pass;
}

public void setStatus(boolean S) {
    this.status = S;
}


public String getUser() {
    return userName;
}

public String getPass() {
    return password;
}

public boolean getStatus() {
    return status;
}
}
