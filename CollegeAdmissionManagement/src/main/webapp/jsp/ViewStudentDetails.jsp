<%@page import="in.co.clg.Ctl.ViewStudentDetailsCtl"%>
<%@page import="in.co.clg.Utility.DataUtility"%>
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
	<div class="container mt-2">
		<h3 class="text-center my-3">Admission Application Form</h3>

		<h6 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h6>

			<jsp:useBean id="bean" scope="request"
				class="in.co.clg.Bean.ApplicationBean"></jsp:useBean>
			<input type="hidden" name="id" value="<%=bean.getId()%>"> 
			<input	type="hidden" name="email" value="<%=bean.getEmailId()%>">
			<input	type="hidden" name="fName" value="<%=bean.getFirstName()%>"> 
			<input type="hidden" value="<%=DataUtility.getStringData(bean.getApplicationNo())%>" name="applicationNo">

			<div class="row g-3">
			
				<div class="col-md-6">
					<label for="inputPassword4" class="form-label">Course Name</label>
					<select name="courseId" class="form-control" disabled="disabled">
						<option selected disabled><%=bean.getCourseName()%></option>
					</select>
				</div>


				<div class="col-md-6">
					<label for="inputPassword4" class="form-label">College Name</label>
					<select name="collegeId" class="form-control" disabled="disabled">
						<option><%=bean.getCollegeName()%></option>
					</select>
				</div>



				<div class="col-md-6">
					<label for="inputPassword4" class="form-label">Application No</label>
					 <input value="<%=bean.getApplicationNo()%>" readonly="readonly"
						type="text" class="form-control" id="inputPassword4"
						name="applicationNo" placeholder="Enter Application No">
				</div>

				<div class="col-md-6">
					<label for="inputEmail4" class="form-label">Email</label> <input
						type="email" class="form-control" id="inputEmail4" name="email"
						readonly="readonly" value="<%=bean.getEmailId()%>">
				</div>

				<div class="col-md-6">
					<label for="inputEmail4" class="form-label">First Name</label> <input
						name="fName" readonly="readonly" type="text" class="form-control"
						value="<%=bean.getFirstName()%>">
				</div>


				<div class="col-md-6">
					<label for="inputPassword4" class="form-label">Last Name</label> <input
						name="LName" readonly="readonly" type="text" class="form-control"
						value="<%=bean.getLastName()%>">
				</div>

				<div class="col-md-6">
					<label for="inputEmail4" class="form-label">Father Name</label> <input
						name="fatherName" readonly="readonly" type="text"
						class="form-control" value="<%=bean.getFatherName()%>">
				</div>


				<div class="col-md-6">
					<label for="inputPassword4" class="form-label">Mother Name</label>
					<input name="motherName" readonly="readonly" type="text"
						class="form-control" value="<%=bean.getMotherName()%>">
				</div>

				<div class="col-md-6">
					<label for="inputEmail4" class="form-label">Phone No</label> <input
						name="phoneNo" readonly="readonly" type="number"
						class="form-control" value="<%=bean.getPhoneNo()%>">
				</div>

				<div class="col-md-6">
					<label for="inputPassword4" class="form-label">Date Of
						Birth</label> <input type="text" class="form-control mb-4 datepicker"
						name="DOB" autocomplete="off" name="dob" data-provide="datepicker"
						readonly="readonly" id="datepicker" value="<%=bean.getDOB()%>"
						placeholder="Enter Date of Birth" required="required">
				</div>

				<div class="col-md-6">
					<label for="inputPassword4" class="form-label">Gender</label> <select
						name="courseId" class="form-control" disabled="disabled">
						<option selected disabled><%=bean.getGender()%></option>
					</select>
				</div>

				<div class="col-md-6">
					<label for="inputPassword4" class="form-label">Category</label> <select
						name="courseId" class="form-control" disabled="disabled">
						<option selected disabled><%=bean.getCategory()%></option>
					</select>
				</div>

				<div class="col-md-6 mt-4">
					<label for="inputPassword4" class="form-label">Nationality</label>
					<input type="text" class="form-control"
						placeholder="Enter Nationality" name="nationality"
						value="<%=bean.getNationality()%>" readonly="readonly">
				</div>

				<div class="col-md-6 mt-4">
					<label for="inputPassword4" class="form-label">Pin Code</label> <input
						type="text" class="form-control" id="inputZip"
						placeholder="Enter Pin Code" name="pincode"
						value="<%=bean.getPincode()%>" readonly="readonly">
				</div>



				<div class="col-md-6">
					<label for="name">Correspondence Address</label>
					<textarea style="height: 100px;" class="form-control"
						readonly="readonly" placeholder="Enter Address"
						name="correspondenceAddress"><%=bean.getCorrespondenceAddress()%></textarea>
				</div>

				<div class="col-md-6">
					<label for="name">Permanent Address</label>
					<textarea style="height: 100px;" class="form-control"
						readonly="readonly" placeholder="Enter Address"
						name="permanentAddress"><%=bean.getAddress()%></textarea>
				</div>

				<div class="col-md-12 text-center mt-4">
					<h4>
						<b>Qualification</b>
					</h4>
				</div>

				<div class="col-md-12 mt-1">
					<h6>
						<b>#10th(Secondary)</b>
					</h6>
				</div>

				<div class="col-md-3">
					<label for="name">Board</label> <input type="text"
						class="form-control" placeholder="Enter Board" name="board1"
						value="<%=DataUtility.getStringData(bean.getBoard1())%>"
						readonly="readonly">
				</div>

				<div class="col-md-3">
					<label for="name">Year</label> <input type="text"
						class="form-control" id="inputZip" placeholder="Enter Year"
						name="year1"
						value="<%=DataUtility.getStringData(bean.getYear1())%>"
						readonly="readonly">
				</div>

				<div class="col-md-3">
					<label for="name">Percentage</label> <input type="text"
						class="form-control" placeholder="Enter Percentage"
						name="percentage1"
						value="<%=DataUtility.getStringData(bean.getPercentange1())%>"
						readonly="readonly">
				</div>

				<div class="col-md-3">
					<label for="name">Stream</label> <input type="text"
						class="form-control" id="inputZip" placeholder="Enter Stream"
						name="stream1"
						value="<%=DataUtility.getStringData(bean.getStream1())%>"
						readonly="readonly">
				</div>


				<div class="col-md-12 mt-4">
					<h6>
						<b>#12th(Senior Secondary)</b>
					</h6>
				</div>

				<div class="col-md-3">
					<label for="name">Board</label> <input type="text"
						class="form-control" placeholder="Enter Board" name="board2"
						value="<%=DataUtility.getStringData(bean.getBoard2())%>"
						readonly="readonly">
				</div>

				<div class="col-md-3">
					<label for="name">Year</label> <input type="text"
						class="form-control" id="inputZip" placeholder="Enter Year"
						name="year2"
						value="<%=DataUtility.getStringData(bean.getYear2())%>"
						readonly="readonly">
				</div>

				<div class="col-md-3">
					<label for="name">Percentage</label> <input type="text"
						class="form-control" placeholder="Enter Percentage"
						name="percentage2"
						value="<%=DataUtility.getStringData(bean.getPercentange2())%>"
						readonly="readonly">
				</div>

				<div class="col-md-3">
					<label for="name">Stream</label> <input type="text"
						class="form-control" id="inputZip" placeholder="Enter Stream"
						name="stream2"
						value="<%=DataUtility.getStringData(bean.getStream2())%>"
						readonly="readonly">
				</div>

				<div class="col-md-12 mt-4">
					<h6>
						<b>Declaration</b>
					</h6>
				</div>

				<div class="col-md-12">
					<textarea style="height: 80px;" class="form-control"
						readonly="readonly" placeholder="Enter Declaration"
						name="declaration"><%=bean.getDeclaration()%></textarea>
				</div>
				
					<div class="col-md-6">
					<label for="inputPassword4" class="form-label">Course Fees</label>
					<input value="&#8377;<%=DataUtility.getStringData(bean.getCourseFees())%> " readonly="readonly" type="text" class="form-control"  placeholder="Enter Course Fess">
				   </div>



					<div class="container mt-4 mb-4 text-center">
					<h6>
						<b>Admin Remark</b>
					</h6>
					
				<%if(bean.getStatus().equalsIgnoreCase("Selected")) {%>	
					<a class="btn btn-success">Selected</a>
				<%}else{ %>
					<a class="btn btn-outline-success" href="<%=CAMView.VIEW_STUDENT_DETAILS%>?Sid=<%=bean.getId()%>&id=<%=bean.getId()%>">Selected</a>
				<%} %>
				
			     <%if(bean.getStatus().equalsIgnoreCase("Rejected")) {%>
			        <a class="btn btn-danger">Rejected</a>
			     <%}else{ %>
				    <a class="btn btn-outline-danger" href="<%=CAMView.VIEW_STUDENT_DETAILS%>?Rid=<%=bean.getId()%>&id=<%=bean.getId()%>">Rejected</a>
				<%}%>
				
				</div>
			</div>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>