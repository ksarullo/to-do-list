package todolist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoListController {
	
	DBConnect db = new DBConnect();
	
	//POST Requests
	
    @RequestMapping(value="/User", method=RequestMethod.POST)
    public @ResponseBody Users createUser(@RequestBody Users user) throws SQLException {
    	String query = "INSERT INTO user VALUE (NULL, '" + user.getName() + "', '" + user.getPass() + "', '" + user.getEmail() + "')";
    	db.getMyStatement().executeUpdate(query);
    	return user;
    }
    
    @RequestMapping(value="/List", method=RequestMethod.POST)
    public @ResponseBody Lists createList(@RequestBody Lists list) throws SQLException {
    	String query = "INSERT INTO user VALUE (NULL, '" + list.getName() + "')";
    	db.getMyStatement().executeUpdate(query);
    	return list;
    }
    
    @RequestMapping(value="/List/{listId}", method=RequestMethod.POST)
    public @ResponseBody Tasks createTask(@RequestBody Tasks task) throws SQLException {
    	String query = "INSERT INTO user VALUE (NULL, '" + task.getName() + "', '" + task.getDesc() + "', '" + task.getStatus() + "')";
    	db.getMyStatement().executeUpdate(query);
    	return task;
    }
    
    //GET Requests
	
    @RequestMapping(value="/User", method=RequestMethod.GET)
    public ResultSet getUsers() throws SQLException {
    	String query = "SELECT * FROM user";
    	ResultSet users = db.getMyStatement().executeQuery(query);
    	return users;
    }
    
    @RequestMapping(value="/List", method=RequestMethod.GET)
    public ResultSet getLists() throws SQLException {
    	String query = "SELECT * FROM list";
    	ResultSet lists = db.getMyStatement().executeQuery(query);
    	return lists;
    }
    
    @RequestMapping(value="/List/{listId}", method=RequestMethod.GET)
    public ResultSet getTasks(@PathVariable("listId") int id) throws SQLException {
    	String query = "SELECT * FROM task WHERE listId=" + id;
    	ResultSet tasks = db.getMyStatement().executeQuery(query);
    	return tasks;
    }
    
    @RequestMapping(value="/User/{userId}/List", method=RequestMethod.GET)
    public ResultSet getListsPerUser(@PathVariable("userId") int id) throws SQLException {
    	String query = "SELECT * FROM list WHERE userId=" + id;
    	ResultSet users = db.getMyStatement().executeQuery(query);
    	return users;
    }
    
    @RequestMapping(value="/User/{userId}", method=RequestMethod.GET)
    public ResultSet getUserProfile(@PathVariable("userId") int id) throws SQLException {
    	String query = "SELECT * FROM user WHERE userId=" + id;
    	ResultSet users = db.getMyStatement().executeQuery(query);
    	return users;
    }
    
    //PUT Requests
    
    @RequestMapping(value="/List/{listId}", method=RequestMethod.PUT)
    public Lists updateList(String name) throws SQLException {
    	//listId.setName = name;
    	//return list;
    	return null;
    }
    
    @RequestMapping(value="/List/{listId}/Task/{taskId}", method=RequestMethod.PUT)
    public @ResponseBody Tasks updateTaskDesc(@RequestBody Tasks task) throws SQLException {
    	if(task.getName() != null) {} //listId.taskId.setName(name);
    	if(task.getDesc() != null) {} //listId.taskId.setDesc(desc);
    	if(task.getStatus()) {} //listId.taskId.setStatus(status);
		return task;
    }
    
    @RequestMapping(value="/User/{userId}", method=RequestMethod.PUT) 
    public @ResponseBody Users updateProfile(@RequestBody Users user) throws SQLException {
    	if(user.getName() != null) {} //userId.setName(name);
    	if(user.getPass() != null) {} //userId.setPass(pass);
    	if(user.getEmail() != null) {} // userId.setEmail(email);
		return user;
    }
    
    //DELETE Requests
    
    @RequestMapping(value="/List/{listId}/Task/{taskId}", method=RequestMethod.DELETE)
    public String deleteTask(int taskId) throws SQLException {
    	String query = "DELETE FROM task WHERE task_unique_id=" + taskId;
    	db.getMyStatement().executeUpdate(query);
    	return "Task Deleted";
    }
    
    @RequestMapping(value="/User/{userId}", method=RequestMethod.DELETE)
    public String deleteUser(int userId) throws SQLException {
    	String query = "DELETE FROM user WHERE user_unique_id=" + userId;
    	db.getMyStatement().executeUpdate(query);
    	return "User Deleted";
    }
    
    @RequestMapping(value="/List/{listId}", method=RequestMethod.DELETE)
    public String deleteList(int listId) throws SQLException {
    	String query = "DELETE FROM list WHERE list_unique_id=" + listId;
    	db.getMyStatement().executeUpdate(query);
    	return "List Deleted";
    }
    
}
