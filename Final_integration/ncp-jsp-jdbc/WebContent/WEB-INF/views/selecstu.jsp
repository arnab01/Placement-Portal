<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%> 
   <%@page import="regis.model.User"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
body {font-family: Arial;
 background-color:  #f5fffa;
}


#lin{
  background: none!important;
  border: none;
  padding: 0!important;
  /*optional*/
  font-family: arial, sans-serif;
  /*input has OS specific font-family*/
  color: #069;
  text-decoration: underline;
  cursor: pointer;
}

/* Style the tab */
.tab {
  width: 99.3899%;
  overflow: hidden;
  border: 4px solid #ccc;
  background-color: #54defd;
  border-style: solid;
  border-color: #49c6e5;
}

/* Style the buttons inside the tab */
.tab button {
  width: 25%;
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #49c6e5;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #49c6e5;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}


th, td {
  padding: 15px;
}
table, td, th {
  border: 1px solid black;
  border-collapse: collapse;
}

table {
  width: 80%;
}

th {
  height: 40px;
}
</style>
</head>

<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #49c6e5">
			
 			
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/regstu"
					class="nav-link">Registered Students</a></li>
			</ul>
			
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/schedule"
					class="nav-link">Scheduling a company</a></li>
			</ul>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/stu"
					class="nav-link">Selected students</a></li>
			</ul>
		</nav>
	</header>
	
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Selects</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/selstu" class="btn btn-success">Add
					New Select</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Company</th>
						<th>Role</th>
						<th>Offer</th>
					
					</tr>
				</thead>
				<tbody>
					<%ArrayList<User> user =(ArrayList<User>)request.getAttribute("listuser"); 
        for(User u:user){%> 

						<tr>
						
							<td><%=u.getId()%></td>
							<td><%=u.getName()%></td>
							<td><%=u.getEmail()%></td>
							<td><%=u.getCompany()%></td>
							<td><%=u.getRole()%></td>
							<td><%=u.getOffer()%></td>
							
						</tr>
					
					<%}%> 
				</tbody>

			</table>
		</div>
	</div>
	
</body>
</html>