package in.co.clg.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.clg.Bean.CollegeBean;
import in.co.clg.Bean.UserBean;
import in.co.clg.Exception.ApplicationException;
import in.co.clg.Exception.DuplicateRecordException;
import in.co.clg.Utility.JDBCDataSource;

public class CollegeModel {

	public Integer nextPk() throws Exception {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM college");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public CollegeBean findByCollegeName(String CollegeName) throws Exception {
		CollegeBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM college WHERE collegeName=?");
			ps.setString(1, CollegeName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new CollegeBean();
				bean.setId(rs.getLong(1));
				bean.setCollegeName(rs.getString(2));
				bean.setCityName(rs.getString(3));
				bean.setUniversityName(rs.getString(4));
				bean.setDescription(rs.getString(5));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bean;
	}
	
	public CollegeBean findByPk(long pk) throws Exception {
		CollegeBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM college WHERE id=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new CollegeBean();
				bean.setId(rs.getLong(1));
				bean.setCollegeName(rs.getString(2));
				bean.setCityName(rs.getString(3));
				bean.setUniversityName(rs.getString(4));
				bean.setDescription(rs.getString(5));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	
	
	public long add(CollegeBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;

		CollegeBean existbean = findByCollegeName(bean.getCollegeName());
		if (existbean != null) {
			throw new DuplicateRecordException("College Name already Exist");
		}

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO college VALUES(?,?,?,?,?)");
			ps.setLong(1, pk);
		    ps.setString(2, bean.getCollegeName());
		    ps.setString(3, bean.getCityName());
		    ps.setString(4, bean.getUniversityName());
		    ps.setString(5, bean.getDescription());
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
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from college");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			CollegeBean bean = new CollegeBean();
			bean.setId(rs.getLong(1));
			bean.setCollegeName(rs.getString(2));
			bean.setCityName(rs.getString(3));
			bean.setUniversityName(rs.getString(4));
			bean.setDescription(rs.getString(5));
			list.add(bean);
		}
		return list;
	}
	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE from college where id=?");
			stmt.setLong(1, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public List search(CollegeBean bean) throws Exception {
		StringBuffer sql = new StringBuffer("SELECT * from college WHERE 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getCollegeName() != null && bean.getCollegeName().length() > 0) {
				sql.append(" AND collegeName like '" + bean.getCollegeName() + "%'");
			}
		}

		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new CollegeBean();
				bean.setId(rs.getLong(1));
				bean.setCollegeName(rs.getString(2));
				bean.setCityName(rs.getString(3));
				bean.setUniversityName(rs.getString(4));
				bean.setDescription(rs.getString(5));
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
