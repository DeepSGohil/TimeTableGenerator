import java.util.*;

public class Professor extends Timetable {
    private List<String> coursesTaught = new ArrayList<>();

    public void addCourseTaught(String courseName) {
        this.coursesTaught.add(courseName);
    }
}
