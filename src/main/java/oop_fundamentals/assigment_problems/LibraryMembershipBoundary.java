package oop_fundamentals.assigment_problems;

/** Shows why member-specific values must not be static. */
public class LibraryMembershipBoundary {
    public static void main(String[] args) { new BrokenMember("Aditi",2); new BrokenMember("Rohan",1); System.out.println("Broken version:\n"+BrokenMember.name+"\n"+BrokenMember.name); LibraryMember aditi=new LibraryMember("Aditi",2); LibraryMember rohan=new LibraryMember("Rohan",1); aditi.printMemberCard(); rohan.printMemberCard(); LibraryMember.printTotalMembers(); }
}
class BrokenMember { // name, memberId, and booksIssued vary per member; static makes their values shared and overwritten.
    static String name,memberId; static int booksIssued; BrokenMember(String name,int booksIssued){BrokenMember.name=name;BrokenMember.booksIssued=booksIssued;}
}
class LibraryMember { String name,memberId; int booksIssued; static String libraryName="SRM Library"; static int memberCount; LibraryMember(String name,int booksIssued){this.name=name;this.booksIssued=booksIssued;memberId="LM-"+(1000 + ++memberCount);} void printMemberCard(){System.out.println(name+" | "+memberId);} static void printTotalMembers(){System.out.println("Total members: "+memberCount);} }
