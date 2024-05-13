package in.co.clg.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.clg.Bean.BaseBean;
import in.co.clg.Bean.CourseBean;
import in.co.clg.Exception.ApplicationException;
import in.co.clg.Exception.DuplicateRecordException;
import in.co.clg.Model.CollegeModel;
import in.co.clg.Model.CourseModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "CourseCtl",urlPatterns = "/Coursectl")
public class CourseCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void preload(HttpServletRequest request) {
		CollegeModel model = new CollegeModel();
		try {
			List list =  model.list();
			request.setAttribute("collegeList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CourseCtl() {
        super();
    }

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		CourseBean bean = new CourseBean();
		bean.setCourseID(DataUtility.getString(request.getParameter("cID")));
		bean.setCourseName(DataUtility.getString(request.getParameter("courseName")));
		bean.setCourseFees(DataUtility.getLong(request.getParameter("courseFees")));
		bean.setCourseSeat(DataUtility.getLong(request.getParameter("courseSeat")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));
//		bean.setCollegeID(DataUtility.getLong(request.getParameter("collegeId")));
//		System.out.println("collge : "+ request.getParameter("collegeId"));
		populateDTO(bean, request);
		return bean;
	}




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseModel model = new CourseModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			CourseBean bean = null;
			try {
				bean = model.findByPk(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ServletUtility.setbean(bean, request);
		}
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		CourseModel model = new CourseModel();
		CourseBean bean = new CourseBean();
		
		bean = (CourseBean) populateBean(request);
		if (OP_SAVE.equalsIgnoreCase(op)) {
		  try {
			long pk = 	model.add(bean);
			ServletUtility.setbean(bean, request);
			ServletUtility.setSuccessMessage("Course Added Successfully !!", request);
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
 		}else {
 			try {
 			long pk = model.Update(bean);
 			ServletUtility.setbean(bean, request);
			ServletUtility.setSuccessMessage("Course Updated Successfully !!", request);
			ServletUtility.forward(getView(), request, response);
			return;
			} catch (Exception e) {
				e.printStackTrace();
			}
 		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return CAMView.COURSE_VIEW;
	}

}
