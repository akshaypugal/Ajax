package service;

import java.sql.SQLException;
import java.util.List;

import dao.StudentDao;
import model.student;

public class StudentService {
           StudentDao sr = new StudentDao();
           
           
          
	     public int addStudentSer( student s ) {
	    	  return sr.addStudent(s);
	     }
       
	     public List<student>getAll (){
	    	    return sr.getAllStudent() ; 
	     }
	     
	     public int deleteStudent(int s ) {
	    	  return sr.deleteStudent(s);
	     }
         
	     public student getById(int id) {
	    	   return sr.getStudentByID(id);
	     }
	     
	     public int updateStudent(student s ) throws SQLException {
	    	   return sr.updateStudent(s);
	     }
		 
}
