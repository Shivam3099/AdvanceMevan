package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
@WebServlet(urlPatterns = "/SetCookie")
public class SetCookies extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
		
		
		
		String login =  req.getParameter("login");
		String pwd = req.getParameter("pwd");
		
		Cookie c = new Cookie(login, pwd);
		c.setMaxAge(24*60*60);
		resp.addCookie(c);
		
	}
	

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
