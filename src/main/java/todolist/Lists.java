package todolist;

public class Lists {

    private String name;
    
    public Lists() {
    	name = "List1";
    }

    public Lists(String name) {
        this.name = name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    public String getName() {
        return name;
    }

}