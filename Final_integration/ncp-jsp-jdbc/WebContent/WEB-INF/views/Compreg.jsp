<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			
 			
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
<form action="<%= request.getContextPath() %>/register" method="post">
<fieldset>
          <h2 style="text-align: center;">Schedule/Reschedule test</h2>
          <table  >
          <tr>
<td>
  <label >Company</label>&emsp;
  <input type="text" name="compname" id="compname" pattern="[a-z0-9A-Z ]+" required/>&emsp;
</td>

</tr>
<tr>
<td>
  <label >Name of the test</label>&emsp;
  <input type="text" name="testname" id="testname" pattern="[a-z0-9A-Z ]+" required/>&emsp;
</td>
<!--  -->
</tr>
<td>
  <label >Round Number </label>&emsp;
  <input type="number" name="roundno" id="roundno" required/>&emsp;
</td>
<tr>
<td>
  <label >Test Window</label>&emsp;
  <label >Start</label>&emsp;
  <input type='time' name="stime" id="stime" required/>&emsp;
  
      <label >End</label>&emsp;
      
      <input type='time' name="etime" id="etime" required/>&emsp;

  
</td>
</tr>


<tr>
<td>
  <label >Test Date</label>&emsp;
  <input type="date" name="tdate" id="tdate" required/>&emsp;
</td>
</tr>


</table>
      </fieldset>
      <div class="center"><button id="csch" >Submit</button></div>

  </form>
  
</body>
</html>