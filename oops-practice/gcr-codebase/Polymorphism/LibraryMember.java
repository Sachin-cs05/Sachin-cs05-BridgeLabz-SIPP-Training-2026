package polymorphism;

public class LibraryMember {
    protected String memberName;
    protected String memberId;

    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    public double calculateFine(int overdueDays) {
        return 0;
    }

    public void printMemberDetails() {
        System.out.println("Member Name: " + memberName);
        System.out.println("Member ID: " + memberId);
    }

    public String getMemberId() {
        return memberId;
    }
}

class StudentMember extends LibraryMember {
    public StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    public double calculateFine(int overdueDays) {
        return overdueDays * 2;
    }
}

class FacultyMember extends LibraryMember {
    public FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    public double calculateFine(int overdueDays) {
        return overdueDays * 1;
    }
}

class GuestMember extends LibraryMember {
    public GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    public double calculateFine(int overdueDays) {
        return overdueDays * 5;
    }
}

class LibraryManagement {
    public static void showAllMembers(LibraryMember[] members, int overdueDays) {
        System.out.println("Library Members:");

        for (LibraryMember member : members) {
            member.printMemberDetails();
            System.out.println("Fine for " + overdueDays + " overdue days: " + member.calculateFine(overdueDays));
            System.out.println();
        }
    }

    public static void findMemberById(LibraryMember[] members, String searchId) {
        boolean found = false;

        for (LibraryMember member : members) {
            if (member.getMemberId().equalsIgnoreCase(searchId)) {
                System.out.println("Member Found:");
                member.printMemberDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No member found with ID: " + searchId);
        }
    }
}

class LibraryMemberMain {
    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("Aman", "S101"),
            new GuestMember("Kunal", "G303"),
        };

        LibraryManagement.showAllMembers(members, 4);
        LibraryManagement.findMemberById(members, "F202");
    }
}
