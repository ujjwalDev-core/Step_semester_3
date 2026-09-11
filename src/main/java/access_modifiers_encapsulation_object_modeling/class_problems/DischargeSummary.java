package access_modifiers_encapsulation_object_modeling.class_problems;

import java.util.Arrays;

/** Immutable base summary. It cannot be final because the required critical-care variant extends it. */
public class DischargeSummary {
    private static final String MEDICATION_PATTERN = "MED-[A-Z]";
    protected final String patientId;
    private final String[] medicationCodes;
    protected static final String PROCESSOR_NAME;

    static {
        PROCESSOR_NAME = "MediTrack Nightly Ledger";
    }

    public DischargeSummary(String patientId, String[] medicationCodes) {
        if (patientId == null || patientId.isBlank()) {
            throw new IllegalArgumentException("Patient ID is required.");
        }
        validateCodes(medicationCodes);
        this.patientId = patientId;
        this.medicationCodes = medicationCodes.clone();
    }

    private static void validateCodes(String[] codes) {
        if (codes == null || codes.length > 20) {
            throw new IllegalArgumentException("Invalid medication-code array.");
        }
        for (String code : codes) {
            if (code == null || !code.matches(MEDICATION_PATTERN)) {
                throw new IllegalArgumentException("Invalid medication code: " + code);
            }
        }
    }

    public String[] getMedicationCodes() {
        return medicationCodes.clone();
    }

    public DischargeSummary withCorrectedMedication(int index, String newCode) {
        String[] correctedCodes = getMedicationCodes();
        if (index < 0 || index >= correctedCodes.length) {
            throw new IndexOutOfBoundsException("Medication index is invalid.");
        }
        correctedCodes[index] = newCode;
        return new DischargeSummary(patientId, correctedCodes);
    }

    public static String processNightlyBatch(DischargeSummary[] summaries) {
        int processed = 0;
        int nullSkipped = 0;
        int criticalCare = 0;
        if (summaries != null) {
            for (DischargeSummary summary : summaries) {
                if (summary == null) { nullSkipped++; continue; }
                processed++;
                if (summary instanceof CriticalCareDischargeSummary) { criticalCare++; }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + criticalCare
                + " critical-care | " + (processed - criticalCare) + " routine";
    }

    public static void main(String[] args) {
        DischargeSummary[] summaries = {new CriticalCareDischargeSummary("MT001", new String[]{"MED-X"}, 4), null, new DischargeSummary("MT002", new String[]{"MED-Y"})};
        System.out.println(processNightlyBatch(summaries));
    }
}

class CriticalCareDischargeSummary extends DischargeSummary {
    private final int icuDays;
    public CriticalCareDischargeSummary(String patientId, String[] medicationCodes, int icuDays) {
        super(patientId, medicationCodes);
        if (icuDays < 0) throw new IllegalArgumentException("ICU days cannot be negative.");
        this.icuDays = icuDays;
    }
}
