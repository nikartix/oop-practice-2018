package seminar12;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import seminar12.bean.Course;
import seminar12.bean.Student;
import seminar12.dao.CourseDao;
import seminar12.dao.StudentDao;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class App {

    public static void main(String[] args) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test_db?characterEncoding=UTF8");
        ds.setUsername("root");
        ds.setPassword("password");
        
        StudentDao studentDao = new StudentDao(ds);
        CourseDao courseDao = new CourseDao(ds);
        
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        
        try {
            for (Student rec : studentDao.getStudentList()) {
                Student student = courseDao.getStudentCourses(rec.getStudentId());
                System.out.println(gson.toJson(student));
                System.out.println("-------------------------");
            }
        } catch (SQLException ex) {
            throw new AssertionError(ex);
        }
        
        System.out.print("\n\n\n");
        
        try {
            for (Course rec : courseDao.getCourseList()) {
                Course course = studentDao.getCourseStudents(rec.getCourseId());
                System.out.println(gson.toJson(course));
                System.out.println("-------------------------");
            }
        } catch (SQLException ex) {
            throw new AssertionError(ex);
        }
    }
}
