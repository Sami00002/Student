package ro.emanuel.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {

	public static void main(String[] args) throws SQLException {
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password", "");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_db", connectionProps);

		// selectAll(conn);

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("insert into student(id,nume,nr_matricol,medie)" + "value(4,'Dani',58812,9.8)");

		stmt.executeUpdate("update student set nume='Amalia', nr_matricol=58694 where id=3");
		selectAll(conn);

		conn.close();
	}

	public static void delete(int id, Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("delete from student where id=" + id);
	}

	public static void selectAll(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from student");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("nume");
			String nr_matricol = rs.getString("nr_matricol");
			float media = rs.getInt("medie");
			System.out.println(id + " " + name + " " + nr_matricol + " " + media);

		}
	}

}
