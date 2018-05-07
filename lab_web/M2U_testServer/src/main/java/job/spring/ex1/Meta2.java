package job.spring.ex1;

public class Meta2
{
    private String dev_key2;

    private String dev_key1;

    public String getDev_key2 ()
    {
        return dev_key2;
    }

    public void setDev_key2 (String dev_key2)
    {
        this.dev_key2 = dev_key2;
    }

    public String getDev_key1 ()
    {
        return dev_key1;
    }

    public void setDev_key1 (String dev_key1)
    {
        this.dev_key1 = dev_key1;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [dev_key2 = "+dev_key2+", dev_key1 = "+dev_key1+"]";
    }
}
			