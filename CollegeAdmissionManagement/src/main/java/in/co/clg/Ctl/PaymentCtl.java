package in.co.clg.Ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.clg.Bean.BaseBean;
import in.co.clg.Bean.PaymentBean;
import in.co.clg.Bean.UserBean;
import in.co.clg.Exception.ApplicationException;
import in.co.clg.Exception.DuplicateRecordException;
import in.co.clg.Model.ApplicationModel;
import in.co.clg.Model.PaymentModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.DataValidator;
import in.co.clg.Utility.PropertyReader;
import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "PaymentCtl",urlPatterns = "/paymentCtl")
public class PaymentCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	
	public static final String 	OP_PAYMENT_NOW = "Payment Now";
	public static final String 	OP_PAYMENT_CHECK = "Payment Check";
       
    public PaymentCtl() {
        super();
    }
    
    @Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		String op = request.getParameter("operation");

		if (DataValidator.isNull(request.getParameter("cardNo"))) {
			request.setAttribute("cardNo", PropertyReader.getvalue("error.require", "Card No"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("expairydate"))) {
			request.setAttribute("expairydate", PropertyReader.getvalue("error.require", "Expairy Date"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("cvvNo"))) {
			request.setAttribute("cvvNo", PropertyReader.getvalue("error.require", "CVV"));
			pass = false;
		}
		return pass;
	}

	protected BaseBean populateBean(HttpServletRequest request) {
		PaymentBean bean = new PaymentBean();

		bean.setCourseFees(DataUtility.getLong(request.getParameter("courseFess")));
		bean.setCardNo(DataUtility.getString(request.getParameter("cardNo")));
		bean.setExpairyDate(DataUtility.getString(request.getParameter("expairydate")));
		bean.setCvv(DataUtility.getInt(request.getParameter("cvvNo")));
		HttpSession session = request.getSession(false);
		UserBean existBean = (UserBean)session.getAttribute("user");
		Long userId = existBean.getId();
		bean.setUserId(userId);
		bean.setStatus("Paid");
		populateDTO(bean, request);
		return bean;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaymentBean bean = new PaymentBean();
		ApplicationModel model = new ApplicationModel();
		long Pid = DataUtility.getLong(request.getParameter("Pid"));
		if (Pid > 0) {
			try {
				long i = model.Payment("Paid", Pid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		long courseFees = DataUtility.getLong(request.getParameter("courseFees"));
		bean.setCourseFees(courseFees);
		ServletUtility.setbean(bean, request);
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PaymentModel model = new PaymentModel();
   		String op = DataUtility.getString(request.getParameter("operation"));
   		long id = DataUtility.getLong(request.getParameter("id"));
   		PaymentBean bean = new PaymentBean();
   		bean = (PaymentBean) populateBean(request);
   		
   		if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(CAMView.PAYMENT_CTL, request, response);
		}
   		
   		if (OP_PAYMENT_NOW.equalsIgnoreCase(op)) {
   			bean = (PaymentBean) populateBean(request);
   			try {
   				long pk = model.add(bean);
   				ServletUtility.setbean(bean, request);
   				ServletUtility.setSuccessMessage("Payment Successfully Done !!", request);
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
		return CAMView.PAYMENT_VIEW;
	}

}
