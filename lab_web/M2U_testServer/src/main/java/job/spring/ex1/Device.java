package job.spring.ex1;

public class Device
{
    private Timestamp timestamp;

    private String timezone;

    private String model;

    private Location location;

    private String type;

    private String serial;

    private Meta1 meta;

    private String version;

    public Timestamp getTimestamp ()
    {
        return timestamp;
    }

    public void setTimestamp (Timestamp timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public String getModel ()
    {
        return model;
    }

    public void setModel (String model)
    {
        this.model = model;
    }

    public Location getLocation ()
    {
        return location;
    }

    public void setLocation (Location location)
    {
        this.location = location;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getSerial ()
    {
        return serial;
    }

    public void setSerial (String serial)
    {
        this.serial = serial;
    }

    public Meta1 getMeta ()
    {
        return meta;
    }

    public void setMeta (Meta1 meta)
    {
        this.meta = meta;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timestamp = "+timestamp+", timezone = "+timezone+", model = "+model+", location = "+location+", type = "+type+", serial = "+serial+", meta = "+meta+", version = "+version+"]";
    }
}