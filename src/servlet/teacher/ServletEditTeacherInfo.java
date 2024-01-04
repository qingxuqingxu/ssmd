package servlet.teacher;

import model.Teacher;
import service.Impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class ServletEditTeacherInfo extends HttpServlet{

	private Teacher teacher;
	private TeacherServiceImpl teacherServiceImpl=new TeacherServiceImpl();
	private ServletTeacherInfo servletTeacherInfo=new ServletTeacherInfo();

	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String teaNum=request.getParameter("teaNum");
		String teaName = request.getParameter("teaName");
		String teaSex = request.getParameter("teaSex");
		int teaAge = Integer.parseInt(request.getParameter("teaAge"));
		String teaCourse = request.getParameter("teaCourse");
		String major = request.getParameter("major");
		String department = request.getParameter("department");
		teacher = new Teacher(teaNum, teaName, teaSex, teaAge, teaCourse, major,
				department);
		int rs=teacherServiceImpl.editTea(teacher);
		if(rs>0){
			request.setAttribute("msg", "ok");
			servletTeacherInfo.doGet(request, response);
		}else{
			request.setAttribute("msg", "有问题");
			request.getRequestDispatcher("teacher/editTeacherInfo.jsp").forward(request, response);
		}

	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}
}
