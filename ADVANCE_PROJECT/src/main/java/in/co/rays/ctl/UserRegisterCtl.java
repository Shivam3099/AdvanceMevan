package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.been.UserBean;
import in.co.rays.model.UserModel;

@WebServlet(urlPatterns = "/reg")

public class UserRegisterCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-yyy");
		String name = req.getParameter("name");
		String login = req.getParameter("login");
		String pwd = req.getParameter("pwd");
		String cpwd = req.getParameter("cpwd");
		String dob = req.getParameter("dob");
		String mob = req.getParameter("mob");

		bean.setName(name);
		bean.setLogin(login);
		bean.setPassword(pwd);
		bean.setConfirmPassword(cpwd);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bean.setMobileNo(mob);

		UserModel model = new UserModel();
		try {

			if (name.equals("") && login.equals("") && pwd.equals("") && cpwd.equals("") && (dob.equals(""))
					&& mob.equals("")) {

				RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");

				req.setAttribute("e1", "Name is Req...");
				req.setAttribute("e2", "Login is Req...");
				req.setAttribute("e3", "Pwd is Req...");
				req.setAttribute("e4", "Pwd is Req...");
				req.setAttribute("e5", "Dob is Req...");
				req.setAttribute("e6", "Mobile is Req...");

				rd.forward(req, resp);

			} else {
				UserBean existBean = model.findByLogin(bean);

				if (existBean == null) {
					model.add(bean);
					RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
					rd.forward(req, resp);
				} else {
					RequestDispatcher rd = req.getRequestDispatcher("RegistrationForm.jsp");
					req.setAttribute("e7", "Login is already exist....");
					rd.forward(req, resp);

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
