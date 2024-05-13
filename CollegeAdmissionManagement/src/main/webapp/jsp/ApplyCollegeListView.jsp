<%@page import="in.co.clg.Ctl.ApplyCollegeListCtl"%>
<%@page import="in.co.clg.Ctl.CourseListCtl"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.clg.Utility.ServletUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.clg.Bean.ApplicationBean"%>
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
	<div class="ml-4 mr-4 mt-5"
		style="position: relative; min-height: 71vh">
		<section id="testimonials">
			<div class="testimonial-heading">
				<h2 class="text-center mt-2 mb-4">Application List</h2>
			</diV>
		</section>

		<h5 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h5>
		<h5 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h5>
		<form action="<%=CAMView.APPLY_COLLEGE_LIST_CTL%>" method="post">
		
		<%if(user.getRoleid()==1) {%>
					<table class="table table-striped table-dark" width="100%">
				<tr>
					<td align="center"><label>Application No :</label> <input
						type="text" name="applicationNo" placeholder="Enter Application No."
						value="<%=ServletUtility.getParameter("applicationNo", request)%>">
						&emsp;&emsp; <input type="submit" name="operation"
						value="<%=ApplyCollegeListCtl.OP_SEARCH%>">&nbsp;&nbsp;&nbsp;<input
						type="submit" name="operation"
						value="<%=ApplyCollegeListCtl.OP_RESET%>"></td>
				</tr>
			</table>
					<%}else{ %>
							
					<%}%>
		
			<table class="table table-striped table-white  mt-4">
				<tr>
					
					<th scope="col">Application No</th>
					<th scope="col">Course Name</th>
					<th scope="col">College Name</th>
					<th scope="col">Email Id</th>
					<th scope="col">Course Fees</th>
					<%if(user.getRoleid()==1) {%>
					<th scope="col">Action</th>
					<%}else{ %>
								<th scope="col">Status</th>
								<th scope="col">Payment Status</th>
								<%}%>
				</tr>
				<%
					int index = 1;
					List list = ServletUtility.getList(request);
					Iterator it = list.iterator();
					while (it.hasNext()) {
						ApplicationBean bean = (ApplicationBean) it.next();
				%>
				<tr>
				<td><%=bean.getApplicationNo()%></td>
					<td><%=bean.getCourseName()%></td>
					<td><%=bean.getCollegeName()%></td>
					<td><%=bean.getEmailId()%></td>
					<td>&#8377; <%=bean.getCourseFees()%></td>
					

		<%if(user.getRoleid()==1){
				%>
			 <td>
			 <a class="btn btn-success" href="<%=CAMView.VIEW_STUDENT_DETAILS%>?id=<%=bean.getId()%>">View Details</a>
			 <a class="btn btn-danger" href="<%=CAMView.APPLY_COLLEGE_LIST_CTL%>?id=<%=bean.getId()%>">Delete</a>
			</td>
			<%}else{ %>
			            <%if(bean.getStatus().equalsIgnoreCase("Selected")) {%>
			            <td class="p-3 mb-2 text-primary"><b><%=bean.getStatus()%></b></td>
			            <%if(bean.getPayment().equalsIgnoreCase("pay")){ %>
			            <td><a href="<%=CAMView.PAYMENT_CTL%>?courseFees=<%=bean.getCourseFees()%>&Pid=<%=bean.getId()%>" class="btn btn-success">Payment</a></td>
			            <%}else{ %>
			            <td class="p-3 mb-2 text-secondary"><b><%=bean.getPayment()%></td>
			            <%}%>
                     <%}else if(bean.getStatus().equalsIgnoreCase("Rejected")) {%>
                     <td class="p-3 mb-2 text-danger"><b><%=bean.getStatus()%></b></td>
                     <td></td>
                     <%}else{ %>
                     <td class="btn btn-primary btn-sm mt-2"><%=bean.getStatus()%></td>
                     <%}%>
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