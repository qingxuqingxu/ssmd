package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter{

	public void destroy() {


	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		String path=request.getRequestURI();
		String userNum = (String) request.getSession().getAttribute("usernum");
		  if(path.contains("/login.jsp") || path.contains("/register.jsp")) {
		   chain.doFilter(request, response);
		   return;
		  }
		  if (userNum == null || "".equals(userNum)) {
		   response.sendRedirect("/StuAMSystem/login/login.jsp");
		  } else {
		   chain.doFilter(request, response);
		  }

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
