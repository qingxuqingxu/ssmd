package servlet.teacher;

import model.PageBean;
import model.Student;
import service.Impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletGetAllStuInfo extends HttpServlet {

    private Student student;
    private StudentServiceImpl studentServiceImpl=new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo=1;
        int pageCount=10;

        String pageNoStr=req.getParameter("pageNo");
        String pageCountStr=req.getParameter("pageCount");


        if(pageNoStr!=null){
            pageNo=Integer.parseInt(pageNoStr);
        }
        if(pageCountStr!=null){
            pageCount=Integer.parseInt(pageCountStr);
        }


        String teacherName = req.getParameter("username");

        PageBean list=studentServiceImpl.stuListPageByTeachName(pageNo, pageCount,teacherName);

        req.setAttribute("list", list);
        req.getRequestDispatcher("admin/studentAllInfo.jsp").forward(req, resp);
    }
}
