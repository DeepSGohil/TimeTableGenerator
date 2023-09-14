import java.util.*;

public class Timetable {
    private String name;
    private String[][] schedule = new String[6][8];

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String[][] getSchedule() {
        return this.schedule;
    }
}
