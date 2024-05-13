package in.co.clg.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.clg.Bean.ApplicationBean;
import in.co.clg.Bean.CollegeBean;
import in.co.clg.Bean.CourseBean;
import in.co.clg.Bean.UserBean;
import in.co.clg.Exception.ApplicationException;
import in.co.clg.Exception.DuplicateRecordException;
import in.co.clg.Utility.JDBCDataSource;

public class ApplicationModel {
	
	
	public Integer nextPk() throws Exception {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM application");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public ApplicationBean findByEmail(String email) throws Exception {
		ApplicationBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM application WHERE email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ApplicationBean();
				bean.setId(rs.getLong(1));
				bean.setApplicationNo(rs.getString(2));
				bean.setCourseId(rs.getLong(3));
				bean.setCourseName(rs.getString(4));
				bean.setCollegeId(rs.getLong(5));
				bean.setCollegeName(rs.getString(6));
				bean.setEmailId(rs.getString(7));
				bean.setFirstName(rs.getString(8));
				bean.setLastName(rs.getString(9));
				bean.setFatherName(rs.getString(10));
				bean.setMotherName(rs.getString(11));
				bean.setPhoneNo(rs.getLong(12));
				bean.setGender(rs.getString(13));
				bean.setDOB(rs.getString(14));
				bean.setCategory(rs.getString(15));
				bean.setNationality(rs.getString(16));
				bean.setPincode(rs.getLong(17));
				bean.setCorrespondenceAddress(rs.getString(18));
				bean.setAddress(rs.getString(19));
				bean.setBoard1(rs.getString(20));
				bean.setYear1(rs.getString(21));
				bean.setPercentange1(rs.getString(22));
				bean.setStream1(rs.getString(23));
				bean.setBoard2(rs.getString(24));
				bean.setYear2(rs.getString(25));
				bean.setPercentange2(rs.getString(26));
				bean.setStream2(rs.getString(27));
				bean.setDeclaration(rs.getString(28));
				bean.setStatus(rs.getString(29));
				bean.setUserID(rs.getLong(30));
				bean.setCourseFees(rs.getLong(31));
				bean.setPayment(rs.getString(32));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	
	public ApplicationBean findByApplicationNo(String ApplicationNo) throws Exception {
		ApplicationBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM application WHERE applicationId=?");
			ps.setString(1, ApplicationNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ApplicationBean();
				bean.setId(rs.getLong(1));
				bean.setApplicationNo(rs.getString(2));
				bean.setCourseId(rs.getLong(3));
				bean.setCourseName(rs.getString(4));
				bean.setCollegeId(rs.getLong(5));
				bean.setCollegeName(rs.getString(6));
				bean.setEmailId(rs.getString(7));
				bean.setFirstName(rs.getString(8));
				bean.setLastName(rs.getString(9));
				bean.setFatherName(rs.getString(10));
				bean.setMotherName(rs.getString(11));
				bean.setPhoneNo(rs.getLong(12));
				bean.setGender(rs.getString(13));
				bean.setDOB(rs.getString(14));
				bean.setCategory(rs.getString(15));
				bean.setNationality(rs.getString(16));
				bean.setPincode(rs.getLong(17));
				bean.setCorrespondenceAddress(rs.getString(18));
				bean.setAddress(rs.getString(19));
				bean.setBoard1(rs.getString(20));
				bean.setYear1(rs.getString(21));
				bean.setPercentange1(rs.getString(22));
				bean.setStream1(rs.getString(23));
				bean.setBoard2(rs.getString(24));
				bean.setYear2(rs.getString(25));
				bean.setPercentange2(rs.getString(26));
				bean.setStream2(rs.getString(27));
				bean.setDeclaration(rs.getString(28));
				bean.setStatus(rs.getString(29));
				bean.setUserID(rs.getLong(30));
				bean.setCourseFees(rs.getLong(31));
				bean.setPayment(rs.getString(32));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	
	public ApplicationBean findByPk(long pk) throws Exception {
		ApplicationBean bean = null;
		Connection conn = null;
		
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM application WHERE id=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ApplicationBean();
				bean.setId(rs.getLong(1));
				bean.setApplicationNo(rs.getString(2));
				bean.setCourseId(rs.getLong(3));
				bean.setCourseName(rs.getString(4));
				bean.setCollegeId(rs.getLong(5));
				bean.setCollegeName(rs.getString(6));
				bean.setEmailId(rs.getString(7));
				bean.setFirstName(rs.getString(8));
				bean.setLastName(rs.getString(9));
				bean.setFatherName(rs.getString(10));
				bean.setMotherName(rs.getString(11));
				bean.setPhoneNo(rs.getLong(12));
				bean.setGender(rs.getString(13));
				bean.setDOB(rs.getString(14));
				bean.setCategory(rs.getString(15));
				bean.setNationality(rs.getString(16));
				bean.setPincode(rs.getLong(17));
				bean.setCorrespondenceAddress(rs.getString(18));
				bean.setAddress(rs.getString(19));
				bean.setBoard1(rs.getString(20));
				bean.setYear1(rs.getString(21));
				bean.setPercentange1(rs.getString(22));
				bean.setStream1(rs.getString(23));
				bean.setBoard2(rs.getString(24));
				bean.setYear2(rs.getString(25));
				bean.setPercentange2(rs.getString(26));
				bean.setStream2(rs.getString(27));
				bean.setDeclaration(rs.getString(28));
				bean.setStatus(rs.getString(29));
				bean.setUserID(rs.getLong(30));
				bean.setCourseFees(rs.getLong(31));
				bean.setPayment(rs.getString(32));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	
	
	public long add(ApplicationBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;

//		ApplicationBean existbean = findByEmail(bean.getEmailId());
//		if (existbean != null) {
//			throw new DuplicateRecordException("This User already Submited Form");
//		}
		
		ApplicationBean appbean = findByApplicationNo(bean.getApplicationNo());
		if (appbean != null) {
			throw new DuplicateRecordException("This Application No. Already Exist");
		}
		
		CollegeModel model = new CollegeModel();
		CollegeBean cBean = new CollegeBean();
		cBean = model.findByPk(bean.getCollegeId());
		String CollegeName = cBean.getCollegeName();
		

		CourseModel cmodel = new CourseModel();
		CourseBean courseBean = new CourseBean();
		courseBean = cmodel.findByPk(bean.getCourseId());
		String CourseName = courseBean.getCourseName();
		
		long courseFees = courseBean.getCourseFees();
		
		
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO application VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
		    ps.setString(2, bean.getApplicationNo());
		    ps.setLong(3, bean.getCourseId());
		    ps.setString(4, CourseName);
		    ps.setLong(5, bean.getCollegeId());
		    ps.setString(6, CollegeName);
		    ps.setString(7, bean.getEmailId());
		    ps.setString(8, bean.getFirstName());
		    ps.setString(9, bean.getLastName());
		    ps.setString(10, bean.getFatherName());
		    ps.setString(11, bean.getMotherName());
		    ps.setLong(12, bean.getPhoneNo());
		    ps.setString(13, bean.getGender());
		    ps.setString(14, bean.getDOB());
		    ps.setString(15, bean.getCategory());
		    ps.setString(16, bean.getNationality());
		    ps.setLong(17, bean.getPincode());
		    ps.setString(18, bean.getCorrespondenceAddress());
		    ps.setString(19, bean.getAddress());
		    ps.setString(20, bean.getBoard1());
		    ps.setString(21, bean.getYear1());
		    ps.setString(22, bean.getPercentange1());
		    ps.setString(23, bean.getStream1());
		    ps.setString(24, bean.getBoard2());
		    ps.setString(25, bean.getYear2());
		    ps.setString(26, bean.getPercentange2());
		    ps.setString(27, bean.getStream2());
		    ps.setString(28, bean.getDeclaration());
		    ps.setString(29, bean.getStatus());
		    ps.setLong(30, bean.getUserID());
		    ps.setLong(31, courseFees);
		    ps.setString(32, bean.getPayment());
			ps.executeUpdate();
			conn.commit();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + e.getMessage());
			}
		} finally {
			JDBCDataSource.closeconnection(conn);
		}
		return pk;
	}
	
	public List list() throws Exception {
		ArrayList list = new ArrayList();
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from application");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ApplicationBean bean = new ApplicationBean();
			bean.setId(rs.getLong(1));
			bean.setApplicationNo(rs.getString(2));
			bean.setCourseId(rs.getLong(3));
			bean.setCourseName(rs.getString(4));
			bean.setCollegeId(rs.getLong(5));
			bean.setCollegeName(rs.getString(6));
			bean.setEmailId(rs.getString(7));
			bean.setFirstName(rs.getString(8));
			bean.setLastName(rs.getString(9));
			bean.setFatherName(rs.getString(10));
			bean.setMotherName(rs.getString(11));
			bean.setPhoneNo(rs.getLong(12));
			bean.setGender(rs.getString(13));
			bean.setDOB(rs.getString(14));
			bean.setCategory(rs.getString(15));
			bean.setNationality(rs.getString(16));
			bean.setPincode(rs.getLong(17));
			bean.setCorrespondenceAddress(rs.getString(18));
			bean.setAddress(rs.getString(19));
			bean.setBoard1(rs.getString(20));
			bean.setYear1(rs.getString(21));
			bean.setPercentange1(rs.getString(22));
			bean.setStream1(rs.getString(23));
			bean.setBoard2(rs.getString(24));
			bean.setYear2(rs.getString(25));
			bean.setPercentange2(rs.getString(26));
			bean.setStream2(rs.getString(27));
			bean.setDeclaration(rs.getString(28));
			bean.setStatus(rs.getString(29));
			bean.setUserID(rs.getLong(30));
			bean.setCourseFees(rs.getLong(31));
			bean.setPayment(rs.getString(32));
			list.add(bean);
		}
		return list;
	}
	
	public List Applicationlist(long userId) throws Exception {
		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from application where userId=?");
		pstmt.setLong(1, userId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ApplicationBean bean = new ApplicationBean();
			bean.setId(rs.getLong(1));
			bean.setApplicationNo(rs.getString(2));
			bean.setCourseId(rs.getLong(3));
			bean.setCourseName(rs.getString(4));
			bean.setCollegeId(rs.getLong(5));
			bean.setCollegeName(rs.getString(6));
			bean.setEmailId(rs.getString(7));
			bean.setFirstName(rs.getString(8));
			bean.setLastName(rs.getString(9));
			bean.setFatherName(rs.getString(10));
			bean.setMotherName(rs.getString(11));
			bean.setPhoneNo(rs.getLong(12));
			bean.setGender(rs.getString(13));
			bean.setDOB(rs.getString(14));
			bean.setCategory(rs.getString(15));
			bean.setNationality(rs.getString(16));
			bean.setPincode(rs.getLong(17));
			bean.setCorrespondenceAddress(rs.getString(18));
			bean.setAddress(rs.getString(19));
			bean.setBoard1(rs.getString(20));
			bean.setYear1(rs.getString(21));
			bean.setPercentange1(rs.getString(22));
			bean.setStream1(rs.getString(23));
			bean.setBoard2(rs.getString(24));
			bean.setYear2(rs.getString(25));
			bean.setPercentange2(rs.getString(26));
			bean.setStream2(rs.getString(27));
			bean.setDeclaration(rs.getString(28));
			bean.setStatus(rs.getString(29));
			bean.setUserID(rs.getLong(30));
			bean.setCourseFees(rs.getLong(31));
			bean.setPayment(rs.getString(32));
			list.add(bean);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE from application where id=?");
			stmt.setLong(1, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public List search(ApplicationBean bean) throws Exception {
		StringBuffer sql = new StringBuffer("SELECT * from application WHERE 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getApplicationNo() != null && bean.getApplicationNo().length() > 0) {
				sql.append(" AND applicationId like '" + bean.getApplicationNo() + "%'");
			}
		}

		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new ApplicationBean();
				bean.setId(rs.getLong(1));
				bean.setApplicationNo(rs.getString(2));
				bean.setCourseId(rs.getLong(3));
				bean.setCourseName(rs.getString(4));
				bean.setCollegeId(rs.getLong(5));
				bean.setCollegeName(rs.getString(6));
				bean.setEmailId(rs.getString(7));
				bean.setFirstName(rs.getString(8));
				bean.setLastName(rs.getString(9));
				bean.setFatherName(rs.getString(10));
				bean.setMotherName(rs.getString(11));
				bean.setPhoneNo(rs.getLong(12));
				bean.setGender(rs.getString(13));
				bean.setDOB(rs.getString(14));
				bean.setCategory(rs.getString(15));
				bean.setNationality(rs.getString(16));
				bean.setPincode(rs.getLong(17));
				bean.setCorrespondenceAddress(rs.getString(18));
				bean.setAddress(rs.getString(19));
				bean.setBoard1(rs.getString(20));
				bean.setYear1(rs.getString(21));
				bean.setPercentange1(rs.getString(22));
				bean.setStream1(rs.getString(23));
				bean.setBoard2(rs.getString(24));
				bean.setYear2(rs.getString(25));
				bean.setPercentange2(rs.getString(26));
				bean.setStream2(rs.getString(27));
				bean.setDeclaration(rs.getString(28));
				bean.setStatus(rs.getString(29));
				bean.setUserID(rs.getLong(30));
				bean.setCourseFees(rs.getLong(31));
				bean.setPayment(rs.getString(32));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {

		} finally {
			JDBCDataSource.closeconnection(conn);
		}
		return list;
	}
	
	public long Update(String status,long id) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update application set status='" + status + "' where id=?");
			//ps.setString(1, bean.getStatus());
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	
	public long Selected(String status, long Sid) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("update application set status='" + status + "'  where id=?");
			ps.setLong(1, Sid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	
	public long Rejected(String status, long Rid) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update application set status='" + status + "' where id=?");
			ps.setLong(1, Rid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	
	public long Payment(String payment, long Pid) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("update application set payment='" + payment + "'  where id=?");
			ps.setLong(1, Pid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}

}
