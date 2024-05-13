package in.co.clg.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.clg.Bean.BaseBean;
import in.co.clg.Bean.CollegeBean;
import in.co.clg.Model.CollegeModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "CollegeListCtl",urlPatterns = "/CollegeListctl")
public class CollegeListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public CollegeListCtl() {
        super();
    }

    
    @Override
    protected BaseBean populateBean(HttpServletRequest request) {
		CollegeBean bean = new CollegeBean();
		
		bean.setCollegeName(DataUtility.getString(request.getParameter("collegeName")));
		bean.setCityName(DataUtility.getString(request.getParameter("city")));
		bean.setUniversityName(DataUtility.getString(request.getParameter("university")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));
		populateDTO(bean, request);
		return bean;
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CollegeModel model = new CollegeModel();
		CollegeBean bean = null;
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
		CollegeModel model = new CollegeModel();
		CollegeBean bean = new CollegeBean();
		bean = (CollegeBean) populateBean(request);
		List list = null;

		if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(CAMView.COLLEGE_LIST_CTL, request, response);
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
		return CAMView.COLLEGE_LIST_VIEW;
	}

}
