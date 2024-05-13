<%@page import="in.co.clg.Ctl.StudentListCtl"%>
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
	<div class="container mt-2"
		style="position: relative; min-height: 71vh">
		<section id="testimonials">
			<div class="testimonial-heading">
				<h2 class="text-center">Student List</h2>
			</diV>
		</section>
		<h5 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h5>
		<h5 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h5>
		<form action="<%=CAMView.STUDENT_LIST_CTL%>" method="post">
			<table class="table table-striped table-dark" width="100%">
				<tr>
					<td align="center"><label>EmailID :</label> <input type="text"
						name="email" placeholder="Enter EmailId"
						value="<%=ServletUtility.getParameter("email", request)%>">
						&emsp;&emsp; <input type="submit" name="operation"
						value="<%=StudentListCtl.OP_SEARCH%>">&nbsp;&nbsp;&nbsp;<input
						type="submit" name="operation"
						value="<%=StudentListCtl.OP_RESET%>"></td>
				</tr>
			</table>

			<table class="table table-striped table-light">
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Father Name</th>
					<th scope="col">Mother Name</th>
					<th scope="col">Email Id</th>
					<th scope="col">Phone No</th>
					<th scope="col">Gender</th>
					<th scope="col">DOB</th>
					<th scope="col">Address</th>
					<th scope="col">RoleName</th>
					<th scope="col">Action</th>
				</tr>
				<%
					int index = 1;
					List list = ServletUtility.getList(request);
					Iterator it = list.iterator();
					while (it.hasNext()) {
						UserBean bean = (UserBean) it.next();
				%>
				<tr>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getFatherName()%></td>
					<td><%=bean.getMotherName()%></td>
					<td><%=bean.getEmailId()%></td>
					<td><%=bean.getPhoneNo()%></td>
					<td><%=bean.getGender()%></td>
					<td><%=bean.getDOB()%></td>
					<td><%=bean.getAddress()%></td>
					<td><%=bean.getRoleName()%></td>

					<%
						if (bean.getRoleName().equalsIgnoreCase("Admin")) {
					%>
				         <td>-------</td>
					<%
						} else {
					%>
					<td><a class="btn btn-danger"
						href="<%=CAMView.STUDENT_LIST_CTL%>?id=<%=bean.getId()%>"><i
							class="fa fa-trash" style='font-size: 20px'></i></a></td>
					<%
						}
					%>
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