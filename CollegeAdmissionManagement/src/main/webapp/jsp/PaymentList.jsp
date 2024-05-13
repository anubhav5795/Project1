<%@page import="in.co.clg.Bean.PaymentBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.clg.Ctl.PaymentListCtl"%>
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
				<h2 class="text-center">Payment List</h2>
			</diV>
		</section>

		<h5 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h5>
		<h5 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h5>
		<form action="<%=CAMView.PAYMENT_LIST_CTL%>" method="post">
		
			<table class="table table-striped table-white">
				<tr>
				    <th scope="col">Student Email ID</th>
					<th scope="col">Course Fess</th>
					<th scope="col">Card No.</th>
					<th scope="col">Expairy Date</th>
					<th scope="col">CVV</th>
					<th scope="col">Status</th>
					<%if(user.getRoleid()==1){
				%>
					<th scope="col">Action</th>
					<%}else{ %>

			<%} %>
				</tr>
				<%
					int index = 1;
					List list = ServletUtility.getList(request);
					Iterator it = list.iterator();
					while (it.hasNext()) {
						PaymentBean bean = (PaymentBean) it.next();
				%>
				<tr>
					<td><%=bean.getEmail()%></td>
					<td>&#8377; <%=bean.getCourseFees()%></td>
					<td><%=bean.getCardNo()%></td>
					<td><%=bean.getExpairyDate()%></td>
					<td><%=bean.getCvv()%></td>
					<td class="p-3 mb-2 text-secondary"><%=bean.getStatus()%></td>

		<%if(user.getRoleid()==1){
				%>
			 <td>
				<a class="btn btn-danger" href="<%=CAMView.PAYMENT_LIST_CTL%>?id=<%=bean.getId()%>"><i class="fa fa-trash" style='font-size:20px'></i></a></td>
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