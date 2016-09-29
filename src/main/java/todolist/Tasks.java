package todolist;

public class Tasks {
	
	private String name;
	private String desc;
	private boolean status;
	
	public Tasks() {
		name = "Task1";
		desc = "Description";
		status = false;
	}

    public Tasks(String name, String desc, boolean status) {
        this.name = name;
        this.desc = desc;
        this.status = status;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setDesc(String desc) {
    	this.desc = desc;
    }
    
    public String getDesc() {
    	return desc;
    }
    
    public void setStatus(boolean status) {
    	this.status = status;
    }
    
    public boolean getStatus() {
    	return status;
    }
}
