package access_modifiers_encapsulation_object_modeling.assigment_problems;

public class LibraryMemberProfile {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;
    public LibraryMemberProfile() {
        this(null, null);
    }

    public LibraryMemberProfile(String name) {
        this(null, name);
    }

    public LibraryMemberProfile(String membershipId, String name) {
        this.membershipId = membershipId;
        this.name = name;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (membershipId == null && id != null && !id.isBlank()) {
            membershipId = id;
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isPremiumMember() { return premiumMember; }
    public void setPremiumMember(boolean premium) { premiumMember = premium; }

    // No getter exists: the answer remains write-only.
    public void setSecurityAnswer(String answer) {
        if (answer != null) {
            securityAnswerHash = Integer.toHexString(answer.hashCode());
        }
    }

    public static void main(String[] args) {
        LibraryMemberProfile member = new LibraryMemberProfile();
        member.setMembershipId("LIB-8841");
        member.setMembershipId("FAKE-0000");
        System.out.println(member.getMembershipId());
    }
}
