package oop_fundamentals.assigment_problems;

/** Shows why member-specific values must not be static. */
public class LibraryMembershipBoundary {
    public static void main(String[] args) {
        new BrokenMember("Aditi", 2);
        new BrokenMember("Rohan", 1);
        System.out.println("Broken version:");
        System.out.println(BrokenMember.name);
        System.out.println(BrokenMember.name);

        LibraryMember aditi = new LibraryMember("Aditi", 2);
        LibraryMember rohan = new LibraryMember("Rohan", 1);
        aditi.printMemberCard();
        rohan.printMemberCard();
        LibraryMember.printTotalMembers();
    }
}

class BrokenMember {
    // These fields vary per member; static makes them shared and overwritten.
    static String name;
    static String memberId;
    static int booksIssued;

    BrokenMember(String name, int booksIssued) {
        BrokenMember.name = name;
        BrokenMember.booksIssued = booksIssued;
    }
}

class LibraryMember {
    String name;
    String memberId;
    int booksIssued;
    static String libraryName = "SRM Library";
    static int memberCount;

    LibraryMember(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
        this.memberId = "LM-" + (1000 + ++memberCount);
    }

    void printMemberCard() { System.out.println(name + " | " + memberId); }
    static void printTotalMembers() { System.out.println("Total members: " + memberCount); }
}
