package in.co.clg.Bean;

public class PaymentBean extends BaseBean {
	
	
	private long courseFees;
	private String cardNo;
	private String expairyDate;
	private int cvv;
	private String status;
	private long userId;
	private String email;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(long courseFees) {
		this.courseFees = courseFees;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpairyDate() {
		return expairyDate;
	}

	public void setExpairyDate(String expairyDate) {
		this.expairyDate = expairyDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
