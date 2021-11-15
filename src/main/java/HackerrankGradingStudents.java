import java.util.ArrayList;
import java.util.List;

public class HackerrankGradingStudents {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> finalList = new ArrayList<>();
        for (int grade : grades) {
            if (grade < 38) {
                finalList.add(grade);
                continue;
            }
            int multiple = (grade % 5 == 0) ? grade / 5 : (grade / 5) + 1;
            finalList.add(Math.abs(multiple * 5 - grade) < 3 ? multiple * 5 : grade);
        }
        return finalList;
    }

    public static void main(String[] args) {
        List<Integer> grades = HackerrankGradingStudents.gradingStudents(List.of(73, 67, 38, 33));
        System.out.println(grades);
    }
}
