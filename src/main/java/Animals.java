import java.util.List;

public class Animals {
    private String name;
    private String ranger;
    private String age;
    private String location;
    private String health;
    private String status;
    private String spottime;
    private int id;


    public Animals(String name, String ranger, String age, String location, String health, String status, String spottime) {
        this.name = name;
        this.ranger = ranger;
        this.age = age;
        this.location = location;
        this.health = health;
        this.status = status;
        this.spottime = spottime;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRanger() {
        return ranger;
    }

    public void setRanger(String ranger) {
        this.ranger = ranger;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpottime() {
        return spottime;
    }

    public void setSpottime(String spottime) {
        this.spottime = spottime;
    }
    public static List<Animals> all(){
        return all();
    }

}
