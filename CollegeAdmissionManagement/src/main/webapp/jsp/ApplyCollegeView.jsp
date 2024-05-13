<%@page import="in.co.clg.Utility.ServletUtility"%>
<%@page import="in.co.clg.Ctl.ApplyCollegeCtl"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.clg.Utility.HTMLUtility"%>
<%@page import="java.util.List"%>
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
	<%
		List courselist = (List) request.getAttribute("courseList");
	    List collegeList = (List) request.getAttribute("CollegeList");
	%>
	<%
		UserBean user = (UserBean) session.getAttribute("user");
	%>


	<div class="container mt-2">
	<h3 class="text-center my-3">Admission Application Form</h3>
	
		<h6 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h6>
	

<form action="<%=CAMView.APPLY_COLLEGE_CTL%>" method="post">
		<jsp:useBean id="bean" scope="request"
			class="in.co.clg.Bean.ApplicationBean"></jsp:useBean>
		<div class="row g-3">

			<div class="col-md-6">
				<label></label> <select name="courseId" class="form-control">
					<option selected disabled>-------Select Course Name--------</option>
					<%=HTMLUtility.getList("courseId", String.valueOf(bean.getCourseId()), courselist)%>
				</select>
			</div>


			<div class="col-md-6">
				<label></label> <select name="collegeId" class="form-control">
					<option selected disabled>-------Select College Name--------</option>
					<%=HTMLUtility.getList("collegeId", String.valueOf(bean.getCollegeId()), collegeList)%>
				</select>
			</div>



            <div class="col-md-6">
				<label for="inputPassword4" class="form-label">Application No</label> <input
					type="text" class="form-control" id="inputPassword4" name="applicationNo" placeholder="Enter Application No">
			</div>

			<div class="col-md-6">
				<label for="inputEmail4" class="form-label">Email</label> <input
					type="email" class="form-control" id="inputEmail4" name="email" readonly="readonly"
					value="<%=user.getEmailId()%>">
			</div>

			<div class="col-md-6"> 
				<label for="inputEmail4" class="form-label">First Name</label> <input name="fName" readonly="readonly"
					type="text" class="form-control" value="<%=user.getFirstName()%>">
			</div>


			<div class="col-md-6">
				<label for="inputPassword4" class="form-label">Last Name</label> <input name="LName" readonly="readonly"
					type="text" class="form-control" value="<%=user.getLastName()%>">
			</div>

			<div class="col-md-6">
				<label for="inputEmail4" class="form-label">Father Name</label> <input name="fatherName" readonly="readonly"
					type="text" class="form-control" value="<%=user.getFatherName()%>">
			</div>


			<div class="col-md-6">
				<label for="inputPassword4" class="form-label">Mother Name</label> <input name="motherName" readonly="readonly"
					type="text" class="form-control" value="<%=user.getMotherName()%>">
			</div>

			<div class="col-md-6">
				<label for="inputEmail4" class="form-label">Phone No</label> <input name="phoneNo" readonly="readonly"
					type="number" class="form-control" value="<%=user.getPhoneNo()%>">
			</div>
			
			<div class="col-md-6">
				<label for="inputPassword4" class="form-label">Date Of Birth</label>
				<input type="text" class="form-control mb-4 datepicker" name="DOB"
					autocomplete="off" name="dob" data-provide="datepicker" readonly="readonly"
					id="datepicker" value="<%=user.getDOB()%>"
					placeholder="Enter Date of Birth" required="required">
			</div>

			<div class="col-md-6">
					<%
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("Male", "Male");
						map.put("Female", "Female");
					%>
					<%=HTMLUtility.getList("gender", String.valueOf(user.getGender()), map)%>
			</div>


			<div class="col-md-6">
				<select class="form-control"   name="category">
									<option selected disabled>---Select Category Type---</option>
									<option>General</option>
									<option>OBC</option>
									<option>ST/SC</option>
									<option>Other</option>
				</select>
			</div>

			<div class="col-md-6 mt-4">
			<input
					type="text" class="form-control" placeholder="Enter Nationality" name="nationality">
			</div>
			
			<div class="col-md-6 mt-4">
			<input
					type="text" class="form-control" id="inputZip" placeholder="Enter Pin Code" name="pincode">
			</div>



			<div class="col-md-6">
				<label for="name">Correspondence Address</label>
				<textarea style="height: 100px;" class="form-control"
					placeholder="Enter Address" name = "correspondenceAddress"></textarea>
			</div>

			<div class="col-md-6">
				<label for="name">Permanent Address</label>
				<textarea style="height: 100px;" class="form-control"  readonly="readonly"
					placeholder="Enter Address" name="permanentAddress"><%=user.getAddress()%></textarea> 
			</div>

<div class="col-md-12 text-center mt-4">
<h4><b>Qualification</b></h4>
</div>

<div class="col-md-12 mt-1">
<h6><b>#10th(Secondary)</b></h6>
</div>

<div class="col-md-3">
				<input
					type="text" class="form-control" placeholder="Enter Board" name="board1">
			</div>
			
			<div class="col-md-3">
			<input
					type="text" class="form-control" id="inputZip" placeholder="Enter Year" name="year1">
			</div>
			
			<div class="col-md-3">
			<input
					type="text" class="form-control" placeholder="Enter Percentage" name="percentage1">
			</div>
			
			<div class="col-md-3">
			<input
					type="text" class="form-control" id="inputZip" placeholder="Enter Stream" name="stream1">
			</div>


<div class="col-md-12 mt-4">
<h6><b>#12th(Senior Secondary)</b></h6>
</div>

<div class="col-md-3">
				 <input
					type="text" class="form-control" placeholder="Enter Board" name="board2">
			</div>
			
			<div class="col-md-3">
			<input
					type="text" class="form-control" id="inputZip" placeholder="Enter Year" name="year2">
			</div>
			
			<div class="col-md-3">
				<input
					type="text" class="form-control" placeholder="Enter Percentage" name="percentage2">
			</div>
			
			<div class="col-md-3">
			<input
					type="text" class="form-control" id="inputZip" placeholder="Enter Stream" name="stream2">
			</div>

<div class="col-md-12 mt-4">
<h6><b>Declaration</b></h6>
</div>

<div class="col-md-12">
				<textarea style="height: 80px;" class="form-control"
					placeholder="Enter Declaration" name="declaration"></textarea>
			</div>
			
			
<div class="container mt-4 mb-4 text-center">
				<input type= "submit" class="btn btn-outline-success" name="operation" value="<%=ApplyCollegeCtl.OP_SUBMIT%>">
				<input type= "submit" class="btn btn-outline-warning" name="operation" value="<%=ApplyCollegeCtl.OP_RESET%>">
			</div>
		</div>
		</form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>