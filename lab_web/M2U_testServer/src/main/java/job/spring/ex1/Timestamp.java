package job.spring.ex1;

public class Timestamp
{
    private String nanos;

    private String seconds;

    public String getNanos ()
    {
        return nanos;
    }

    public void setNanos (String nanos)
    {
        this.nanos = nanos;
    }

    public String getSeconds ()
    {
        return seconds;
    }

    public void setSeconds (String seconds)
    {
        this.seconds = seconds;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [nanos = "+nanos+", seconds = "+seconds+"]";
    }
}
			