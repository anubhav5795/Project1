<%@page import="in.co.clg.Utility.ServletUtility"%>
<%@page import="in.co.clg.Ctl.LoginCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp" %>
<div class="container mt-5 pt-5 align-items-cente" style="position: relative; min-height: 64vh">


	<div class="container">
		<div class="row mb-4">
			<div class="col-md-6 offset-md-3">
			<div class="card">
			<h6 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h6>
			   <div class="card-header">
			   <h3 class="text-center">Login here</h3>
			   </div>
			    <div class="card-body">
			   <form action= "<%=CAMView.LOGIN_CTL%>" method = "post">
			   
  <div class="form-group">
    <label>Email ID</label>
    <input type="email" name = "email" class="form-control"  placeholder="Enter email">
  </div>
 <div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></div>
  
  
  <div class="form-group">
    <label>Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name = "Password">
  </div>
<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("Password", request)%></div>
  
  
  <a href="<%=CAMView.USER_REGISTRATION_CTL%>" class="text-center d-block mb-2"> IF Not Registered Click Here</a>
  
 <div class="container text-center">
 <input type= "submit" class="btn btn-primary border-0" name="operation" value="<%=LoginCtl.OP_SINGIN%>">
<input type= "submit" class="btn btn-primary border-0" name="operation" value="<%=LoginCtl.OP_RESET%>">
  </div>
  
</form>
			   </div>
			
			 <div class="card-footer">
			   
			   </div>
			</div>
			
			
			
			</div>
		</div>

	</div>
	</div>
		<%@include file="Footer.jsp"%>
	
</body>
</html>