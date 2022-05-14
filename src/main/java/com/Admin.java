
package com;

import java.sql.*;
public  class Admin {
	
	public  Connection connect() {
		
		Connection con =null;
		
		try 
		 { 
		 Class.forName("com.mysql.jdbc.Driver"); 
		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electrogrid", "root", ""); 
		 //For testing
		 System.out.print("Successfully connected"); 
		 } 
		 catch(Exception e) 
		 { 
		 e.printStackTrace(); 
		 } 
		 
		 return con;
		
		
	}
	
	public String insertNotice(String noticecontent, String idate) {
		
		String output="";
		
		try {
			Connection con = connect(); 
			if (con == null) 
			{ 
				return "Error while connecting to the database";
			}
				String query = " insert into notices (`nid`,`ncontent`,`issuedate`)"
					 + " values (?, ?, ?)"; 
					 PreparedStatement preparedStmt = con.prepareStatement(query); 
					 // binding values
					 preparedStmt.setInt(1, 0); 
					 preparedStmt.setString(2, noticecontent); 
					 preparedStmt.setString(3, idate);  
					 
					 
					 //execute the statement
					 preparedStmt.execute(); 
					 con.close(); 
					 
					 
					 String newnotices = viewNotices(); 
					 output = "{\"status\":\"success\", \"data\": \"" + 
							 newnotices + "\"}"; 
			
		}catch(Exception e){
					output = "{\"status\":\"error\", \"data\": \"Error while inserting the payments.\"}";
			 
					System.err.println(e.getMessage());
			
		}
		
		return output;
		

		
	}//endofinsertmethod
	
	public String viewNotices() {
		
		String output="";
	
		
		try
		{ 
		 Connection con = connect(); 
		if (con == null) 
		 { 
			return "Error while connecting to the database for retrieving."; 
		 }
		
		// Prepare the html table to be displayed
		 	output = "<table border='1'><tr><th>Notice</th>" 
		 			+ "<th>Date of publish</th>"
		 			+ "<th>Update</th><th>Remove</th></tr>"; 
		 	String query = "select * from notices"; 
		 	Statement stmt = con.createStatement(); 
		 	ResultSet rs = stmt.executeQuery(query); 
		 // iterate through the rows in the result set
		 while (rs.next()) 
		 { 
			 
			
			 
			 String nid = Integer.toString(rs.getInt("nid")); 
			 String ncontent = rs.getString("ncontent"); 
			 String issuedate = rs.getString("issuedate");
			 
			 
		 // Add a row into the html table
	//		 output += "<tr><td>" + nid + "</td>"; 
			 output += "<td>" + ncontent + "</td>"; 
			 output += "<td>" + issuedate + "</td>";
			 
		
		 // buttons
			 output += "<td><input name='btnUpdate' type='button' value='Update' "
					 + "class='btnUpdate btn btn-secondary' data-noticeid='" + nid + "'></td>"
					 + "<td><input name='btnRemove' type='button' value='Remove' "
					 + "class='btnRemove btn btn-danger' data-noticeid='" + nid + "'></td></tr>"; 
		 } 
		 con.close(); 
		 // Complete the html table
		 	output += "</table>"; 
		
		
		
		}catch (Exception e) 
		{ 
			output = "Error while reading the items."; 
			System.err.println(e.getMessage()); 
		}

		return output;
		
		
	}
	
	public String removeNotice(String nid) 
	{ 
	 String output = ""; 
	try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 { 
	 return "Error while connecting to the database for deleting."; 
	 } 
	 // create a prepared statement
	 String query = "delete from notices where nid=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(nid)); 
	 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 String newnotices = viewNotices(); 
	 output = "{\"status\":\"success\", \"data\": \"" + newnotices + "\"}"; 

	 
	 
	 }  
	catch (Exception e) 
	 { 
		output = "{\"status\":\"error\", \"data\": \"Error while deleting the payment.\"}"; 
 
	 System.err.println(e.getMessage()); 
	 } 
	return output; 
	}

	//updating
	public String editNotice(String noticeid, String noticecontent, String idate) {
		String output ="";
		
		try {
			 Connection con = connect(); 
			 if (con == null) 
			 { 
			 return "Error while connecting to the database for updating."; 
			 } 
			 
			 String query = "UPDATE notices SET ncontent=?,issuedate=? WHERE nid=?"; 
			 PreparedStatement preparedStmt = con.prepareStatement(query); 
			 
			 
			 preparedStmt.setString(1, noticecontent); 
			 preparedStmt.setString(2, idate);  
			 
			 preparedStmt.setInt(3, Integer.parseInt(noticeid)); 
			 //execute the statement
			 preparedStmt.execute(); 
			 con.close(); 
			 
			 String newnotices = viewNotices(); 
			 output = "{\"status\":\"success\", \"data\": \"" + newnotices + "\"}"; 

			
		}catch(Exception e) {
			

			 output = "{\"status\":\"error\", \"data\": \"Error while updating the payment.\"}"; 
 
			 System.err.println(e.getMessage()); 
			
		}
		
		
		return output;
	}


	
}

