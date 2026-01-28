package week04.scenariobased.eduresults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EduResults {

    // Merge two sorted lists
    static List<Student> merge(List<Student> a, List<Student> b) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i).score >= b.get(j).score) { // higher score first
                result.add(a.get(i++));
            } else {
                result.add(b.get(j++));
            }
        }

        while (i < a.size()) result.add(a.get(i++));
        while (j < b.size()) result.add(b.get(j++));

        return result;
    }

    // Merge multiple district lists using Merge Sort idea
    static List<Student> mergeAll(List<List<Student>> districts) {
        if (districts.size() == 1) return districts.get(0);

        int mid = districts.size() / 2;
        List<Student> left = mergeAll(districts.subList(0, mid));
        List<Student> right = mergeAll(districts.subList(mid, districts.size()));

        return merge(left, right);
    }

    public static void main(String[] args) {

        // Each district sends sorted data (by score descending)
        List<Student> d1 = Arrays.asList(
                new Student("Amit", 95),
                new Student("Ravi", 88)
        );

        List<Student> d2 = Arrays.asList(
                new Student("Neha", 92),
                new Student("Pooja", 85)
        );

        List<Student> d3 = Arrays.asList(
                new Student("Karan", 98),
                new Student("Simran", 90)
        );

        List<List<Student>> allDistricts = Arrays.asList(d1, d2, d3);

        List<Student> finalRankList = mergeAll(allDistricts);

        System.out.println("State-wise Rank List:");
        for (Student s : finalRankList) {
            System.out.println(s);
        }
    }
}

