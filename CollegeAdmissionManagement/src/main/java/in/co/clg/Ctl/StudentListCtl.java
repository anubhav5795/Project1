package in.co.clg.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.clg.Bean.BaseBean;
import in.co.clg.Bean.UserBean;
import in.co.clg.Model.UserModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.ServletUtility;


@WebServlet(name = "StudentListCtl",urlPatterns = "/StudentListctl")
public class StudentListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public StudentListCtl() {
        super();
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
		UserModel model = new UserModel();
		UserBean bean = null;
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			model.delete(id);
			ServletUtility.setSuccessMessage("Data Deleted Successfully !!", request);
		}
		List list = null;
		try {
			list = model.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list == null && list.size() == 0) {
			ServletUtility.setErrorMessage("No record found", request);
		}
		ServletUtility.setList(list, request);
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean = (UserBean) populateBean(request);
		List list = null;

		if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(CAMView.STUDENT_LIST_CTL, request, response);
			return;
		}
		
		if (OP_SEARCH.equalsIgnoreCase(op)) {
			try {
				list = model.search(bean);
				ServletUtility.setList(list, request);
				ServletUtility.setbean(bean, request);

			} catch (Exception e) {
				e.printStackTrace();
			}
			ServletUtility.forward(getView(), request, response);
		}
	}

	@Override
	protected String getView() {
		return CAMView.STUDENT_LIST_VIEW;
	}

}
