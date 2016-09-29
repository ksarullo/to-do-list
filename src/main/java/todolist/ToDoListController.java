package todolist;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoListController {
	
	private static ArrayList<Lists> lists = new ArrayList<Lists>();
	private static ArrayList<Users> users = new ArrayList<Users>();
	private static ArrayList<Tasks> tasks = new ArrayList<Tasks>();
    
	//POST Requests
	
    @RequestMapping(value="/User", method=RequestMethod.POST)
    public @ResponseBody Users createUser(@RequestBody Users user) {
    	users.add(user);
    	return user;
    }
    
    @RequestMapping(value="/List", method=RequestMethod.POST)
    public @ResponseBody Lists createList(@RequestBody Lists list) {
    	lists.add(list);
    	return list;
    }
    
    @RequestMapping(value="/List/{listId}", method=RequestMethod.POST)
    public @ResponseBody Tasks createTask(@RequestBody Tasks task) {
    	tasks.add(task);
    	return task;
    }
    
    //GET Requests
	
    @RequestMapping(value="/User", method=RequestMethod.GET)
    public ArrayList<Users> getUsers() {
    	return users;
    }
    
    @RequestMapping(value="/List", method=RequestMethod.GET)
    public ArrayList<Lists> getLists() {
    	return lists;
    }
    
    @RequestMapping(value="/List/{listId}", method=RequestMethod.GET)
    public ArrayList<Tasks> getTasks(@PathVariable("listId") int id) {
    	//Use listId to grab all Tasks under that List
    	return null;
    }
    
    @RequestMapping(value="/User/{userId}/List", method=RequestMethod.GET)
    public ArrayList<Lists> getListsPerUser(@PathVariable("userId") int id) {
    	//Use userId to grab all Lists under that userId
    	return null;
    }
    
    @RequestMapping(value="/User/{userId}", method=RequestMethod.GET)
    public Users getUserProfile(@PathVariable("userId") int id) {
    	return users.get(id);
    }
    
    //Can't do PUT or DELETE until we have database.
    
}
