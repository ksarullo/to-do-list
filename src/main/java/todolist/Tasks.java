package todolist;

public class Tasks {
	
	private String name;
	private String desc;
	private int status;
	private int listId;
	
	public Tasks() {
		name = "Task1";
		desc = "Description";
		status = -1;
		listId = -1;
	}

    public Tasks(String name, String desc, int status, int listId) {
        this.name = name;
        this.desc = desc;
        this.status = status;
        this.listId = listId;
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
    
    public void setStatus(int status) {
    	this.status = status;
    }
    
    public int getStatus() {
    	return status;
    }
    
    public void setListId(int listId) {
    	this.listId = listId;
    }
    
    public int getListId() {
    	return listId;
    }
}
