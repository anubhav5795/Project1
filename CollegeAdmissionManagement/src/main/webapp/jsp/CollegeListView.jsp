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
				<h2 class="text-center">College List</h2>
			</diV>
		</section>
		<h5 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h5>
		<h5 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h5>
		<form action="<%=CAMView.COLLEGE_LIST_CTL%>" method="post">
			<table class="table table-striped table-dark" width="100%">
				<tr>
					<td align="center"><label>College Name :</label> <input
						type="text" name="collegeName" placeholder="Enter College Name"
						value="<%=ServletUtility.getParameter("collegeName", request)%>">
						&emsp;&emsp; <input type="submit" name="operation"
						value="<%=CollegeListCtl.OP_SEARCH%>">&nbsp;&nbsp;&nbsp;<input
						type="submit" name="operation"
						value="<%=CollegeListCtl.OP_RESET%>"></td>
				</tr>
			</table>

			<table class="table table-striped table-white">
				<tr>
					<th scope="col">College Name</th>
					<th scope="col">City Name</th>
					<th scope="col">UniverSity Name</th>
					<th scope="col">Description</th>
				</tr>
				<%
					int index = 1;
					List list = ServletUtility.getList(request);
					Iterator it = list.iterator();
					while (it.hasNext()) {
						CollegeBean bean = (CollegeBean) it.next();
				%>
				<tr>
					<td><%=bean.getCollegeName()%></td>
					<td><%=bean.getCityName()%></td>
					<td><%=bean.getUniversityName()%></td>
					<td><%=bean.getDescription()%></td>

		<%if(user.getRoleid()==1){
				%>
			 <td><%-- <a class="btn btn-success"
					href="<%=CAMView.COLLEGE_CTL%>?id=<%=bean.getId()%>"><i class="fa fa-pencil-square-o" style='font-size:20px'></i></a> --%>
				<a class="btn btn-danger" href="<%=CAMView.COLLEGE_LIST_CTL%>?id=<%=bean.getId()%>"><i class="fa fa-trash" style='font-size:20px'></i></a></td>
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