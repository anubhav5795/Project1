package in.co.clg.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.clg.Bean.CollegeBean;
import in.co.clg.Bean.PaymentBean;
import in.co.clg.Bean.UserBean;
import in.co.clg.Exception.ApplicationException;
import in.co.clg.Utility.JDBCDataSource;

public class PaymentModel {

	public Integer nextPk() throws Exception {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM payment");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(PaymentBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;
		
		UserModel  model = new UserModel();
		UserBean userBean = new UserBean();
		userBean = model.findByPk(bean.getUserId());
		String email = userBean.getEmailId();

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO payment VALUES(?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setLong(2, bean.getCourseFees());
			ps.setString(3, bean.getCardNo());
			ps.setString(4, bean.getExpairyDate());
			ps.setInt(5, bean.getCvv());
			ps.setString(6, bean.getStatus());
			ps.setLong(7, bean.getUserId());
			ps.setString(8 , email);
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
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from payment");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			PaymentBean bean = new PaymentBean();
			bean.setId(rs.getLong(1));
			bean.setCourseFees(rs.getLong(2));
			bean.setCardNo(rs.getString(3));
			bean.setExpairyDate(rs.getString(4));
			bean.setCvv(rs.getInt(5));
			bean.setStatus(rs.getString(6));
			bean.setUserId(rs.getLong(7));
			bean.setEmail(rs.getString(8));
			list.add(bean);
		}
		return list;
	}

	public List studentpaymentlist(long userid) throws Exception {
		ArrayList list = new ArrayList();
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from payment where userId = ?");
		pstmt.setLong(1, userid);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			PaymentBean bean = new PaymentBean();
			bean.setId(rs.getLong(1));
			bean.setCourseFees(rs.getLong(2));
			bean.setCardNo(rs.getString(3));
			bean.setExpairyDate(rs.getString(4));
			bean.setCvv(rs.getInt(5));
			bean.setStatus(rs.getString(6));
			bean.setUserId(rs.getLong(7));
			bean.setEmail(rs.getString(8));
			list.add(bean);
		}
		return list;
	}

	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE from payment where id=?");
			stmt.setLong(1, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
