package access_modifiers_encapsulation_object_modeling.class_problems;

public class CrossPackageAccessRuleEngine {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        return AccessRuleEngine.classifyAccess(fieldModifier, accessorContext);
    }

    public static String describeContext(String accessorContext) {
        if (accessorContext == null || accessorContext.isBlank()) {
            return "";
        }
        StringBuilder description = new StringBuilder();
        for (String word : accessorContext.toLowerCase().split("_")) {
            if (description.length() > 0) {
                description.append(' ');
            }
            description.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1));
        }
        return description.toString();
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
        System.out.println(describeContext("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}
