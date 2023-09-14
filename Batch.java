import java.util.*;

public class Batch extends Timetable {
    private static Random rand = new Random();
    private static List<Integer> availableSlots = new ArrayList<>();

    public boolean add(Course course, Professor professor) {
        int numRows = this.a.length;
        int numCols = this.a[0].length;

        // Find available slots for scheduling
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (professor.a[row][col] == null && this.a[row][col] == null) {
                    availableSlots.add(row * 10 + col);
                }
            }
        }

        // Check if there are enough available slots for the course
        if (availableSlots.size() >= course.getCredits()) {
            for (int i = 0; i < course.getCredits(); i++) {
                int randomIndex = rand.nextInt(availableSlots.size());
                int selectedSlot = availableSlots.get(randomIndex);
                int selectedRow = selectedSlot / 10;
                int selectedCol = selectedSlot % 10;

                this.a[selectedRow][selectedCol] = course.getName() + "(" + professor.getName() + ")";
                professor.a[selectedRow][selectedCol] = this.getName() + "(" + course.getName() + ")";
                availableSlots.remove(randomIndex);
            }
            return true; // Course successfully added to the batch's timetable
        }

        availableSlots.clear();
        return false; // Not enough available slots for the course
    }
}
