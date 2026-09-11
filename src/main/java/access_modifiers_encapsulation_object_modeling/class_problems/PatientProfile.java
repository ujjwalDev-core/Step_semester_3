package access_modifiers_encapsulation_object_modeling.class_problems;

public class PatientProfile {
    private String patientId;
    private String name;
    private boolean discharged;
    private String lockerPinHash;

    public PatientProfile() {
        this(null, null);
    }

    public PatientProfile(String name) {
        this(null, name);
    }

    public PatientProfile(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }

    public String getPatientId() { return patientId; }

    public void setPatientId(String id) {
        if (patientId == null && id != null && !id.isBlank()) {
            patientId = id;
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public boolean isDischarged() { return discharged; }
    public void setDischarged(boolean discharged) { this.discharged = discharged; }

    // Write-only: no getter exposes the original PIN or its stored transformation.
    public void setLockerPin(String pin) {
        if (pin != null && pin.matches("\\d{4,6}")) {
            lockerPinHash = Integer.toHexString(pin.hashCode());
        }
    }

    public static void main(String[] args) {
        PatientProfile profile = new PatientProfile();
        profile.setPatientId("MT2026-0142");
        profile.setPatientId("HACKED-0000");
        System.out.println(profile.getPatientId());
    }
}
