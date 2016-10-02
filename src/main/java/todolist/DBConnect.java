package todolist;

import java.sql.*;

public class DBConnect {

	private Connection myConn;
	private Statement myStatement;
	
	public DBConnect() {
		try {
			String url = "jdbc:mysql://10.50.71.20:3306/csci321?autoReconnect=true&useSSL=false";
			myConn = DriverManager.getConnection(url, "csci321", "csci321");
			myStatement = myConn.createStatement();
		} catch(Exception e) {
			System.err.println("Got an exception: " + e.getMessage());
		}
	}

	public Statement getMyStatement() {
		return myStatement;
	}

	public void setMyStatement(Statement myStatement) {
		this.myStatement = myStatement;
	}

}
