package in.co.clg.Ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.clg.Bean.BaseBean;
import in.co.clg.Bean.UserBean;
import in.co.clg.Exception.ApplicationException;
import in.co.clg.Exception.DuplicateRecordException;
import in.co.clg.Model.UserModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.DataValidator;
import in.co.clg.Utility.PropertyReader;
import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "RegistrationCtl" ,urlPatterns = "/Registration")
public class RegistrationCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationCtl() {
        super();
    }

    @Override
   	protected boolean validate(HttpServletRequest request) {
   		boolean pass = true;

   		if(DataValidator.isNull(request.getParameter("fName"))) {
   			request.setAttribute("fName", PropertyReader.getvalue("error.require", "fName"));
   			pass = false;
   		}
   		if(DataValidator.isNull(request.getParameter("lName"))) {
   			request.setAttribute("lName", PropertyReader.getvalue("error.require", "lName"));
   			pass = false;
   		}
   		if(DataValidator.isNull(request.getParameter("fatherName"))) {
   			request.setAttribute("fatherName", PropertyReader.getvalue("error.require", "fatherName"));
   			pass = false;
   		}
   		if(DataValidator.isNull(request.getParameter("motherName"))) {
   			request.setAttribute("motherName", PropertyReader.getvalue("error.require", "motherName"));
   			pass = false;
   		}

   		if (DataValidator.isNull(request.getParameter("email"))) {
   			request.setAttribute("email", PropertyReader.getvalue("error.require", "Email Id"));
   			pass = false;

   		} else if (!DataValidator.isEmail(request.getParameter("email"))) {
   			request.setAttribute("email", PropertyReader.getvalue("error.login", "Email Id"));
   			pass = false;
   		}

   		if (DataValidator.isNull(request.getParameter("password"))) {
   			request.setAttribute("password", PropertyReader.getvalue("error.require", "Password"));
   			pass = false;
   		}
   		else if (!DataValidator.isPassword(request.getParameter("password"))) {
   			request.setAttribute("password", PropertyReader.getvalue("error.password", "Password"));
   			return false;
   		}

   		if(DataValidator.isNull(request.getParameter("phoneNo"))) {
   			request.setAttribute("phoneNo", PropertyReader.getvalue("error.require", "Phone No"));
   			pass = false;
   		}
   		if(DataValidator.isNull(request.getParameter("gender"))) {
   			request.setAttribute("gender", PropertyReader.getvalue("error.require", "Gender"));
   			pass = false;
   		}
   		if(DataValidator.isNull(request.getParameter("Address"))) {
   			request.setAttribute("Address", PropertyReader.getvalue("error.require", "Address"));
   			pass = false;
   		}
   		
   		return pass;
   	}
       
       protected BaseBean populateBean(HttpServletRequest request) {
   		UserBean bean = new UserBean();

   		bean.setId(DataUtility.getLong(request.getParameter("id")));
   		bean.setFirstName(DataUtility.getString(request.getParameter("fName")));
   		bean.setLastName(DataUtility.getString(request.getParameter("lName")));
   		bean.setFatherName(DataUtility.getString(request.getParameter("fatherName")));
   		bean.setMotherName(DataUtility.getString(request.getParameter("motherName")));
   		bean.setAddress(DataUtility.getString(request.getParameter("Address")));
   		bean.setEmailId(DataUtility.getString(request.getParameter("email")));
   		bean.setPassword(DataUtility.getString(request.getParameter("password")));
   		bean.setPhoneNo(DataUtility.getLong(request.getParameter("phoneNo")));
   		bean.setGender(DataUtility.getString(request.getParameter("gender")));
   		bean.setDOB(DataUtility.getDate(request.getParameter("dob")));
   		bean.setRoleid(2);
   		bean.setRoleName("Student");
   		populateDTO(bean, request);
   		return bean;

   	}
       
   	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		 ServletUtility.forward(getView(), request, response);
   	}

   	
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		UserModel model = new UserModel();
   		String op = DataUtility.getString(request.getParameter("operation"));
   		long id = DataUtility.getLong(request.getParameter("id"));
   		UserBean bean = new UserBean();
   		bean = (UserBean) populateBean(request);
   		
   		if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(CAMView.USER_REGISTRATION_CTL, request, response);
		}
   		
   		if (OP_REGISTER.equalsIgnoreCase(op)) {
   			bean = (UserBean) populateBean(request);
   			try {
   				long pk = model.add(bean);
   				ServletUtility.setbean(bean, request);
   				ServletUtility.setSuccessMessage("Student Successfully Registered !!", request);
   				ServletUtility.forward(getView(), request, response);
   				return;
   			} catch (DuplicateRecordException e) {
   				ServletUtility.setbean(bean, request);
   				ServletUtility.setErrorMessage(e.getMessage(), request);
   				ServletUtility.forward(getView(), request, response);
   			} catch (ApplicationException e) {
   				e.printStackTrace();
   			} catch (Exception e) {
   				e.printStackTrace();
   			}
   			ServletUtility.forward(getView(), request, response);
   		}
   	}


   	@Override
   	protected String getView() {
   		return CAMView.USER_REGISTRATION_VIEW;
   	}

}
