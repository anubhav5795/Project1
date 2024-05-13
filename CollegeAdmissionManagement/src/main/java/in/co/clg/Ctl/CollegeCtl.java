package in.co.clg.Ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.clg.Bean.BaseBean;
import in.co.clg.Bean.CollegeBean;
import in.co.clg.Exception.ApplicationException;
import in.co.clg.Exception.DuplicateRecordException;
import in.co.clg.Model.CollegeModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "CollegeCtl",urlPatterns = "/Collegectl")
public class CollegeCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public CollegeCtl() {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CollegeModel model = new CollegeModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			CollegeBean bean = null;
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
		CollegeModel model = new CollegeModel();
   		String op = DataUtility.getString(request.getParameter("operation"));
   		long id = DataUtility.getLong(request.getParameter("id"));
   		CollegeBean bean = new CollegeBean();
   		bean = (CollegeBean) populateBean(request);
   		
   		if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(CAMView.ADMIN_CTL, request, response);
		}
   		
   		
   		if (OP_SAVE.equalsIgnoreCase(op)) {
   			bean = (CollegeBean) populateBean(request);
   			try {
   				long pk = model.add(bean);
   				ServletUtility.setbean(bean, request);
   				ServletUtility.setSuccessMessage("College Added Successfully !!", request);
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
		return CAMView.ADMIN_VIEW;
	}

}
