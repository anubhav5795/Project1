package in.co.clg.Ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.clg.Bean.BaseBean;
import in.co.clg.Bean.UserBean;
import in.co.clg.Model.UserModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.DataValidator;
import in.co.clg.Utility.PropertyReader;
import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "LoginCtl", urlPatterns = "/Login")
public class LoginCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SINGIN = "SignIn";
	public static final String OP_SING_UP = "SignUp";
	public static final String OP_LOGOUT = "Logout";

	public LoginCtl() {
		super();
	}

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		String op = request.getParameter("operation");

		if (OP_SING_UP.equalsIgnoreCase(op) || OP_LOGOUT.equalsIgnoreCase(op)) {
			return true;
		}
		if (DataValidator.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getvalue("error.require", "Email Id"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("Password"))) {
			request.setAttribute("Password", PropertyReader.getvalue("error.require", "Password"));
			pass = false;
		}
		return pass;
	}

	protected BaseBean populateBean(HttpServletRequest request) {
		UserBean bean = new UserBean();

		bean.setEmailId(DataUtility.getString(request.getParameter("email")));
		bean.setPassword(DataUtility.getString(request.getParameter("Password")));
		populateDTO(bean, request);
		return bean;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		HttpSession session = request.getSession(false);
		UserBean bean = (UserBean) populateBean(request);
		if (OP_LOGOUT.equalsIgnoreCase(op)) {
			session = request.getSession(false);
			session.invalidate();
			ServletUtility.setSuccessMessage("Logout Sucessfully !!", request);
			ServletUtility.forward(CAMView.LOGIN_VIEW, request, response);
			return;
		}
		ServletUtility.setbean(bean, request);
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String op = DataUtility.getString(request.getParameter("operation"));
		UserModel model = new UserModel();
		if (OP_SINGIN.equalsIgnoreCase(op)) {
			UserBean bean = (UserBean) populateBean(request);
			try {
				bean = model.Authenticate(bean.getEmailId(), bean.getPassword());

				if (bean.getRoleid()== 1) {
					if (bean != null) {
						session.setAttribute("user", bean);
						ServletUtility.setbean(bean, request);
						ServletUtility.redirect(CAMView.ADMIN_CTL, request, response);
						return;
					} else {
						bean = (UserBean) populateBean(request);
						ServletUtility.setbean(bean, request);
						ServletUtility.setErrorMessage("Invalid Email Id and Password??", request);
						ServletUtility.forward(getView(), request, response);
					}
				}else {
					if (bean != null) {
						session.setAttribute("user", bean);
						ServletUtility.setbean(bean, request);
						ServletUtility.redirect(CAMView.WELCOME_CTL, request, response);
						return;
					} else {
						bean = (UserBean) populateBean(request);
						ServletUtility.setbean(bean, request);
						ServletUtility.setErrorMessage("Invalid Email Id and Password??", request);
						ServletUtility.forward(getView(), request, response);
					}
				}
				

				
				
			} catch (Exception e) {
			}
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return CAMView.LOGIN_VIEW;
	}
}
