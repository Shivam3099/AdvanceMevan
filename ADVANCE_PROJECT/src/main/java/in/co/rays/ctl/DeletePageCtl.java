package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.been.StudentBean;
import in.co.rays.model.StudentManagementModel;

@WebServlet(urlPatterns = "/DeletePageCtl")
public class DeletePageCtl extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rollNo = req.getParameter("rollNo");

		StudentBean bean = new StudentBean();
		bean.setRollNo(rollNo);

		StudentManagementModel model = new StudentManagementModel();
		try {
			StudentBean bean0 = model.findByRollNo(bean);

			RequestDispatcher rd = req.getRequestDispatcher("DeleteDestination.jsp");
			req.setAttribute("rollNo", bean0);
			rd.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentBean bean = new StudentBean();

		String rollNo = req.getParameter("rollNo");
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String session = req.getParameter("session");

		bean.setRollNo(rollNo);
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setSession(session);

		StudentManagementModel model = new StudentManagementModel();

		try {
			StudentBean existBean = model.findByRollNo(bean);
			model.delete(rollNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
