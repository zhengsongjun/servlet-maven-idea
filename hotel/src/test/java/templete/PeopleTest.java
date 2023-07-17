package templete;

import org.junit.Test;

import static org.junit.Assert.*;

public class PeopleTest {
    @Test
    public void testStudentAndTeacher(){
        People student = new Student();
        System.out.println("学生的一天");
        student.OneDay();
        People teacher = new Teacher();
        System.out.println("老师的一天");
        teacher.OneDay();
    }
}