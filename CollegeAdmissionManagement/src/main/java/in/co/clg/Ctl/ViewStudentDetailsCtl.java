package in.co.clg.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.clg.Bean.ApplicationBean;
import in.co.clg.Bean.BaseBean;
import in.co.clg.Model.ApplicationModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "ViewStudentDetailsCtl", urlPatterns = "/viewStudentDetails")
public class ViewStudentDetailsCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	public ViewStudentDetailsCtl() {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApplicationModel model = new ApplicationModel();
		ApplicationBean bean = (ApplicationBean) populateBean(request);

		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			try {
				bean = model.findByPk(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ServletUtility.setbean(bean, request);
		}

		long Sid = DataUtility.getLong(request.getParameter("Sid"));
		if (Sid > 0) {
			try {
				long i = model.Selected("Selected", Sid);
				ServletUtility.setSuccessMessage("Admin Remark And Application Selected", request);
				ServletUtility.forward(getView(), request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long Rid = DataUtility.getLong(request.getParameter("Rid"));
		if (Rid > 0) {
			try {
				long i = model.Rejected("Rejected", Rid);
				ServletUtility.setSuccessMessage("Admin Remark And Application Rejected", request);
				ServletUtility.forward(getView(), request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List list = null;
		try {
			list = model.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletUtility.setList(list, request);
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected String getView() {
		return CAMView.VIEW_STUDENT_DETAILS_JSP;
	}

}
