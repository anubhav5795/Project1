<%@page import="java.util.List"%>
<%@page import="in.co.clg.Model.ApplicationModel"%>
<%@page import="in.co.clg.Ctl.LoginCtl"%>
<%@page import="in.co.clg.Bean.UserBean"%>
<%@page import="in.co.clg.Ctl.CAMView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>

<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>
</head>
<%-- <%
						  ApplicationModel model = new ApplicationModel();
						  List applicationlist = model.list();
	%> --%>
<body>
	<%
		UserBean userBean = (UserBean) session.getAttribute("user");
	%>
	<%
		boolean userLoggedIn = userBean != null;

		String welcomeMsg = "Hello, ";

		if (userLoggedIn) {
			String role = (String) session.getAttribute("role");
			welcomeMsg += userBean.getRoleName();
		} else {
			welcomeMsg += "Guest";
		}
	%>
	<nav class="navbar navbar-light bg-dark">
		<span class="navbar-brand mb-0 h1 text-white"
			href="<%=CAMView.WELCOME_CTL%>"><span
			style="color: #00e7ff99;">College Admission Management System</span></span>
	</nav>
	<!-- header start -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand text-dark" href="<%=CAMView.WELCOME_CTL%>"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<%
						if (userBean != null) {
					%>

					<%
						if (userBean.getRoleid() == 1) {
					%>						
						<li class="nav-item active"><a class="nav-link"
						href="<%=CAMView.APPLY_COLLEGE_LIST_CTL%>"> <span>Admission Request</span><i class='material-icons'
							style='font-size: 30px; color: red'>notifications </i><!-- <span
							class="ml-1 cart-items text-dark" style="margin-top: -20px;">(4)
						</span>  --></a></li>
						
					<li class="nav-item"><a class="nav-link text-dark"
						href="<%=CAMView.ADMIN_CTL%>"><b>Home</b></a></li>
						
								<li class="nav-item"><a class="nav-link text-dark"
						href="<%=CAMView.PAYMENT_LIST_CTL%>"><b>Payment List</b></a></li>

					<li class="nav-item"><a class="nav-link text-dark"
						href="<%=CAMView.LOGIN_CTL%>?operation=<%=LoginCtl.OP_LOGOUT%>"><b>Logout</b></a>
					</li>
					<%
						} else if (userBean.getRoleid() == 2) {
					%>
					<li class="nav-item"><a class="nav-link text-dark"
						href="<%=CAMView.APPLY_COLLEGE_CTL%>"><b>Apply for College</b></a></li>
						
							<li class="nav-item"><a class="nav-link text-dark"
						href="<%=CAMView.APPLY_COLLEGE_LIST_CTL%>"><b>Applied For</b></a></li>

					<li class="nav-item"><a class="nav-link text-dark"
						href="<%=CAMView.COLLEGE_LIST_CTL%>"><b>College List</b></a></li>

					<li class="nav-item"><a class="nav-link text-dark"
						href="<%=CAMView.COURSE_LIST_CTL%>"><b>Course List</b></a></li>
						
								<li class="nav-item"><a class="nav-link text-dark"
						href="<%=CAMView.PAYMENT_LIST_CTL%>"><b>Payment List</b></a></li>

					<li class="nav-item"><a class="nav-link text-dark"
						href="<%=CAMView.LOGIN_CTL%>?operation=<%=LoginCtl.OP_LOGOUT%>"><b>Logout</b></a>
					</li>

					<%
						}
					%>
					<%
						} else {
					%>
					<li class="nav-item"><a class="nav-link text-dark"
						href="<%=CAMView.LOGIN_CTL%>"><b>Login</b></a></li>
					<li class="nav-item"><a class="nav-link text-dark"
						href="<%=CAMView.USER_REGISTRATION_CTL%>"><b>Registration</b></a>
					</li>
					<%
						}
					%>
				</ul>
			</div>
		</div>

	</nav>
</body>
</html>