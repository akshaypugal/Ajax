package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.student;
import service.StudentService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.google.gson.Gson;

@WebServlet("/studentController")
public class studentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    StudentService sr = new StudentService();

    public studentController() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        
           switch(action) {
           case "add" : 
        	   try {
                   String sname = request.getParameter("sname");
                   String scourse = request.getParameter("scourse");
                   Double sfee = Double.parseDouble(request.getParameter("sfee"));

                   int row = sr.addStudentSer(new student(sname, scourse, sfee));

                   if (row > 0) {
                       response.getWriter().write("{\"message\":\"Student Added Successfully\"}");
                   } else {

                       response.getWriter().write("{\"message\":\"Something went wrong\"}");
                   }

               } catch (Exception e) {
                  
                   response.getWriter().write("{\"message\":\"Invalid input: " + e.getMessage() + "\"}");
               }
        	   break ;
           case "delete" : 
        	   int id =  Integer.parseInt(request.getParameter("id"));
        	   System.out.println(id);
        	   int row = sr.deleteStudent(id);
        	   System.out.println(row);
        	   if (row > 0) {
                   response.getWriter().write("{\"message\":\"Student Deleted Successfully\"}");
               } else {

                   response.getWriter().write("{\"message\":\"Something went wrong\"}");
               }
        	   break ; 
           case "getStudent" :
        	   int id1 = Integer.parseInt(request.getParameter("id"));
        	   System.out.println(id1);
        	   student s = sr.getById(id1);
        	   Gson gs = new Gson();
        	   String json = gs.toJson(s);
        	   response.getWriter().write(json); 
        	   
        	   break ; 
           case "edit" : 
        	   try {
                   String sname = request.getParameter("sname");
                   String scourse = request.getParameter("scourse");
                   Double sfee = Double.parseDouble(request.getParameter("sfee"));
                   int sid = Integer.parseInt(request.getParameter("sid"));
                   int row1 = sr.updateStudent(new student(sid , sname, scourse, sfee));

                   if (row1 > 0) {
                       response.getWriter().write("{\"message\":\"Student Updated Successfully\"}");
                   } else {

                       response.getWriter().write("{\"message\":\"Something went wrong\"}");
                   }

               } catch (Exception e) {
                  
                   response.getWriter().write("{\"message\":\"Invalid input: " + e.getMessage() + "\"}");
               }
        	   break ;
        	   
           }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               String action = request.getParameter("action");
               String keyword = request.getParameter("keyword");
             
               System.out.println(action);
               System.out.println(keyword);
               StudentService sr = new StudentService();
                      switch(action) {
                      case "list" :
            		  List<student> list = sr.getAll();
            		  Gson gs = new Gson();
            		  response.getWriter().write(gs.toJson(list));
            		  break ;
                      case "search" : 
                    	  List<student> list1;
						try {
							list1 = sr.getBySearch(keyword);
							Gson gs1 = new Gson();
	                    	  response.getWriter().write(gs1.toJson(list1));
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    	  
                    	  break ; 
                      }
            		  
    }
}
