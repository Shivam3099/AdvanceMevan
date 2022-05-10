package in.co.rays.ctl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import in.co.rays.been.StudentBean;
import in.co.rays.been.UserBean;
import in.co.rays.model.StudentManagementModel;

@WebServlet(urlPatterns = "/PaginationCtl")
public class PaginationCtl extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentManagementModel model = new StudentManagementModel();

		try {

			List list = model.search(1, 5);
			RequestDispatcher rd = req.getRequestDispatcher("PaginationView.jsp");
			req.setAttribute("List", list);

			rd.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentManagementModel model = new StudentManagementModel();
		int pageNo = 0;
		int pageSize = 0;
		String op = req.getParameter("operation");

		try {
			List list = model.search(pageNo + 1, pageSize);
			if (op.equals(list)) {
				pageNo++;
				RequestDispatcher rd = req.getRequestDispatcher("PaginationView.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
