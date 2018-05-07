package job.spring.ex1;

public class ReqJsonVO
{
    private Query query;

    private Device device;

    private String contextReset;

    public Query getQuery ()
    {
        return query;
    }

    public void setQuery (Query query)
    {
        this.query = query;
    }

    public Device getDevice ()
    {
        return device;
    }

    public void setDevice (Device device)
    {
        this.device = device;
    }

    public String getContextReset ()
    {
        return contextReset;
    }

    public void setContextReset (String contextReset)
    {
        this.contextReset = contextReset;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [query = "+query+", device = "+device+", contextReset = "+contextReset+"]";
    }
}
