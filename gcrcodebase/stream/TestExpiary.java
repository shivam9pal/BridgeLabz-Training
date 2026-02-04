package week06.gcrcodebase.stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class Member {
    String name;
    LocalDate expiryDate;

    public Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return name + " | Expiry Date: " + expiryDate;
    }
}

public class TestExpiary {

    public static void main(String[] args) {

        List<Member> members = Arrays.asList(
                new Member("John", LocalDate.now().plusDays(10)),
                new Member("Emma", LocalDate.now().plusDays(40)),
                new Member("David", LocalDate.now().plusDays(25)),
                new Member("Sophia", LocalDate.now().plusDays(5))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        System.out.println("=== Memberships Expiring in Next 30 Days ===");

        members.stream()
               .filter(m -> !m.expiryDate.isBefore(today) &&
                            !m.expiryDate.isAfter(next30Days))
               .forEach(System.out::println);
    }
}

