<%@page import="in.co.clg.Utility.ServletUtility"%>
<%@page import="in.co.clg.Ctl.RegistrationCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Header.jsp"%>

	<div class="container-fluid">
		<div class="row mt-5 mb-4">
			<div class="col-md-4 offset-md-4">
				<h3 class="text-center my-3">Sign up Here</h3>

				<form action="<%=CAMView.USER_REGISTRATION_CTL%>" method="post">
					<div class="card">
	<h6 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h6>
						<div class="card-body px-5">

							<div class="form-group">
								<label>First Name</label> <input type="text"
									class="form-control" placeholder="Enter FirstName"
									name="fName">
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("fName", request)%></div>
							

							<div class="form-group">
								<label>Last Name</label> <input type="text" class="form-control"
									placeholder="Enter LastName" name="lName">
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("lName", request)%></div>

							<div class="form-group">
								<label>Father Name</label> <input type="text"
									class="form-control" placeholder="Enter FatherName"
									name="fatherName">
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("fatherName", request)%></div>

							<div class="form-group">
								<label>Mother Name</label> <input type="text"
									class="form-control" placeholder="Enter MotherName"
									name="motherName">
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("motherName", request)%></div>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									name="email">
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></div>

							<div class="form-group">
								<label for="password">Password</label> <input type="password"
									class="form-control" id="password" aria-describedby="password"
									placeholder="Enter Password" name="password">
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></div>

							<div class="form-group">
								<label for="name">Gender</label> <select class="form-control"
									name="gender">
									<option selected disabled>---Select Gender Type---</option>
									<option>Male</option>
									<option>Female</option>
								</select>
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("gender", request)%></div>



							<div class="form-group">
								<label for="name">Phone No</label> <input type="number"
									class="form-control" id="name" aria-describedby="name"
									placeholder="Enter Phone No" name="phoneNo">
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("phoneNo", request)%></div>

							<div class="form-group">
								<label for="name">Date of Birth</label> <input type="text"
									class="form-control mb-4 datepicker" autocomplete="off"
									name="dob" data-provide="datepicker" id="datepicker"
									placeholder="Enter Date of Birth" required="required">
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("dob", request)%></div>

							<div class="form-group">
								<label for="name">Student Address</label>
								<textarea style="height: 100px;" class="form-control"
									placeholder="Enter Address" name="Address"></textarea>
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("Address", request)%></div>

							<div class="container text-center">
								<input type= "submit" class="btn btn-outline-success" name="operation" value="<%=RegistrationCtl.OP_REGISTER%>">
								<input type= "submit" class="btn btn-outline-warning" name="operation" value="<%=RegistrationCtl.OP_RESET%>">
							</div>


						</div>

					</div>

				</form>
			</div>

		</div>
	</div>

	<%@include file="Footer.jsp"%>
</body>
</html>