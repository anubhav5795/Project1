package in.co.clg.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.clg.Bean.PaymentBean;
import in.co.clg.Bean.UserBean;
import in.co.clg.Model.PaymentModel;
import in.co.clg.Utility.DataUtility;
import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "PaymentListCtl",urlPatterns = "/paymentList")
public class PaymentListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public PaymentListCtl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PaymentModel model = new PaymentModel();
		PaymentBean bean = new PaymentBean();
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
				list = model.studentpaymentlist(bean2.getId());
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
	}

	@Override
	protected String getView() {
		return CAMView.PAYMENT_LIST_VIEW;
	}

}
