package in.co.rays.model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.been.StudentBean;
import in.co.rays.been.UserBean;

public class StudentManagementModel {

	public static int nextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "ROOT");

		PreparedStatement ps = conn.prepareStatement("select max(id) from studentmanagement");
		conn.setAutoCommit(false);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}

	public static void add(StudentBean bean) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "ROOT");

		PreparedStatement ps = conn.prepareStatement("insert into studentmanagement values (?,?,?,?)");

		// ps.setInt(1, nextPk());
		ps.setString(1, bean.getRollNo());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getSession());

		int i = ps.executeUpdate();
		System.out.println(i + "add");
		conn.close();
		ps.close();

	}

	public static void update(StudentBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "ROOT");

		PreparedStatement ps = conn
				.prepareStatement("update studentmanagement set first_name=?,last_name=?,session=? where roll_no=?;");

		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getSession());
		ps.setString(4, bean.getRollNo());

		int i = ps.executeUpdate();

		System.out.println(i + "Updated");
		conn.close();
		ps.close();
	}

	public static void delete(String rollNo) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "ROOT");
		PreparedStatement ps = conn.prepareStatement("delete from studentmanagement where roll_no=?;");
		ps.setString(1, rollNo);
		int i = ps.executeUpdate();
		System.out.println(i + "Deleted");
		conn.close();
		ps.close();
	}

	public static StudentBean get(String rollNo) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "ROOT");
		PreparedStatement ps = conn.prepareCall("select * from studentmanagement where roll_no=?");

		ps.setString(1, rollNo);

		ResultSet rs = ps.executeQuery();

		ArrayList<StudentBean> list = new ArrayList<StudentBean>();

		while (rs.next()) {
			StudentBean bean1 = new StudentBean();
			bean1.setRollNo(rs.getString(1));
			bean1.setFirstName(rs.getString(2));
			bean1.setLastName(rs.getString(3));
			bean1.setSession(rs.getString(4));

			list.add(bean1);
		}
		conn.commit();
		conn.close();
		ps.close();
		return null;
	}

	public StudentBean findByRollNo(StudentBean bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "ROOT");

		PreparedStatement ps = conn.prepareStatement("select * from studentmanagement where Roll_No = ?");

		ps.setString(1, bean.getRollNo());

		ResultSet rs = ps.executeQuery();

		StudentBean bean1 = null;
		while (rs.next()) {
			bean1 = new StudentBean();

			bean1.setRollNo(rs.getString(1));
			bean1.setFirstName(rs.getString(2));
			bean1.setLastName(rs.getString(3));
			bean1.setSession(rs.getString(4));

		}
		return bean1;
	}

	public List search(int pageNo, int pageSize) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "ROOT");

		conn.setAutoCommit(false);
		StringBuffer sql = new StringBuffer("select * from studentmanagement where 1=1");
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" Limit " + pageNo + ", " + pageSize);
		}

		PreparedStatement ps = conn.prepareStatement(sql.toString());

		ResultSet rs = ps.executeQuery();

		ArrayList list = new ArrayList();

		while (rs.next()) {
			StudentBean bean1 = new StudentBean();
			bean1.setRollNo(rs.getString(1));
			bean1.setFirstName(rs.getString(2));
			bean1.setLastName(rs.getString(3));
			bean1.setSession(rs.getString(4));

			list.add(bean1);
		}

		conn.commit();

		ps.close();
		conn.close();

		return list;

	}
}
