package Conntroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Member;
import Dao.member.implMember;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.接收->request->username,password
		 * 2.判斷-->querMember
		 * !=null-->true-->LoginSuccess
		 * fales-->LoginError
		 */
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session=request.getSession();

		Member m = new implMember().queryMember(username, password);
		if (m != null) {
			session.setAttribute("M", m);
			response.sendRedirect("member/loginSuccess.jsp");
		} else {
			response.sendRedirect("member/loginError.jsp");
		}

	}
}
