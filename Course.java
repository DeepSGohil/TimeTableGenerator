import java.util.*;

public class Course {
    private String name;
    private int credits;
    private List<String> professors = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getName() {
        return this.name;
    }

    public int getCredits() {
        return this.credits;
    }

    public void addProfessor(String professorName) {
        this.professors.add(professorName);
    }

    public int getProfessorCount() {
        return this.professors.size();
    }

    public String getProfessor(int index) {
        return this.professors.get(index);
    }
}
