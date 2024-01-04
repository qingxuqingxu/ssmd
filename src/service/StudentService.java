package service;

import java.util.List;

import model.PageBean;
import model.Student;

public interface StudentService {
    /*
     * ���ѧ��
     */
    int addStu(Student student);

    /*
     * ɾ��ѧ��
     */
    int deleteStu(String stuNum);

    /*
     * �޸�ѧ��
     */
    int editStu(Student student);

    /*
     * ��ѯ����ѧ��
     */
    List findAll();

    /*
     * ��ѯһ��ѧ��
     */
    List findOne(String userNum);

    /*
     * ��ҳ��ʾѧ��
     */
    public PageBean stuListPage(int pageNo, int pageCount);

    public PageBean stuListPageByTeachName(int pageNo, int pageCount, String teacherName);

}
