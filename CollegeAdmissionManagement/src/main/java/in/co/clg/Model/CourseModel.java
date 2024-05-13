package in.co.clg.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.clg.Bean.CourseBean;
import in.co.clg.Exception.ApplicationException;
import in.co.clg.Exception.DuplicateRecordException;
import in.co.clg.Utility.JDBCDataSource;

public class CourseModel {
	
	public Integer nextPk() throws Exception {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM course");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public CourseBean findByCourseName(String CourseName) throws Exception {
		CourseBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM course WHERE courseName=?");
			ps.setString(1, CourseName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setCourseID(rs.getString(2));
				bean.setCourseName(rs.getString(3));
				bean.setDescription(rs.getString(4));
				bean.setCourseFees(rs.getLong(5));
				bean.setCourseSeat(rs.getLong(6));
//				bean.setCollegeID(rs.getLong(7));
//				bean.setCollegeName(rs.getString(8));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bean;
	}
	
	public CourseBean findByPk(long pk) throws Exception {
		CourseBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM course WHERE id=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setCourseID(rs.getString(2));
				bean.setCourseName(rs.getString(3));
				bean.setDescription(rs.getString(4));
				bean.setCourseFees(rs.getLong(5));
				bean.setCourseSeat(rs.getLong(6));
//				bean.setCollegeID(rs.getLong(7));
//				bean.setCollegeName(rs.getString(8));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public long add(CourseBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;

		CourseBean existbean = findByCourseName(bean.getCourseName());
		if (existbean != null) {
			throw new DuplicateRecordException("Course Name already Exist");
		}
		
//		CollegeModel model = new CollegeModel();
//		CollegeBean cBean = new CollegeBean();
//		cBean = model.findByPk(bean.getCollegeID());
//		String CollegeName = cBean.getCollegeName();

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO course VALUES(?,?,?,?,?,?)");
			ps.setLong(1, pk);
		    ps.setString(2, bean.getCourseID());
		    ps.setString(3, bean.getCourseName());
		    ps.setString(4, bean.getDescription());
		    ps.setLong(5, bean.getCourseFees());
		    ps.setLong(6, bean.getCourseSeat());
//		    ps.setLong(7, bean.getCollegeID());
//		    ps.setString(8, CollegeName);
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
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from course");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			CourseBean bean = new CourseBean();
			bean.setId(rs.getLong(1));
			bean.setCourseID(rs.getString(2));
			bean.setCourseName(rs.getString(3));
			bean.setDescription(rs.getString(4));
			bean.setCourseFees(rs.getLong(5));
			bean.setCourseSeat(rs.getLong(6));
//			bean.setCollegeID(rs.getLong(7));
//			bean.setCollegeName(rs.getString(8));
			list.add(bean);
		}
		return list;
	}
	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE from course where id=?");
			stmt.setLong(1, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public long Update(CourseBean bean) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("update course set courseId=?,courseName=?,description=?,coursefees=?,courseSeat=?,collegeId=?,collegeName=? where id=?");
			    ps.setString(1, bean.getCourseID());
			    ps.setString(2, bean.getCourseName());
			    ps.setString(3, bean.getDescription());
			    ps.setLong(4, bean.getCourseFees());
			    ps.setLong(5, bean.getCourseSeat());
			    ps.setLong(6, bean.getCollegeID());
			    ps.setString(7, bean.getCollegeName());
			    ps.setLong(8, bean.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	
	

	
	public List search(CourseBean bean) throws Exception {
		StringBuffer sql = new StringBuffer("SELECT * from course WHERE 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getCourseName() != null && bean.getCourseName().length() > 0) {
				sql.append(" AND courseName like '" + bean.getCourseName() + "%'");
			}
		}

		ArrayList list = new ArrayList();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setCourseID(rs.getString(2));
				bean.setCourseName(rs.getString(3));
				bean.setDescription(rs.getString(4));
				bean.setCourseFees(rs.getLong(5));
				bean.setCourseSeat(rs.getLong(6));
//				bean.setCollegeID(rs.getLong(7));
//				bean.setCollegeName(rs.getString(8));
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
