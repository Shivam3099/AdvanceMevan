package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.been.StudentBean;
import in.co.rays.model.StudentManagementModel;
@WebServlet(urlPatterns = "/StudentMgtCtl")
public class StudentMgtCtl extends HttpServlet{

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentBean bean = new StudentBean();
		bean.setRollNo(request.getParameter("rollNo"));
		bean.setFirstName(request.getParameter("fname"));
		bean.setLastName(request.getParameter("lname"));
		bean.setSession(request.getParameter("session"));
		
		response.setContentType("text/html");
		
		
		String op = request.getParameter("operation");
		
		if(op.equals("Add")) {
			try {
				StudentManagementModel.add(bean);
				request.setAttribute("err1", "addSucessfull");
          RequestDispatcher rd = request.getRequestDispatcher("StudentMgtViwe.jsp");
          rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(op.equals("Modify")) {
			try {
				RequestDispatcher rd = request.getRequestDispatcher("Modify.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(op.equals("Delete")) {
			String rollNo = null;
			try {
				RequestDispatcher rd = request.getRequestDispatcher("DeletePage.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	}
	
	


