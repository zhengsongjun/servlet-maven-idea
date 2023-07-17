package templete;

public class Teacher extends People{
    @Override
    public void getUp() {
        System.out.println("闹钟叫我起床");
    }


    @Override
    public void goToSchool() {
        System.out.println("我是老师，当然是开车去学校啦");
    }

    @Override
    public void work() {
        System.out.println("我是老师，我的工作就是开车");
    }
}
