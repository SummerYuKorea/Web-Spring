package job.spring.ex1;

public class Query
{
    private String[] altUtters;

    private String type;

    private String lang;

    private Meta2 meta2;

    private String utter;

    public String[] getAltUtters ()
    {
        return altUtters;
    }

    public void setAltUtters (String[] altUtters)
    {
        this.altUtters = altUtters;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getLang ()
    {
        return lang;
    }

    public void setLang (String lang)
    {
        this.lang = lang;
    }

    public Meta2 getMeta2 ()
    {
        return meta2;
    }

    public void setMeta2 (Meta2 meta2)
    {
        this.meta2 = meta2;
    }

    public String getUtter ()
    {
        return utter;
    }

    public void setUtter (String utter)
    {
        this.utter = utter;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [altUtters = "+altUtters+", type = "+type+", lang = "+lang+", meta2 = "+meta2+", utter = "+utter+"]";
    }
}
			