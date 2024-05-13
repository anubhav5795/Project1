<%@page import="in.co.clg.Bean.CourseBean"%>
<%@page import="in.co.clg.Ctl.CourseListCtl"%>
<%@page import="in.co.clg.Ctl.CollegeListCtl"%>
<%@page import="in.co.clg.Bean.CollegeBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
		UserBean user = (UserBean) session.getAttribute("user");
	%>
	<div class="ml-4 mr-4 mt-2"
		style="position: relative; min-height: 71vh">
		<section id="testimonials">
			<div class="testimonial-heading">
				<h2 class="text-center">Course List</h2>
			</diV>
		</section>

		<h5 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h5>
		<h5 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h5>
		<form action="<%=CAMView.COURSE_LIST_CTL%>" method="post">
			<table class="table table-striped table-dark" width="100%">
				<tr>
					<td align="center"><label>Course Name :</label> <input
						type="text" name="courseName" placeholder="Enter Course Name"
						value="<%=ServletUtility.getParameter("courseName", request)%>">
						&emsp;&emsp; <input type="submit" name="operation"
						value="<%=CourseListCtl.OP_SEARCH%>">&nbsp;&nbsp;&nbsp;<input
						type="submit" name="operation"
						value="<%=CourseListCtl.OP_RESET%>"></td>
				</tr>
			</table>

			<table class="table table-striped table-white">
				<tr>
					<th scope="col">Course Name</th>
					<th scope="col">Course ID</th>
					<th scope="col">Course Fees</th>
					<th scope="col">Course Seats</th>
					<th scope="col">Description</th>
				</tr>
				<%
					int index = 1;
					List list = ServletUtility.getList(request);
					Iterator it = list.iterator();
					while (it.hasNext()) {
						CourseBean bean = (CourseBean) it.next();
				%>
				<tr>
					<td><%=bean.getCourseName()%></td>
					<td><%=bean.getCourseID()%></td>
					<td>&#8377; <%=bean.getCourseFees()%></td>
					<td><%=bean.getCourseSeat()%></td>
					<td><%=bean.getDescription()%></td>

		<%if(user.getRoleid()==1){
				%>
			 <td><%-- <a class="btn btn-success"
					href="<%=CAMView.COURSE_CTL%>?id=<%=bean.getId()%>"><i class="fa fa-pencil-square-o" style='font-size:20px'></i></a> --%>
				<a class="btn btn-danger" href="<%=CAMView.COURSE_LIST_CTL%>?id=<%=bean.getId()%>"><i class="fa fa-trash" style='font-size:20px'></i></a></td>
			<%}else{ %>

			<%} %>
				</tr>
				<%
					}
				%>
				</tbody>
			</table>
		</form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>