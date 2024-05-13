<%@page import="in.co.clg.Utility.DataUtility"%>
<%@page import="in.co.clg.Utility.ServletUtility"%>
<%@page import="in.co.clg.Ctl.PaymentCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #f0f1f2">
	<%@ include file="Header.jsp"%>
	<div class="container-fluid"
		style="position: relative; min-height: 70vh">
		<div class="row mt-1">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-body px-5">

						<h6 class="text-center mt-5" style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
						<h6 class="text-center mt-5" style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>

						<h4 class="text-center">Payment Details</h4>
						<div class="container mt-3">
						
						<form action="<%=CAMView.PAYMENT_CTL%>" method="post">
						<jsp:useBean id="bean" scope="request" class="in.co.clg.Bean.PaymentBean"></jsp:useBean>
						
						
							<div class="form-group">
								<label for="name">Course Fess</label> <input type="text"
									value="<%=DataUtility.getStringData(bean.getCourseFees())%>" readonly="readonly" class="form-control"
									name="courseFess" placeholder="Enter Course Fess">
							</div>

							<div class="form-group">
								<label for="name">Your Card No</label> <input type="text"
								 class="form-control" name="cardNo"
									placeholder="Enter Card No">
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("cardNo", request)%></div>

							<div class="form-group">
								<label for="name">Card Expairy Date </label> <input type="text"
								 class="form-control" name="expairydate"
									placeholder="Enter  Expairy Date">
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("expairydate", request)%></div>

							<div class="form-group">
								<label for="name">Cvv No</label> <input type="text"
									 class="form-control" name="cvvNo"
									placeholder="Enter Cvv No">
							</div>
							<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("cvvNo", request)%></div>


							<div class="container text-center mt-2">
							
								<input type="submit" class="btn btn-outline-success border-0"
									name="operation" value="<%=PaymentCtl.OP_PAYMENT_NOW%>">

								<a href="<%=CAMView.PAYMENT_LIST_CTL%>"
									class="btn btn-outline-primary border-0">Check Payment List</a>
							</div>

                         </form>
						</div>
						

					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="mt-4">
	<%@ include file="Footer.jsp"%>
	</div>
</body>
</html>