package access_modifiers_encapsulation_object_modeling.assigment_problems;

public class ReferenceDeskAccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        return MembershipAccessChecker.classifyAccess(fieldModifier, accessorContext);
    }
    public static String describeContext(String accessorContext) {
        if (accessorContext == null || accessorContext.isBlank()) return "";
        StringBuilder result = new StringBuilder();
        for (String part : accessorContext.toLowerCase().split("_")) {
            if (result.length() > 0) result.append(' ');
            result.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1));
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(describeContext("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
    }
}
