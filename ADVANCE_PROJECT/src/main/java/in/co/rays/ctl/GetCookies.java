package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/GetCookie")
public class GetCookies  extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie []  cookie = req.getCookies();
		for (Cookie c :cookie ) {
			 String login =c.getName();
			 String pwd= c.getValue();
      PrintWriter out = resp.getWriter();
      out.println(login+" "+pwd );
		
		}
		}
	

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			
	}
	

}
