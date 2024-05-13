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
import in.co.clg.Exception.ApplicationException;
import in.co.clg.Exception.DuplicateRecordException;
import in.co.clg.Model.ApplicationModel;
import in.co.clg.Model.CollegeModel;
import in.co.clg.Model.CourseModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "ApplyCollegeCtl",urlPatterns = "/applyCollege")
public class ApplyCollegeCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public ApplyCollegeCtl() {
        super();
    }
    
    @Override
   	protected void preload(HttpServletRequest request) {
   		CourseModel model = new CourseModel();
   		CollegeModel cModel = new CollegeModel();
   		try {
   			List list =  model.list();
   			List cList = cModel.list();
   			
   			request.setAttribute("courseList", list);
   			request.setAttribute("CollegeList", cList);
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
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
		HttpSession session = request.getSession(false);
		UserBean existBean = (UserBean)session.getAttribute("user");
		Long userId = existBean.getId();
		bean.setUserID(userId);
		bean.setStatus("Processing");
		bean.setPayment("pay");
		populateDTO(bean, request);
		return bean;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ApplicationModel model = new ApplicationModel();
   		String op = DataUtility.getString(request.getParameter("operation"));
   		long id = DataUtility.getLong(request.getParameter("id"));
   		ApplicationBean bean = new ApplicationBean();
   		bean = (ApplicationBean) populateBean(request);
   		
   		if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(CAMView.APPLY_COLLEGE_CTL, request, response);
		}
   		
   		if (OP_SUBMIT.equalsIgnoreCase(op)) {
   			bean = (ApplicationBean) populateBean(request);
   			try {
   				long pk = model.add(bean);
   				ServletUtility.setbean(bean, request);
   				ServletUtility.setSuccessMessage("Admission Application Form Successfully Submit !!", request);
   				ServletUtility.forward(getView(), request, response);
   				return;
   			} catch (DuplicateRecordException e) {
   				ServletUtility.setbean(bean, request);
   				ServletUtility.setErrorMessage(e.getMessage(), request);
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
		return CAMView.APPLY_COLLEGE_VIEW;
	}

}
