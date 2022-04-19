package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.been.MarksheetBean;
import in.co.rays.model.UserModel;


@WebServlet(urlPatterns = "/list")
public class MarksheetCtl extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel model = new UserModel();
		try {
			List<MarksheetBean> list = model.Search();
			RequestDispatcher rd = req.getRequestDispatcher("MarksheetListView.jsp");
			req.setAttribute("List", list);
			rd.forward(req, resp);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
