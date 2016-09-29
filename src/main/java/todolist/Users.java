package todolist;

public class Users {
	
	private String name;
	private String pass;
	private String email;
	
	public Users() {
		name = "User1";
		pass = "Password1";
		email = "username@test.com";
	}

    public Users(String name, String pass, String email) {
        this.name = name;
        this.pass = pass;
        this.email = email;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setPass(String pass) {
    	this.pass = pass;
    }
    
    public String getPass() {
    	return pass;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getEmail() {
    	return email;
    }
}
