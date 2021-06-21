public class Company {

    private long id;
    private String company;
    private String city;
    private String timezone;

    public static final String ID = "id";
    public static final String NAME = "company";
    public static final String CITY = "city";
    public static final String TIMEZONE = "timezone";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
