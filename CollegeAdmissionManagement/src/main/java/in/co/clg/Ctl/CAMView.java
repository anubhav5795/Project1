package in.co.clg.Ctl;

public interface CAMView {
	
	public String APP_CONTEXT = "/CollegeAdmissionManagement";
	public String PAGE_FOLDER = "/jsp";
	
	
	//Controller------------------------------
	public String WELCOME_CTL = APP_CONTEXT + "/welcome";
	public String LOGIN_CTL = APP_CONTEXT + "/Login";
	public String USER_REGISTRATION_CTL = APP_CONTEXT +  "/Registration";
	public String STUDENT_LIST_CTL = APP_CONTEXT + "/StudentListctl";
	public String ADMIN_CTL = APP_CONTEXT + "/Adminctl";
	public String COLLEGE_CTL = APP_CONTEXT + "/Collegectl";
	public String COURSE_CTL = APP_CONTEXT + "/Coursectl";
	public String COLLEGE_LIST_CTL = APP_CONTEXT + "/CollegeListctl";
	public String COURSE_LIST_CTL = APP_CONTEXT + "/CourseListctl";
    public String APPLY_COLLEGE_CTL = APP_CONTEXT + "/applyCollege";
    public String APPLY_COLLEGE_LIST_CTL = APP_CONTEXT + "/applyCollegeList";
    public String VIEW_STUDENT_DETAILS = APP_CONTEXT + "/viewStudentDetails";
    public String PAYMENT_CTL = APP_CONTEXT + "/paymentCtl";
    public String PAYMENT_LIST_CTL = APP_CONTEXT + "/paymentList";
    public String APPLICATION_CTL = APP_CONTEXT + "/ApplicationCtl";


	//View-------------------------------------
	public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";
	public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/RegistrationView.jsp";
	public String STUDENT_LIST_VIEW = PAGE_FOLDER + "/StudentList.jsp";
	public String ADMIN_VIEW = PAGE_FOLDER + "/Admin.jsp";
	public String COURSE_VIEW = PAGE_FOLDER + "/CourseView.jsp";
	public String COLLEGE_LIST_VIEW = PAGE_FOLDER + "/CollegeListView.jsp";
	public String COURSE_LIST_VIEW = PAGE_FOLDER + "/CourseListView.jsp";
    public String APPLY_COLLEGE_VIEW = PAGE_FOLDER + "/ApplyCollegeView.jsp";
    public String APPLY_COLLEGE_LIST_VIEW = PAGE_FOLDER + "/ApplyCollegeListView.jsp";
    public String VIEW_STUDENT_DETAILS_JSP = PAGE_FOLDER + "/ViewStudentDetails.jsp";
    public String PAYMENT_VIEW = PAGE_FOLDER + "/PaymentView.jsp";
    public String PAYMENT_LIST_VIEW = PAGE_FOLDER + "/PaymentList.jsp";
    
    
}
