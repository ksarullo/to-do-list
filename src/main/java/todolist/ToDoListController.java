package todolist;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoListController {
	
	private static ArrayList<Lists> lists = new ArrayList<Lists>();
	private static ArrayList<Users> users = new ArrayList<Users>();
	private static ArrayList<Tasks> tasks = new ArrayList<Tasks>();
    
   @RequestMapping(value="/User", method=RequestMethod.POST)
    public Users createUser(@RequestParam("name") String name, @RequestParam("pass") String pass, @RequestParam("email") String email) {
    	Users tempUser = new Users(name, pass, email);
    	users.add(tempUser);
    	return tempUser;
    }
    
    @RequestMapping(value="/List", method=RequestMethod.POST)
    public Lists createList(@RequestParam("name") String name) {
    	Lists tempList = new Lists(name);
    	lists.add(tempList);
    	return tempList;
    }
    
    @RequestMapping(value="/List/{listId}", method=RequestMethod.POST)
    public Tasks createTask(@RequestParam("name") String name, @RequestParam("desc") String desc) {
    	Tasks tempTask = new Tasks(name, desc, false);
    	tasks.add(tempTask);
    	return tempTask;
    }
	
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
    	//Use userId to grab that user profile
    	return null;
    }
    
    //Can't do PUT or DELETE until we have database.
    
}
