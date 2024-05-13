<%@page import="in.co.clg.Utility.DataUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.clg.Utility.HTMLUtility"%>
<%@page import="in.co.clg.Ctl.CourseCtl"%>
<%@page import="in.co.clg.Utility.ServletUtility"%>
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
		List collegelist = (List) request.getAttribute("collegeList");
	%>
	<div class="container mt-5 pt-5 align-items-cente"
		style="position: relative; min-height: 64vh">


		<div class="container">
			<div class="row mb-4">
				<div class="col-md-6 offset-md-3">
					<div class="card">
						<h6 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h6>
						<h6 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h6>
						<div class="card-header bg-dark text-white"></div>
						<div class="card-body">
							<form action="<%=CAMView.COURSE_CTL%>" method="post">
								<jsp:useBean id="bean" scope="request"
									class="in.co.clg.Bean.CourseBean"></jsp:useBean>
<input type="hidden" name="id" value="<%=bean.getId()%>">
								<%
									if (bean.getId() > 0) {
								%>
								<h3 class="text-center">Course Update</h3>
								<%
									} else {
								%>
								<h3 class="text-center">Course Add</h3>
								<%
									}
								%>

								<%-- <div class="form-group">
									<label></label> <select name="collegeId" class="form-control">
										<option selected disabled>-------Select College
											Name--------</option>
										<%=HTMLUtility.getList("collegeId", String.valueOf(bean.getCollegeID()), collegelist)%>
									</select>
								</div> --%>

								<div class="form-group">
									<input type="text" name="courseName" class="form-control"
										value="<%=DataUtility.getStringData(bean.getCourseName())%>"
										placeholder="Enter Course Name" required />
								</div>

								<div class="form-group">
									<input type="text" name="cID" class="form-control"
										value="<%=DataUtility.getStringData(bean.getCourseID())%>"
										placeholder="Enter Course ID" required />
								</div>

								<div class="form-group">
									<input type="number" min="4" name="courseFees"
										
										class="form-control" placeholder="Enter Course Fees" required />
								</div>

								<div class="form-group">
									<input type="number" min="4" name="courseSeat"
										
										class="form-control" placeholder="Enter Course Seat" required />
								</div>

								<div class="form-group">
									<textarea name="description" class="form-control"
										style="height: 100px" placeholder="Enter Description" required><%=DataUtility.getStringData(bean.getDescription())%></textarea>
								</div>

								<div class="container text-center">
									<%
										if (bean.getId() > 0) {
									%>
									<input type="submit" class="btn btn-primary border-0"
										name="operation" value="<%=CourseCtl.OP_UPDATE%>">
									<%
										} else {
									%>
									<input type="submit" class="btn btn-primary border-0"
										name="operation" value="<%=CourseCtl.OP_SAVE%>">
									<%
										}
									%>

								</div>
							</form>
						</div>
					</div>



				</div>
			</div>

		</div>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>