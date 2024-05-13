package in.co.clg.Ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.clg.Utility.ServletUtility;

@WebServlet(name = "WelcomeCtl" ,urlPatterns = "/welcome")
public class WelcomeCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
   
    public WelcomeCtl() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ServletUtility.forward(getView(), request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	@Override
	protected String getView() {
		return CAMView.WELCOME_VIEW;
	}

}