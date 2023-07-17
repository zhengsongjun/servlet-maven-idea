package templete;

public class Student extends People{

    @Override
    public void getUp() {
        System.out.println("爸爸妈妈叫我起床");
    }


    @Override
    public void goToSchool() {
        System.out.println("坐校车去学校");
    }

    @Override
    public void work() {
        System.out.println("我是学生，我的工作就是学习");
    }
}
