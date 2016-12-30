package a.nothing.contentProvider.self;

/**
 * Created by Administrator on 2016/12/29.
 */

public class User
{
    private String name;
    private int age;

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
}
