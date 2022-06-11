package com.jdbc_crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOps {
	
	/**
	 * C --> Create new object and insert into table
	 * R --> Read/Write
	 * U --> Update
	 * D --> Delete
	 * 
	 * **/
	
	/*	>	method to insert student object into database
	 *	>	returns true when student information successfully inserted into database
	 *		otherwise false
	 */
	
	public boolean insertStudent(Student student) throws SQLException {
		
		Connection con = JdbcConnection.getdbConnection();
		
		String insertStudentObjectQuery = "insert into Student values(?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(insertStudentObjectQuery);
		
		stmt.setInt(1, student.getRollno());
		stmt.setString(2, student.getName());
		stmt.setString(3, student.getCity());
		stmt.setInt(4, student.getPincode());
		
		int update = stmt.executeUpdate();
		
		JdbcConnection.closeDbConnection();
		
		if(update>0)
		{
			System.out.println("Student information inserted into database successfully");
			return true;
		}
		else
			return false;
	}
	
	/*	>	method to retrieve student object from the database
	 * 	>	returns student object
	 */
	
	public Student getStudentByRoll(int rollno) throws SQLException {
		
		Statement stmt =JdbcConnection.getdbConnection().createStatement();
		
		String setStudent = "select*from Student where rollno = "+rollno;

		ResultSet set = stmt.executeQuery(setStudent);
		
		Student student = null;
		
			while(set.next()) {
				student = new Student(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4));
			}
		
		JdbcConnection.closeDbConnection();
		return student;
	}
	
	/*	>	It is used to update student information to the database
	 * 	>	returns true when student information successfully updated
	 */
	
	public boolean updateStudent(Student student) throws SQLException {
		
		
		String updateStudent = "UPDATE Student SET name = ?, city = ?, pincode = ? WHERE rollno = ?";
		
		PreparedStatement stmt = JdbcConnection.getdbConnection().prepareStatement(updateStudent);
		
		stmt.setString(1, student.getName());
		stmt.setString(2, student.getCity());
		stmt.setInt(3, student.getPincode());
		stmt.setInt(4, student.getRollno());
		
		int update = stmt.executeUpdate();
		
		JdbcConnection.closeDbConnection();
		
		if(update>0)
			return true;
		else
			return false;
	}
	
	/*	>	It is used to delete the student from the database
	 * 	>	returns true when student is removed from the database
	 */
	
	public boolean deleteStudentByRoll(int rollno) throws SQLException {
		
		String deleteStudent = "DELETE FROM Student Where rollno = ?";
		
		PreparedStatement stmt = JdbcConnection.getdbConnection().prepareStatement(deleteStudent);
		
		stmt.setInt(1, rollno);
		
		int update = stmt.executeUpdate();
		
		JdbcConnection.closeDbConnection();
		
		if(update>0)
			return true;
		else
			return false;
	}
}
