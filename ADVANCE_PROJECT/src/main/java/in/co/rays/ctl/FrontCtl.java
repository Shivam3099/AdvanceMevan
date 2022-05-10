package in.co.rays.ctl;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FrontCtl", urlPatterns = { "*.do" })
public class FrontCtl implements Filter {

	public FrontCtl() {
		// TODO Auto-generated constructor stub
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
			req.setAttribute("message", "Your session has been expired. Please re-Login.");
			rd.forward(request, response);

		} else {
			chain.doFilter(req, resp);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void destroy() {
	}

}
