package in.co.clg.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.clg.Bean.UserBean;
import in.co.clg.Exception.ApplicationException;
import in.co.clg.Exception.DuplicateRecordException;
import in.co.clg.Utility.JDBCDataSource;

public class UserModel {
	
	public Integer nextPk() throws Exception {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM USER");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public UserBean findByEmail(String email) throws Exception {
		UserBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setFatherName(rs.getString(4));
				bean.setMotherName(rs.getString(5));
				bean.setEmailId(rs.getString(6));
				bean.setPassword(rs.getString(7));
				bean.setPhoneNo(rs.getLong(8));
				bean.setGender(rs.getString(9));
				bean.setDOB(rs.getDate(10));
				bean.setAddress(rs.getString(11));
				bean.setRoleid(rs.getLong(12));
				bean.setRoleName(rs.getString(13));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bean;
	}

	public UserBean findByPk(long pk) throws Exception {
		UserBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE id=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setFatherName(rs.getString(4));
				bean.setMotherName(rs.getString(5));
				bean.setEmailId(rs.getString(6));
				bean.setPassword(rs.getString(7));
				bean.setPhoneNo(rs.getLong(8));
				bean.setGender(rs.getString(9));
				bean.setDOB(rs.getDate(10));
				bean.setAddress(rs.getString(11));
				bean.setRoleid(rs.getLong(12));
				bean.setRoleName(rs.getString(13));

			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public UserBean Authenticate(String Email, String Password) throws Exception {
		UserBean bean = null;
		Connection conn = null;

		conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE email =? AND password =?");
		ps.setString(1, Email);
		ps.setString(2, Password);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setFatherName(rs.getString(4));
			bean.setMotherName(rs.getString(5));
			bean.setEmailId(rs.getString(6));
			bean.setPassword(rs.getString(7));
			bean.setPhoneNo(rs.getLong(8));
			bean.setGender(rs.getString(9));
			bean.setDOB(rs.getDate(10));
			bean.setAddress(rs.getString(11));
			bean.setRoleid(rs.getLong(12));
			bean.setRoleName(rs.getString(13));
		}
		return bean;
	}

public long add(UserBean bean) throws Exception {
	Connection conn = null;
	int pk = 0;

	UserModel model = new UserModel();
	UserBean existbean = findByEmail(bean.getEmailId());
	if (existbean != null) {
		throw new DuplicateRecordException("Email Id already Exist");
	}

	try {
		conn = JDBCDataSource.getConnection();
		pk = nextPk();
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("INSERT INTO USER VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setLong(1, pk);
	    ps.setString(2, bean.getFirstName());
	    ps.setString(3, bean.getLastName());
	    ps.setString(4, bean.getFatherName());
	    ps.setString(5, bean.getMotherName());
		ps.setString(6, bean.getEmailId());
		ps.setString(7, bean.getPassword());
		ps.setLong(8, bean.getPhoneNo());
		ps.setString(9, bean.getGender());
		ps.setDate(10, new Date(bean.getDOB().getTime()));
		ps.setString(11, bean.getAddress());
		ps.setLong(12, bean.getRoleid());
		ps.setString(13, bean.getRoleName());
		ps.executeUpdate();
		conn.commit();
		ps.close();
	} catch (Exception e) {
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
	PreparedStatement pstmt = conn.prepareStatement("SELECT * from user");
	ResultSet rs = pstmt.executeQuery();
	while (rs.next()) {
		UserBean bean = new UserBean();
		bean.setId(rs.getLong(1));
		bean.setFirstName(rs.getString(2));
		bean.setLastName(rs.getString(3));
		bean.setFatherName(rs.getString(4));
		bean.setMotherName(rs.getString(5));
		bean.setEmailId(rs.getString(6));
		bean.setPassword(rs.getString(7));
		bean.setPhoneNo(rs.getLong(8));
		bean.setGender(rs.getString(9));
		bean.setDOB(rs.getDate(10));
		bean.setAddress(rs.getString(11));
		bean.setRoleid(rs.getLong(12));
		bean.setRoleName(rs.getString(13));
		list.add(bean);
	}
	return list;
}
public static long delete(long id) {
	int i = 0;
	try {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("DELETE from USER where id=?");
		stmt.setLong(1, id);
		i = stmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}

public long Update(UserBean bean) {
	int pk = 0;
	try {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"update USER set userName=?, emailId=?, password=?, repeatPassword=?, phoneNo=?,gender=?,roleid=?,roleName=? where id=?");
		ps.setLong(1, pk);
	    ps.setString(2, bean.getFirstName());
	    ps.setString(3, bean.getLastName());
	    ps.setString(4, bean.getFatherName());
	    ps.setString(5, bean.getMotherName());
		ps.setString(6, bean.getEmailId());
		ps.setString(7, bean.getPassword());
		ps.setLong(8, bean.getPhoneNo());
		ps.setString(9, bean.getGender());
		ps.setDate(10, new Date(bean.getDOB().getTime()));
		ps.setString(11, bean.getAddress());
		ps.setLong(12, bean.getRoleid());
		ps.setString(13, bean.getRoleName());
		    ps.setLong(9, bean.getId());
		    ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return pk;
}


public List search(UserBean bean) throws Exception {
	StringBuffer sql = new StringBuffer("SELECT * from USER WHERE 1=1");
	if (bean != null) {
		if (bean.getId() > 0) {
			sql.append(" AND id = " + bean.getId());
		}
		if (bean.getEmailId() != null && bean.getEmailId().length() > 0) {
			sql.append(" AND email like '" + bean.getEmailId() + "%'");
		}
	}

	ArrayList list = new ArrayList();
	Connection conn = null;
	try {
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getLong(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setFatherName(rs.getString(4));
			bean.setMotherName(rs.getString(5));
			bean.setEmailId(rs.getString(6));
			bean.setPassword(rs.getString(7));
			bean.setPhoneNo(rs.getLong(8));
			bean.setGender(rs.getString(9));
			bean.setDOB(rs.getDate(10));
			bean.setAddress(rs.getString(11));
			bean.setRoleid(rs.getLong(12));
			bean.setRoleName(rs.getString(13));
			list.add(bean);
		}
		rs.close();
	} catch (Exception e) {

	} finally {
		JDBCDataSource.closeconnection(conn);
	}

	return list;

}

}
