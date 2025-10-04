package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



import model.student;
import util.DBconnection;

public class StudentDao {
       
	
	public int addStudent(student s) {
	 try {
		 Connection conn = DBconnection.getConnection() ; 
		 String sql = "insert into student (sname , scourse , sfee) values('"+s.getSname()+"' , '"+s.getScourse()+"' , '"+s.getSfee()+"')";
		 PreparedStatement ps = conn.prepareStatement(sql);
		int row =  ps.executeUpdate();
		 return row ; 
		 
	 }
	 catch(Exception e) {
		    System.out.println(e);
	 }
	 return 0;
	 
	 						
	}
	
	public List<student> getBySearch(String s) throws SQLException{
		  List<student> list = new ArrayList<>();
		  String sql = "Select * from student where sname like ? or scourse like ? ";
		  try(Connection conn = DBconnection.getConnection() ;
			  PreparedStatement ps = conn.prepareStatement(sql)){
			  ps.setString(1, "%"+s+"%");
			  ps.setString(2, "%"+s+"%");
			  ResultSet rs = ps.executeQuery() ; 
			  while(rs.next()) {
				   student data = new student(
						   rs.getInt("sid") , 
						   rs.getString("sname"),
						   rs.getString("scourse"),
						   rs.getDouble("sfee")
						   );
						   list.add(data) ;
				  
				   
			  }
			  return list ; 
		  }
			 
		  
	}
	public student getStudentByID(int id ) {
		student s = null ; 
		    try {
		    	Connection conn = DBconnection.getConnection() ; 
		    	String sql = "Select * from student where sid ='"+id+"'";
		    	PreparedStatement ps = conn.prepareStatement(sql);
		    	ResultSet rs = ps.executeQuery() ; 
		    	
		    	while(rs.next()) {
		    		   s = new student(
		    				 rs.getInt("sid"),
				    		 rs.getString("sname"),
				    		 rs.getString("scourse"),
				    		 rs.getDouble("sfee")
		    				 ) ; 
		    		 
		    	}
		    }catch(Exception e ) {
		    	 System.out.println(e);
		    }
		    return s ; 
		
	}
	
	public int updateStudent(student s) throws SQLException {
		   String sql = "Update student set sname=?  , scourse=? , sfee=? where sid = ?" ;
		   try(Connection conn = DBconnection.getConnection() ; 
				PreparedStatement ps = conn.prepareStatement(sql)){
			    ps.setString(1, s.getSname());
			    ps.setString(2, s.getScourse());
			    ps.setDouble(3, s.getSfee());
			    ps.setInt(4, s.getSid());
			    int row =  ps.executeUpdate();
			    
			    return row ; 
		   }
	}
	
	 public List<student> getAllStudent(){
		  List<student> list = new ArrayList<>();
		  try {
			  Connection conn = DBconnection.getConnection() ; 
			  String sql = "select * from student";
			  PreparedStatement ps = conn.prepareStatement(sql);
			  ResultSet rs = ps.executeQuery();
			  while(rs.next()) {
				   student s = new student(
				   rs.getInt("sid"),
				   rs.getString("sname"),
				   rs.getString("scourse"),
				   rs.getDouble("sfee")
				   ) ; 
				   list.add(s);
			  }
					  
		  }catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
			  
			  
		  }
	 
	 
	  public int deleteStudent(int s) {
		   
		   try {
			   Connection conn = DBconnection.getConnection() ; 
			   String sql = "Delete from student where sid = '"+s+"'";
			   PreparedStatement ps = conn.prepareStatement(sql);
			   int row = ps.executeUpdate(sql);
			   return row ; 
		   }catch(Exception e ){
			   
			   e.printStackTrace();			   
		   }
		  return 0 ; 
	  }
	 }

