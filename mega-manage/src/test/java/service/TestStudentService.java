package service;

import com.ilovemasami.entity.Students;
import com.ilovemasami.service.StudentService;
import com.ilovemasami.service.impl.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yuzhezhu
 * @date 2020/01/23
 **/
public class TestStudentService {
  @Test
  public void testQueryAllStudents() {
    StudentService studentService = new StudentServiceImpl();
    List<Students> list = studentService.queryAllStudents();
    Assert.assertNotNull(list);
  }

  @Test
  public void testQueryStudentBySid() {
    StudentService studentService = new StudentServiceImpl();
    Students res = studentService.queryStudentBySid("S001");
    Assert.assertNotNull(res);
  }

  @Test
  public void testDeleteStudent() {
    StudentService studentService = new StudentServiceImpl();
    boolean res = studentService.deleteStudent("S002");
    Assert.assertTrue(res);
  }

  @Test
  public void testUpdateStudent() {
    StudentService studentService = new StudentServiceImpl();
    Students s = new Students();
    s.setSid("S002");
    s.setSname("test003");
    boolean res = studentService.updateStudent(s);
    Assert.assertTrue(res);
  }

  @Test
  public void testAddStudents() {
    Students s = new Students();
    s.setSname("xiaoyuyu");
    s.setGender("man");
    String dateString = "1987-06-03";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date;
    try {
      date = sdf.parse(dateString);
      s.setBirthday(date);
    } catch (Exception e) {
      e.printStackTrace();
    }
    s.setAddress("USA");
    StudentService studentService = new StudentServiceImpl();
    boolean res = studentService.addStudent(s);
    Assert.assertEquals(true, res);
  }
}
