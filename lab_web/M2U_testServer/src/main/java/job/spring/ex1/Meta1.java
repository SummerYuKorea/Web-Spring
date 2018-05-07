package job.spring.ex1;

public class Meta1
{
    private String sig_skill;

    private String query_key1;

    private String query_key2;

    public String getSig_skill ()
    {
        return sig_skill;
    }

    public void setSig_skill (String sig_skill)
    {
        this.sig_skill = sig_skill;
    }

    public String getQuery_key1 ()
    {
        return query_key1;
    }

    public void setQuery_key1 (String query_key1)
    {
        this.query_key1 = query_key1;
    }

    public String getQuery_key2 ()
    {
        return query_key2;
    }

    public void setQuery_key2 (String query_key2)
    {
        this.query_key2 = query_key2;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sig_skill = "+sig_skill+", query_key1 = "+query_key1+", query_key2 = "+query_key2+"]";
    }
}
