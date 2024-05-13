<%@page import="in.co.clg.Bean.CollegeBean"%>
<%@page import="in.co.clg.Bean.CourseBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.clg.Utility.HTMLUtility"%>
<%@page import="in.co.clg.Model.UserModel"%>
<%@page import="in.co.clg.Model.CourseModel"%>
<%@page import="in.co.clg.Model.CollegeModel"%>
<%@page import="java.util.List"%>
<%@page import="in.co.clg.Ctl.CourseCtl"%>
<%@page import="in.co.clg.Utility.ServletUtility"%>
<%@page import="in.co.clg.Ctl.CollegeCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>

<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>
</head>
<body>
	<%
	    CollegeModel model = new CollegeModel();
	    List  list =  model.list();
	    
	    CourseModel cModel = new CourseModel();
	    List cList = cModel.list();
	    
	    UserModel userModel = new UserModel();
	    List Ulist =  userModel.list();
	%>

	<%@include file="Header.jsp"%>
	<div class="container pt-4 pb-4 align-items-cente"
		style="position: relative; min-height: 63vh">

		<div class="container admin">
			<div class="container-fluid">
				<h5 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h5>
				<h5 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h5>

			</div>

			<div class="row">
				<div class="col-md-4">

					<div class="card text-center">
					<a href="<%=CAMView.STUDENT_LIST_CTL%>" style="text-decoration: none;">
						<div class="card-body">
							<div class="container">
								<img alt="" src="img/graduating-student.png" class="img-fluid rounded-circle"
									style="max-width: 100px">
							</div>
							<h1><%=Ulist.size()%></h1>
							<h1 class="text-uppercase text-muted">Student</h1>
						</div>
						</a>
						
					</div>
					
				</div>
				

				<div class="col-md-4">
					<div class="card text-center">
					<a href="<%=CAMView.COLLEGE_LIST_CTL%>" style="text-decoration: none;">
						<div class="card-body">
							<div class="container">
								<img alt="" src="img/college.png"
									class="img-fluid rounded-circle" style="max-width: 100px">
							</div>
							<h1><%=list.size()%></h1>
							<h1 class="text-uppercase text-muted">College</h1>
						</div>
						</a>
					</div>


				</div>

				<div class="col-md-4">
					<div class="card text-center">
						<a href="<%=CAMView.COURSE_LIST_CTL%>" style="text-decoration: none;">
						<div class="card-body">
							<div class="container">
								<img alt="" src="img/online-course.png"
									class="img-fluid rounded-circle" style="max-width: 100px">
							</div>
							<h1><%=cList.size()%></h1>
							<h1 class="text-uppercase text-muted">Courses</h1>
						</div>
						</a>
					</div>


				</div>


			</div>

			<div class="row mt-3">
				<div class="col-md-6">
					<div class="card" data-toggle="modal" data-target="#exampleModal">
						<div class="card-body text-center">
							<div class="container">
								<img alt="" src="img/plus.png"
									class="img-fluid rounded-circle" style="max-width: 100px">
							</div>
							<p class="mt-2 text-muted">Click Here to Add new College</p>
							<h1 class="text-uppercase text-muted">Add College</h1>
						</div>
					</div>
				</div>

				<div class="col-md-6">
					<div class="card" data-toggle="modal" data-target="#courseModal">
						<div class="card-body text-center">
								<a href="<%=CAMView.COURSE_CTL%>" style="text-decoration: none;">
							<div class="container">
								<img alt="" src="img/plus (1).png" class="img-fluid rounded-circle"
									style="max-width: 100px">
							</div>
							<p class="mt-2 text-muted">Click Here to Add new Courses</p>
							<h1 class="text-uppercase text-muted">Add Courses</h1>
								</a>
						</div>
					
					</div>
				</div>
			</div>

		</div>

		<!-- ADD College -->

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add College</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form action="<%=CAMView.COLLEGE_CTL%>" method="post">

							<div class="form-group">
								<input type="text" name="collegeName" class="form-control"
									placeholder="Enter College Name" required />
							</div>

							<div class="form-group">
								<input type="text" name="city" class="form-control"
									placeholder="Enter City" required />
							</div>

							<div class="form-group">
								<input type="text" name="university" class="form-control"
									placeholder="Enter College University" required />
							</div>

							<div class="form-group">
								<textarea name="description" class="form-control"
									style="height: 100px" placeholder="Enter Description" required></textarea>
							</div>



							<div class="container text-center">
								<input type="submit" class="btn btn-primary border-0"
									name="operation" value="<%=CollegeCtl.OP_SAVE%>">
									<input type="submit" class="btn btn-secondary border-0"
									name="operation" value="<%=CollegeCtl.OP_RESET%>">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>


		<!-- END College -->

		<!-- ADD COURSES -->
		<!-- Modal -->
		<%-- <div class="modal fade" id="courseModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add Courses</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					
					<div class="modal-body">
						<form action="<%=CAMView.COURSE_CTL%>" method="post">
						<jsp:useBean id="bean" scope="request" class="in.co.clg.Bean.CourseBean"></jsp:useBean>
						
						<div class="form-group"><select name="collegeId" class="form-control">
						    <option>-----Select-----</option>
							<option>1</option>
						 </select>
							</div>

							<div class="form-group">
								<input type="text" name="courseName" class="form-control"
									placeholder="Enter Course Name" required />
							</div>

							<div class="form-group">
								<input type="text" name="cID" class="form-control"
									placeholder="Enter CourseID" required />
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
									style="height: 100px" placeholder="Enter Description" required></textarea>
							</div>



							<div class="container text-center">
								<input type="submit" class="btn btn-primary border-0"
									name="operation" value="<%=CourseCtl.OP_SAVE%>">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
 --%>



		<!-- End Course -->
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>