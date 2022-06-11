package com.jdbc_crud;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {

		CrudOps crud = new CrudOps();

		Student s1 = new Student(1, "Prathamesh", "Dindewadi", 416209);
		Student s2 = new Student(2, "Mahesh", "Sangli", 416111);
		Student s3 = new Student(3, "Sushant", "Gargoti", 416112);
		Student s4 = new Student(4, "Sanket", "Kolhapur", 416110);

		//Test of inserting Student Objects into database
		
		try {
			crud.insertStudent(s1);
			crud.insertStudent(s2);
			crud.insertStudent(s3);
			crud.insertStudent(s4);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		//Test to get Student Object from database
		
		try {
			System.out.println(crud.getStudentByRoll(s1.getRollno()));
			System.out.println(crud.getStudentByRoll(s2.getRollno()));;
			System.out.println(crud.getStudentByRoll(s3.getRollno()));;
			System.out.println(crud.getStudentByRoll(s4.getRollno()));;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		//Update student information by using rollno
		
		s1.setName("Vignesh");
		
		try {
			System.out.println("\n"+crud.updateStudent(s1));;
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		//Delete Student details from the database
		
		try {
			crud.deleteStudentByRoll(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
