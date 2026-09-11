package access_modifiers_encapsulation_object_modeling.class_problems;

/** Encodes Java field visibility rules without relying on individual field names. */
public class AccessRuleEngine {
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

    public static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length == 2
                        && "ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) {
                    allowed++;
                } else {
                    denied++;
                }
            }
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {
        String[][] attempts = {
            {"protected", "SAME_PACKAGE"},
            {"protected", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeBatch(attempts));
        System.out.println(new PatientRecord("MT94", "W3", 98.2, "MediTrack Central"));
    }
}

class PatientRecord {
    private final String patientId;
    String wardCode;
    protected double vitalsScore;
    public String facilityName;

    public PatientRecord(String patientId, String wardCode, double vitalsScore, String facilityName) {
        if (patientId == null || patientId.trim().length() < 4) {
            throw new IllegalArgumentException("Patient ID must contain at least four non-blank characters.");
        }
        this.patientId = patientId.trim();
        this.wardCode = wardCode;
        this.vitalsScore = vitalsScore;
        this.facilityName = facilityName;
    }

    @Override
    public String toString() {
        return "PatientRecord{" + patientId + "}";
    }
}
