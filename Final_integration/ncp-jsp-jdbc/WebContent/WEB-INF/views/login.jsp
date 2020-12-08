<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <style>
      
        .center{
  position: fixed;
  top: 50%;
  left: 50%;
 
  transform: translate(-50%, -50%);
}
        </style>
        </head>
<body style="background-image: url('https://wallpaperaccess.com/full/1567838.jpg');">
    
<div class="center">
    
    <h1>CIR Login</h1>
    <form action="<%= request.getContextPath() %>/validation" method="post">
        Username : <input type="text" id="username"  name="username" required /> <br/><br/>
        Password : <input type="password" id="password" name="password" required /> <br/><br/>
        <input type="submit" value="Login"  />


</form>
</div>

</body>
</html>

