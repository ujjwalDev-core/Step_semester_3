package access_modifiers_encapsulation_object_modeling.assigment_problems;

public class MembershipAccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        boolean sameClass = "SAME_CLASS".equals(accessorContext);
        boolean samePackage = "SAME_PACKAGE".equals(accessorContext);
        boolean subclassOwnType = "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext);
        boolean allowed = switch (fieldModifier) {
            case "private" -> sameClass;
            case "default" -> sameClass || samePackage;
            case "protected" -> sameClass || samePackage || subclassOwnType;
            case "public" -> true;
            default -> false;
        };
        return allowed ? "ALLOWED" : "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        StringBuilder report = new StringBuilder();
        for (String modifier : modifiers) {
            int allowed = 0;
            int denied = 0;
            if (attempts != null) for (String[] attempt : attempts) {
                if (attempt != null && attempt.length == 2 && modifier.equals(attempt[0])
                        && "ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) allowed++;
                else if (attempt != null && attempt.length == 2 && modifier.equals(attempt[0])) denied++;
            }
            if (report.length() > 0) report.append(" | ");
            report.append(modifier).append(": ").append(allowed).append(" allowed / ").append(denied).append(" denied");
        }
        return report.toString();
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        new LibraryMember("LB94", "BR1", 0, "Priya Nair");
    }
}

class LibraryMember {
    private final String membershipId;
    String branchCode;
    protected double finesOwed;
    public String displayName;
    public LibraryMember(String membershipId, String branchCode, double finesOwed, String displayName) {
        if (membershipId == null || membershipId.trim().length() < 4) throw new IllegalArgumentException("Membership ID must have at least four characters.");
        this.membershipId = membershipId.trim(); this.branchCode = branchCode; this.finesOwed = finesOwed; this.displayName = displayName;
    }
}
