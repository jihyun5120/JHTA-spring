package di_step4;

import java.sql.Connection;

public class MyConnection {
	String userName;
	String password;
	Connection conn;
	
	public Connection getConn() {
		System.out.println(userName);
		System.out.println(password);
		return conn;
	}
	
	public String getUserName(String userName) {return userName;}
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
}

