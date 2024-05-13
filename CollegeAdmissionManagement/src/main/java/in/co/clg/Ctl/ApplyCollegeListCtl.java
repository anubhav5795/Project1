package in.co.clg.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.clg.Bean.ApplicationBean;
import in.co.clg.Bean.BaseBean;
import in.co.clg.Bean.UserBean;
import in.co.clg.Model.ApplicationModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "ApplyCollegeListCtl",urlPatterns = "/applyCollegeList")
public class ApplyCollegeListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public ApplyCollegeListCtl() {
        super();
    }
    
    @Override
	protected BaseBean populateBean(HttpServletRequest request) {
		ApplicationBean bean = new ApplicationBean();
		
		bean.setId(DataUtility.getLong(request.getParameter("id")));
        bean.setCollegeId(DataUtility.getLong(request.getParameter("collegeId")));	
        bean.setCourseId(DataUtility.getLong(request.getParameter("courseId")));
        bean.setApplicationNo(DataUtility.getString(request.getParameter("applicationNo")));
        bean.setEmailId(DataUtility.getString(request.getParameter("email")));
		bean.setFirstName(DataUtility.getString(request.getParameter("fName")));
		bean.setLastName(DataUtility.getString(request.getParameter("LName")));
		bean.setFatherName(DataUtility.getString(request.getParameter("fatherName")));
		bean.setMotherName(DataUtility.getString(request.getParameter("motherName")));
		bean.setPhoneNo(DataUtility.getLong(request.getParameter("phoneNo")));
		bean.setDOB(DataUtility.getString(request.getParameter("DOB")));
		bean.setGender(DataUtility.getString(request.getParameter("gender")));
		bean.setCategory(DataUtility.getString(request.getParameter("category")));
		bean.setNationality(DataUtility.getString(request.getParameter("nationality")));
		bean.setPincode(DataUtility.getLong(request.getParameter("pincode")));
		bean.setCorrespondenceAddress(DataUtility.getString(request.getParameter("correspondenceAddress")));
		bean.setAddress(DataUtility.getString(request.getParameter("permanentAddress")));
		bean.setBoard1(DataUtility.getString(request.getParameter("board1")));
		bean.setYear1(DataUtility.getString(request.getParameter("year1")));
		bean.setPercentange1(DataUtility.getString(request.getParameter("percentage1")));
		bean.setStream1(DataUtility.getString(request.getParameter("stream1")));
		bean.setBoard2(DataUtility.getString(request.getParameter("board2")));
		bean.setYear2(DataUtility.getString(request.getParameter("year2")));
		bean.setPercentange2(DataUtility.getString(request.getParameter("percentage2")));
		bean.setStream2(DataUtility.getString(request.getParameter("stream2")));
		bean.setDeclaration(DataUtility.getString(request.getParameter("declaration")));
		populateDTO(bean, request);
		return bean;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationModel model = new ApplicationModel();
		ApplicationBean bean = new ApplicationBean();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			model.delete(id);
			ServletUtility.setSuccessMessage("Data Deleted Successfully !!", request);
		}
		
		List list = null;
		HttpSession session = request.getSession(false);
    	UserBean bean2 = (UserBean) session.getAttribute("user");
    	long roleid = bean2.getRoleid();
    	if (roleid==2) {
    		try {
				list = model.Applicationlist(bean2.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else {
    		try {
				list = model.list();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		ApplicationModel model = new ApplicationModel();
		ApplicationBean bean = new ApplicationBean();
		bean = (ApplicationBean) populateBean(request);
		List list = null;

		if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(CAMView.APPLY_COLLEGE_LIST_CTL, request, response);
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
		return CAMView.APPLY_COLLEGE_LIST_VIEW;
	}

}
