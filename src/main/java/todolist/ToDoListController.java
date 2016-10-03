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
    	String query = "INSERT INTO user VALUE (NULL, '" + user.getName() + "', '" + user.getPass() + "', '" + user.getEmail() + "');";
    	db.getMyStatement().executeUpdate(query);
    	return user;
    }
    
    @RequestMapping(value="/List", method=RequestMethod.POST)
    public @ResponseBody Lists createList(@RequestBody Lists list) throws SQLException {
    	String query = "INSERT INTO list VALUE (NULL, '" + list.getName() + "');";
    	db.getMyStatement().executeUpdate(query);
    	return list;
    }
    
    @RequestMapping(value="/List/{listId}/Task", method=RequestMethod.POST)
    public @ResponseBody Tasks createTask(@RequestBody Tasks task, @PathVariable("listId") int listId) throws SQLException {
    	task.setListId(listId);
    	String query = "INSERT INTO task VALUE (NULL, '" + task.getName() + "', '" + task.getStatus() + "', '" + task.getListId() + "', '" + task.getDesc() + "');";
    	db.getMyStatement().executeUpdate(query);
    	return task;
    }
    
    //GET Requests
	
    @RequestMapping(value="/User", method=RequestMethod.GET)
    public ArrayList<Users> getUsers() throws SQLException {
    	String query = "SELECT * FROM user;";
    	ResultSet resultSet = db.getMyStatement().executeQuery(query);
    	ArrayList<Users> users = new ArrayList<Users>();
    	while (resultSet.next()) {
             Users user = new Users();
             user.setName(resultSet.getString("user_name"));
             user.setPass(resultSet.getString("password"));
             user.setEmail(resultSet.getString("email"));
             users.add(user);
        }
    	return users;
    }
    
    @RequestMapping(value="/List", method=RequestMethod.GET)
    public ArrayList<Lists> getLists() throws SQLException {
    	String query = "SELECT * FROM list;";
    	ResultSet resultSet = db.getMyStatement().executeQuery(query);
    	ArrayList<Lists> lists = new ArrayList<Lists>();
    	while (resultSet.next()) {
             Lists list = new Lists();
             list.setName(resultSet.getString("type_of_list"));
             lists.add(list);
        }
    	return lists;
    }
    
    @RequestMapping(value="/List/{listId}/Task", method=RequestMethod.GET)
    public ArrayList<Tasks> getTasks(@PathVariable("listId") int listId) throws SQLException {
    	String query = "SELECT * FROM task WHERE list_unique_id=" + listId + ";";
    	ResultSet resultSet = db.getMyStatement().executeQuery(query);
    	ArrayList<Tasks> tasks = new ArrayList<Tasks>();
    	while (resultSet.next()) {
             Tasks task = new Tasks();
             task.setName(resultSet.getString("task"));
             task.setDesc(resultSet.getString("description"));
             task.setStatus(resultSet.getInt("status"));
             task.setListId(resultSet.getInt("list_unique_id"));
             tasks.add(task);
        }    	
    	return tasks;
    }
    
    @RequestMapping(value="/User/{userId}/List", method=RequestMethod.GET)
    public Users getListsPerUser(@PathVariable("userId") int userId) throws SQLException {
    	return null;
    }
    
    @RequestMapping(value="/User/{userId}", method=RequestMethod.GET)
    public ArrayList<Users> getUserProfile(@PathVariable("userId") int userId) throws SQLException {
    	String query = "SELECT * FROM user WHERE user_unique_id=" + userId + ";";
    	ResultSet resultSet = db.getMyStatement().executeQuery(query);
    	ArrayList<Users> users = new ArrayList<Users>();
    	while (resultSet.next()) {
			Users user = new Users();
			user.setName(resultSet.getString("user_name"));
			user.setPass(resultSet.getString("password"));
			user.setEmail(resultSet.getString("email"));
			users.add(user);
    	}
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
    	if(task.getStatus() == -1) {} //listId.taskId.setStatus(status);
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
    public String deleteTask(@PathVariable("taskId") int taskId) throws SQLException {
    	String query = "DELETE FROM task WHERE task_unique_id=" + taskId;
    	db.getMyStatement().executeUpdate(query);
    	return "Task Deleted";
    }
    
    @RequestMapping(value="/User/{userId}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userId") int userId) throws SQLException {
    	String query = "DELETE FROM user WHERE user_unique_id=" + userId;
    	db.getMyStatement().executeUpdate(query);
    	return "User Deleted";
    }
    
    @RequestMapping(value="/List/{listId}", method=RequestMethod.DELETE)
    public String deleteList(@PathVariable("listId") int listId) throws SQLException {
    	String query = "DELETE FROM list WHERE list_unique_id=" + listId;
    	db.getMyStatement().executeUpdate(query);
    	return "List Deleted";
    }
    
}
