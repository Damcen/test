package a.nothing.ContentProvider;

/**
 * Created by Administrator on 2016/12/27.
 */

public class Calllog
{
    private long id;
    private String number;
    private String data;

    @Override
    public String toString()
    {
        return "Calllog{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public long getId()
    {
        return id;
    }

    public String getNumber()
    {
        return number;
    }

    public String getData()
    {
        return data;
    }

    public Calllog(long id, String number, String data)
    {
        this.id = id;

        this.number = number;
        this.data = data;
    }
}
