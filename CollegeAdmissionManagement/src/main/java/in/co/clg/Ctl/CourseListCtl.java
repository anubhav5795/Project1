package in.co.clg.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.clg.Bean.BaseBean;
import in.co.clg.Bean.CourseBean;
import in.co.clg.Model.CourseModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "CourseListCtl",urlPatterns = "/CourseListctl")
public class CourseListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public CourseListCtl() {
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
		populateDTO(bean, request);
		return bean;
	}
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	CourseModel model = new CourseModel();
		CourseBean bean = null;
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
		CourseModel model = new CourseModel();
		CourseBean bean = new CourseBean();
		bean = (CourseBean) populateBean(request);
		List list = null;

		if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(CAMView.COURSE_LIST_CTL, request, response);
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
		return CAMView.COURSE_LIST_VIEW;
	}
}
