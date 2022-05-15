<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.Admin" %>
<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.cj.jdbc.Driver"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notices</title>


<link rel="stylesheet" href="Views/bootstrap.css">
<link rel="stylesheet" href="css/Notices.css">

<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/Admin.js"></script>
</head>
<body>

<div class="bg-light">
     <div class="container">
     <div class="row">
     <div class="col-12">
	
     <center><h1 style="font-size:380%;">Notice</h1></center>
	
<br>
  
  <div>
  
			  <form id="formItem" name="formItem" method="post" action="Admin.jsp">
			 Notice Content: 
			<input id="ncontent" name="ncontent" type="text" 
			 class="form-control form-control-sm">
			
			<br> Issued Date:
			<input id="issuedate" name="issuedate" type="text" 
			 class="form-control form-control-sm">
			
			 <br>
			<input id="btnSave" name="btnSave" type="button" value="Save" 
			 class="btn btn-primary">
			<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
			</form>
  		<br>
  		<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div class="table table-Stiped" id="divItemsGrid">
				 <%
				 Admin noticeobj = new Admin(); 
				 out.print(noticeobj.viewNotices()); 
				 %>
</div>
  
  </div>
  </div>
  </div>
  </div></div>
 
</body>
</html>