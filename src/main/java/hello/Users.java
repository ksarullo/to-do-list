package hello;

public class Users {
	
	private final String name;
	private final String pass;
	private final String email;

    public Users(String name, String pass, String email) {
        this.name = name;
        this.pass = pass;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    
    public String getPass() {
    	return pass;
    }
    
    public boolean getEmail() {
    	return email;
    }
}
