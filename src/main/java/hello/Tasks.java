package hello;

public class Tasks {
	
	private final String name;
	private final String desc;
	private final boolean status;

    public Tasks(String name, String desc, boolean status) {
        this.name = name;
        this.desc = desc;
        this.status = status;
    }

    public String getName() {
        return name;
    }
    
    public String getDesc() {
    	return desc;
    }
    
    public boolean getStatus() {
    	return status;
    }
}
